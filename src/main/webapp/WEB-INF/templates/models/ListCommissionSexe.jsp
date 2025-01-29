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
        .table-container {
            display: flex;
            flex-wrap: wrap;
            gap: 30px;
        }
        .table-container table {
            width: 100%;
            max-width: 45%;
        }

        @media (max-width: 600px) {
            .table-container table {
                max-width: 100%;
            }
        }
    </style>
</head>
<body>
    <jsp:include page="inc/header.jsp" />

    <h1>Etat des Commissions</h1>

    <div class="table-container">

        <table border="1">
            <thead>
                <tr><th colspan=3 style="text-align:center">Femme</th></tr>
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
                        <%
                            if(allReparations.size() == 0){
                                out.print("Aucune commission");
                            }
                            else{
                        %>
                            <table>
                            <%
                                for(Reparation reparation : allReparations){
                                    double com = (reparation.getCommission()!=null) ? reparation.getCommission().getMontantTotal():0;
                                    %>

                                        <tr>
                                            <td class="montant-cell"><%= com %></td>
                                        </tr>
                                <% } %>
                            </table>
                        <% } %>
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
                <tr><th colspan=3 style="text-align:center">Homme</th></tr>
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
                        <%
                            if(allReparations.size() == 0){
                                out.print("Aucune commission");
                            }
                            else{
                        %>
                            <table>
                            <%
                                for(Reparation reparation : allReparations){
                                    double com = (reparation.getCommission()!=null) ? reparation.getCommission().getMontantTotal():0;
                                    %>

                                        <tr>
                                            <td class="montant-cell"><%= com %></td>
                                        </tr>
                                <% } %>
                            </table>
                        <% } %>
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
    </div>    

    <form action="/commissions/etat" method="get">

        <label for="dateMin">Min Date:</label>
        <input type="date" name="dateMin">

        <label for="dateMax">Max Date:</label>
        <input type="date" name="dateMax">

        <button type="submit">Filtrer</button>

    </form>
</body>
</html>