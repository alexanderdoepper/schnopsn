package org.schnopsn.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.websocket.Session;

/**
 *
 * @author Alexander Doepper (genosse_alexai)
 */
public class Player 
{
    public static enum State{FREE,ONTABLE,INGAME};
    public static int maxCards = 5;
    
    private double id; //-1 for Anonymous; >= 0 for registered
    private String name;
    private Session session;
    
    private State state;
    private CallType callType;
    
    private Table table;
    private Team team;
    private List<Card> cards = new ArrayList<Card>();

    public Player(String name, double id, Session session) 
    {
        this.name = name;
        this.id = id;
        this.state = State.FREE;
        this.callType = new CallType(CallType.Type.NONE, false);
        this.session = session; 
        this.cards.clear();
    }
    
    //GET und SETs
    //##########################################################################

    public double getDbId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Session getSession() {
        return session;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public State getState() {
        return state;
    }
     
    public void setState(State state) {
    this.state = state;
    }

    public CallType getCallType() {
        return callType;
    }

    public void setCallType(CallType callType) {
        this.callType = callType;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) 
    {
        if(cards.size() == Player.maxCards)
        {
            this.cards = cards;
            this.cards.get(3).setOpen(false);
            this.cards.get(3).setOpen(false);
        }
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
