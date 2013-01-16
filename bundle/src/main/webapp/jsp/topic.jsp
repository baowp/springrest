<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<p>
		This is my message:<br> ${message}
	</p>
<%-- 	<div>${command.apple(fruit) }</div>  --%>
	<div>${spel["T(java.lang.Math).random() * 100.0"]}</div>
	<form:form commandName="fruit" action="23" method="post">
		<div>
			<form:input path="name" />
			<form:errors path="name" />
		</div>
		<div>
			<form:input path="price" />
			<form:errors path="price" />
		</div>
		<div>
			<form:input path="username" />
			<form:errors path="username" />
		</div>
		<div>
			<form:input path="price2" />
			<form:errors path="price2" />
		</div>
		<input type="submit" />
	</form:form>
</body>
</html>