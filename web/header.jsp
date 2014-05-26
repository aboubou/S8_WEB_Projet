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
        <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a href="#" class="navbar-brand">Project name</a>
      </div>
      <c:if test="${empty param.idSession}">
        <div class="navbar-collapse collapse">
          <form role="form" class="navbar-form navbar-right">
            <div class="form-group">
              <input type="text" class="form-control" placeholder="Pseudo">
            </div>
            <div class="form-group">
              <input type="password" class="form-control" placeholder="Password">
            </div>
            <button class="btn btn-success" type="submit">S'identifer</button>
            <button class="btn btn-success" type="button" onclick="self.location.href='fInscription.jsp'">S'inscire</button>
          </form>
        </div><!--/.navbar-collapse -->
      </c:if>
    </div>
</div>
