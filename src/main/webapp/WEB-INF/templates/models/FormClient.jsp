<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="com.web.atelier.Models.Client"%>

<!DOCTYPE html>
<html>
<head>
    <title>Formulaire Client</title>
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

    <form action="/clients" method="post">
        <h1>Client</h1>

        <label for="name">Nom:</label>
        <input type="text" id="name" name="name" placeholder="Nom" required />

        <label for="birthDate">Birth Date:</label>
        <input type="date" id="birthDate" name="birthDate" required />

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" placeholder="email" required />

        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>