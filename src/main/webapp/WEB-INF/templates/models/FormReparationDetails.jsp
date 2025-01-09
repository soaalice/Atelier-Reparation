i<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.Reparation" %>
<%@ page import="com.web.atelier.Models.Ordinateur" %>
<%@ page import="com.web.atelier.Models.TypeReparation" %>
<%@ page import="com.web.atelier.Models.Composant" %>

<%
    Object ordinateurId =  request.getAttribute("ordinateurId");
    if (ordinateurId == null) {
        response.sendRedirect("/reparations/form");
        return;  // Arrête l'exécution du reste de la page JSP
    }
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire Reparation details</title>
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

    <form action="/reparations" method="post">
        <h1>Réparation Details</h1>

        <input type="hidden" name="ordinateurId" value="<%= request.getAttribute("ordinateurId") %>"></input>

        <input type="hidden" name="dateReparation" value="<%= request.getAttribute("dateReparation") %>"></input>

        <label for="composant">composant:</label>
        
            <%
                List<Composant> listcomposants = (List<Composant>) request.getAttribute("listComposants");
                for (Composant composant : listcomposants) {
            %>
                <input id="composant_<%=composant.getId()%>" type="checkbox" name="composants" value="<%= composant.getId() %>"><%= composant.getName() %></input>

                <select name="reparation_<%= composant.getId() %>" id="select_<%= composant.getId() %>" style='display:none'>
                    <%
                        List<TypeReparation> listType = (List<TypeReparation>) request.getAttribute("listTypeReparations");
                        for (TypeReparation type : listType) {
                    %>
                        <option value="<%= type.getId() %>"><%= type.getName() %></option>
                    <% } %>
                </select>
            <% } %>


        <button type="submit">Enregistrer</button>
    </form>

    <script>
    // Ajouter un gestionnaire d'événement pour chaque checkbox
    document.querySelectorAll('input[type="checkbox"]').forEach(function(checkbox) {
        checkbox.addEventListener('change', function () {
            var select = document.getElementById('select_'+this.value);
            if (this.checked) {
                // Afficher le select si la case est cochée
                select.style.display = 'inline';
            } else {
                // Cacher le select si la case est décochée
                select.style.display = 'none';
            }
        }
    }  
    
    </script>
</body>
</html>
