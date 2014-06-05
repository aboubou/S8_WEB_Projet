/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utilisateurs.gestionnaires.GestionnaireInitialisation;

/**
 *
 * @author Alexandre
 */
@WebListener
public class InitApplication extends HttpServlet implements ServletContextListener {
   GestionnaireInitialisation gestionnaireInitialisation = lookupGestionnaireInitialisationBean();
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        gestionnaireInitialisation.initialiserBD();    
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private GestionnaireInitialisation lookupGestionnaireInitialisationBean() {
        try {
            Context c = new InitialContext();
            return (GestionnaireInitialisation) c.lookup("java:global/S8_WEB_Projet/GestionnaireInitialisation!utilisateurs.gestionnaires.GestionnaireInitialisation");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

   

}
