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
        <script>
            
           
             function selectionnerStyle(val){
                $("#style-input").val(val); 
                $("#sty-inputh-search").attr("value",val);
            }
            
            function selectionnerAnnee(val){
                $("#annee-input").val(val); 
                $("#ann-inputh-search").attr("value",val);
            }
            
            function selectionnerInstrument(val){
                $("#instrument-input").val(val); 
                $("#instru-inputh-search").attr("value",val);
            }
            
            function exectuerFormProfil(){
                $("#menu-profil").submit();
            }
            
             $(document).ready(function() {
                $('#menu-style').click(function()
                    {
                    $('#form-style-init').submit();
                });
                
                $("#achatPanier").click(function(){
                    if( $("#panier-info table input").attr("name") != "action"){
                        $("#panier-info table input").attr("name","selectionnee");
                        $("#panier-info").slideUp("slow");
                    }
                })
                
                 $('#btn-profil').click(function(){
                    $('#menu-profil').submit();
                });
                
                $('#menu-profil-search').click(function(){
                    $('#form-profil-init').submit();
                });
                
                $('#menu-musiques-search').click(function(){
                    $('#form-musiques-init').submit();
                });
                
                $('#menu-annee-search').click(function()
                    {
                    $('#form-annee-init').submit();
                });
                
                $('#menu-instrument-search').click(function()
                    {
                    $('#form-instrument-init').submit();
                });
                
                 $('#menu-link-annee').click(function(){
                    $('#form-instrument-ah').submit();
                });
                
                 $('#btn-demo').click(function(){
                    $('#form-init').submit();
                });
                
                 $('#menu-gen > li').click(function(){
                    $("#menu-gen > li").removeClass("active");
                    $(this).addClass("active");
                });
                
                <c:if test="${param['action']=='afficherPanier'}" >
                        $("#panier-info").slideDown("slow");
                </c:if>
                    
                <c:if test="${(param['action'] == 'achatSuccess')}">
                   $("#achatS").slideDown("slow");
         
                </c:if>
                $("#mettrePanier").click(function(){
                        $("#form-mettre-p").slideUp("slow");
                })
                    
         

                
                 <c:if test="${param['resultat']=='success'}" >
                        $("#panier-info").slideDown("slow");
                            
                        $("#angus-img").slideDown("slow");
                        
                </c:if>
                
            });
            
            function selectionnerMusique(val){
                var id = "musique-"+val;
                if($("#musique-"+val).is(":checked")){
                    $("#musiqueR-"+val).attr("name", "selectionnee");
                }else
                    $("#musiqueR-"+val).attr("name", "");
            }
        </script>
    </head>
    <body>
        <header id="header">
            <jsp:include page="header.jsp"/>
        </header>
        <c:if test="${param['action'] == 'initialiserDemo'}">
        <div id="demo" class="container backgrouWhite"> 
            <jsp:include page="demo.jsp"/>
        </div>
        </c:if>
        <c:if test="${not empty sessionScope['connecte']}"> 
        <div class="container backgrouWhite" id="menu">
       
            <jsp:include page="menu.jsp"/>
            <c:if test="${param['action'] == 'afficherProfilSuccess'}">
                <jsp:include page="profil.jsp"/>
            </c:if>

            <c:if test="${(param['action'] == 'rechercherTitreForm' || param['action'] == 'rechercherArtisteForm' || param['action'] == 'rechercherStyleForm' || param['action'] == 'rechercherAnneeForm' || param['action'] == 'rechercherInstruForm' ||
                          param['action'] == 'rechercheTitreResultat' || param['action'] == 'rechercheResultat' ) }">
                    <jsp:include page="fRecherche.jsp"/>
            </c:if>
             <c:if test="${( param['action'] == 'rechercheResultat' || param['action'] == 'afficherMusiques' ) }">
            <!--<div id="resultat-recherche" >-->
                <form action="ServletUsers" id="form-mettre-p">
                    <jsp:include page="resultatRecherche.jsp"/> 
                    <input type="hidden" value="mettrePanier" name="action" id="inputh-mettre-panier">
                    <button class="btn btn-success" type="submit" id="mettrePanier">Mettre au panier !</button>
                </form>
            <!--</div>-->
            </c:if>
            <c:if test="${(param['action'] == 'afficherPanier') }">
            <div class="panel panel-info" id="panier-info">
                <div class="panel-heading">
                  <h3 class="panel-title">Votre panier</h3>
                </div>
                <div class="panel-body">
                          <form action="ServletUsers" id="form-achat-p">
                              <jsp:include page="resultatRecherche.jsp"/>
                              <div class="alert alert-info">Votre facture s'élève à ${prixAchat} €</div>
                              <input type="hidden" value="AcheterPanier" name="action" id="inputh-achat-panier">
                              <button class="btn btn-success" type="submit" id="achatPanier">Acheter !</button>
                          </form>
                </div>
            </div>
            </c:if>
            <c:if test="${(param['action'] == 'rechercheAucunResultat')}">
                 <div class="alert alert-warning">Votre recherche n'a abouti à aucun résultat !</div>
            </c:if>
            <c:if test="${(param['action'] == 'panierAucuneMusique')}">
                 <div class="alert alert-warning">Votre panier est vide !</div>
            </c:if> 
            <c:if test="${(param['action'] == 'achatSuccess')}">
                 <div class="alert alert-warning" id="achatS">Votre achat a été réalisé !</div>
            </c:if> 
            
        </div>
         </c:if>
    </div>
    </body>
</html>
