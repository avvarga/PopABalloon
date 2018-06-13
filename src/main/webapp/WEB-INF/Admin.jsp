<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
       <%@include file="css/Style.css" %>
       <%@include file="css/skeleton.css" %>
       <%@include file="css/normalize.css" %>
</style>
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
	<header>
	    <h4>Welcome <c:out value="${ currentUser.login }"></c:out></h4>
	    <a href="/">Dashboard</a>
	    <form id="logoutForm" method="POST" action="/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout!" />
	    </form>
    </header>
    
    <table id="table">
    	<thead>
    		<tr>
    			<th>Login </th>
    			<th>Current Role</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach var="user" items="${ users }">
    			<tr>
    				<c:choose>
    					<c:when test="${ user.roles[0].name == 'ROLE_ADMIN' }">
	    					<td> ${user.login} </td>
	    					<td> ${user.roles[0].name } </td>
    					</c:when>
   					</c:choose>
    			</tr>
    		</c:forEach>
    	</tbody>
    </table>
</div>
</body>
</html>