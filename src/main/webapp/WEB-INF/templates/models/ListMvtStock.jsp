<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.MvtStock" %>
<%@ page import="com.web.atelier.Models.Composant" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Mouvements de Stock</title>
</head>
<body>
    <h1>Liste des Mouvements de Stock</h1>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Entrée</th>
            <th>Sortie</th>
            <th>Composant</th>
            <th>Date du Mvt</th>
        </tr>
        <%
            List<MvtStock> listMvtStock = (List<MvtStock>) request.getAttribute("listMvtStock");
            for (MvtStock mvtStock : listMvtStock) {
        %>
            <tr>
                <td><%= mvtStock.getId() %></td>
                <td><%= mvtStock.getEntree() %></td>
                <td><%= mvtStock.getSortie() %></td>
                <td><%= mvtStock.getComposant().getName() %></td>
                <td><%= mvtStock.getDateMvt() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>