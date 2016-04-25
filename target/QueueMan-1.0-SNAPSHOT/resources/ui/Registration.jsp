<%--
  Created by IntelliJ IDEA.
  User: sukhi
  Date: 22-03-2016
  Time: 04:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<%@ include file="header.jsp" %>
<form action="/registration" method="post" >
    <div>
        <h3 class="form-signin-heading">New User Registration</h3>
        <hr class="colorgraph"><br>

        <input type="text" class="form-control" name="Username" placeholder="Username" required="yes" autofocus="" />
        <input type="text" class="form-control" name="Name" placeholder="Full Name" required="yes" autofocus="" />
        <input type="password" class="form-control" name="Password" placeholder="Password" required="yes"/>
        <input type="password" class="form-control" name="ReTypePassword" placeholder="Re-Type Password" required="yes"/>
        <input type="text" class="form-control" name="mailId" placeholder="E Mail ID" required="yes"/>
        <br />
        <button class="btn btn-lg btn-primary btn-block"  name="CreateUser" value="CreateUser" type="CreateUser">Create User</button>
    </div>
</form>
<%@ include file="footer.jsp" %>
