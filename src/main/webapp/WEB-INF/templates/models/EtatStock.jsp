<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Dto.StockDto" %>
<%@ page import="com.web.atelier.Models.TypeComposant" %>

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
            <th>Composant Name</th>
            <th>Type Composant Name</th>
            <th>Stock</th>
        </tr>
        <%
            List<StockDto> stockList = (List<StockDto>) request.getAttribute("stockList");
            if (stockList != null) {
                for (StockDto stock : stockList) {
        %>
            <tr>
                <td><%= stock.getComposantName() %></td>
                <td><%= stock.getTypeComposantName() %></td>
                <td><%= stock.getStock() %></td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="3">Aucun stock disponible.</td>
            </tr>
        <%
            }
        %>
    </table>

    <form action="/etat-stock" method="get">
        <label for="startDate">Date de début :</label>
        <input type="date" id="startDate" name="startDate" value="<%= request.getAttribute("startDate") != null ? request.getAttribute("startDate") : "" %>">
        
        <label for="endDate">Date de fin :</label>
        <input type="date" id="endDate" name="endDate" value="<%= request.getAttribute("endDate") != null ? request.getAttribute("endDate") : "" %>">
        
        <label for="typeComposantId">Type de composant :</label>
        <select id="typeComposantId" name="typeComposantId">
            <option value="">Tous</option>
            <%
                List<TypeComposant> listTypeComposant = (List<TypeComposant>) request.getAttribute("listTypeComposant");
                if (listTypeComposant != null) {
                    for (TypeComposant typeComposant : listTypeComposant) {
                %>
                        <option value="<%= typeComposant.getId() %>"><%= typeComposant.getName() %></option>
                <%
                    }}
                %>
        </select>
        
        <button type="submit">Filtrer</button>
    </form>
</body>
</html>
