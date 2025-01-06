<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.Tarif" %>
<%@ page import="com.web.atelier.Models.Composant" %>
<%@ page import="com.web.atelier.Models.TypeReparation" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Tarifs</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />
    <h1>Liste des Tarifs</h1>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Prix</th>
            <th>Durée</th>
            <th>Composant</th>
            <th>Type de Réparation</th>
        </tr>
        <%
            List<Tarif> listTarifs = (List<Tarif>) request.getAttribute("listTarifs");
            for (Tarif tarif : listTarifs) {
        %>
            <tr>
                <td><%= tarif.getId() %></td>
                <td><%= tarif.getPrix() %></td>
                <td><%= tarif.getDuree() %></td>
                <td><%= tarif.getComposant().getName() %></td>
                <td><%= tarif.getTypeReparation().getName() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>
