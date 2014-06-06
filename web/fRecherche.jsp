<%-- 
    Document   : fRecherche
    Created on : 4 juin 2014, 21:46:43
    Author     : Alexandre
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

 <c:if test="${param['action'] == 'rechercherTitreForm'}">
                <form id="form-titre" class="navbar-form navbar-left backgrouWhite" role="search" action="ServletUsers">
                    <div class="form-group">
                        Veuillez indiquez votre titre à rechercher : <input type="text" size="100" name="titre" class="form-control" placeholder="Titre">
                    </div>
                    <input type="hidden" value="rechercherTitre" name="action">
                    <button type="submit" class="btn btn-default">Envoyer</button>
                </form>
            </c:if>
            <c:if test="${param['action'] == 'rechercherArtisteForm'}">
                <form id="form-titre" class="navbar-form navbar-left backgrouWhite" role="search" action="ServletUsers">
                    <div class="form-group">
                        Veuillez indiquez votre artiste à rechercher : <input type="text" size="100" name="artiste" class="form-control" placeholder="Artiste">
                    </div>
                    <input type="hidden" value="rechercherArtiste" name="action">
                    <button type="submit" class="btn btn-default">Envoyer</button>
                </form>
            </c:if>
            <c:if test="${param['action'] == 'rechercherStyleForm'}">
                <form id="form-style" class="navbar-form navbar-left backgrouWhite" role="search" action="ServletUsers">
                   <div class="input-group dispo-recherche" id="style-input-search" >
                      <div class="input-group-btn">
                          <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Veuillez selectionner le style à rechercher<span class="caret"></span></button>
                          <ul class="dropdown-menu">
                              <c:forEach var="i" items="${requestScope['resultatStyles']}" >
                                  <li><a id="style-${i}" onclick="selectionnerStyle('${i}')" value="${i}">${i}</a></li>
                              </c:forEach>
                          </ul>
                      </div><!-- /btn-group -->
                      <input type="hidden"  id="sty-inputh-search" name="style-choosen" >
                      <input type="text" size="100" readonly class="form-control" id="style-input"  name="style">
                  </div>
                    <div class="btn-recherche">
                    <input type="hidden" value="rechercherStyle" name="action">
                    <button type="submit" class="btn btn-default">Envoyer</button>
                    </div>
                </form>
            </c:if>
            <c:if test="${param['action'] == 'rechercherAnneeForm'}">
                <form id="form-annee" class="navbar-form navbar-left backgrouWhite" role="search" action="ServletUsers">
                   <div class="input-group dispo-recherche" id="annee-input-search">
                      <div class="input-group-btn" >
                          <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Veuillez selectionner l'année à rechercher<span class="caret"></span></button>
                          <ul class="dropdown-menu">
                              <c:forEach var="i" items="${requestScope['resultatStyles']}" >
                                  <li><a id="annee-${i}" onclick="selectionnerAnnee('${i}')" value="${i}">${i}</a></li>
                              </c:forEach>
                          </ul>
                      </div>
                       <!-- /btn-group -->
                      <input type="hidden"  id="ann-inputh-search"  name="annee-choosen" >
                      <input type="text" size="100" readonly class="form-control" id="annee-input"  name="style">
                  </div>
                    <div class="btn-recherche">
                    <input type="hidden" value="rechercherAnnee" name="action">
                    <button type="submit" class="btn btn-default" >Envoyer</button>
                    </div>
                </form>
            </c:if>
            <c:if test="${param['action'] == 'rechercherInstruForm'}">
                <form id="form-instrument" class="navbar-form navbar-left backgrouWhite" role="search" action="ServletUsers">
                   <div class="input-group dispo-recherche" id="instrument-input-search">
                      <div class="input-group-btn">
                          <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Veuillez selectionner l'instrument à rechercher<span class="caret"></span></button>
                          <ul class="dropdown-menu">
                              <c:forEach var="i" items="${requestScope['resultatStyles']}" >
                                  <li><a id="annee-${i}" onclick="selectionnerInstrument('${i}')" value="${i}">${i}</a></li>
                              </c:forEach>
                          </ul>
                      </div><!-- /btn-group -->
                      <input type="hidden"  id="instru-inputh-search"  name="instrument-choosen" >
                      <input type="text" size="100" readonly class="form-control" id="instrument-input"  name="style">
                  </div>
                    <div class="btn-recherche">
                        <input type="hidden" value="rechercherInstrument" name="action">
                        <button  type="submit" class="btn btn-default">Envoyer</button>
                    </div>
                </form>
            </c:if>
