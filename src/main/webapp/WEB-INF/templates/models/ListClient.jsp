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
            
        </tr>
        <%
            List<Client> listClients = (List<Client>) request.getAttribute("listClients");
            for (Client client : listClients){
                %>
                    <tr>
                        <td><%= client.getId() %></td>
                        <td><%= client.getFullName() %></td>
                    </tr>
                <%
            }
        %>
    </table>
</body>
</html>