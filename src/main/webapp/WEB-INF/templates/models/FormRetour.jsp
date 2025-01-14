<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.Reparation" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire Retour</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />
    <% 
        String successMessage = (String) request.getAttribute("successMessage");
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (successMessage != null) {
    %>
        <div style="color: green; font-weight: bold;">
            <%= successMessage %>
        </div>
    <% 
        } 
        if (errorMessage != null) {
    %>
        <div style="color: red; font-weight: bold;">
            <%= errorMessage %>
        </div>
    <% 
        }
    %>
    <form action="/retours" method="post">
        <h1>Retour</h1>
        <label for="reparation">Reparation:</label>
        <select id="reparation" name="reparationId">
            <%
                List<Reparation> listReparations = (List<Reparation>) request.getAttribute("listReparations");
                for (Reparation reparation : listReparations) {
            %>
                <option value="<%= reparation.getId() %>"><%= reparation.getDateReparation() + "-" + reparation.getOrdinateur().getName() %></option>
            <% } %>
        </select>

        <label for="dateRetour">Date de Retour:</label>
        <input type="date" id="dateRetour" name="dateRetour" required />

        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>
