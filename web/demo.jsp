<%-- 
    Document   : demo
    Created on : 4 juin 2014, 22:08:26
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${empty param['resultat']}">
    <form action="ServletUsers" id="form-demo-achat">
    <jsp:include page="resultatRecherche.jsp"/>
    

    <input type="hidden" value="acheterGratuit" name="action" id="inputh-acchatG">
    <button class="btn btn-success" type="submit" id="achatG">Acheter gratuitement !</button>
</form>
</c:if>
<c:if test="${param['resultat']=='success'}">
    <div class="alert alert-success" id="achatG-success">Votre achat est un succès !</div> 
                <input type="button" class="btn btn-lg btn-primary btn-block" value="Retour à l'acceuil" onclick="self.location.href='index.jsp'"><br>
                </div><div><img align="center" src="img/Angus.jpg" id="angus-img"></div>

   
</c:if>

