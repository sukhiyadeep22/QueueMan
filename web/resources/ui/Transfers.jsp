<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<%@ include file="header.jsp" %>
<div class = "container">
    <div class="block right form-reg2">
        <form action="/transfers" method="post" >
            <div>
                <h3 class="form-signin-heading">Transfer the Ticket</h3>
                <hr class="colorgraph"><br>

                <textarea rows="4" cols="50" placeholder="Issue" required="yes" autofocus="" class="form-control" name="Symptoms"></textarea>
                <textarea rows="4" cols="50" placeholder="Steps Taken" required="yes" class="form-control" name="Steps Taken"></textarea>
                <textarea rows="4" cols="50" placeholder="Action Plan" required="yes" class="form-control" name="Action Plan"></textarea>
                <br />
                <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Submit" type="Submit">Transfer Ticket</button>
            </div>
        </form>
        <%@ include file="footer.jsp" %>

