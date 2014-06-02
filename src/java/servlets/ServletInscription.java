/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilisateurs.gestionnaires.GestionnaireInitialisation;
import utilisateurs.gestionnaires.GestionnaireInstrument;
import utilisateurs.gestionnaires.GestionnaireUtilisateurs;
import utilisateurs.modeles.Abonnement;
import utilisateurs.modeles.Instrument;

/**
 *
 * @author Alexandre
 */
@WebServlet(name = "ServletInscription", urlPatterns = {"/ServletInscription"})
public class ServletInscription extends HttpServlet {

     @EJB
     private GestionnaireInitialisation gestionnaireInitialisation;
     
     @EJB
     private GestionnaireUtilisateurs gestionnaireUtilisateurs;
     
     @EJB
     private GestionnaireInstrument gestionnaireInstrument;
     
     //@EJB
     //private Gestionnaire gestionnaireUtilisateurs;
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
        String action = request.getParameter("action");
        String forwardTo = "";
        String message = "";
        
        
        if (action != null) {
            if (action.equals("initialiserFormulaire")) {
                Collection<Instrument> listeInstru = gestionnaireInitialisation.getAllInstrument();
                Collection<Abonnement> listeAbo = gestionnaireInitialisation.getAllAbonnement();

                request.setAttribute("ListeInstruments", listeInstru);
                request.setAttribute("ListeAbonnements", listeAbo);
                forwardTo = "fInscription.jsp?action=formulaireInscription";
                
            }
            else if(action.equals("creerUtilisateur")){
                String pseudo = request.getParameter("pseudo");
                String mdp = request.getParameter("mdp");
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String adresse = request.getParameter("adresse");
                String ville = request.getParameter("ville");
                String codep = request.getParameter("codep");
                String mail = request.getParameter("mail");
                String abonnement = request.getParameter("abonnement-choosen");
                String[] instruments = request.getParameterValues("instrument-choosen");
                
                ArrayList<Instrument> listeInstru = new ArrayList<Instrument>();
                for(int i = 0; i < instruments.length; i++){
                    listeInstru.add(gestionnaireInstrument.getInstrument(instruments[i]));
                }
                //if(!listeInstru.isEmpty())
                gestionnaireUtilisateurs.creerUtilisateur(pseudo, mdp, nom, prenom, adresse, ville, codep, mail, listeInstru, abonnement);
                //gestionnaireUtilisateurs.creerUtilisateur(pseudo, mdp, nom, prenom, adresse, ville, codep, mail, instruments, abonnement);
                forwardTo = "fInscription.jsp?action=creerUtilisateurSuccess";
            }
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
