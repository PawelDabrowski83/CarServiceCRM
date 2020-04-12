<%--
  Created by IntelliJ IDEA.
  User: paweld
  Date: 30.03.2020
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Car - details</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<form action="${pageContext.request.contextPath}/cars?action=${action}" method="post">
    <input type="hidden" name="carId" value="${car.carId}"/>
    Mark: <input type="text" name="mark" value="${car.mark}"/><br/>
    Model: <input type="text" name="model" value="${car.model}"/><br/>
    Year of production: <input type="text" name="productionYear" value="${car.productionYear}"/><br/>
    <c:if test="${error}">
        ${errorMessage}<br/>
    </c:if>
    <input type="submit" value="Save"/>
</form>

<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>
