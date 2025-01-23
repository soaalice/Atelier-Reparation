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
        <thead>
            <tr>
                <th>Technicien</th>
                <th>Réparation</th>
                <th>Commissions</th>
            </tr>
        </thead>

        <tbody>
        <%
            Double[]sumReparation = (Double[]) request.getAttribute("sumReparation");
            Double[]sumCommission = (Double[]) request.getAttribute("sumCommission");
            List<Technicien> listTechniciens = (List<Technicien>) request.getAttribute("listTechniciens");
            for (Technicien technicien : listTechniciens) {
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
                    <% } %>
                </td>
            </tr>
            <tr class="total-row">
                <td>total</td>
                <td><%= sumReparation[listTechniciens.indexOf(technicien)] %></td>
                <td><%= sumCommission[listTechniciens.indexOf(technicien)] %></td>
            </tr>
        <% } %>
        </tbody>
    </table>

    <form action="/commissions" method="get">
        <label for="technicienId">Technicien:</label>
        <select id="technicien" name="technicienId">
        <option value="">Tous</option>
            <%
                List<Technicien> listAllTechniciens = (List<Technicien>) request.getAttribute("allTechniciens");
                for (Technicien technicien : listAllTechniciens) {
            %>
                <option value="<%= technicien.getId() %>"><%= technicien.getName() %></option>
            <% } %>
        </select>

        <label for="dateMin">Min Date:</label>
        <input type="date" name="dateMin">

        <label for="dateMax">Max Date:</label>
        <input type="date" name="dateMax">

        <select id="technicienId" name="technicienId">
            <option value="">Tous</option>
            <%
                List<Technicien> listAllTechniciens = (List<Technicien>) request.getAttribute("listAlltechniciens");
                if (listAllTechniciens != null) {
                    for (Technicien technicien : listAllTechniciens) {
                %>
                        <option value="<%= technicien.getId() %>"><%= technicien.getName() %></option>
                <%
                    }}
                %>
        </select>

        <button type="submit">Filtrer</button>

    </form>
</body>
</html>