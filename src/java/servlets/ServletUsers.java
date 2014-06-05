/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utilisateurs.gestionnaires.GestionnaireRecherche;
import utilisateurs.gestionnaires.GestionnaireUtilisateurs;
import utilisateurs.modeles.Utilisateur;
import utilisateurs.modeles.Adresse;
import utilisateurs.modeles.Instrument;
import utilisateurs.modeles.Musique;
/**
 *
 * @author Jim
 */
@WebServlet(name = "ServletUsers", urlPatterns = {"/ServletUsers"})
public class ServletUsers extends HttpServlet {

    @EJB
    private GestionnaireUtilisateurs gestionnaireUtilisateurs;
    
    @EJB
    private GestionnaireRecherche gestionnaireRecherche;

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
        String[] actions = request.getParameterValues("action");
        String initStylesMenu = request.getParameter("initStylesMenu");
        String forwardTo = "";
        String message = "";
        HttpSession session = request.getSession(true);
        if (action != null) {
            if (action.equals("rechercherTitre")) {
                String titre = request.getParameter("titre");
                Collection<Musique> listeResultat = gestionnaireRecherche.getMusiqueParTitre(titre);
                if (!listeResultat.isEmpty()) {
                    request.setAttribute("resultatRecherche", listeResultat);
                    forwardTo = "index.jsp?action=rechercheResultat";
                } else {
                    forwardTo = "index.jsp?action=rechercheAucunResulat";
                }
            }else if (action.equals("rechercherArtiste")) {
                String artiste = request.getParameter("artiste");
                Collection<Musique> listeResultat = gestionnaireRecherche.getMusiqueParArtiste(artiste);
                if (!listeResultat.isEmpty()) {
                    request.setAttribute("resultatRecherche", listeResultat);
                    forwardTo = "index.jsp?action=rechercheResultat&resultat=success";
                } else {
                    forwardTo = "index.jsp?action=rechercheAucunResultat";
                } 
            } else if (actions[0].equals("rechercherStylesForm")) {
                
                Collection<Musique> listeStyles = gestionnaireRecherche.getStyles();
                if (!listeStyles.isEmpty()) {
                    request.setAttribute("resultatStyles", listeStyles);
                    forwardTo = "index.jsp?action=rechercherStyleForm";
                } else {
                    forwardTo = "index.jsp?action=rechercheTitreZero";
                }
             } else if (action.equals("rechercherStyle")) {
                String style = request.getParameter("style-choosen");
                Collection<Musique> listeResultat = gestionnaireRecherche.getMusiqueParStyle(style);
                if (!listeResultat.isEmpty()) {
                    request.setAttribute("resultatRecherche", listeResultat);
                    forwardTo = "index.jsp?action=rechercheResultat";
                } else {
                    forwardTo = "index.jsp?action=rechercheAucunResultat";
                }

            } else if (actions[0].equals("rechercherAnneeInitForm")) {
                Collection<Musique> listeAnnees = gestionnaireRecherche.getAllAnnees();
                if (!listeAnnees.isEmpty()) {
                    request.setAttribute("resultatStyles", listeAnnees);
                    forwardTo = "index.jsp?action=rechercherAnneeForm";
                } else {
                    forwardTo = "index.jsp?action=rechercheTitreZero";
                }
            } else if (action.equals("rechercherInstrumentInitForm")) {
                 Collection<Instrument> listeInstru = gestionnaireRecherche.getAllInstruments();
                if (!listeInstru.isEmpty()) {
                    request.setAttribute("resultatStyles", listeInstru);
                    forwardTo = "index.jsp?action=rechercherInstruForm";
                } else {
                    forwardTo = "index.jsp?action=rechercheTitreZero";
                }
            } else if (action.equals("rechercherAnnee")) {
                String annee = request.getParameter("annee-choosen");
                Collection<Musique> listeResultat = gestionnaireRecherche.getMusiqueParAnnee(annee);
                if (!listeResultat.isEmpty()) {
                    request.setAttribute("resultatRecherche", listeResultat);
                    forwardTo = "index.jsp?action=rechercheResultat";
                } else {
                    forwardTo = "index.jsp?action=rechercheAucunResultat";
                }

            } else if (action.equals("rechercherInstrument")) {
                String instru = request.getParameter("instrument-choosen");
                Collection<Musique> listeResultat = gestionnaireRecherche.getMusiqueParInstrument(instru);
                if (!listeResultat.isEmpty()) {
                    request.setAttribute("resultatRecherche", listeResultat);
                    forwardTo = "index.jsp?action=rechercheResultat";
                } else {
                    forwardTo = "index.jsp?action=rechercheAucunResultat";
                }

            } else if (action.equals("initialiserDemo")) {
                Collection<Musique> listeResultat = gestionnaireRecherche.getTroisMusique();
                if (!listeResultat.isEmpty()) {
                    request.setAttribute("resultatRecherche", listeResultat);
                    forwardTo = "index.jsp?action=initialiserDemo";
                } else {
                    forwardTo = "index.jsp?action=rechercheAucunResultat";
                }
            } else if (action.equals("acheterGratuit")) {
                String[] MusiqueSelectionnees = request.getParameterValues("selectionnee");
                /*Collection<Musique> listeResultat = gestionnaireRecherche.getTroisMusique();
                if (!listeResultat.isEmpty()) {
                    request.setAttribute("resultatRecherche", listeResultat);*/
                    forwardTo = "index.jsp?action=initialiserDemo&resultat=success";
                /*} else {
                    forwardTo = "index.jsp?action=rechercheAucunResultat";
                }*/
            }else if (action.equals("afficherProfil")) {
                String login = (String)session.getAttribute("pseudo");
                Utilisateur result = gestionnaireUtilisateurs.getUtilisateurProfil(login);
                request.setAttribute("resultatRecherche", result);
                forwardTo = "index.jsp?action=afficherProfilSuccess";
                /*} else {
                    forwardTo = "index.jsp?action=rechercheAucunResultat";
                }*/
           
            }else if (action.equals("afficherMusiques")) {
                Collection<Musique> resultList= gestionnaireUtilisateurs.getAllMusiques();
                request.setAttribute("resultatRecherche", resultList);
                forwardTo = "index.jsp?action=afficherMusiques";
                /*} else {
                    forwardTo = "index.jsp?action=rechercheAucunResultat";
                }*/
           
            }else if (action.equals("mettrePanier")) {
                String[] musiques = request.getParameterValues("selectionnee");
                if(musiques.length!=0){
                    Collection<Musique> resultList= new ArrayList<Musique>();
                    for(int i = 0 ; i < musiques.length; i++){
                         resultList.add(gestionnaireUtilisateurs.getMusiqueParID(musiques[i]));
                    }
                    int nbMusiques = resultList.size();
                    int prix=0;                
                    if(nbMusiques%3 == 0)
                        prix = (nbMusiques/3)*10;
                    else if(nbMusiques%3 == 1)
                        prix = (nbMusiques-(nbMusiques%3))/3*10 + 5;
                    else if(nbMusiques%3 == 2)
                        prix = (nbMusiques-(nbMusiques%3))/3*10 + 8;

                    request.setAttribute("resultatRecherche", resultList);
                    request.setAttribute("prixAchat", prix);
                    forwardTo = "index.jsp?action=afficherPanier";
                }else{
                    forwardTo = "index.jsp?action=panierAucuneMusique";
                }
           
            } else if (action.equals("AcheterPanier")) {
                String[] musiques = request.getParameterValues("selectionnee");
                Collection<Musique> resultList= new ArrayList<Musique>();
                for(int i = 0 ; i < musiques.length; i++){
                     resultList.add(gestionnaireUtilisateurs.getMusiqueParID(musiques[i]));
                }
                int nbMusiques = resultList.size();
                int prix=0;                
                if(nbMusiques%3 == 0)
                    prix = (nbMusiques/3)*10;
                else if(nbMusiques%3 == 1)
                    prix = (nbMusiques-(nbMusiques%3))/3*10 + 5;
                else if(nbMusiques%3 == 2)
                    prix = (nbMusiques-(nbMusiques%3))/3*10 + 8;
                    
                request.setAttribute("resultatRecherche", resultList);
                request.setAttribute("prixAchat", prix);
                forwardTo = "index.jsp?action=afficherPanier";
                /*} else {
                    forwardTo = "index.jsp?action=rechercheAucunResultat";
                }*/
           
            }else if (action.equals("updateUtilisateur")) {

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
