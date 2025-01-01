<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.ComposantModele" %>
<%@ page import="com.web.atelier.Models.Composant" %>
<%@ page import="com.web.atelier.Models.Modele" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Composants Modèles</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />

    <h1>Liste des Composants Modèles</h1>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Composant</th>
            <th>Modele</th>
        </tr>
        <%
            List<ComposantModele> listComposantModeles = (List<ComposantModele>) request.getAttribute("listComposantModeles");
            for (ComposantModele composantModele : listComposantModeles) {
        %>
            <tr>
                <td><%= composantModele.getId() %></td>
                <td><%= composantModele.getComposant().getName() %></td>
                <td><%= composantModele.getModele().getName() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>
