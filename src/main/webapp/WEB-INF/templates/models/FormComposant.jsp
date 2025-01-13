<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="com.web.atelier.Models.Composant"%>
<%@page import="com.web.atelier.Models.TypeComposant"%>

<!DOCTYPE html>
<html>
<head>
    <title>Formulaire Composant</title>
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

    <form action="/composants" method="post">
        <h1>Composant</h1>

        <label for="name">Nom:</label>
        <input type="text" id="name" name="name" required />

        <label for="valeur">Valeur:</label>
        <input type="number" id="valeur" name="valeur" min="0" step="0.01" required />

        <label for="typeComposant">Type de Composant:</label>
        <select id="typeComposant" name="typeComposantId">
            <%
            List<TypeComposant> listTypeComposant = (List<TypeComposant>) request.getAttribute("listTypeComposant");
            for (TypeComposant typeComposant : listTypeComposant) {
            %>
                <option value="<%= typeComposant.getId() %>"><%= typeComposant.getName() %></option>
            <% } %>
        </select>
        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>