<%--
  Created by IntelliJ IDEA.
  User: sukhi
  Date: 22-03-2016
  Time: 04:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp" %>
<form action="/ZenAuth" method="post" >
    <div>
        <h3 class="form-signin-heading">Click Authorize Button To Receive a Token from Zendesk</h3>
        <hr class="colorgraph"><br>
        <button class="btn btn-lg btn-primary btn-block"  name="Auth2Zendesk" value="Auth2Zendesk" type="Auth2Zendesk">Authorize</button>
    </div>
</form>
<%@ include file="footer.jsp" %>