/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.schnopsn.java;

/**
 *
 * @author root
 */
public class CallType 
{
    public static enum Type{NONE,WEITER,DREISTUCH,LAND,ZEHNERLAND,BAUER};
    
    private Type type;
    private int points;
    private String name;
    private String description;
    private boolean doubled;
    
    public CallType(Type type, boolean doubled)
    {
        
        this.doubled = doubled;
        this.type = type;
        
        if(type == Type.NONE)
        {
            this.name = "";
            this.points = -1;
        }
        
        
        if(type == Type.WEITER)
        {
            this.name = "Weiter";
            this.points = 3;
        }
        
        if(type == Type.DREISTUCH)
        {
            this.name = "Dreistuch";
            this.points = 3;
        }
        
        if(type == Type.LAND)
        {
            this.name = "Land";
            this.points = 3;
        }        
        
        if(type == Type.ZEHNERLAND)
        {
            this.name = "Zehnerland";
            this.points = 3;
        }
         
        if(type == Type.BAUER)
        {
            this.name = "Bauer";
            this.points = 3;
        }
    }
}
