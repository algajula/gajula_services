<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html />
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>home page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/global.css" />
    <script>
        var contextPath = "<%=request.getContextPath()%>";
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
</head>
<body>
<body>
    <jsp:include page="/views/header.jsp" />
    <header>
        <jsp:include page="/views/navbar.jsp" />
    </header>
    <div class="container">
        <div class="box">
            <label class="title01">Customer Details:</label>
            <div align="center">
                <c:if test="${!empty custList}">
                	<table class="tg">
                	<tr>
                		<th width="80">Cust Number</th>
                		<th width="120">Cust Name</th>
                		<th width="120">Email Address</th>
                		<th width="120">Phone</th>
                		<th width="60">Edit</th>
                		<th width="60">Delete</th>
                	</tr>
                	<c:forEach items="${custList}" var="customer">
                		<tr>
                			<td>${customer.custNumber}</td>
                			<td>${customer.custName}</td>
                			<td>${customer.emailAddress}</td>
                			<td>${customer.phone}</td>
                			<td><a href="<c:url value='/edit/${customer.cust_uid}' />" >Edit</a></td>
                			<td><a href="<c:url value='/remove/${customer.cust_uid}' />" >Delete</a></td>
                		</tr>
                	</c:forEach>
                	</table>
                </c:if>
            </div>
        </div>
    </div>
    <footer>
        <jsp:include page="/views/footer.jsp" />
    </footer>

</body>
</html>
