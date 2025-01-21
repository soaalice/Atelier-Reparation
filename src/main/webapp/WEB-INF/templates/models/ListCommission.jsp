<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.atelier.Models.Technicien" %>
<%@ page import="com.web.atelier.Models.Reparation" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Commissions</title>
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
    <h1>Liste des Commissions</h1>
    <table border="1">
        <tr>
            <th>Technicien</th>
            <th>Réparation</th>
            <th>Commissions</th>
        </tr>
        <%
            List<Technicien> listTechniciens = (List<Technicien>) request.getAttribute("listTechniciens");
            for (Technicien technicien : listTechniciens) {
        %>
            <tr>
                <td><%= technicien.getName() %></td>
                <td>
                    <table>
                    <%
                        double sommeReparation = 0;
                        double sommeCommission = 0;
                        List<Reparation> allReparations = technicien.getAllReparations();
                        Double[] commissions = new Double[allReparations.size()];
                        if(allReparations.size()==0){
                            out.print("Aucune Reparation");
                        }
                        else{
                            for(Reparation reparation : allReparations) {
                                sommeReparation += reparation.getMontantTotal();
                                sommeCommission += reparation.getMontantTotal()*0.05; 
                                commissions[allReparations.indexOf(reparation)] = reparation.getMontantTotal()*0.05;
                                %>
                                <tr>
                                    <td>REP<%= reparation.getId()  %></td>
                                    <td class="montant-cell"><%=reparation.getMontantTotal()%></td>
                                </tr>
                                <%
                            }
                        }
                    %>
                    </table>
                </td>
                <td>
                    <table>
                    <%
                        if(allReparations.size() == 0){
                            out.print("Aucune commission");
                        }
                        else{
                            for(Double commission : commissions){
                                %>
                                    <tr>
                                        <td class="montant-cell"><%= commission %></td>
                                    </tr>
                                <%
                            } 
                        }
                    %>
                    </table>
                </td>
            </tr>
            <tr class="total-row">
                <td>total</td>
                <td><%= sommeReparation %></td>
                <td><%= sommeCommission %></td>
            </tr>
        <% } %>
    </table>

    <form action="/commissions" method="get">
        <label for="dateMin">Min Date:</label>
        <input type="date" name="dateMin">

        <label for="dateMax">Max Date:</label>
        <input type="date" name="dateMax">
        <button type="submit">Filtrer</button>
    </form>
</body>
</html>