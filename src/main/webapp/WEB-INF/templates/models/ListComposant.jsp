<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="com.web.atelier.Models.Composant"%>
<%@page import="com.web.atelier.Models.TypeComposant"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List Composant</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>TypeComposant</th>
        </tr>
        <%
            List<Composant> listComposants = (List<Composant>) request.getAttribute("listComposant");
            for (Composant composant : listComposants){
                %>
                    <tr>
                        <td><%= composant.getId() %></td>
                        <td><%= composant.getName() %></td>
                        <td><%= composant.getType_composant().getName() %></td>
                    </tr>
                <%
            }
        %>
    </table>
</body>
</html>