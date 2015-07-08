package org.schnopsn.java;

/**
 *
 * @author Alexander Doepper (genosse_alexai)
 */
public class Team 
{ 
    private int number; //[1|2]
    private Table table;
    private Player player1;
    private Player player2;
    
    private int scoreRound;
    private int scoreMatch;
    private int scoreOverall;
    
    public Team(Player player1, Player player2) throws Exception
    {
        if((player1.getState() != Player.State.ONTABLE) || (player2.getState() != Player.State.ONTABLE) ||
            (!player1.getTable().equals(player2.getTable())))
        {
            throw new Exception("Server error: Error creating Team!");
        }
        
        this.table = player1.getTable();
        this.player1 = player1;
        this.player2 = player2;
        
        this.scoreMatch = 0;
        this.scoreOverall = 0;
        this.scoreRound = 0;   
    }
    
}
