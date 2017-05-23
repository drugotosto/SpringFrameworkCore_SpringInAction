<%--
  Created by IntelliJ IDEA.
  User: drugo
  Date: 18/05/2017
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>

<!--
    Now that there’s data in the model, how does the JSP access it? As it turns out,
    when the view is a JSP, the model data is copied into the request as request attributes.
    Therefore, the spittles.jsp file can use JavaServer Pages Standard Tag Library’s (JSTL)
    "c:forEach" tag to render the list of spittles.
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="spittleForm">
    <h1>Spit it out...</h1>
    <form method="POST" name="spittleForm">
        <input type="hidden" name="latitude">
        <input type="hidden" name="longitude">
        <textarea name="message" cols="80" rows="5"></textarea><br/>
        <input type="submit" value="Add" />
    </form>
</div>
<div class="listTitle">
    <h1>Recent Spittles</h1>
    <ul class="spittleList">
        <c:forEach items="${spittleList}" var="spittle" >
            <li id="spittle_<c:out value="spittle.id"/>">
                <div class="spittleMessage"><c:out value="${spittle.message}" /></div>
                <div>
                    <span class="spittleTime"><c:out value="${spittle.time}" /></span>
                    <span class="spittleLocation">(<c:out value="${spittle.latitude}" />, <c:out value="${spittle.longitude}" />)</span>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>
