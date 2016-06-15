<%--
  Created by IntelliJ IDEA.
  User: sukhi
  Date: 24-03-2016
  Time: 11:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<%@ include file="header.jsp" %>
<div class = "container">
    <div class="block right form-reg">
<form action="/resetpass" method="post" >
    <div>
        <h3 class="form-signin-heading">New User Registration</h3>
        <hr class="colorgraph"><br>
        <input type="password" class="form-control" name="CurrentPassword" placeholder="Current Password" required="yes"/>
        <input type="password" class="form-control" name="NewPassword" placeholder="New Password" required="yes"/>
        <input type="password" class="form-control" name="ReTypeNewPassword" placeholder="Re-Type New Password" required="yes"/>
        <br />
        <button class="btn btn-lg btn-primary btn-block"  name="ResetPassword" value="ResetPassword" type="ResetPassword">Reset Password</button>
    </div>
</form>
<%@ include file="footer.jsp" %>