<%-- 
    Document   : index
    Created on : 24 mai 2014, 10:26:54
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Accueil - Projet web</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
        <link rel="stylesheet" type="text/css" href="css/theme.css">
        <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <header id="header">
            <jsp:include page="header.jsp"/>
        </header>
        <div id="demo"></div>
        <div class="container" id="menu">
            <jsp:include page="menu.jsp"/>
            <c:if test="${param['action'] == 'rechercherTitreForm'}">
                <form id="form-titre" class="navbar-form navbar-left" role="search" action="ServletUsers">
                    <div class="form-group">
                        Veuillez indiquez votre titre à rechercher : <input type="text" size="100" name="titre" class="form-control" placeholder="Titre">
                    </div>
                    <input type="hidden" value="rechercherTitre" name="action">
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </c:if>
            <c:if test="${param['action'] == 'rechercherArtisteForm'}">
                <form id="form-titre" class="navbar-form navbar-left" role="search" action="ServletUsers">
                    <div class="form-group">
                        Veuillez indiquez votre artiste à rechercher : <input type="text" size="100" name="titre" class="form-control" placeholder="Artiste">
                    </div>
                    <input type="hidden" value="rechercherArtiste" name="action">
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </c:if>
            <c:if test="${param['action'] == 'rechercherStyleForm'}">
                <form id="form-titre" class="navbar-form navbar-left" role="search" action="ServletUsers">
                   <div class="input-group" id="style-input-search">
                      <div class="input-group-btn">
                          <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Veuillez selectionner le style à rechercher<span class="caret"></span></button>
                          <ul class="dropdown-menu">
                              <c:forEach var="i" items="${requestScope['resultatStyles']}" >
                                    <li><a id="i-${i.id}" onclick="" value="${i.id}">${i.style}</a></li>
                              </c:forEach>
                          </ul>
                      </div><!-- /btn-group -->
                      <input type="hidden"  id="s-inputh-search"  name="style-choosen" value="">
                      <input type="text" readonly class="form-control" id="style-input"  name="style">
                  </div>
                    <input type="hidden" value="rechercherStyle" name="action">
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </c:if>
            
            <!--<div id="resultat-recherche" >-->
                <span>Résultat de votre recherche</span>
                <table id="table-recherche" border="1" class="container">
                    <tr>
                        <td>Titre</td>
                        <td>Artiste</td>
                        <td>Année</td>
                        <td>Style</td>
                        <td>Instrument</td>
                        <td>Difficulte</td>
                        <td>Piste</td>
                        <td>Panier</td>    
                    </tr>
                   <c:forEach var="t" items="${requestScope['resultatRecherche']}">
                       <tr>
                           <td>${t.titre}</td>
                           <td>${t.artiste}</td>
                           <td>${t.annee}</td>
                           <td>${t.style}</td>
                           <td>${t.instrument.instrument}</td>
                           <td>${t.difficulte}</td>
                           <td>${t.piste}</td>
                           <td></td>
                       </tr>
                    </c:forEach>
                </table>
            <!--</div>-->
        </div>
    </div>
    </body>
</html>
