package org.schnopsn.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Alexander Doepper (genosse_alexai)
 */
public class Table 
{
    //General
    private int id;
    private String name;
    
    
    //Player related
    private Map<Integer, Player> players = new HashMap<Integer, Player>();
    private Map<Integer,Team> teams = new HashMap<Integer,Team>();
    
    
    //Card realted
    private Card[] cardsInit = new Card[20]; 
    private Map<Integer, Card> cardsMiddle = new HashMap<Integer, Card>(); 
    private Map<Integer, Card> cardsFallen = new HashMap<Integer, Card>(); 
    
    //Round Infos
    public static enum RoundType {NORMAL,DREISTUCH,LAND,ZEHNERLAND,BAUER,K_DREISTUCH,K_BAUER};
    private Card.Color trumpColor;
    private Player callingPlayer;
    private Player roundPlayer;
    private RoundType roundType;
    private boolean doubled;
    
    //Inital config
    private static final int maxPlayers = 4;
    
    public Table(String name, int dbId) 
    {
        this.name = name;
        this.id = id;
    }
    
    private void initCards()
    {
        this.cardsFallen.clear();
        this.cardsMiddle.clear();
        
        cardsInit[0] = new Card(Card.Color.DIAMONDS, Card.Type.JACK);
        cardsInit[1] = new Card(Card.Color.DIAMONDS, Card.Type.QUEEN); 
        cardsInit[2] = new Card(Card.Color.DIAMONDS, Card.Type.KING); 
        cardsInit[3] = new Card(Card.Color.DIAMONDS, Card.Type.TEN); 
        cardsInit[4] = new Card(Card.Color.DIAMONDS, Card.Type.ACE); 
        cardsInit[5] = new Card(Card.Color.HEARTS, Card.Type.JACK);
        cardsInit[6] = new Card(Card.Color.HEARTS, Card.Type.QUEEN); 
        cardsInit[7] = new Card(Card.Color.HEARTS, Card.Type.KING); 
        cardsInit[8] = new Card(Card.Color.HEARTS, Card.Type.TEN); 
        cardsInit[9] = new Card(Card.Color.HEARTS, Card.Type.ACE); 
        cardsInit[10] = new Card(Card.Color.SPADES, Card.Type.JACK);
        cardsInit[11] = new Card(Card.Color.SPADES, Card.Type.QUEEN); 
        cardsInit[12] = new Card(Card.Color.SPADES, Card.Type.KING); 
        cardsInit[13] = new Card(Card.Color.SPADES, Card.Type.TEN); 
        cardsInit[14] = new Card(Card.Color.SPADES, Card.Type.ACE); 
        cardsInit[15] = new Card(Card.Color.CLUBS, Card.Type.JACK);
        cardsInit[16] = new Card(Card.Color.CLUBS, Card.Type.QUEEN); 
        cardsInit[17] = new Card(Card.Color.CLUBS, Card.Type.KING); 
        cardsInit[18] = new Card(Card.Color.CLUBS, Card.Type.TEN); 
        cardsInit[19] = new Card(Card.Color.CLUBS, Card.Type.ACE); 
        
        shuffleCards();
    }
    
    private void shuffleCards()
    {
        Card helper;
        int randomPos = 0;
        int randomPos2 = 0;
        int counter = 0;
        
        for(counter = 0; counter <= 19; counter++)
        {
            randomPos = (int)Math.round((Math.random() * 19)); //Number between 0 and 19
            helper = cardsInit[counter];
            cardsInit[counter] = cardsInit[randomPos];
            cardsInit[randomPos] = helper;
        }
        
        for(counter = 0; counter <= 200; counter++)
        {
            randomPos = (int)Math.round((Math.random() * 19)); //Number between 0 and 19
            randomPos2 = (int)Math.round((Math.random() * 19)); //Number between 0 and 19
            helper = cardsInit[randomPos];
            cardsInit[randomPos] = cardsInit[randomPos2];
            cardsInit[randomPos2] = helper;
        }
    }
    
    public String addPlayer(Player player, int seat)
    {
        if ((seat > 4) || (seat < 1))
        {
            return JSONProvider.getErrorJSON(MsgData.ErrorCodes.E003);
        }
        
        if(player.getState() != Player.State.FREE)
        {
            return JSONProvider.getErrorJSON(MsgData.ErrorCodes.E001);
        }
        
        if(this.players.size() >= maxPlayers)
        {
            return JSONProvider.getErrorJSON(MsgData.ErrorCodes.E002);
        }
        
        this.players.put(seat, player); // Join Table
        player.setState(Player.State.ONTABLE);
        player.setTable(this);
        
        return JSONProvider.getOkJSON();
    }
    
    public String newGame() throws Exception//Complete new Round, after Table is full
    {
        String res = "";
        resetPlayers();
        this.teams.clear();
        initCards();
        
        if(this.players.size() != 4)
        {
            return JSONProvider.getErrorJSON(MsgData.ErrorCodes.E004);
        }
        
        res = teamUp();
        if(JSONProvider.isJSONError(res))
        {return res;}
        
        dealCards();
        
        
        return JSONProvider.getOkJSON();
    }
    
    private void dealCards()
    {
        int c = 0;
        for(Entry<Integer,Player> p: this.players.entrySet())
        {
            p.getValue().getCards().add(this.cardsInit[c++]);
            p.getValue().getCards().add(this.cardsInit[c++]);
            p.getValue().getCards().add(this.cardsInit[c++]);
            p.getValue().getCards().add(this.cardsInit[c++]);
            p.getValue().getCards().add(this.cardsInit[c++]);
        }
    }
            
    private String teamUp() throws Exception
    {
        this.teams.put(1, new Team(this.players.get(1), this.players.get(3)));
        this.teams.put(2, new Team(this.players.get(2), this.players.get(4)));
        
        this.players.get(1).setTeam(this.teams.get(1));
        this.players.get(2).setTeam(this.teams.get(2));
        this.players.get(3).setTeam(this.teams.get(1));
        this.players.get(4).setTeam(this.teams.get(2));
        
        return JSONProvider.getOkJSON();
    }
    
    private void resetPlayers()
    {
        for(Entry<Integer,Player> p: this.players.entrySet())
        {
            p.getValue().setCallType(new CallType(CallType.Type.NONE,false));
            p.getValue().getCards().clear();
        }
    }
    
    //GET und SETs
    //##########################################################################

    public int getDbId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Player> getPlayers() {
        return players;
    }

    public Map<Integer, Team> getTeams() {
        return teams;
    }

    public Map<Integer, Card> getCardsMiddle() {
        return cardsMiddle;
    }

    public void setCardsMiddle(Map<Integer, Card> cardsMiddle) {
        this.cardsMiddle = cardsMiddle;
    }

    public Map<Integer, Card> getCardsFallen() {
        return cardsFallen;
    }

    public void setCardsFallen(Map<Integer, Card> cardsFallen) {
        this.cardsFallen = cardsFallen;
    }

    public Card.Color getTrumpColor() {
        return trumpColor;
    }

    public void setTrumpColor(Card.Color trumpColor) {
        this.trumpColor = trumpColor;
    }

    public RoundType getRoundType() {
        return roundType;
    }

    public void setRoundType(RoundType roundType) {
        this.roundType = roundType;
    }

    public boolean isDoubled() {
        return doubled;
    }

    public void setDoubled(boolean doubled) {
        this.doubled = doubled;
    }
    
        
}
