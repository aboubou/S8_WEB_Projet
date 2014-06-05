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
            
             $(document).ready(function() {
                $('#menu-style').click(function()
                    {
                    $('#form-style-init').submit();
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
                
                 <c:if test="${param['resultat']=='success'}" >
                        $("#achatG-success").slideDown("slow");
                            
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
        <div id="demo" class="container"> 
            <jsp:include page="demo.jsp"/>
        </div>
        </c:if>
        <c:if test="${not empty sessionScope['connecte']}"> 
        <div class="container" id="menu">
         
            <jsp:include page="menu.jsp"/>
            <jsp:include page="fRecherche.jsp"/>
           
            
            <!--<div id="resultat-recherche" >-->
                    <jsp:include page="resultatRecherche.jsp"/> 
            <!--</div>-->
        </div>
         </c:if>
    </div>
    </body>
</html>
