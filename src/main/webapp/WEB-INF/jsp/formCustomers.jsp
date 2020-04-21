<%--
  Created by IntelliJ IDEA.
  User: paweld
  Date: 28.03.2020
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer - details</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<form method="post" action="${pageContext.request.contextPath}/customers?action=${action}">
    <input type="hidden" name="customerId" value="${customer.customerId}"/>
    <select name="personId">
        <c:if test="${action eq 'new'}">
            <option value="" hidden disabled selected>select</option>
        </c:if>
        <c:if test="${action eq 'edit'}">
            <option value="${customer.personalId}" title="${customer.fullname}">${customer.fullname}</option>
        </c:if>
        <c:forEach items="${persons}" var="person">
            <option value="${person.id}">${person.fullname}</option>
        </c:forEach>
    </select><br/>
    <c:if test="${error}">
        ${errorMessage}<br/>
    </c:if>
    <input type="submit" value="Save"/>

</form>

<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>
