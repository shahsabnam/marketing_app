<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update</title>
</head>
<body>
<h2>Update New Lead</h2>
<form action="updatelead" method="post">
<pre>
	<input type="hidden"  value="${lead.id}"/>
	First Name<input type="text" name="firstName" value="${lead.firstName}"/>
	Last Name <input type="text" name="lastName" value="${lead.lastName}"/>
	Email<input type="text" name="email" value="${lead.email}"/>
	Mobile<input type="text" name="mobile" value="${lead.mobile}"/>
		<input type="submit" value="update"/>
</pre>
</form>
</body>
</html>