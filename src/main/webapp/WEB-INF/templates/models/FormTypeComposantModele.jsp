<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.TypeComposantModele" %>
<%@ page import="com.web.atelier.Models.Modele" %>
<%@ page import="com.web.atelier.Models.TypeComposant" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire Type Composant Modèle</title>
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
    <form action="/type-composant-modeles" method="post">
        <h1>Type Composant Modèle</h1>
        <label for="modele">Modèle:</label>
        <select id="modele" name="modeleId">
            <%
                List<Modele> listModeles = (List<Modele>) request.getAttribute("listModeles");
                for (Modele modele : listModeles) {
            %>
                <option value="<%= modele.getId() %>"><%= modele.getName() %></option>
            <% } %>
        </select>

        <label for="typeComposant">Type Composant:</label>
        <select id="typeComposant" name="typeComposantId">
            <%
                List<TypeComposant> listTypeComposants = (List<TypeComposant>) request.getAttribute("listTypeComposants");
                for (TypeComposant typeComposant : listTypeComposants) {
            %>
                <option value="<%= typeComposant.getId() %>"><%= typeComposant.getName() %></option>
            <% } %>
        </select>

        <label for="min">Min:</label>
        <input type="number" id="min" name="min" required />

        <label for="max">Max:</label>
        <input type="number" id="max" name="max" required />

        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>
