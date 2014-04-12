/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;  
import java.util.Collection;  
import javax.ejb.EJB;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import utilisateurs.gestionnaires.GestionnaireConnexion;  
import utilisateurs.modeles.Utilisateur;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alexandre
 */
@WebServlet(name = "ServletConnexion", urlPatterns = {"/ServletConnexion"})
public class ServletConnexion extends HttpServlet {
    @EJB
    private GestionnaireConnexion gestionnaireConnexion;
    private static final String ATT_USER = "utilisateur";
    private static final String ATT_SESSION_USER="sessionUtilisateur";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Pratique pour décider de l'action à faire  
        String action = request.getParameter("action");  
        String forwardTo = "";  
        String message = "";  
  
        if (action.equals("identifierUtilisateur")){
                String paramLog = request.getParameter("login");
                String paramPass = request.getParameter("password");
                System.out.println(paramLog);
                HttpSession session = request.getSession();
                if(gestionnaireConnexion.identifierUtilisateur(paramLog, paramPass)!= 0){
                    message = "Vous vous êtes authentifié en tant que "+paramLog;
                    session.setAttribute(ATT_SESSION_USER, paramLog);
                    request.setAttribute(ATT_USER, paramLog);
                }else{
                    message = "Echec de l'authentification";
                    session.setAttribute(ATT_SESSION_USER, null);
                }
                forwardTo="template.jsp?action=identifierUtilisateur";
        }
        RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);  
        dp.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}