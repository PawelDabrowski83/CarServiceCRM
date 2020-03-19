<%--
  Created by IntelliJ IDEA.
  User: paweld
  Date: 18.03.2020
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Personal Details view</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>


<table>
    <caption>Personal Details View</caption>
    <tr>
        <th>Fullname</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Notes</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${persons}" var="person">
        <tr>
            <td>${person.fullname}</td>
            <td>${person.address}</td>
            <td>${person.phone}</td>
            <td>${person.notes}</td>
            <td>Edit - Delete</td>
        </tr>
    </c:forEach>
</table>


<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>
