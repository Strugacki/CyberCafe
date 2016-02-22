<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
		<title> Cyber Cafe </title>
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
						<c:set var="user" value="${user}"/>
						<div class="collapse navbar-collapse" id="mynavbar-content">
							<ul class="nav navbar-nav">
								<li><a href="<c:url value="/about/" /> ">O nas</a></li>
								<li><a href="<c:url value="/contact/" /> ">Kontakt</a></li>
								<li><a href="<c:url value="/pricing/" /> ">Cennik</a></li>
								<li><a href="<c:url value="/promotions/" /> ">Promocje</a></li>
								<li><a href="<c:url value="/devices/add" /> ">Sprzęt</a></li>
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
						<c:choose >
							<c:when test="${empty user}">
								<li><a class="btn btn-primary-outline" href="<c:url value='/user/login' />" ><span class="glyphicon glyphicon-log-in" ></span> Logowanie</a></li>
							</c:when>
							<c:otherwise>
								<li><a class="btn btn-primary-outline" href="<c:url value='/user/logout' />" ><span class="glyphicon glyphicon-log-in" ></span> Wyloguj</a></li>
							</c:otherwise>
						</c:choose>
						<li><a class="btn btn-info-outline" href="<c:url value='/user/registration' />" ><span class="glyphicon glyphicon-user" ></span> Rejestracja</a></li>
					</ul>
			</div>
		</nav>
			<section>
				<div class="jumbotron">
					<div class="container">
						<h1 class="text-center">Witaj na Cyber Cafe!!</h1>
						<p class="text-center">Z nami możesz się zrelaksować w Świecie gier</p>
					</div>
				</div>
			</section>
			
			<div id="slider" class="carousel slide" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#slider" data-slide-to="0" class="active"></li>
					<li data-target="#slider" data-slide-to="1"></li>
					<li data-target="#slider" data-slide-to="2"></li>
					<li data-target="#slider" data-slide-to="3"></li>
				</ol>
			<div class="carousel-inner">
				<div class="item active">
					<img class="img-responsive" src="<c:url value="/resources/images/slider_1.jpg" />" />
					<div class="carousel-caption" >
						<h4>Gwarancja dobrego połączenia</h4>
						<p>Nasza owocna współpraca z dostawcą internetu gwarantuje brak lagów podczas rozgrywki i niski ping</p>
					</div>
				</div>
				<div class="item">
					<img class="img-responsive" src="<c:url value="/resources/images/slider_2.jpg" />" />
					<div class="carousel-caption" >
						<h4>Need for Speed 3CITY</h4>
						<p>Zapraszamy na pierwszy trójmiejski turniej w Need for Speed. Zapisy w naszym lokalu, zapraszamy!</p>
					</div>
				</div>
				<div class="item">
					<img class="img-responsive" src="<c:url value="/resources/images/slider_3.jpg" />" />
					<div class="carousel-caption" >
						<h4>League of Legends</h4>
						<p>Z okazji zbliżającego się IEM'u mamy zniżkę dla grup grających w LoL'a. Wpadajcie, warto!</p>
					</div>
				</div>
				<div class="item">
					<img class="img-responsive" src="<c:url value="/resources/images/slider_4.jpg" />" />
					<div class="carousel-caption" >
						<h4>Counter Strike Global Offensive</h4>
						<p>Jeśli jesteś zapalonym graczem cs:go i szukasz drużyny, przyjdź do nas! Takich osób jest więcej, z pewnością znajdziesz team marzeń!</p>
					</div>
				</div>
			</div>
				<a class="left carousel-control" href="#slider" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
				</a>
				<a class="right carousel-control" href="#slider" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
				</a>
			</div>
			
			<br>
			<div class="container">
				
				<div class="row">
				
					<div class="col-lg-9 col-md-7  col-sm-12">
						<c:forEach items="${news}" var="single">
						
						<div class="panel panel-default">
							<div class="panel-heading-dark">
								<h3 id="${single.title}"><span class="glyphicon glyphicon-paperclip"></span> ${single.title}</h3>
							</div>
							<div class="panel-body">
								<p>${single.body}</p>
							</div>
							<div class="panel-footer">
								<span class="glyphicon glyphicon-calendar"></span> ${single.uploadDate}
							</div>
						</div>
						
						</c:forEach>
					</div>
				
					<div class="col-lg-3 col-md-5 col-sm-12">
						
						<div class="panel panel-default">
							<div class="panel-heading-dark">
								<h3><span class="glyphicon glyphicon-tags"> Short newsy </h3>
							</div>
							<c:forEach items="${news}" var="single">
								<ul class="list-group">
									<a href="#<c:out value="${single.title}"/>"><li class="list-group-item">${single.title}</li></a>
								</ul>
							</c:forEach>
						</div>
				</div>
			
			</div>
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
	</body>
</html>