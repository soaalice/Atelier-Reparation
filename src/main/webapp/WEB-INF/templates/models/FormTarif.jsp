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
    <title>Formulaire Tarif</title>
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
    <form action="/tarifs" method="post">
        <h1>Tarif</h1>
        <label for="prix">Prix:</label>
        <input type="number" id="prix" name="prix" min="0" step="0.01" required />

        <label for="duree">Durée:</label>
        <input type="number" id="duree" name="duree" min="0" step="0.01" required />

        <label for="composant">Composant:</label>
        <select id="composant" name="composantId">
            <%
                List<Composant> listComposants = (List<Composant>) request.getAttribute("listComposants");
                for (Composant composant : listComposants) {
            %>
                <option value="<%= composant.getId() %>"><%= composant.getName() +" - "+ composant.getValeur() + " "+ composant.getTypeComposant().getUnite().getName() %></option>
            <% } %>
        </select>

        <label for="typeReparation">Type de Réparation:</label>
        <select id="typeReparation" name="typeReparationId">
            <%
                List<TypeReparation> listTypeReparations = (List<TypeReparation>) request.getAttribute("listTypeReparations");
                for (TypeReparation typeReparation : listTypeReparations) {
            %>
                <option value="<%= typeReparation.getId() %>"><%= typeReparation.getName() %></option>
            <% } %>
        </select>

        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>
