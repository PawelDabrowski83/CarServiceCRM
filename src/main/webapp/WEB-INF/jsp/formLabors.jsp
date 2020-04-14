<%--
  Created by IntelliJ IDEA.
  User: paweld
  Date: 01.04.2020
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Labor - details</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<form action="${pageContext.request.contextPath}/labors?action=${action}" method="post">
    <input type="hidden" name="laborId" value="${labor.laborId}"/>
    Registration: <input type="date" name="registrationDate" value="${labor.registrationDate}"/><br/>
    Scheduled: <input type="date" name="scheduledDate" value="${labor.scheduledDate}"/><br/>
    Started: <input type="date" name="startedDate" value="${labor.startedDate}"/><br/>
    Finished: <input type="date" name="finishedDate" value="${labor.finishedDate}"/><br/>
    <label>Employee: </label>
    <select name="employeeId">
        <c:choose>
            <c:when test="${labor.employeeId < 1}">
                <option value="" selected disabled hidden>select</option>
            </c:when>
            <c:otherwise>
                <option value="${labor.employeeId}" selected>${labor.employeeFullname}</option>
            </c:otherwise>
        </c:choose>
        <c:forEach items="${employees}" var="employee">
            <option value="${employee.employeeId}">${employee.fullname}</option>
        </c:forEach>
    </select><br/>
    Issue description: <input type="text" name="descriptionIssue" value="${labor.descriptionIssue}"/><br/>
    Provided service description: <input type="text" name="descriptionService" value="${labor.descriptionService}"/><br/>
    <label>Status:</label>
    <select name="status">
        <c:choose>
            <c:when test="${empty labor.status}">
                <option value="" selected disabled hidden>select</option>
            </c:when>
            <c:otherwise>
                <option value="${labor.status}" selected>${labor.status}</option>
            </c:otherwise>
        </c:choose>
        <c:forEach items="${statuses}" var="status">
            <option value="${status}">${status}</option>
        </c:forEach>
    </select><br/>
    <label>Vehicle:</label>
    <select name="vehicleId">
        <c:choose>
            <c:when test="${labor.vehicleId < 1}">
                <option value="" selected disabled hidden>select</option>
            </c:when>
            <c:otherwise>
                <option value="${labor.vehicleId}">${labor.vehicleSignature}</option>
            </c:otherwise>
        </c:choose>
        <c:forEach items="${vehicles}" var="vehicle">
            <option value="${vehicle.vehicleId}">${vehicle.carSignature}</option>
        </c:forEach>
    </select><br/>
    Customer cost: <input type="text" name="customerCost" value="${labor.customerCost}"/><br/>
    Material cost: <input type="text" name="materialCost" value="${labor.materialCost}"/><br/>
    MH count: <input type="text" name="mhTotal" value="${labor.mhTotal}"/><br/>
    <input type="submit" value="Save"/>

</form>



<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>
