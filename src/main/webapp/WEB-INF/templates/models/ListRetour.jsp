<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.Reparation" %>
<%@ page import="com.web.atelier.Models.Ordinateur" %>
<%@ page import="com.web.atelier.Models.Retour" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Retours</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />
    <h1>Liste des Retours</h1>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Réparation</th>
            <th>Date de Réparation</th>
            <th>Date de Retour</th>
        </tr>
        <%
            List<Retour> listRetours = (List<Retour>) request.getAttribute("listRetours");
            for (Retour retour : listRetours) {
                Reparation reparation = retour.getReparation(); // Obtient la réparation liée au retour
                Ordinateur ordinateur = reparation.getOrdinateur(); // Obtient l'ordinateur de la réparation
        %>
            <tr>
                <td><%= retour.getId() %></td>
                <td><%= reparation.getId() + " - " + ordinateur.getName() %></td>
                <td><%= reparation.getDateReparation() %></td>
                <td><%= retour.getDateRetour() %></td>
            </tr>
        <% } %>
    </table>

    <%-- <form action="/retours" method="get">
        
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
    </form> --%>
</body>
</html>
