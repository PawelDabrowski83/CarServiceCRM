<%--
  Created by IntelliJ IDEA.
  User: paweld
  Date: 27.03.2020
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Employees</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<p><a href="${pageContext.request.contextPath}/employees?action=new">Add new Employees</a></p>

<table>
    <caption>All Employees</caption>
    <tr>
        <th>id</th>
        <th>Fullname</th>
        <th>MHCost</th>
        <th>actions</th>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.employeeId}</td>
            <td>${employee.fullname}</td>
            <td>${employee.mhCost}</td>
            <td><a href="${pageContext.request.contextPath}/employees?action=edit&id=${employee.employeeId}">Edit</a> - <a href="${pageContext.request.contextPath}/employees?action=delete&id=${employee.employeeId}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>
