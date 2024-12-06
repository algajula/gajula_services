<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
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
            <div align="center">
            		<h2>User Registration</h2>
            		<form:form action="${pageContext.request.contextPath}/api/v1/user/register" method="post" modelAttribute="user">
            			<div>
            			<form:label path="fullName"><spring:message code="label.fullname"/>:</form:label>
            			<form:input path="fullName" />
            			<form:errors path="fullName" cssClass="error" />
            			</div>

            			<div>
            			<form:label path="emailAddress">E-mail:</form:label>
            			<form:input path="emailAddress" />
            			<form:errors path="emailAddress" cssClass="error" />
            			</div>

            			<div>
            			<form:label path="phone">Phone:</form:label>
            			<form:input path="phone"/>
            			<form:errors path="phone" cssClass="error" />
            			</div>


            			<div>
            			<form:label path="dateOfBirth">Date Of Birth:</form:label>
            			<form:input path="dateOfBirth" type="date"/>
            			<form:errors path="dateOfBirth" cssClass="error" />
            			</div>

            			<div>
            			<form:label path="gender">Gender:</form:label>
            			<form:radiobutton path="gender" value="Male"/>Male
            			<form:radiobutton path="gender" value="Female"/>Female
            			<form:errors path="gender" cssClass="error" />
            			</div>

            			<div>
            			<form:label path="occupation">Profession:</form:label>
            			<form:select path="occupation" items="${professionList}" />
            			<form:errors path="occupation" cssClass="error" />
            			</div>

            			<div>
            			<form:label path="maritalStatus">Married?</form:label>
            			<form:checkbox path="maritalStatus"/>
            			<form:errors path="maritalStatus" cssClass="error" />
            			</div>


            			<div>
            				<div></div>
            				<div>
            				<form:button>Register</form:button>
            				</div>
            				<div></div>
            			</div>
            		</form:form>
            	</div>

            	<div>
            	<button name="GetCountries" id="getcountries" class="getcountries" >GetCountries</button>
            	</div>
        </div>
    </div>
    <footer>
        <jsp:include page="/views/footer.jsp" />
    </footer>

</body>
</html>
