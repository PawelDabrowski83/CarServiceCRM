<%--
  Created by IntelliJ IDEA.
  User: paweld
  Date: 30.03.2020
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Cars</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<p><a href="${pageContext.request.contextPath}/cars?action=new">Add new Car</a></p>

<table>
    <caption>All Cars</caption>
    <tr>
        <th>Production Year</th>
        <th>Model</th>
        <th>Mark</th>
        <th>actions</th>
    </tr>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td>${car.productionYear}</td>
            <td>${car.model}</td>
            <td>${car.mark}</td>
            <td><a href="${pageContext.request.contextPath}/cars?action=edit&id=${car.carId}">Edit</a> - <a href="${pageContext.request.contextPath}/cars?action=delete&id=${car.carId}">Delete</a></td>
        </tr>
    </c:forEach>
</table>


<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>
