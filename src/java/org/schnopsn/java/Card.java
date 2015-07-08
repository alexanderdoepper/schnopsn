package org.schnopsn.java;

/**
 *
 * @author Alexander Doepper (genosse_alexai)
 */
public class Card 
{
    private int id;
    public static enum Color{DIAMONDS,HEARTS,SPADES,CLUBS};
    public static enum Type {JACK,QUEEN,KING,TEN,ACE};
    
    private Color color;
    private Type type;
    
    private int value;
    private boolean open;

    public Card(Color color, Type type) 
    {
        this.color = color;
        this.type = type;
        
        if(this.type == Type.JACK) { value = 2; }
        if(this.type == Type.QUEEN) { value = 3; }
        if(this.type == Type.KING) { value = 4; }
        if(this.type == Type.TEN) { value = 10; }
        if(this.type == Type.ACE) { value = 11; }
        
        this.open = true;
    }
    
    public int getValue()
    {
        return value;
    }

    public Color getColor() 
    {
        return color;
    }

    public void setColor(Color color) 
    {
        this.color = color;
    }

    public Type getType() 
    {
        return type;
    }

    public void setType(Type type) 
    {
        this.type = type;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
    
    
}
