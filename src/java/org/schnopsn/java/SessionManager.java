package org.schnopsn.java;

import java.util.HashSet;
import java.util.Set;
import javax.websocket.Session;

/**
 *
 * @author Alexander Doepper (genosse_alexai)
 */
public abstract class SessionManager 
{
    public static Set<Session> sessions = new HashSet<Session>();
    public static Set<Player> players = new HashSet<Player>();
    public static Set<Table> tables = new HashSet<Table>();    
}
