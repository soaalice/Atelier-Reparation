<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.MvtStock" %>
<%@ page import="com.web.atelier.Models.Composant" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire Mvt de Stock</title>
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
    <form action="/mvt-stocks" method="post">
        <h1>Mouvement de Stock</h1>
        <label for="entree">Entrée:</label>
        <input type="number" id="entree" name="entree" value="0" required />

        <label for="sortie">Sortie:</label>
        <input type="number" id="sortie" name="sortie" value="0" required />

        <label for="composant">Composant:</label>
        <select id="composant" name="composantId">
            <%
                List<Composant> listComposants = (List<Composant>) request.getAttribute("listComposant");
                for (Composant composant : listComposants) {
            %>
                <option value="<%= composant.getId() %>"><%= composant.getName() %></option>
            <% } %>
        </select>

        <label for="dateMvt">Date du Mvt:</label>
        <input type="date" id="dateMvt" name="dateMvt" required />

        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>
