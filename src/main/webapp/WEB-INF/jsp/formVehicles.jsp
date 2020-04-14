<%--
  Created by IntelliJ IDEA.
  User: paweld
  Date: 30.03.2020
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Vehicle - details</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<form action="${pageContext.request.contextPath}/vehicles?action=${action}" method="post">
    <input type="hidden" name="vehicleId" value="${vehicle.vehicleId}"/>
    Type of car:
    <select name="carId">
        <c:if test="${action eq 'new'}">
            <c:choose>
                <c:when test="${vehicle.carId > 0}">
                    <option value="${vehicle.carId}" selected>${vehicle.carSignature}</option>
                </c:when>
                <c:otherwise>
                    <option hidden selected disabled value="">select</option>
                </c:otherwise>
            </c:choose>
        </c:if>
        <c:if test="${action eq 'edit'}">
            <option value="${vehicle.carId}" selected>${vehicle.carSignature}</option>
        </c:if>
        <c:forEach items="${cars}" var="car">
            <option value="${car.carId}">${car.carSignature}</option>
        </c:forEach>
    </select><br/>
    Registry plate: <input type="text" name="registryPlate" value="${vehicle.registryPlate}"/><br/>
    Color: <input type="text" name="color" value="${vehicle.color}"/><br/>
    Notes: <input type="text" name="notes" value="${vehicle.notes}"/><br/>
    Owner: <select name="ownerId">
            <c:choose>
                <c:when test="${vehicle.ownerId > 0}">
                    <option value="${vehicle.ownerId}" selected>${vehicle.ownerFullname}</option>
                </c:when>
                <c:otherwise>
                    <option hidden selected disabled value="">select</option>
                </c:otherwise>
            </c:choose>
        <c:forEach items="${customers}" var="customer">
            <option value="${customer.customerId}">${customer.fullname}</option>
        </c:forEach>
    </select><br/>
    Next Inspection Date: <input type="date" name="nextInspection" value="${vehicle.nextInspection}"/><br/>
    <c:if test="${error}">
        ${errorMessage}<br/>
    </c:if>
    <input type="submit" value="Save"/>
</form>

<jsp:include page="/WEB-INF/jsp/footer.jsp"/>
</body>
</html>
