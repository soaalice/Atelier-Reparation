<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="com.web.atelier.Models.Unite"%>

<!DOCTYPE html>
<html>
<head>
    <title>Formulaire Type de Composant</title>
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
    <form action="/type-composants" method="post">
        <h1>Type de Composant</h1>
        <label for="name">Nom:</label>
        <input type="text" id="name" name="name" required />

        <label for="unite">Unite:</label>
        <select id="unite" name="uniteId">
            <%
            List<Unite> listUnite = (List<Unite>) request.getAttribute("listUnites");
            for (Unite unite : listUnite) {
            %>
                <option value="<%= unite.getId() %>"><%= unite.getName() %></option>
            <% } %>
        </select>
        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>