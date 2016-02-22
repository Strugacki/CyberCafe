<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
		<title> Cyber Cafe - kontakt</title>
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
							<a class="navbar-brand " href="<c:url value="/" /> ">CyberCafe</a>
						</div>
						
						<div class="collapse navbar-collapse" id="mynavbar-content">
							<ul class="nav navbar-nav">
								<li><a href="<c:url value="/about/" /> ">O nas</a></li>
								<li class="active"><a href="<c:url value="/contact/" /> ">Kontakt</a></li>
								<li><a href="<c:url value="/pricing/" /> ">Cennik</a></li>
								<li><a href="<c:url value="/promotions/" /> ">Promocje</a></li>
								<li><a href="<c:url value="/devices/" /> ">Sprzęt</a></li>
								<li><a href="<c:url value="/events/" /> ">Turnieje</a></li>
								<c:if test="${!empty user}">
									<li class="nav-divider"></li>
									<li><a href="<c:url value="/user/profile" />" class="btn-profile">Moje konto</a>
								</c:if>
								<c:choose>
									<c:when test="${role == 'ROLE_ADMIN'}">
										<jsp:include page="templates/admin.jsp"></jsp:include>
									</c:when>
									<c:when test="${role == 'ROLE_EMPLOYEE'}">
										<jsp:include page="templates/admin.jsp"></jsp:include>
									</c:when>
									<c:when test="${role == 'ROLE_USER'}">
										<jsp:include page="templates/admin.jsp"></jsp:include>
									</c:when>
								</c:choose>
							</ul>
						</div>
					<ul class="nav navbar-nav navbar-right">
						<c:choose >
							<c:when test="${empty user}">
								<li><a class="btn btn-primary-outline" href="<c:url value='/user/login' />" ><span class="glyphicon glyphicon-log-in" ></span> Logowanie</a></li>
							</c:when>
							<c:otherwise>
								<li><a class="btn btn-primary-outline" href="<c:url value='/user/logout' />" ><span class="glyphicon glyphicon-log-out" ></span> Wyloguj</a></li>
							</c:otherwise>
						</c:choose>
						<li><a class="btn btn-info-outline" href="<c:url value='/user/registration' />" ><span class="glyphicon glyphicon-user" ></span> Rejestracja</a></li>
					</ul>
			</div>
		</nav>
		
		<!--  <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d4645.553118896304!2d18.58045355361044!3d54.39626155185611!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0000000000000000%3A0x4d4128c9a5066e47!2sUniwersytet+Gda%C5%84ski!5e0!3m2!1spl!2spl!4v1455224517923" 
		width="400" 
		height="300" 
		frameborder="0" 
		style="border:0" 
		allowfullscreen></iframe> !-->
		
		
		<div class="container">
			<div class="well lead">
				<h2 class="text-center">Kontakt i lokalizacja</h2>
			</div>
			<div class="row">
			
				<div class="col-lg-4 col-md-10 col-md-offset-1">
					<img class="img-circle img-center" src="<c:url value="/resources/images/map.png" />" alt="banner" style="width:300px;height:300px">
				</div>
				<div class="col-lg-6 col-lg-offset-1 col-md-8 col-md-offset-2 dark-bg">
					<br>
					<form class="form" action="mailto:cybercafe@gmail.com" enctype="text/plain"  method="post">
						<div class="form-group">
							<label for="name"><span class="glyphicon glyphicon-pushpin"></span> Imię</label>
							<input type="text" class="form-control" id="name" placeholder="Twoje imię" />
						</div>
					
						<div class="form-group">
							<label for="email"><span class="glyphicon glyphicon-envelope"></span> Adres E-mail</label>
							<input type="text" class="form-control" id="email" placeholder="Adres e-mail" />
						</div>
						
						<div class="form-group">
							<label for="body"><span class="glyphicon glyphicon-pencil"></span> Treść</label>
							<textarea cols="40" rows="20" class="form-control" id="body" placeholder="Treść...." /></textarea>
						</div>
						
						<button type="submit" class="btn btn-primary">Wyślij wiadomość</button>
					</form>
					<br>
				</div>
			
			</div>
		
		</div>
		
		<br>
		<br>
		<!-- Footer  -->
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
		<script src="<c:url value="/resources/js/googlemap.js" />"></script>
	</body>
</html>