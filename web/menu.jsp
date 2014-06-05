<%-- 
    Document   : menu
    Created on : 24 mai 2014, 11:51:44
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


    <ul class="nav nav-tabs" id="menu-gen">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">Profil</a></li>
        <li><a href="#">Musique</a></li>
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
      </ul>
