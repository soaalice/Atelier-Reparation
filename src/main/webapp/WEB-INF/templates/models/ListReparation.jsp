<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.Reparation" %>
<%@ page import="com.web.atelier.Models.Ordinateur" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Reparations</title>
</head>
<body>
    <form action="/reparations/search" method="get">
        <label for="minDate">Date min :</label>
        <input type="date" id="minDate" name="minDate">

        <label for="maxDate">Date max :</label>
        <input type="date" id="maxDate" name="maxDate">

        <label for="modele">Modèle :</label>
        <input type="text" id="modele" name="modele">

        <button type="submit">Rechercher</button>
    </form>
    <h1>Liste des Reparations</h1>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Ordinateur</th>
            <th>Date de Réparation</th>
            <th>Montant Total</th>
            <th>Durée Totale</th>
        </tr>
        <%
            List<Reparation> listReparations = (List<Reparation>) request.getAttribute("listReparations");
            for (Reparation reparation : listReparations) {
        %>
            <tr>
                <td><%= reparation.getId() %></td>
                <td><%= reparation.getOrdinateur().getName() %></td>
                <td><%= reparation.getDateReparation() %></td>
                <td><%= reparation.getMontantTotal() %></td>
                <td><%= reparation.getDureeTotale() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>
