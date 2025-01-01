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
    <form action="/composants" method="post">
        <h1>Composant</h1>
        <label for="name">Nom:</label>
        <input type="text" id="name" name="name" required />
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