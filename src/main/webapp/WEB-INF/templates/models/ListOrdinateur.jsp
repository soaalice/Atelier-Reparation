<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="com.web.atelier.Models.Ordinateur"%>
<%@page import="com.web.atelier.Models.Modele"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List Ordinateurs</title>
</head>
<body>
    <h1>Liste des Ordinateurs</h1>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Modele</th>
        </tr>
        <%
            List<Ordinateur> listOrdinateurs = (List<Ordinateur>) request.getAttribute("listOrdinateurs");
            for (Ordinateur ordinateur : listOrdinateurs) {
            %>
                <tr>
                    <td><%= ordinateur.getId() %></td>
                    <td><%= ordinateur.getName() %></td>
                    <td><%= ordinateur.getModele().getName() %></td>
                </tr>
            <%
                }
            %>
    </table>
</body>
</html>