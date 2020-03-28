<%--
  Created by IntelliJ IDEA.
  User: paweld
  Date: 28.03.2020
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All customers</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<p><a href="${pageContext.request.contextPath}/customers?action=new">Add new Customer</a></p>

<table>
    <caption>All customers</caption>
    <tr>
        <th>id</th>
        <th>Fullname</th>
        <th>actions</th>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.customerId}</td>
            <td>${customer.fullname}</td>
            <td><a href="${pageContext.request.contextPath}/customers?action=edit&id=${customer.customerId}">Edit</a> - <a href="${pageContext.request.contextPath}/customers?action=delete&id=${customer.customerId}">Delete</a></td>
        </tr>
    </c:forEach>
</table>


<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>
