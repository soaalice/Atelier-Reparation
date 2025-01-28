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
            <th>Date Tarif</th>
        </tr>
        <%
            List<Tarif> listTarifs = (List<Tarif>) request.getAttribute("listTarifs");
            for (Tarif tarif : listTarifs) {
        %>
            <tr>
                <td><%= tarif.getId() %></td>
                <td><%= tarif.getPrix() %></td>
                <td><%= tarif.getDuree() %></td>
                <% Composant composant = tarif.getComposant(); %>
                <td><%= composant.getName() +"-"+ composant.getValeur() + composant.getTypeComposant().getUnite().getName() %></td>
                <td><%= tarif.getTypeReparation().getName() %></td>
                <td><%= tarif.getDateTarif() %></td>
            </tr>
        <% } %>
    </table>

    <form action="/tarifs" method="get">
        
        <label for="ComposantId"> Composant :</label>
        <select id="ComposantId" name="composantId">
            <option value="">Tous</option>
            <%
                List<Composant> listComposant = (List<Composant>) request.getAttribute("listComposants");
                if (listComposant != null) {
                    for (Composant Composant : listComposant) {
                %>
                        <option value="<%= Composant.getId() %>"><%= Composant.getName() %></option>
                <%
                    }}
                %>
        </select>

        <label for="typeReparationId"> Composant :</label>
        <select id="typeReparationId" name="typeReparationId">
            <option value="">Tous</option>
            <%
                List<TypeReparation> listTypeReparation = (List<TypeReparation>) request.getAttribute("listTypeReparations");
                if (listTypeReparation != null) {
                    for (TypeReparation TypeReparation : listTypeReparation) {
                %>
                        <option value="<%= TypeReparation.getId() %>"><%= TypeReparation.getName() %></option>
                <%
                    }}
                %>
        </select>

        <label for="date"> Date :</label>
        <input type="date" name="date"/>
        
        <button type="submit">Filtrer</button>
    </form>

</body>
</html>
