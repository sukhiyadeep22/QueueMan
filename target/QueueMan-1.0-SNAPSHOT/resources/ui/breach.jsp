<%@ include file="header.jsp" %>
<style>
    .tableside {margin-left: 0%; width: 99%;margin-right: 50px; padding-top: 40px}
    .tr:nth-child(even){background-color: #f2f2f2}
    .th {background-color: #00accc; color: white;}
    .table {border-collapse: collapse; width: 100%;}
    .th, td {text-align: left; padding: 8px;}
</style>
<script>setTimeout(function(){window.location.href='/queue'},50000);</script>
<div class = "container">
    <div>
        <div style="padding-top: 50px"><div/>
            <h3>SLA Breaching Tickets</h3>
            ${s}
<%@ include file="footer.jsp" %>
