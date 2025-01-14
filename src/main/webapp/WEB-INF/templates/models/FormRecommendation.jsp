<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.Composant" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire Recommendation</title>
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
    <form action="/recommendations" method="post">
        <h1>Recommendation</h1>

        <label for="date">Date:</label>
        <input type="date" id="date" name="date"  required />

        <label for="composant">Composant:</label>
        <select id="composant" name="composantId">
            <%
                List<Composant> listComposants = (List<Composant>) request.getAttribute("listComposants");
                for (Composant composant : listComposants) {
            %>
                <option value="<%= composant.getId() %>"><%= composant.getName() +" - "+ composant.getValeur() + " "+ composant.getTypeComposant().getUnite().getName() %></option>
            <% } %>
        </select>

        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>
