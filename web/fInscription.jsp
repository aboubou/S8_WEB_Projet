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
            
            function Inscrire(){
                
            }
        </script>
    </head>
    <body>
        <div class="container">

      <form role="form" class="form-signin">
        <h2 class="form-signin-heading">Formulaire d'inscription</h2>
        
        <label>Pseudonyme *</label>
        <input type="text"  placeholder="Pseudo" class="form-control" required><br>
        <label>Mot de passe *</label>
        <input type="password"  placeholder="Password" class="form-control" required><br>
        <label>Nom *</label>
        <input type="text"  placeholder="Nom" class="form-control" required><br>
        <label>Prénom *</label>
        <input type="text"  placeholder="Prénom" class="form-control" required><br>
        <label>Adresse *</label>
        <input type="text"  placeholder="Adresse" class="form-control" required><br>
        <label>Ville *</label>
        <input type="text"  placeholder="Ville" class="form-control" required><br>
        <label>Code postal *</label>
        <input type="text"  placeholder="Code postal" class="form-control" required><br>
        <label>E-mail *</label>
        <input type="email" autofocus="" required placeholder="Email address" class="form-control" required><br>
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
        <button type="submit" class="btn btn-lg btn-primary btn-block" onsubmit="Inscrire();">Valider</button>
      </form>

    </div>
    </body>
</html>
