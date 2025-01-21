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
</head>
<body>
    <jsp:include page="inc/header.jsp" />
    <h1>Liste des Commissions</h1>
    <table border="1">
        <tr>
            <th>Technicien</th>
            <th>Réparation</th>
            <th>Commissions</th>
            <%--<th>Durée Totale</th> --%>
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
                        for(Reparation reparation : allReparations) {
                            sommeReparation += reparation.getMontantTotal();
                            sommeCommission += reparation.getMontantTotal()*0.05; 
                            commissions[allReparations.indexOf(reparation)] = reparation.getMontantTotal()*0.05;
                            %>
                            <tr>
                                <td>REP<%= reparation.getId()  %></td>
                                <td><%=reparation.getMontantTotal()%></td>
                            </tr>
                            <%
                        }
                    %>
                    </table>
                </td>
                <td>
                    <table>
                    <%
                        for(Double commission : commissions){
                            %>
                                <tr>
                                    <td><%= commission %></td>
                                </tr>
                            <%
                        } 
                    %>
                    </table>
                </td>
            </tr>
            <tr style="text-align:right">
                <td>total</td>
                <td><%= sommeReparation %></td>
                <td><%= sommeCommission %></td>
            </tr>
        <% } %>
    </table>

    <%-- <form action="/reparations" method="get">
        
        <label for="typeComposantId">Type de composant :</label>
        <select id="typeComposantId" name="typeComposantId">
            <option value="">Tous</option>
            <%
                List<TypeComposant> listTypeComposant = (List<TypeComposant>) request.getAttribute("listTypeComposants");
                if (listTypeComposant != null) {
                    for (TypeComposant typeComposant : listTypeComposant) {
                %>
                        <option value="<%= typeComposant.getId() %>"><%= typeComposant.getName() %></option>
                <%
                    }}
                %>
        </select>
        
        <button type="submit">Filtrer</button>
    </form> --%>
</body>
</html>
