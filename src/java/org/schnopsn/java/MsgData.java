package org.schnopsn.java;

import java.util.EnumMap;

/**
 *
 * @author Alexander Doepper (genosse_alexai)
 */
public abstract class MsgData 
{
    public static enum MessageTypes{OK,ERROR,ACTION};
    public static String messageTypeKey = "type";
    public static String messageCodeKey = "code";
    public static String messageTextKey = "text";
    
    //ERROR---------------------------
    public static enum ErrorCodes
    {
        E001,
        E002,
        E003,
        E004,
        E005,
        E006,
        E007,
        E008
    };
    
    private static final EnumMap<ErrorCodes,String> ErrorTexts;
    static
    {
        ErrorTexts = new EnumMap<ErrorCodes,String>(ErrorCodes.class);
        
        ErrorTexts.put(ErrorCodes.E001, "Cannot add Player to Table. Only Players with STATE = FREE can be added to a Table.");
        ErrorTexts.put(ErrorCodes.E002, "Cannot add Player to Table. Table is full.");
        ErrorTexts.put(ErrorCodes.E003, "Cannot add Player to Table. Seat number has to be in the range from 1 to 4.");
        ErrorTexts.put(ErrorCodes.E004, "Cannot start new Round. There must be 4 Players on the Table.");
        ErrorTexts.put(ErrorCodes.E005, "Cannot create Teams. There must be 4 Players on the same Table.");
        ErrorTexts.put(ErrorCodes.E006, "");
        ErrorTexts.put(ErrorCodes.E007, "");
        ErrorTexts.put(ErrorCodes.E008, "");
    }
    
    //OK---------------------------
    public static enum OKCodes
    {
        OK
    };
    
    private static final EnumMap<OKCodes,String> OKTexts;
    static
    {
        OKTexts = new EnumMap<OKCodes,String>(OKCodes.class);
        
        OKTexts.put(OKCodes.OK, "OK");
    }
    
    //Action---------------------------
    public static enum ActionCodes
    {
        A001,
        A002,
        A003,
        A004,
        A005,
        A006,
        A007,
        A008,
        A009,
        A010,
        A011,
        A012,
        A013,
        A014,
        A015,
        A016
    };
    
    private static final EnumMap<ActionCodes,String> ActionTexts;
    static
    {
        ActionTexts = new EnumMap<ActionCodes,String>(ActionCodes.class);
        
        ActionTexts.put(ActionCodes.A001, "");
        ActionTexts.put(ActionCodes.A002, "");
        ActionTexts.put(ActionCodes.A003, "");
        ActionTexts.put(ActionCodes.A004, "");
        ActionTexts.put(ActionCodes.A005, "");
        ActionTexts.put(ActionCodes.A006, "");
        ActionTexts.put(ActionCodes.A007, "");
        ActionTexts.put(ActionCodes.A008, "");
        ActionTexts.put(ActionCodes.A009, "");
        ActionTexts.put(ActionCodes.A010, "");
        ActionTexts.put(ActionCodes.A011, "");
        ActionTexts.put(ActionCodes.A012, "");
        ActionTexts.put(ActionCodes.A013, "");
        ActionTexts.put(ActionCodes.A014, "");
        ActionTexts.put(ActionCodes.A015, "");
        ActionTexts.put(ActionCodes.A016, "");
    }
    
    public static String getMessageText(ErrorCodes errorCode)
    {
        return ErrorTexts.get(errorCode);
    }
    
    public static String getMessageText(ActionCodes actionCode)
    {
        return ActionTexts.get(actionCode);
    }
        
    public static String getMessageText(OKCodes okCode)
    {
        return OKTexts.get(okCode);
    }
}
