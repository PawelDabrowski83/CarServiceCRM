<%--
  Created by IntelliJ IDEA.
  User: paweld
  Date: 27.03.2020
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee - details</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>

    <form method="post" action="${pageContext.request.contextPath}/employees?action=${action}">
        <input type="hidden" name="employeeId" value="${employee.employeeId}"/>
        Person: <select name="personId">
        <optgroup label="select">
            <c:choose>
                <c:when test="${empty (employee.personId) || (employee.personId < 1)}">
                    <option value="" selected disabled hidden>select</option>
                </c:when>
                <c:otherwise>
                    <option value="${employee.personId}" title="${employee.fullname}">${employee.fullname}</option>
                </c:otherwise>
            </c:choose>
            <c:forEach items="${persons}" var="person">
                <option title="${person.fullname}" value="${person.id}">${person.fullname}</option>
            </c:forEach>
        </optgroup>
    </select><br/>
        Man hour cost: <input type="text" name="mhCost" value="${employee.mhCost}"/><br/>
        <c:if test="${error}">
            ${errorMessage}<br/>
        </c:if>

        <input type="submit" value="Save"/>
    </form>

<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>
