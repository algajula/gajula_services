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
            <label class="title01">AWS S3 Upload File:</label>
            <div align="center">
                <form:form action="${pageContext.request.contextPath}/api/v1/aws/s3/uploads3file" method="post" modelAttribute="metaData">
                <table>
                    <tr>
                        <td><label><spring:message code="label.awss3.bucketname"/></label></td>
                        <td><form:input path="bucketName" type="text" id="bucketName" /></td>
                    </tr>
                    <tr>
                        <td><label><spring:message code="label.awss3.uploadfile"/></label></td>
                        <td><form:input path="file" type="file" id="file" /></td>
                    </tr>
                    <tr>
                        <td><button name="uploads3file" id="uploads3file" class="uploads3file"><spring:message code="action.upload"/></button></td>
                    </tr>
                </table>
                </form:form>
            </div>
        </div>
    </div>
    <footer>
        <jsp:include page="/views/footer.jsp" />
    </footer>

</body>
</html>
