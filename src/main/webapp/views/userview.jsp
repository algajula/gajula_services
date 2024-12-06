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
            <label class="title01">User Details:</label>
            <div align="center">
                <c:if test="${!empty userList}">
                	<table class="tg">
                	<tr>
                		<th width="80">User Number</th>
                		<th width="120">User Name</th>
                		<th width="120">Gender</th>
                		<th width="120">Married</th>
                		<th width="120">Date Of Birth</th>
                		<th width="120">Occupation</th>
                		<th width="120">Phone</th>
                		<th width="120">Email Address</th>
                		<th width="60">Edit</th>
                		<th width="60">Delete</th>
                	</tr>
                	<c:forEach items="${userList}" var="user">
                		<tr>
                			<td>${user.userId}</td>
                			<td>${user.fullName}</td>
                			<td>${user.gender}</td>
                			<td>${user.maritalStatus}</td>
                			<td>${user.dateOfBirth}</td>
                			<td>${user.occupation}</td>
                			<td>${user.phone}</td>
                			<td>${user.emailAddress}</td>
                			<td><a href="<c:url value='/edit/${user.userUid}' />" >Edit</a></td>
                			<td><a href="<c:url value='/remove/${user.userUid}' />" >Delete</a></td>
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
