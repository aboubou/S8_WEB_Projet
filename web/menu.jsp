<%-- 
    Document   : menu
    Created on : 24 mai 2014, 11:51:44
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:out value="${sessionScope['abonnement']}"/>
       
    <ul class="nav nav-tabs" id="menu-gen">
        <li class="active"><a href="#">Home</a></li>
        <li class="" id="menu-profil-search"><form action="ServletUsers" id="form-profil-init"><input type="hidden" name="action" value="afficherProfil"><a>Profil</a></form></li>
        <c:if test="${not empty sessionScope['abonnement']}">
        <li class="" id="menu-musiques-search"><form action="ServletUsers" id="form-musiques-init"><input type="hidden" name="action" value="afficherMusiques"><a>Musique</a></form></li>
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Recherche ... <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li><a href="index.jsp?action=rechercherTitreForm">par titre</input></a></li>
                <li><a href="index.jsp?action=rechercherArtisteForm">par artiste</a></li>
                <li class="menu-link-search" id="menu-style" onclick="executerStyle();"><form action="ServletUsers" id="form-style-init"><input type="hidden" name="action" value="rechercherStylesForm">par style</form></li>
                <li class="menu-link-search" id="menu-annee-search"><form action="ServletUsers" id="form-annee-init"><input type="hidden" name="action" value="rechercherAnneeInitForm">par année</form></li>
                <li class="menu-link-search" id="menu-instrument-search"><form action="ServletUsers" id="form-instrument-init"><input type="hidden" name="action" value="rechercherInstrumentInitForm">par instrument</form></li>
                <li><a href="index.jsp?action=rechercherPisteForm">par nombre de pistes</a></li>
            </ul>
        </li>
        </c:if>
      </ul>


