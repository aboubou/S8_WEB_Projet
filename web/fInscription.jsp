<%-- 
    Document   : fInscription
    Created on : 24 mai 2014, 11:59:00
    Author     : Alexandre
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
        <link rel="stylesheet" type="text/css" href="css/fInscription.css">
        <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script>
            var nbInstrument = 1;
            function ajouterInstru(){
                nbInstrument +=1;
                var instru = "<br><div class=\"input-group\" id=\"instru-input-"+nbInstrument+"\">"+
                      "<div class=\"input-group-btn\">"+
                      "<button type=\"button\" class=\"btn btn-default dropdown-toggle\" data-toggle=\"dropdown\">Instruments <span class=\"caret\"></span></button>"+
                      "<ul class=\"dropdown-menu\">"+
                      <c:forEach var="i" items="${requestScope['ListeInstruments']}" >
                           "<li><a id=\"i-${i.id}\" onclick=\"SelectionnerInstru("+nbInstrument+",${i.id});\" value=\"${i.id}\">${i.instrument}</a></li>"+
                      </c:forEach>
                      "</ul>"+
                      "</div><!-- /btn-group -->"+
                      "<input type=\"hidden\"  id=\"i-inputh-"+nbInstrument+"\"  name=\"instrument-choosen\" value=\"\">"+
                      "<input type=\"text\" class=\"form-control\" id=\"instrut-input-"+nbInstrument+"\" readonly name=\"instrument\">"+
                      "</div>";
                //$("#add-instru").before($("#instru-input").html());
                $("#add-instru").before(instru);
                
            }
            function SelectionnerAbo(val){
                var str = $( "#a-"+val+"" ).text();
                $("#abonnement-input").val(str); 
                $("#a-inputh").attr("value",val);
            }
            
            function SelectionnerInstru(instru, val){
                var str = $( "#i-"+val+"" ).text();
                $("#i-inputh-"+instru).attr("value",val);
                $("#instrut-input-"+instru).val(str);
            }
            
            function controleInscription(){
                $("div .error-message").hide();
                $("div").removeClass("error-message");
                var erreur = 0;
                if($("#input-pseudo").val() == null || $("#input-pseudo").val() == ""){
                    $("#error-pseudo").addClass("error-message");
                    $("#error-pseudo").show();
                    erreur += 1;
                }
                if($("#input-pass").val() == null || $("#input-pass").val() == ""){
                    $("#error-pass").addClass("error-message");
                    $("#error-pass").show();
                    erreur += 1;
                }
                if($("#input-name").val() == null || $("#input-name").val() == ""){
                    $("#error-name").addClass("error-message");
                    $("#error-name").show();
                    erreur += 1;
                }
                if($("#input-firstname").val() == null || $("#input-firstname").val() == ""){
                    $("#error-firstname").addClass("error-message");
                    $("#error-firstname").show();
                    erreur += 1;
                }
                if($("#input-address").val() == null || $("#input-address").val() == ""){
                    $("#error-address").addClass("error-message");
                    $("#error-address").show();
                    erreur += 1;
                }
                if($("#input-town").val() == null || $("#input-town").val() == ""){
                    $("#error-town").addClass("error-message");
                    $("#error-town").show();
                    erreur += 1;
                }
                if($("#input-postal").val() == null || $("#input-postal").val() == ""){
                    $("#error-postal").addClass("error-message");
                    $("#error-postal").show();
                    erreur += 1;
                }
                if($("#input-postal").val() == null || $("#input-postal").val() == ""){
                    $("#error-postal").addClass("error-message");
                    $("#error-postal").show();
                    erreur += 1;
                }
                 if($("#input-mail").val() == null || $("#input-mail").val() == ""){
                    $("#error-mail").addClass("error-message");
                    $("#error-mail").show();
                    erreur += 1;
                }
                for(var i=1; i <= nbInstrument; i++){
                    if($("#instrut-input-"+i).val() == null || $("#instrut-input-"+i).val() == ""){
                        $("#error-instru").addClass("error-message");
                        $("#error-instru").show();
                        erreur += 1;
                        break;
                    }
                }
                if($("#abonnement-input").val() == null || $("#abonnement-input").val() == ""){
                    $("#error-abo").addClass("error-message");
                    $("#error-abo").show();
                    erreur += 1;
                }
                 
                if(erreur == 0){
                    $("#inscription-form" ).toggle( "slow" );
                    $("#inscription-form").submit();
                }
            }
            
            $(document).ready(function(){
                <c:if test="${param['action']=='creerUtilisateurSuccess'}" >
                        $("#inscription-success").slideDown("slow");
                            
                        $("#angus-img").slideDown("slow");
                        
                </c:if>
            });
        </script>
    </head>
    <body>
        <div class="container" >
            <c:if test="${param['action']=='creerUtilisateurSuccess'}" >
                <div class="alert alert-success" id="inscription-success">Votre insciption est un succès !</div>
                <input type="button" class="btn btn-lg btn-primary btn-block" value="Retour à l'acceuil" onclick="self.location.href='index.jsp'"><br>
                </div><div>
                   <img align="center" src="img/Angus.jpg" id="angus-img">
                   
            </c:if>
            <c:if test="${param['action']=='creerUtilisateurError'}" >
                   <div class="alert alert-danger">Une erreur est survenue lors de l'enregistrement de votre inscription !</div>
            </c:if>       
            <c:if test="${param['action']=='formulaireInscription'}" >
                <c:if test="${param['pseudo']=='existant'}" >
                   <div class="alert alert-danger">Le pseudo est déjà utilisé ! Veuillez en choisir un autre !</div>
                </c:if>
                <form id="inscription-form" role="form" class="form-signin" action="ServletInscription">
                  <h2 class="form-signin-heading">Formulaire d'inscription</h2>

                  <label>Pseudonyme *</label>
                  <div class="alert alert-danger error-cache" id="error-pseudo">Veuillez indiquer un pseudonyme</div>
                  <input type="text" autofocus="" placeholder="Pseudo" class="form-control"  id="input-pseudo" name="pseudo" ><br>
                  <label>Mot de passe *</label>
                  <div class="alert alert-danger error-cache" id="error-pass">Veuillez indiquer un mot de passe</div>
                  <input type="password"  placeholder="Password" class="form-control" id="input-pass" name="mdp"><br>
                  <label>Nom *</label>
                  <div class="alert alert-danger error-cache" id="error-name">Veuillez indiquer un nom</div>
                  <input type="text"  placeholder="Nom" class="form-control"  id="input-name" name="nom"><br>
                  <label>Prénom *</label>
                  <div class="alert alert-danger error-cache" id="error-firstname">Veuillez indiquer un prénom</div>
                  <input type="text"  placeholder="Prénom" class="form-control"  id="input-firstname" name="prenom"><br>
                  <label>Adresse *</label>
                  <div class="alert alert-danger error-cache" id="error-address">Veuillez indiquer une adresse</div>
                  <input type="text"  placeholder="Adresse" class="form-control"  id="input-address" name="adresse"><br>
                  <label>Ville *</label>
                  <div class="alert alert-danger error-cache" id="error-town">Veuillez indiquer une ville</div>
                  <input type="text"  placeholder="Ville" class="form-control"  id="input-town" name="ville"><br>
                  <label>Code postal *</label>
                  <div class="alert alert-danger error-cache" id="error-postal">Veuillez indiquer un code postal</div>
                  <input type="text"  placeholder="Code postal" class="form-control" id="input-postal" name="codep"><br>
                  <label>E-mail *</label>
                  <div class="alert alert-danger error-cache" id="error-mail">Veuillez indiquer un maill</div>
                  <input type="email" placeholder="Email address" class="form-control" id="input-mail" name="mail"><br>
                  <label>Instrument(s) joué(s) *</label>
                  <div class="alert alert-danger error-cache" id="error-instru">Veuillez indiquer un instrument</div>
                  <div class="input-group" id="instru-input-1">
                      <div class="input-group-btn">
                          <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Instruments <span class="caret"></span></button>
                          <ul class="dropdown-menu">
                              <c:forEach var="i" items="${requestScope['ListeInstruments']}" >
                                    <li><a id="i-${i.id}" onclick="SelectionnerInstru(1,${i.id});" value="${i.id}">${i.instrument}</a></li>
                              </c:forEach>
                          </ul>
                      </div><!-- /btn-group -->
                      <input type="hidden"  id="i-inputh-1"  name="instrument-choosen" value="">
                      <input type="text" readonly class="form-control" id="instrut-input-1"  name="instrument">
                  </div>
                  <a id="add-instru" onclick="ajouterInstru();">Ajouter un instrument</a><br><br>
                  <label>Choissisez votre abonnement *</label>
                  <div class="alert alert-danger error-cache" id="error-abo">Veuillez indiquer un abonnement</div>
                  <div class="input-group">
                      <div class="input-group-btn">
                          <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Abnonement <span class="caret"></span></button>
                          <ul class="dropdown-menu">
                               <c:forEach var="a" items="${requestScope['ListeAbonnements']}" >
                                    <li><a id="a-${a.id}" onclick="SelectionnerAbo(${a.id});" value="${a.id}">${a.description} - ${a.prix} €</a></li>
                              </c:forEach>
                          </ul>
                      </div><!-- /btn-group -->
                      <input type="hidden" readonly class="form-control" id="a-inputh"  val="" name="abonnement-choosen">
                      <input type="text" readonly class="form-control" id="abonnement-input" name="abonnement">
                  </div><br>
                  <input type="hidden" value="creerUtilisateur" name="action">
                  <input type="button" class="btn btn-lg btn-primary btn-block" value="Valider" onclick="controleInscription()">
                </form>
           </c:if>
    </div>
    </body>
</html>
