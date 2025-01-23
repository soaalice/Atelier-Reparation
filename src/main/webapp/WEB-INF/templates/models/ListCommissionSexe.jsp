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

    <h1>Etat des Commissions</h1>

    <table border="1">
        <thead>
            <tr><th colspan=3>Femme</th></tr>
            <tr>
                <th>Technicien</th>
                <th>Réparation</th>
                <th>Commissions</th>
            </tr>
        </thead>

        <tbody>
        <%
            double sumGirl = (double ) request.getAttribute( "sumGirl" );
            double sumBoy = (double ) request.getAttribute( "sumBoy" );

            Double[]sumReparationGirls = (Double[]) request.getAttribute("sumReparationGirls");
            Double[]sumCommissionGirls = (Double[]) request.getAttribute("sumCommissionGirls");

            Double[]sumReparationBoys = (Double[]) request.getAttribute("sumReparationBoys");
            Double[]sumCommissionBoys = (Double[]) request.getAttribute("sumCommissionBoys");
            List<Technicien> listGirlsTechniciens = (List<Technicien>) request.getAttribute("listGirlsTechniciens");
            for (Technicien technicien : listGirlsTechniciens) {
        %>
            
            <tr>
                <td><%= technicien.getName() %></td>
                <td>
                    <%
                        List<Reparation> allReparations = technicien.getAllReparations();
                        if(allReparations.size()==0){
                            out.print("Aucune réparation");
                        } else{
                    %>
                    <table>
                        <%
                            for(Reparation reparation : allReparations) {
                                %>
                                <tr>
                                    <td>REP<%= reparation.getId()+" ("+reparation.getDateReparation()+")"  %></td>
                                    <td class="montant-cell"><%=reparation.getMontantTotal()%></td>
                                </tr>
                                <%
                            }
                        %>
                    </table>
                    <% } %>
                </td>
                <td>
                    <table>
                    <%
                        if(allReparations.size() == 0){
                            out.print("Aucune commission");
                        }
                        else{
                            for(Reparation reparation : allReparations){
                                %>

                                    <tr>
                                        <td class="montant-cell"><%= reparation.getCommission().getMontantTotal() %></td>
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
                <td><%= sumReparationGirls[listGirlsTechniciens.indexOf(technicien)] %></td>
                <td><%= sumCommissionGirls[listGirlsTechniciens.indexOf(technicien)] %></td>
            </tr>
            <% } %>
            <tr class="total-row"><th>Somme Commissions</th><td colspan=2><%= sumGirl %></td></tr>
        </tbody>
    </table>

    <table border="1">
        <thead>
            <tr><th colspan=3>Homme</th></tr>
            <tr>
                <th>Technicien</th>
                <th>Réparation</th>
                <th>Commissions</th>
            </tr>
        </thead>

        <tbody>
        <%
            List<Technicien> listBoysTechniciens = (List<Technicien>) request.getAttribute("listBoysTechniciens");
            for (Technicien technicien : listBoysTechniciens) {
        %>
            <tr>
                <td><%= technicien.getName() %></td>
                <td>
                    <%
                        List<Reparation> allReparations = technicien.getAllReparations();
                        if(allReparations.size()==0){
                            out.print("Aucune réparation");
                        } else{
                    %>
                    <table>
                        <%
                            for(Reparation reparation : allReparations) {
                                %>
                                <tr>
                                    <td>REP<%= reparation.getId()+" ("+reparation.getDateReparation()+")"  %></td>
                                    <td class="montant-cell"><%=reparation.getMontantTotal()%></td>
                                </tr>
                                <%
                            }
                        %>
                    </table>
                    <% } %>
                </td>
                <td>
                    <table>
                    <%
                        if(allReparations.size() == 0){
                            out.print("Aucune commission");
                        }
                        else{
                            for(Reparation reparation : allReparations){
                                %>

                                    <tr>
                                        <td class="montant-cell"><%= reparation.getCommission().getMontantTotal() %></td>
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
                <td><%= sumReparationBoys[listBoysTechniciens.indexOf(technicien)] %></td>
                <td><%= sumCommissionBoys[listBoysTechniciens.indexOf(technicien)] %></td>
            </tr>
            <% } %>
            <tr class="total-row"><th>Somme Commissions</th><td colspan=2><%= sumBoy %></td></tr>
        </tbody>
    </table>

    <form action="/commissions/etat" method="get">

        <label for="dateMin">Min Date:</label>
        <input type="date" name="dateMin">

        <label for="dateMax">Max Date:</label>
        <input type="date" name="dateMax">

        <button type="submit">Filtrer</button>

    </form>
</body>
</html>