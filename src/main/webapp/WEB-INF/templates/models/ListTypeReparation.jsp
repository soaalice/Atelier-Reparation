<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="com.web.atelier.Models.TypeReparation"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste Types Reparation</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />
    <h1>Liste des Types de Composant</h1>

    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        <% 
            List<TypeReparation> listTypeReparations = (List<TypeReparation>) request.getAttribute("listTypeReparations");
            for (TypeReparation typeComposant : listTypeReparations) { 
        %>
            <tr>
                <td><%= typeComposant.getId() %></td>
                <td><%= typeComposant.getName() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>