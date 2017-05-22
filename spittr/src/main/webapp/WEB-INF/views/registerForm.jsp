<%--
  Created by IntelliJ IDEA.
  User: drugo
  Date: 18/05/2017
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Register</h1>
<!--
    Notice that the <form> tag doesn’t have an action parameter set. Because of that,
    when this form is submitted, it will be posted back to the same URL path that displayed
    it. That is, it will be posted back to /spitters/register.
    That means you’ll need something back on the server to handle the HTTP POST
    request
-->
<form method="POST">
    First Name: <input type="text" name="firstName" /><br/>
    Last Name: <input type="text" name="lastName" /><br/>
    Email: <input type="email" name="email" /><br/>
    Username: <input type="text" name="username" /><br/>
    Password: <input type="password" name="password" /><br/>
    <input type="submit" value="Register" />
</form>
