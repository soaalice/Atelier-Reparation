<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="com.web.atelier.Models.TypeComposant"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste Types Composant</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />
    <h1>Liste des Types de Composant</h1>

    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Unite</th>
        </tr>
        <% 
            List<TypeComposant> listTypeComposants = (List<TypeComposant>) request.getAttribute("listTypeComposants");
            for (TypeComposant typeComposant : listTypeComposants) { 
        %>
            <tr>
                <td><%= typeComposant.getId() %></td>
                <td><%= typeComposant.getName() %></td>
                <td><%= typeComposant.getUnite().getName() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>