<%-- 
    Document   : resultatRecherche
    Created on : 5 juin 2014, 09:19:50
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table id="table-recherche"  class="table">
                    <thead>
                    <tr>
                        <th>Titre</th>
                        <th>Artiste</th>
                        <th>Année</th>
                        <th>Style</th>
                        <th>Instrument</th>
                        <th>Difficulte</th>
                        <th>Piste</th>
                        <th>Panier</th>    
                    </tr>
                    </thead>
                   <c:forEach var="t" items="${requestScope['resultatRecherche']}">
                       <tr>
                           <td>${t.titre}<input type="hidden" name="" value="${t.id}" id="musiqueR-${t.id}"></td>
                           <td>${t.artiste}</td>
                           <td>${t.annee}</td>
                           <td>${t.style}</td>
                           <td>${t.instrument.instrument}</td>
                           <td>
                               <c:forEach var="entry" begin="1" end="${t.difficulte}">
                                   <span class="glyphicon glyphicon-star"></span>
                               </c:forEach>
                           </td>
                           <td>${t.piste}</td>
                           <td><input type="checkbox" id="musique-${t.id}" onclick="selectionnerMusique('${t.id}');"></td>
                       </tr>
                    </c:forEach>
                </table>