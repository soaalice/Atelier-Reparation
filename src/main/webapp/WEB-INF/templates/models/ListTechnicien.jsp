<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.Technicien" %>
<%@ page import="com.web.atelier.Models.Reparation" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Techniciens</title>
    <style>
        .montant-cell {
            text-align: right;
        }
        .total-row td {
            text-align: right;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <jsp:include page="inc/header.jsp" />
    <h1>Liste des Techniciens</h1>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        <%
            List<Technicien> listTechniciens = (List<Technicien>) request.getAttribute("listTechniciens");
            for (Technicien technicien : listTechniciens) {
        %>
            <tr>
                <td><%= technicien.getId() %></td>
                <td><%= technicien.getName() %></td>
            </tr>
        <% } %>
    </table>

</body>
</html>