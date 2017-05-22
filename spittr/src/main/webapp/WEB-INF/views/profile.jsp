<%--
  Created by IntelliJ IDEA.
  User: drugo
  Date: 19/05/2017
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<h1>Your Profile</h1>
<c:out value="${spitter.username}" /><br/>
<c:out value="${spitter.firstName}" /> <c:out value="${spitter.lastName}" /><br/>
<c:out value="${spitter.email}" />
