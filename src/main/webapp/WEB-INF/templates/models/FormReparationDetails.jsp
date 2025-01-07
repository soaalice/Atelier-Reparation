i<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.Reparation" %>
<%@ page import="com.web.atelier.Models.Ordinateur" %>
<%@ page import="com.web.atelier.Models.Composant" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire Reparation details</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />

    <form action="/reparations" method="post">
        <h1>Reparation Details</h1>

        <input type="hidden" name="ordinateurId" value="<%= request.getAttribute("ordinateurId") %>"></input>

        <input type="hidden" name="dateReparation" value="<%= request.getAttribute("dateReparation") %>"></input>

        <label for="composant">composant:</label>
        
            <%
                List<Composant> listcomposants = (List<Composant>) request.getAttribute("listComposants");
                for (Composant composant : listcomposants) {
            %>
                <input type="checkbox" name="composants" value="<%= composant.getId() %>"><%= composant.getName() %></input>
            <% } %>

        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>
