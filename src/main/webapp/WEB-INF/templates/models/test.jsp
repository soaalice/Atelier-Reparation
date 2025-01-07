<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Dto.StockDto" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Etat Stocks</title>
</head>
<body>
    <jsp:include page="inc/header.jsp" />
    <h1>Etat des Stocks</h1>
    <table border="1">
        <tr>
            <%-- <th>Composant ID</th> --%>
            <th>Composant Name</th>
            <%-- <th>Type Composant ID</th> --%>
            <th>Type Composant Name</th>
            <th>Stock</th>
        </tr>
        <%
            List<StockDto> stockList = (List<StockDto>) request.getAttribute("stockList");
            if (stockList != null) {
                for (StockDto stock : stockList) {
        %>
            <tr>
                <%-- <td><%= stock.getComposantId() %></td> --%>
                <td><%= stock.getComposantName() %></td>
                <%-- <td><%= stock.getTypeComposantId() %></td> --%>
                <td><%= stock.getTypeComposantName() %></td>
                <td><%= stock.getStock() %></td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="5">Aucun stock disponible.</td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
