<%-- 
    Document   : fInscription
    Created on : 24 mai 2014, 11:59:00
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
        <link rel="stylesheet" type="text/css" href="css/theme.css">
        <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script>

            function ajouterInstru(){
                var instru = "<br><div class=\"input-group\" id=\"instru-input\">"+
                      "<div class=\"input-group-btn\">"+
                      "<button type=\"button\" class=\"btn btn-default dropdown-toggle\" data-toggle=\"dropdown\">Instruments<span class=\"caret\"></span></button>"+
                      "<ul class=\"dropdown-menu\">"+
                      "<li><a id=\"i-1\" onclick=\"SelectionnerAbo(1);\">Instrument 1</a></li>"+
                      "<li><a id=\"i-2\" onclick=\"SelectionnerAbo(2);\">Instrument 2</a></li>"+
                      "<li><a id=\"i-3\" onclick=\"SelectionnerAbo(3);\">Instrument 3</a></li>"+
                      "</ul>"+
                      "</div><!-- /btn-group -->"+
                      "<input type=\"text\" class=\"form-control\" id=\"abonnement-input\" required>"+
                      "</div>";
                //$("#add-instru").before($("#instru-input").html());
                $("#add-instru").before(instru);
            }
            function SelectionnerAbo(val){
                var str = $( "#"+val+"" ).text();
                $("#abonnement-input").val(str);              
            }
            
            function controleInscription(){
                var erreur = 0;
                if($("#input-pseudo").val() == null || $("#input-pseudo").val() == ""){
                    $("#error-pseudo").show();
                    erreur += 1;
                }
                else if($("#input-pass").val() == null || $("#input-pass").val() == ""){
                    $("#error-pass").show();
                    erreur += 1;
                }
                else if($("#input-name").val() == null || $("#input-name").val() == ""){
                    $("#error-name").show();
                    erreur += 1;
                }
                 else if($("#input-firstname").val() == null || $("#input-firstname").val() == ""){
                    $("#error-firstname").show();
                    erreur += 1;
                }
                else if($("#input-address").val() == null || $("#input-address").val() == ""){
                    $("#error-address").show();
                    erreur += 1;
                }
                else if($("#input-town").val() == null || $("#input-town").val() == ""){
                    $("#error-town").show();
                    erreur += 1;
                }
                else if($("#input-postal").val() == null || $("#input-postal").val() == ""){
                    $("#error-postal").show();
                    erreur += 1;
                }
                
                if(erreur == 0){
                    
                }
                    
                    
            }
        </script>
    </head>
    <body>
        <div class="container">

      <form role="form" class="form-signin">
        <h2 class="form-signin-heading">Formulaire d'inscription</h2>

        <label>Pseudonyme *</label>
        <div class="alert alert-danger error-cache" id="error-pseudo">Veuillez indiquer un pseudonyme</div>
        <input type="text"  placeholder="Pseudo" class="form-control" required id="input-pseudo"><br>
        <label>Mot de passe *</label>
        <div class="alert alert-danger error-cache" id="error-pass">Veuillez indiquer un mot de passe</div>
        <input type="password"  placeholder="Password" class="form-control" required id="input-pass"><br>
        <label>Nom *</label>
        <div class="alert alert-danger error-cache" id="error-name">Veuillez indiquer un nom</div>
        <input type="text"  placeholder="Nom" class="form-control" required id="input-name"><br>
        <label>Prénom *</label>
        <div class="alert alert-danger error-cache" id="error-firstname">Veuillez indiquer un prénom</div>
        <input type="text"  placeholder="Prénom" class="form-control" required id="input-firstname"><br>
        <label>Adresse *</label>
        <div class="alert alert-danger error-cache" id="error-address">Veuillez indiquer une adresse</div>
        <input type="text"  placeholder="Adresse" class="form-control" required id="input-address"><br>
        <label>Ville *</label>
        <div class="alert alert-danger error-cache" id="error-town">Veuillez indiquer une ville</div>
        <input type="text"  placeholder="Ville" class="form-control" required id="intput-town"><br>
        <label>Code postal *</label>
        <div class="alert alert-danger error-cache" id="error-postal">Veuillez indiquer un code postal</div>
        <input type="text"  placeholder="Code postal" class="form-control" required id="input-postal"><br>
        <label>E-mail *</label>
        <div class="alert alert-danger error-cache" id="error-mail">Veuillez indiquer un code postal</div>
        <input type="email" autofocus="" required placeholder="Email address" class="form-control" required id="input-mail"><br>
        <label>Instrument(s) joué(s) *</label>
        <div class="input-group" id="instru-input">
            <div class="input-group-btn">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Instruments<span class="caret"></span></button>
                <ul class="dropdown-menu">
                    <li><a id="i-1" onclick="SelectionnerAbo(1);">Instrument 1</a></li>
                    <li><a id="i-2" onclick="SelectionnerAbo(2);">Instrument 2</a></li>
                    <li><a id="i-3" onclick="SelectionnerAbo(3);">Instrument 3</a></li>
                </ul>
            </div><!-- /btn-group -->
            <input type="text" class="form-control" id="abonnement-input" required>
        </div>
        <a id="add-instru" onclick="ajouterInstru();">Ajouter un instrument</a><br><br>
        <label>Choissisez votre abonnement *</label>
        <div class="input-group">
            <div class="input-group-btn">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Abnonement <span class="caret"></span></button>
                <ul class="dropdown-menu">
                    <li><a id="1" onclick="SelectionnerAbo(1);">Abonnement 3€</a></li>
                    <li><a id="2" onclick="SelectionnerAbo(2);">Abonnement 4€</a></li>
                    <li><a id="3" onclick="SelectionnerAbo(3);">Abonnement 5€</a></li>
                </ul>
            </div><!-- /btn-group -->
            <input type="text" class="form-control" id="abonnement-input" required>
        </div><br>
        <button type="submit" class="btn btn-lg btn-primary btn-block" onsubmit="controleInscription();">Valider</button>
      </form>

    </div>
    </body>
</html>
