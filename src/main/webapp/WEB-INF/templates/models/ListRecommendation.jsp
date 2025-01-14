<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.Recommendation" %>
<%@ page import="com.web.atelier.Models.Composant" %>
<%@ page import="com.web.atelier.Models.TypeComposant" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Recommendations</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />
    <h1>Liste des Recommendations</h1>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Composant</th>
            <th>Type Composant</th>
            <th>Mois</th>
            <th>Annee</th>
        </tr>
        <%
            List<Recommendation> listRecommendations = (List<Recommendation>)request.getAttribute("listRecommendations");
            for (Recommendation recommendation : listRecommendations) {
        %>
            <tr>
                <td><%= recommendation.getId() %></td>
                <% Composant composant = recommendation.getComposant(); %>
                <td><%= composant.getName() +"-"+ composant.getValeur() + composant.getTypeComposant().getUnite().getName() %></td>
                <td><%= composant.getTypeComposant().getName() %></td>
                <td><%= recommendation.getMois() %></td>
                <td><%= recommendation.getAnnee() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>
