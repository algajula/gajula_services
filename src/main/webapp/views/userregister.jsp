<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Form</title>
<style type="text/css">
	
	button {
		padding: 10px;
	}
	.error {
		color: red;
		font-style: italic;
	}
	form {
		display: table;
	}
	form div {
		display: table-row;
	}
	label, input, span, select {
		display: table-cell;
		margin: 5px;
		text-align: left;		
	}
	input[type=text], input[type=password], select, textarea {
		width: 200px;
		margin: 5px;
	}

	form div div {
		display: table-cell;
	}	
</style>
</head>
<body>
	<div align="center">
		<h2>User Registration</h2>
		<form:form action="api/v1/user/register" method="post" modelAttribute="user">
			<div>
			<form:label path="fullName"><spring:message code="user.form.fullname"/>:</form:label>
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
			<form:password path="phone"/>
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
</body>
</html>