<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="com.web.atelier.Models.TypeComposant"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List TypeComposant</title>
</head>
<body>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        <% 
            List<TypeComposant> listTypeComposants = (List<TypeComposant>) request.getAttribute("listTypeComposants");
            for (TypeComposant typeComposant : listTypeComposants) { 
        %>
            <tr>
                <td><%= typeComposant.getId() %></td>
                <td><%= typeComposant.getName() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>