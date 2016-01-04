<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html"; charser="UTF-8">
		<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >
		<link rel="stylesheet" href="css/styles.css" > !-->
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
		<link rel="stylesheet" href="css/styles.css" >
		<title> Cyber Cafe </title>
	</head>

	<body>
	<div class="navbar navbar-default">
		<div class="row">
			<div class="col-lg-10">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mynavbar-content">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="home">Cyber Cafe</a>
					</div>
					
					<div class="collapse navbar-collapse" id="mynavbar-content">
						<ul class="nav navbar-nav">
							<li><a href="#">O nas</a></li>
							<li><a href="#">Kontakt</a></li>
							<li><a href="#">Cennik</a></li>
							<li><a href="#">Promocje</a></li>
							<li><a href="#">Sprzęt</a></li>
							<li><a href="#">Turnieje</a></li>
						</ul>
					</div>
				</div>
				<form class="col-lg-2">
				
				<div class="form-group">
					<input class="form-control input-sm" type="text" name="username" placeholder="Login"/>
				</div>
				<div class="form-group">
					<input class="form-control input-sm" type="text" name="password" placeholder="Hasło" />
				</div>
				
				<a class="btn btn-primary" href="<c:url value='/user/registration' />" >Zaloguj</button>
				
				
				<a class="btn btn-info" href="<c:url value='/user/registration' />" >Rejestracja</a>
				
				</form>
		</div>
	</div>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>${greeting}<h1>
					<p>${tagline}<p>
				</div>
			</div>
		</section>
		<div class="col-md-4">
      		<img src="<c:url value="/resources/images/banner_1.jpg" />" alt="banner" style="width:600px;height:300px">
 		 </div>
		
	<body>
	<script src="<c:url value='/resources/js/bootstrap.min.j' />" />
	<script src="<c:url value='/resources/js/jquery.js' />" />
</html>