<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.Sexe" %>


<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire Technicien</title>
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
    <form action="/techniciens" method="post">
        <h1>Technicien</h1>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required />

        <label for="sexe">Sexe:</label>
        <select id="sexe" name="sexeId">
            <%
                List<Sexe> listSexe = (List<Sexe>) request.getAttribute("listSexe");
                for (Sexe sexe : listSexe) {
            %>
                <option value="<%= sexe.getId() %>"><%= sexe.getName() %></option>
            <% } %>
        </select>

        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>
