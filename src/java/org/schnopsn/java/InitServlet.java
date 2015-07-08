package org.schnopsn.java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Alexander Doepper (genosse_alexai)
 */

/*Only for Init at Application Startup - no mapping to Url!*/
public class InitServlet extends HttpServlet 
{

    @Override
    public void init() throws ServletException 
    {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("<InitServlet>: Init Started!");
        doInit();
        System.out.println("<InitServlet>: Init Completed!");
        this.destroy();
    }
    
    private static void doInit()
    {
        //Creating Play-Tables
        //MakeDBConnection
        //..
    }
    
}
