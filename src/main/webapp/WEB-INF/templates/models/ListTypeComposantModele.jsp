<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.TypeComposantModele" %>
<%@ page import="com.web.atelier.Models.Modele" %>
<%@ page import="com.web.atelier.Models.TypeComposant" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Type Composant Modèles</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />
    <h1>Liste des Type Composant Modèles</h1>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Modele</th>
            <th>Type Composant</th>
            <th>Min</th>
            <th>Max</th>
        </tr>
        <%
            List<TypeComposantModele> listTypeComposantModeles = (List<TypeComposantModele>) request.getAttribute("listTypeComposantModeles");
            for (TypeComposantModele typeComposantModele : listTypeComposantModeles) {
        %>
            <tr>
                <td><%= typeComposantModele.getId() %></td>
                <td><%= typeComposantModele.getModele().getName() %></td>
                <td><%= typeComposantModele.getTypeComposant().getName() %></td>
                <td><%= typeComposantModele.getMin() %></td>
                <td><%= typeComposantModele.getMax() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>
