<!DOCTYPE HTML>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8" />
<title>Spring Boot Index Example</title>
</head>
<body>
	<div style="border: 1px solid #ccc; padding: 5px; margin-bottom: 10px;">
		<a href="/login">/login</a>
	</div>
	<h3>Spring Boot Index Example</h3>
	<span style="color: blue;">Hello ${message} Testing
		LogInterceptor</span>
	<br />
	<br /> See Log in Console..
</body>
</html>