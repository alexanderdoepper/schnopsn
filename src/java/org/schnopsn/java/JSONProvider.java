package org.schnopsn.java;
import org.json.simple.*;

/**
 *
 * @author Alexander Doepper (genosse_alexai)
 */
public abstract class JSONProvider 
{    
    public static String getErrorJSON(MsgData.ErrorCodes errorCode)
    {
        JSONObject json = new JSONObject();
        
        json.put(MsgData.messageTypeKey, MsgData.MessageTypes.ERROR.name());
        json.put(MsgData.messageCodeKey, errorCode.name());
        json.put(MsgData.messageTextKey, MsgData.getMessageText(errorCode));
        
        return json.toJSONString(); 
    } 
    
    public static String getOkJSON(MsgData.OKCodes okCode)
    {
        JSONObject json = new JSONObject();
        
        json.put(MsgData.messageTypeKey, MsgData.MessageTypes.OK.name());
        json.put(MsgData.messageCodeKey, okCode.name());
        json.put(MsgData.messageTextKey, MsgData.getMessageText(okCode));
        
        return json.toJSONString();
        
    } 
    
    public static String getOkJSON()
    {
        JSONObject json = new JSONObject();
        
        json.put(MsgData.messageTypeKey, MsgData.MessageTypes.OK.name());
        json.put(MsgData.messageCodeKey, MsgData.OKCodes.OK);
        json.put(MsgData.messageTextKey, MsgData.getMessageText(MsgData.OKCodes.OK));
        
        return json.toJSONString();
        
    } 
    
    public String getActionJSON(MsgData.ActionCodes actionCode, JSONObject jsonData)
    {
        return "";
    }
    
    public static boolean isJSONError(String msg)
    {
        JSONObject obj = (JSONObject)JSONValue.parse(msg);
        if(obj == null)
        {
            return false;
        }
        
        if(obj.get(MsgData.messageTypeKey) == MsgData.MessageTypes.ERROR.name())
        {
            return true;
        }
        
        return false;
        
    }
    
    public static boolean isJSONOk(String msg)
    {
        JSONObject obj = (JSONObject)JSONValue.parse(msg);
        if(obj == null)
        {
            return false;
        }
        
        if(obj.get(MsgData.messageTypeKey) == MsgData.MessageTypes.OK.name())
        {
            return true;
        }
        
        return false;
        
    }
    
    public static MsgData.MessageTypes getMessageType(String msg)
    {
        JSONObject obj = (JSONObject)JSONValue.parse(msg);
        if(obj == null)
        {
            return null;
        }
        
        if(obj.get(MsgData.messageTypeKey) == MsgData.MessageTypes.ERROR.name())
        {
            return MsgData.MessageTypes.ERROR;
        }
        
        if(obj.get(MsgData.messageTypeKey) == MsgData.MessageTypes.ACTION.name())
        {
            return MsgData.MessageTypes.ACTION;
        }
        
        if(obj.get(MsgData.messageTypeKey) == MsgData.MessageTypes.OK.name())
        {
            return MsgData.MessageTypes.OK;
        }
        
        return null;
    }
}