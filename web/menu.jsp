<%-- 
    Document   : menu
    Created on : 24 mai 2014, 11:51:44
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


    <ul class="nav nav-tabs">
        <li class="active"><a href="#">Home</a></li>
        <c:if test="${!empty param.idSession}">
            <li><a href="#">Profil</a></li>
        </c:if>
        <li><a href="#">Musique</a></li>
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Recherche ... <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
                <li><a href="index.jsp?action=rechercherTitreForm">par titre</input></a></li>
                <li><a href="index.jsp?action=rechercherArtisteForm">par artiste</a></li>
                <li><a href="index.jsp?action=rechercherStyleForm">par style</a></li>
                <li><a href="index.jsp?action=rechercherAnneeForm">par année</a></li>
                <li><a href="index.jsp?action=rechercherInstrumentForm">par instrument</a></li>
                <li><a href="index.jsp?action=rechercherPisteForm">par nombre de pistes</a></li>
            </ul>
        </li>
      </ul>
