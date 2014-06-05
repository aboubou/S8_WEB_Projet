<%-- 
    Document   : header
    Created on : 24 mai 2014, 11:49:20
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div role="navigation" class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
          
           <c:if test="${empty sessionScope['connecte']}">
                <form action="ServletUsers" id="form-init">
                    <input type="hidden" name="action" value="initialiserDemo">
                </form>
            </c:if>
                <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
        
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <c:if test="${empty sessionScope['connecte']}">
            <a id="btn-demo" class="navbar-brand">Demo</a>
        </c:if>
      </div>
       <c:if test="${empty sessionScope['connecte']}">
        <div class="navbar-collapse collapse">
          <form action="ServletInscription" class="navbar-form navbar-right">
                <input type="hidden" value="initialiserFormulaire" name="action">
            <button class="btn btn-success" type="submit" onclick="self.location.href='fInscription.jsp'">S'inscire</button>
          </form>
          <form role="form" class="navbar-form navbar-right" action="ServletConnexion">
            <div class="form-group">
              <input type="text" class="form-control" placeholder="Pseudo" name="login">
            </div>
            <div class="form-group">
              <input type="password" class="form-control" placeholder="Password" name="password">
            </div>
            <input type="hidden" name="action" value="identifierUtilisateur">
            <button class="btn btn-success" type="submit">S'identifer</button>
          </form>

           
             
        </div><!--/.navbar-collapse -->
      </c:if>
     <c:if test="${not empty sessionScope['connecte']}">
         <div class="navbar-collapse collapse">
          <form role="form" class="navbar-form navbar-right" action="ServletConnexion">
            <input type="hidden" name="action" value="deconnecterUtilisateur">
            <button class="btn btn-success" type="submit">Se déconnecter</button>
          </form>    
        </div><!--/.navbar-collapse -->
     </c:if>
    </div>
   
</div>
    <c:if test="${param['action']=='identifierUtilisateurError'}">
        <div class="alert alert-danger" id="error-identification">Pseudo ou Mot de passe incorrect ! Veuillez ressaisir vos identifiants.</div>
    </c:if>
