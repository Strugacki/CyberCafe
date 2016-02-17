<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html"; charset="UTF-8">
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
		<title> Cyber Cafe - registration</title>
	</head>

	<body>
	<nav class="navbar navbar-inverse">
			<div class="container-fluid">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mynavbar-content">
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand " href="#">Cyber Cafe</a>
						</div>
						
						<div class="collapse navbar-collapse" id="mynavbar-content">
							<ul class="nav navbar-nav">
								<li><a href="<c:url value="/about/" /> ">O nas</a></li>
								<li><a href="<c:url value="/contact/" /> ">Kontakt</a></li>
								<li><a href="<c:url value="/pricing/" /> ">Cennik</a></li>
								<li><a href="<c:url value="/promotions/" /> ">Promocje</a></li>
								<li><a href="<c:url value="/devices/" /> ">Sprzęt</a></li>
								<li><a href="<c:url value="/events/" /> ">Turnieje</a></li>
							</ul>
						</div>
					<!--  <form class="col-lg-2">
						<div class="form-group">
							<input class="form-control input-sm" type="text" name="username" placeholder="Login"/>
						</div>
						<div class="form-group">
							<input class="form-control input-sm" type="text" name="password" placeholder="Hasło" />
						</div>
						<a class="btn btn-primary" href="<c:url value='/user/registration' />" >Zaloguj</a>
						<a class="btn btn-info" href="<c:url value='/user/registration' />" >Rejestracja</a>
					</form> !-->
					<ul class="nav navbar-nav navbar-right">
						<li><a class="btn btn-primary-outline" href="<c:url value='/user/login' />" ><span class="glyphicon glyphicon-log-in" ></span> Logowanie</a></li>
						<li><a class="btn btn-info-outline" href="<c:url value='/user/registration' />" ><span class="glyphicon glyphicon-user" ></span> Rejestracja</a></li>
					</ul>
			</div>
	</nav>
	
	<div class="generic-container">
    	<div class="well lead">
    		<h2 class="text-center">Formularz logowania</h2>
    	</div>
			<form lass="form-horizontal">
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-3 col-md-3 col-sm-3" for="login">Login</label>
						<div class="col-lg-5 col-md-5 col-sm-5">
							<input id="login" name="login" type="text" class="form-control input-sm"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-3 col-md-3 col-sm-3" for="password">Hasło</label>
						<div class="col-lg-5 col-md-5 col-sm-5">
							<input id="password" name="password" type="password" class="form-control input-sm"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-actions col-lg-5 col-md-5 col-sm-5 pull-right">
						<input type="submit" value="Zaloguj" class="btn btn-primary btn-sm"/> albo <a
						href="<c:url value='/home' />">wróć</a>
					</div>
				</div>
			</form>
		</div>
	
	<footer class="navbar-inverse">
			<div class="container">
				<div class="row">
					<div class="col-lg-4">
						<ul class="nav nav-stacked">
							<li class="text-center"><h5>Firma: </h5></li>
							<li class="text-center"><a href="<c:url value="/about/" /> ">O nas</a></li>
							<li class="text-center"><a href="<c:url value="/contact/" /> ">Kontakt</a></li>
							<li class="text-center"><a href="<c:url value="/pricing/" /> ">Cennik</a></li>
							<li class="text-center"><a href="<c:url value="/promotions/" /> ">Promocje</a></li>
						</ul>
					</div>
					<div class="col-lg-4">
						<ul class="nav nav-stacked">
							<li class="text-center"><h5>Znajdź nas na: </h5></li>
							<li class="text-center"><a href="<c:url value="#" /> "><img src="<c:url value="/resources/images/social_fb.png" />" /></a></li>
							<li class="text-center"><a href="<c:url value="#" /> "><img src="<c:url value="/resources/images/social_tw.png" />" /></a></li>
						</ul>
					</div>
				</div>
				<div class="row">
					<hr>
					<p class="text-white">® 2016 CyberCafe, All Rights Reserved.</p>
					<br>
				</div>
			</div>	
	</footer>
	<script src="<c:url value="/resources/js/jquery.js" />" ></script>
	<script src="<c:url value="/resources/js/bootstrap.js" />" ></script>		
	<body>
</html>