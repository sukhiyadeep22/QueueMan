<%--
  Created by IntelliJ IDEA.
  User: sukhi
  Date: 25-02-2016
  Time: 12:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp" %>
<form action="/queue" method="get">
<div>
Congratulation QueueMan:QueueMan:war:1.0-SNAPSHOT <br>
    ${SessionValue}

            <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="login" type="Submit">Login</button>

</div>
</form>
<%@ include file="footer.jsp" %>
