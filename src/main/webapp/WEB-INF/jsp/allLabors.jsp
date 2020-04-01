<%--
  Created by IntelliJ IDEA.
  User: paweld
  Date: 01.04.2020
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Labors</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<p><a href="${pageContext.request.contextPath}/labors?action=new">Add new Labor</a></p>

<table>
    <caption>All Labors</caption>
    <tr>
        <th>Id</th>
        <th>Status</th>
        <th>Vehicle signature</th>
        <th>Employee</th>
        <th>Customer</th>
        <th>Total Cost</th>
        <th>Scheduled</th>
        <th>Started</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${labors}" var="labor">
        <tr>
            <td>${labor.laborId}</td>
            <td>${labor.status}</td>
            <td>${labor.vehicleSignature}</td>
            <td>${labor.employeeFullname}</td>
            <td>${labor.customerFullname}</td>
            <td>${labor.mhTotal}</td>
            <td>${labor.scheduledDate}</td>
            <td>${labor.startedDate}</td>
            <td><a href="${pageContext.request.contextPath}/labors?action=edit&id=${labor.laborId}">Edit</a> - <a href="${pageContext.request.contextPath}/labors?action=delete&id=${labor.laborId}">Delete</a></td>
        </tr>
    </c:forEach>
</table>


<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>
