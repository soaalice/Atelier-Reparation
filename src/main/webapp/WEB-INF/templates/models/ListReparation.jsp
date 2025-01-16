<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.Reparation" %>
<%@ page import="com.web.atelier.Models.Ordinateur" %>
<%@ page import="com.web.atelier.Models.TypeComposant" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Réparations</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />
    <h1>Liste des Réparations</h1>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Ordinateur</th>
            <th>Client</th>
            <th>Date de Réparation</th>
            <%-- <th>Montant Total</th>
            <th>Durée Totale</th> --%>
        </tr>
        <%
            List<Reparation> listReparations = (List<Reparation>) request.getAttribute("listReparations");
            for (Reparation reparation : listReparations) {
        %>
            <tr>
                <td><%= reparation.getId() %></td>
                <td><%= reparation.getOrdinateur().getName() %></td>
                <td><%= reparation.getClient().getFullName() %></td>
                <td><%= reparation.getDateReparation() %></td>
                <%-- <td><%= reparation.getMontantTotal() %></td>
                <td><%= reparation.getDureeTotale() %></td> --%>
            </tr>
        <% } %>
    </table>

    <form action="/reparations" method="get">
        
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
        
        <button type="submit">Filtrer</button>
    </form>
</body>
</html>
