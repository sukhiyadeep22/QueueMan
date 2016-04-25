<%@ page import="qman.PlainSet" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.zendesk.client.v2.model.Ticket" %>
<%@ include file="header.jsp" %>
<table class=" table table-striped">
    <tr><th>Ticket Number</th><th>Ticket Owner</th><th>Ticket Type</th><th>Ticket Subject</th><th>Time to Breach in Hours</th><th>Time to Breach in Minutes</th>
        <tr></tr><td>
    <%
        PlainSet pl= new PlainSet();
        Set s = pl.GetTableSet(request);
        while (s.){
        Ticket t = i.getClass();
        }
    %>
</table>
<%@ include file="footer.jsp" %>