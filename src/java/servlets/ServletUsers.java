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
import utilisateurs.gestionnaires.GestionnaireUtilisateurs;
import utilisateurs.modeles.Utilisateur;
import utilisateurs.modeles.Adresse;

/**
 *
 * @author Jim
 */
@WebServlet(name = "ServletUsers", urlPatterns = {"/ServletUsers"})
public class ServletUsers extends HttpServlet {

    @EJB
    private GestionnaireUtilisateurs gestionnaireUtilisateurs;

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

        if (action != null) {
            if (action.equals("listerLesUtilisateurs")) {
                int sizeliste = gestionnaireUtilisateurs.getAllUsers().size();

                if (sizeliste > 10) {
                    request.setAttribute("cur-min", 0);
                    request.setAttribute("cur-max", 10);
                }
                request.setAttribute("taille-max", sizeliste);
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers(0, 10);
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "template.jsp?action=listerLesUtilisateurs";
                message = "Liste des utilisateurs";
            } else if (action.equals("affichersuivant")) {
                Integer param1 = new Integer(request.getParameter("cur-min"));
                param1 += 10;
                Integer param2 = new Integer(request.getParameter("cur-max"));
                param2 += 10;
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers(param1, 10);
                if (liste.size() != 0) {
                    request.setAttribute("cur-min", param1);
                    request.setAttribute("cur-max", param2);
                }
                request.setAttribute("taille-max", gestionnaireUtilisateurs.getAllUsers().size());
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "template.jsp?action=listerLesUtilisateurs";
                message = "Liste des utilisateurs";
            } else if (action.equals("afficherprecedent")) {
                Integer param1 = new Integer(request.getParameter("cur-min"));
                param1 -= 10;
                Integer param2 = new Integer(request.getParameter("cur-max"));
                param2 -= 10;
                if (param2 < 10) {
                    param2 = 10;
                }
                if (param1 < 0) {
                    param1 = 0;
                }
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers(param1, 10);
                request.setAttribute("cur-min", param1);
                request.setAttribute("cur-max", param2);
                request.setAttribute("taille-max", gestionnaireUtilisateurs.getAllUsers().size());
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "template.jsp?action=listerLesUtilisateurs";
                message = "Liste des utilisateurs";
            } else if (action.equals("creerUnUtilisateurParDefaut")) {
                gestionnaireUtilisateurs.creeUtilisateur("user", "user", "user", "user");
                forwardTo = "template.jsp?action=creerUnUtilisateurParDefaut";
                message = "Vous venez de créer un utilisateur par défaut";
            } else if (action.equals("creerUtilisateursDeTest")) {
                gestionnaireUtilisateurs.creerUtilisateursDeTest();
                int sizeliste = gestionnaireUtilisateurs.getAllUsers().size();
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers(0,10);
                request.setAttribute("cur-min", 0);
                request.setAttribute("cur-max", 10);
                request.setAttribute("taille-max", sizeliste);
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "template.jsp?action=listerLesUtilisateurs";
                message = "Liste des utilisateurs";
            } else if (action.equals("creerUnUtilisateur")) {
                String param1 = request.getParameter("nom");
                String param2 = request.getParameter("prenom");
                String param3 = request.getParameter("login");
                String param4 = request.getParameter("password");

                gestionnaireUtilisateurs.creeUtilisateur(param1, param2, param3, param4);
                
                int sizeliste = gestionnaireUtilisateurs.getAllUsers().size();
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers(0,10);
                request.setAttribute("cur-min", 0);
                request.setAttribute("cur-max", 10);
                request.setAttribute("taille-max", sizeliste);
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "template.jsp?action=listerLesUtilisateurs";
                message = "Liste des utilisateurs après ajout de : " + param1 + " " + param2 + " " + param3;
            } else if (action.equals("creer30Utilisateurs")) {
                int a = Integer.parseInt(request.getParameter("nb"));
                for (int i = 0; i < a; i++) {
                    String param1 = request.getParameter("nom") + i;
                    String param2 = request.getParameter("prenom") + i;
                    String param3 = request.getParameter("nom") + request.getParameter("prenom") + i;
                    String param4 = request.getParameter("nom");

                    gestionnaireUtilisateurs.creeUtilisateur(param1, param2, param3, param4);
                }
                int sizeliste = gestionnaireUtilisateurs.getAllUsers().size();
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers(0,10);
                 request.setAttribute("cur-min", 0);
                request.setAttribute("cur-max", 10);
                request.setAttribute("taille-max", sizeliste);
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "template.jsp?action=listerLesUtilisateurs";
                message = "Liste des utilisateurs après ajout de "+request.getParameter("nb")+" utilisateurs";

            } else if (action.equals("chercherParLogin")) {
                String paramLog = request.getParameter("login");

                Collection<Utilisateur> liste = gestionnaireUtilisateurs.rechercheUser(paramLog, 0, 10);
                int sizeliste = gestionnaireUtilisateurs.rechercheUser(paramLog).size();
                if (!liste.isEmpty()) {
                    request.setAttribute("cur-min", 0);
                    request.setAttribute("cur-max", 10);
                    request.setAttribute("taille-max", sizeliste);
                    request.setAttribute("resultatRecherche", liste);
                    forwardTo = "template.jsp?action=rechercheUtilisateur";
                    message = "Recherche de l'utilisateur :  " + paramLog;
                } else {
                    forwardTo = "template.jsp?action=listerLesUtilisateurs";
                    message = "Votre recherche n'a abouti à aucun resultat !";
                }
            } else if (action.equals("updateUtilisateur")) {

                String param1 = request.getParameter("login");
                String param2 = request.getParameter("nom");
                String param3 = request.getParameter("prenom");

                gestionnaireUtilisateurs.updateUtilisateur(param1, param2, param3);

                Collection<Utilisateur> liste = gestionnaireUtilisateurs.rechercheUser(param1,0,10);
                int sizeliste = gestionnaireUtilisateurs.rechercheUser(param1).size();
                if (!liste.isEmpty()) {
                    request.setAttribute("cur-min", 0);
                    request.setAttribute("cur-max", 10);
                    request.setAttribute("taille-max", sizeliste);
                    request.setAttribute("resultatRecherche", liste);
                    forwardTo = "template.jsp?action=rechercheUtilisateur";
                    message = param1 + " a été mis à jour !";
                } else {
                    forwardTo = "template.jsp?action=listerLesUtilisateurs";
                    message = "Votre recherche n'a abouti à aucun resultat !";
                }

            } else if (action.equals("deleteUtilisateur")) {
                String paramLog = request.getParameter("login");

                if (gestionnaireUtilisateurs.supprimerUtilisateur(paramLog) != 0) {
                    message = "Liste des utilisateurs après suppresion de : " + paramLog;
                } else {
                    message = "Liste des utilisateurs après aucune supression d'utilisateur";
                }

                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getAllUsers(0,10);
                int sizeliste = gestionnaireUtilisateurs.getAllUsers().size();
                request.setAttribute("cur-min", 0);
                request.setAttribute("cur-max", 10);
                request.setAttribute("taille-max", sizeliste);
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "template.jsp?action=listerLesUtilisateurs";
            } else if(action.equals("listerUtilisateursParVille")){
                // on récupère le paramètre idville
                int idVille = Integer.parseInt(request.getParameter("idVille"));
                
                // on récupère la liste des utilisateurs pour la ville
                Collection<Utilisateur> liste = gestionnaireUtilisateurs.getUsersParVille(idVille);
                
                // et on passe le résultat à la JSP pour affichage
                request.setAttribute("listeDesUsers", liste);
                forwardTo = "template.jsp?action=listerLesUtilisateurs";
                message = "Liste des utilisaterus pour la ville No : " + idVille;
            } else {
                forwardTo = "template.jsp?action=todo";
                message = "La fonctionnalité pour le paramètre " + action + " est à implémenter !";
            }
        }
        RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);
        dp.forward(request, response);
        // Après un forward, plus rien ne peut être exécuté après !  
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
