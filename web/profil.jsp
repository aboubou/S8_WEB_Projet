<%-- 
    Document   : profil
    Created on : 5 juin 2014, 16:30:27
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<div class="panel panel-info" id="profil-info">
      <div class="panel-heading">
        <h3 class="panel-title">Votre profil</h3>
      </div>
      <div class="panel-body">
         
            Pseudonyme : ${resultatRecherche.login}<br><br>
            Nom :  ${resultatRecherche.lastname}<br><br>
            Prénom : ${resultatRecherche.firstname}<br><br>
            Rue :  ${resultatRecherche.adresse.rue}<br><br>
            Ville : ${resultatRecherche.adresse.ville}<br><br>
            Code postal : ${resultatRecherche.adresse.codePostal}<br><br>
            Adresse mail : ${resultatRecherche.mail}<br><br>
            <c:forEach var="t" items="${resultatRecherche.instruments}">
                Instrument()joué(s) : ${t.instrument}<br><br>
            </c:forEach>
            Abonnement : ${resultatRecherche.abonnement.description}<br><br>
            Date Abonnement : ${resultatRecherche.dateAbo}<br><br>
      </div>
    </div>

