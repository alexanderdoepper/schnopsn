package org.schnopsn.java;

import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.enterprise.context.ApplicationScoped;
/**
 *
 * @author Alexander Doepper (genosse_alexai)
 */

@ApplicationScoped
@ServerEndpoint(value="/wsocket")
public class WebSocketServer
{ 
    /*IMPLEMENTS Interface Method - New Session occouring*/
    @OnOpen
    public void open(Session session) 
    {
        
    }

    /*IMPLEMENTS Interface Method*/
    @OnClose
    public void close(Session session) 
    {        
        
    }

    /*IMPLEMENTS Interface Method*/
    @OnError
    public void onError(Throwable error) 
    {
    }

    /*IMPLEMENTS Interface Method*/
    @OnMessage
    public void handleMessage(String message, Session session) 
    {
        
    }    
    
}
