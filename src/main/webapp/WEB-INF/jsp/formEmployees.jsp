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
        <input hidden="employeeId" value="${employee.employeeId}"/>
        Person: <select name="personId">
        <optgroup label="select">
            <c:forEach items="$persons" var="person">
                <option label="${person.fullname}" value="${person.id}"></option>
            </c:forEach>
        </optgroup>
    </select>
    </form>

<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>
