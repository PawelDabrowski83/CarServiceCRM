<%--
  Created by IntelliJ IDEA.
  User: paweld
  Date: 19.03.2020
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Person Details</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/WEB-INF/css/style.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<form action="${pageContext.request.contextPath}/managePersonDetails?action=${action}" method="post">
    <input type="hidden" name="id" value="${person.id}"/>
    First name: <input type="text" name="firstName" value="${person.firstName}"/><br/>
    Last name: <input type="text" name="lastName" value="${person.lastName}"/><br/>
    Address: <input type="text" name="address" value="${person.address}"/><br/>
    Phone: <input type="text" name="phone" value="${person.phone}"/><br/>
    Notes: <input name="notes" value="${person.notes}"/><br/>
    Year of birth (YYYY): <input type="text" name="birthYear" value="${person.birthYear}"/><br/>
    Month of birth (MM): <input type="text" name="birthMonth" value="${person.birthMonth}"/><br/>
    Day of birth (DD): <input type="text" name="birthDay" value="${person.birthDay}"/><br/>
    <c:if test="${error}">
        <span class="error">${errorMessage}</span><br/>
    </c:if>
    <input type="submit" value="Save"/>
</form>

<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>
