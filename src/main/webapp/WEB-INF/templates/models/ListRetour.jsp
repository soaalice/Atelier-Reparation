<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.Reparation" %>
<%@ page import="com.web.atelier.Models.Ordinateur" %>
<%@ page import="com.web.atelier.Models.TypeReparation" %>
<%@ page import="com.web.atelier.Models.TypeComposant" %>
<%@ page import="com.web.atelier.Models.Retour" %>
<%@ page import="com.web.atelier.Models.TypeOrdinateur" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Retours</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />
    <h1>Liste des retours</h1>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Id reparation</th>
            <th>Ordinateur</th>
            <th>Date de Retour</th>
            <%-- <th>Montant Total</th>
            <th>Durée Totale</th> --%>
        </tr>
        <%
            List<Retour> listRetours = (List<Retour>) request.getAttribute("listRetours");
            for (Retour retour : listRetours) {
        %>
            <tr>
                <td><%= retour.getId() %></td>
                <td><%= retour.getReparation().getId() %></td>
                <td><%= retour.getReparation().getOrdinateur().getName() %></td>
                <td><%= retour.getDate() %></td>
                <%-- <td><%= reparation.getMontantTotal() %></td>
                <td><%= reparation.getDureeTotale() %></td> --%>
            </tr>
        <% } %>
    </table>

    <form action="/retours" method="get">
        
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

        <label for="typeReparationId">Type de reparation :</label>
        <select id="typeReparationId" name="typeReparationId">
            <option value="">Tous</option>
            <%
                List<TypeReparation> listTypeReparation = (List<TypeReparation>) request.getAttribute("listTypeReparations");
                if (listTypeReparation != null) {
                    for (TypeReparation typeReparation : listTypeReparation) {
                %>
                    <option value="<%= typeReparation.getId() %>"><%= typeReparation.getName() %></option>
                <%
                    }}
                %>
        </select>

        <label for="typeOrdinateurId">Type d'ordinateurs :</label>
        <select id="typeOrdinateurId" name="typeOrdinateurId">
            <option value="">Tous</option>
            <%
                List<TypeOrdinateur> listTypeOrdinateur = (List<TypeOrdinateur>) request.getAttribute("listTypeOrdinateurs");
                if (listTypeOrdinateur != null) {
                    for (TypeOrdinateur typeOrdinateur : listTypeOrdinateur) {
                %>
                    <option value="<%= typeOrdinateur.getId() %>"><%= typeOrdinateur.getName() %></option>
                <%
                    }}
                %>
        </select>
        
        <button type="submit">Filtrer</button>
    </form>
</body>
</html>
