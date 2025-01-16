i<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.TypeReparation" %>
<%@ page import="com.web.atelier.Models.Ordinateur" %>
<%@ page import="com.web.atelier.Models.TypeReparation" %>
<%@ page import="com.web.atelier.Models.Composant" %>

<%
    Object ordinateurId = request.getAttribute("ordinateurId");
    if (ordinateurId == null) {
        response.sendRedirect("/reparations/form");
        return; 
    }
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire Réparation details</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />
    <style>
        /* Style de base pour les cases à cocher */
        input[type="checkbox"] {
            width: 20px; /* Taille de la case à cocher */
            height: 20px; /* Taille de la case à cocher */
            margin-right: 10px; /* Espace entre la case et le label */
            border: 2px solid #34495e; /* Bordure de la case */
            border-radius: 4px; /* Coins arrondis */
            background-color: #fff; /* Fond de la case */
            position: relative; /* Positionnement pour l'état coché */
            cursor: pointer; /* Curseur de la souris au survol */
            transition: all 0.3s ease; /* Transition fluide */
        }

        /* État lorsque la case est cochée */
        input[type="checkbox"]:checked {
            background-color: #f39c12; /* Fond jaune pour la case cochée */
            border-color: #f39c12; /* Bordure jaune pour la case cochée */
        }

        /* Coche qui apparait lorsque la case est cochée */
        input[type="checkbox"]:checked::before {
            content: '\2713'; /* Ajoute une coche dans la case */
            position: absolute;
            top: 2px;
            left: 5px;
            font-size: 16px;
            color: white; /* Coche en blanc */
        }

        /* Lorsque la case est survolée */
        input[type="checkbox"]:hover {
            border-color: #f39c12; /* Change la bordure au survol */
        }

        /* Style pour le label associé */
        input[type="checkbox"] + label {
            font-size: 1rem;
            font-weight: 500;
            color: #34495e;
            cursor: pointer; /* Curseur de la souris au survol du label */
            display: inline-block;
            margin-left: 10px; /* Espacement entre la case et le texte */
        }

        /* Focus sur l'input */
        input[type="checkbox"]:focus {
            outline: none; /* Enlever la bordure par défaut du focus */
            box-shadow: 0 0 5px rgba(243, 156, 18, 0.7); /* Ajouter une ombre autour de la case au focus */
        }

    </style>

    <% 
        String successMessage = (String) request.getAttribute("successMessage");
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (successMessage != null) {
    %>
        <div style="color: green; font-weight: bold;">
            <%= successMessage %>
        </div>
    <% 
        } 
        if (errorMessage != null) {
    %>
        <div style="color: red; font-weight: bold;">
            <%= errorMessage %>
        </div>
    <% 
        }
    %>

    <form action="/reparations" method="post">
        <h1>Réparation Details</h1>

        <input type="hidden" name="ordinateurId" value="<%= request.getAttribute("ordinateurId") %>"></input>

        <input type="hidden" name="dateReparation" value="<%= request.getAttribute("dateReparation") %>"></input>
        <input type="hidden" name="clientId" value="<%= request.getAttribute("clientId") %>"></input>

        <label for="composant">composant:</label>
        <div style="display: flex; align-items: center; flex-wrap: wrap;">
        
            <%
                List<Composant> listcomposants = (List<Composant>) request.getAttribute("listComposants");
                List<TypeReparation> listTypeReparations = (List<TypeReparation>) request.getAttribute("listTypeReparations");
                for (Composant composant : listcomposants) {
            %>
                <input type="checkbox" name="composants" value="<%= composant.getId() %>" id="composant_<%= composant.getId() %>">
                <label for="composant_<%= composant.getId() %>"><%= composant.getName() +" - "+ composant.getValeur() + " " + composant.getTypeComposant().getUnite().getName() %></label>

                <select name="reparation_<%= composant.getId() %>" id="select_<%= composant.getId() %>" style="display:none;">
                    <% for (TypeReparation reparation : listTypeReparations) { %>
                        <option value="<%= reparation.getId() %>"><%= reparation.getName() %></option>
                    <% } %>
                </select>
            <% } %>
        </div>


        <button type="submit">Enregistrer</button>
    </form>

    <script>
        // Script pour afficher le select des réparations lorsque la case est cochée
        document.querySelectorAll('input[type="checkbox"]').forEach(function(checkbox) {
            checkbox.addEventListener('change', function() {
                var select = document.getElementById('select_' + this.value);
                if (this.checked) {
                    select.style.display = 'inline';
                } else {
                    select.style.display = 'none';
                }
            });
        });
    </script>
</body>
</html>
