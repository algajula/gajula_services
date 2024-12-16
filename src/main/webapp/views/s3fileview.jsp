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
            <label class="title01">AWS S3 files:</label>
            <div align="center">
                <c:if test="${!empty s3files}">
                	<table class="tg">
                	<tr>
                		<th width="80">Bucket name</th>
                		<th width="120">File Name</th>
                		<th width="120">File Type</th>
                		<th width="60">Download</th>
                		<th width="60">Delete</th>
                	</tr>
                	<c:forEach items="${s3files}" var="awss3">
                		<tr>
                			<td>${awss3.bucketName}</td>
                			<td>${awss3.keyName}</td>
                			<td>${awss3.keyType}</td>
                			<td><a href="<c:url value='/api/v1/aws/s3/downloads3file?bucketName=${awss3.bucketName}&fileName=${awss3.keyName}&fileType=${awss3.keyType}' />" >Doqnload</a></td>
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
