<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="com.web.atelier.Models.Client"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List clients</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />

    <h1>Liste de clients</h1>

    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Birth Date</th>
        </tr>
        <%
            List<Client> listClients = (List<Client>) request.getAttribute("listClients");
            for (Client client : listClients){
                %>
                    <tr>
                        <td><%= client.getId() %></td>
                        <td><%= client.getFullName() %></td>
                        <td><%= client.getEmail() %></td>
                        <td><%= client.getBirthDate() %></td>
                    </tr>
                <%
            }
        %>
    </table>

    <form action="/clients" method="get">
        
        <label for="dateReparation">Date de reparation:</label>
        <input type="date" name="dateReparation">
        
        <button type="submit">Filtrer</button>
    </form>
</body>
</html>