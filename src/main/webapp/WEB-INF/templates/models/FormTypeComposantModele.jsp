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
    <title>Ajouter un Type Composant Modele</title>
</head>
<body>
    <h1>Ajouter un Type Composant Modele</h1>
    <form action="/typeComposantModeles" method="post">
        <label for="modele">Modele:</label>
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
