<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.ComposantModele" %>
<%@ page import="com.web.atelier.Models.Composant" %>
<%@ page import="com.web.atelier.Models.Modele" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter un Composant Modele</title>
</head>
<body>
    <h1>Ajouter un Composant Modele</h1>
    <form action="/composantModeles" method="post">
        <label for="composant">Composant:</label>
        <select id="composant" name="composantId">
            <%
                List<Composant> listComposants = (List<Composant>) request.getAttribute("listComposants");
                for (Composant composant : listComposants) {
            %>
                <option value="<%= composant.getId() %>"><%= composant.getName() %></option>
            <% } %>
        </select>

        <label for="modele">Modele:</label>
        <select id="modele" name="modeleId">
            <%
                List<Modele> listModeles = (List<Modele>) request.getAttribute("listModeles");
                for (Modele modele : listModeles) {
            %>
                <option value="<%= modele.getId() %>"><%= modele.getName() %></option>
            <% } %>
        </select>

        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>
