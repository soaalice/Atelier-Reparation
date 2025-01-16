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
                <td><%= composant.getName() +" - "+ composant.getValeur() + " " + composant.getTypeComposant().getUnite().getName() %></td>
                <td><%= composant.getTypeComposant().getName() %></td>
                <td><%= recommendation.getMois() %></td>
                <td><%= recommendation.getAnnee() %></td>
            </tr>
        <% } %>
    </table>

    <form action="/recommendations" method="get">
        
        <label for="typeComposantId">Type de composant :</label>
        <select id="typeComposantId" name="typeComposantId">
            <option value="">Tous</option>
            <%
                List<TypeComposant> listTypeComposant = (List<TypeComposant>) request.getAttribute("listTypeComposants");
                if (listTypeComposant != null) {
                    for (TypeComposant typeComposant : listTypeComposant) {
                %>
                        <option value="<%= typeComposant.getId() %>"><%= typeComposant.getName() %></option>
                <%
                    }}
                %>
        </select>

        <%-- <label for="dateMin">DateMin:</label>
        <input type="date" id="dateMin" name="dateMin"   />

        <label for="dateMax">DateMax:</label>
        <input type="date" id="dateMax" name="dateMax"   /> --%>

        <label for="annee">Annee:</label>
        <input type="number" id="date" name="annee" min="0"/>

        <label for="mois">Mois:</label>
        <select name="mois">
        <option value="">Tous</option>
        <%
            for(int i = 1 ; i <=12 ; i++){
                %>
                <option value="<%=i%>"><%=i%></option>
                <%
            }
        %>
        </select>
        
        <button type="submit">Filtrer</button>
    </form>

</body>
</html>
