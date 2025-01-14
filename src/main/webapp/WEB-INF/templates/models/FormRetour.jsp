<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.Reparation" %>
<%@ page import="com.web.atelier.Models.Ordinateur" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire Retour</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />

    <form action="/retours" method="post">
        <h1>Retour</h1>
        <label for="Reparation">Reparation:</label>
        <select id="Reparation" name="reparationId">
            <%
                List<Reparation> listReparations = (List<Reparation>) request.getAttribute("listReparations");
                for (Reparation reparation : listReparations) {
            %>
                <option value="<%= reparation.getId() %>"><%= reparation.getOrdinateur().getName() %>(<%= reparation.getDateReparation() %>)</option>
            <% } %>
        </select>

        <label for="dateRetour">Date de Retour:</label>
        <input type="date" id="dateRetour" name="dateRetour" required />

        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>
