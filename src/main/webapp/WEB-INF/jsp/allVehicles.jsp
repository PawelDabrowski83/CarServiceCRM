<%--
  Created by IntelliJ IDEA.
  User: paweld
  Date: 30.03.2020
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Vehicles</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<p><a href="${pageContext.request.contextPath}/vehicles?action=new">Add new Vehicle</a></p>

<table>
    <caption>All Vehicles</caption>
    <tr>
        <th>id</th>
        <th>Car type</th>
        <th>Color</th>
        <th>Registry plate</th>
        <th>Next inspection</th>
        <th>Owner</th>
        <th>Notes</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${vehicles}" var="vehicle">
        <tr>
            <td>${vehicle.vehicleId}</td>
            <td>${vehicle.carSignature}</td>
            <td>${vehicle.color}</td>
            <td>${vehicle.registryPlate}</td>
            <td>${vehicle.nextInspection}</td>
            <td>${vehicle.ownerFullname}</td>
            <td>${vehicle.notes}</td>
            <td><a href="${pageContext.request.contextPath}/vehicles?action=edit&id=${vehicle.vehicleId}">Edit</a> - <a href="${pageContext.request.contextPath}/vehicles?action=delete&id=${vehicle.vehicleId}">Delete</a></td>
        </tr>
    </c:forEach>

</table>

<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>
