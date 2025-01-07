<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="com.web.atelier.Models.Modele"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste Modèles</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />
    <h1>Liste des Modèles</h1>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        <%
            List<Modele> listModeles = (List<Modele>) request.getAttribute("listModeles");
            for (Modele modele : listModeles) {
        %>
        <tr>
            <td><%= modele.getId() %></td>
            <td><%= modele.getName() %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>