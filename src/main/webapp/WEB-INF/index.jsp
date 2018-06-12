<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" >
	<link rel="icon" href="resources/balloons.png">
	<title>Pop-A-Balloon</title>
	<link rel="stylesheet" href="/resources/style.css" type="text/css">
    <script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
    <script src="resources/scripts.js" type="text/javascript"></script>
</head>
	<body>
		<!-- BACKGROUND -->
        <div class="grass"></div>
        <div class="cloud"></div>
        <div class="cloud"></div>
        <div class="cloud"></div>
        <!-- END BACKGROUD -->
        <!-- Title  -->
        <div class="title-box">
            <h1 class="title-text">POP-A-BALLOON</h1>
        </div>
        <!-- End of title -->
        <!-- Enter code page  -->
        
        <div class="enterCodeBox content-background">
        <h1>Claim your Code</h1>
        	<form action="/" class="form">
			<input type="text" placeholder="Login" name="login">
			<input type="text" placeholder="Code" name="code">
			<button class='claim' type="submit">Claim</button>
			</form>
			<a href="/" id="loginAsAdmin">Login as Admin</a>
        </div>
        
        
        
        <div id="adminLoginForm" class="content-background">
        <h1>Login As Admin</h1>
        	<form action="/" class="form">
			<input type="text" placeholder="Login" name="login">
			<input type="password" placeholder="Password" name="code">
			<button class='claim' type="submit">Login</button>
			</form>
        </div>
        
        <!-- End of enter code page -->
        
        <!-- Pop the balloon -->
        <div class="balloons-page">
            <div class="board">
                <div class="balloon red"></div>
                <div class="balloon black"></div>
                <div class="balloon purple"></div>
                <div class="balloon blue"></div>
                <div class="balloon green"></div>
            </div>
            <div class="modal">
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <img alt="Movie Tickets" src="resources/movie-tickets.jpg">
                    <h1>Congratulations!</h1>
                    <p>You won Movie Tickets</p>
                    <p>Please reach out Jimena@ to claim your prize</p>
                    <hr>
                    <button id="close">Close</button>
                </div>
            </div>
        </div>
        <!-- End of pop a balloon -->
	</body>
</html>