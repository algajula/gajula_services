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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bookservice.js"></script>
</head>
<body>
<body>
    <jsp:include page="/views/header.jsp" />
    <header>
        <jsp:include page="/views/navbar.jsp" />
    </header>
    <div class="container">
        <div class="box">
            <label class="title01">Add Book:</label>
            <div align="center">
                <table>
                    <tr>
                        <td><label><spring:message code="label.book.title"/></label></td>
                        <td><input type="text" id="title" /></td>
                        <td><label id="titleerr" class="titleerr" /></td>
                    </tr>
                    <tr>
                        <td><label><spring:message code="label.book.genre"/></label></td>
                        <td><input type="text" id="genre" /></td>
                        <td><label id="genreerr" class="genreerr" /></td>
                    </tr>
                    <tr>
                        <td><label><spring:message code="label.book.publishDate"/></label></td>
                        <td><input type="text" id="publicationDate" /></td>
                    </tr>
                    <tr>
                        <td><label><spring:message code="label.book.price"/></label></td>
                        <td><input type="text" id="price" /></td>
                        <td><label id="priceerr" class="priceerr" /></td>
                    </tr>
                    <tr>
                        <td><button name="savebook" id="savebook" class="savebook"><spring:message code="action.save"/></button></td>
                        <td><button name="cancel" id="cancel" class="cancel"><spring:message code="action.cancel"/></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <footer>
        <jsp:include page="/views/footer.jsp" />
    </footer>

</body>
</html>
