<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
		<title> Cyber Cafe - promocje</title>
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
								<li><a href="<c:url value="/contact/" /> ">Kontakt</a></li>
								<li><a href="<c:url value="/pricing/" /> ">Cennik</a></li>
								<li class="active"><a href="<c:url value="/promotions/" /> ">Promocje</a></li>
								<li><a href="<c:url value="/device/list" /> ">Sprzęt</a></li>
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
										<jsp:include page="templates/employee.jsp"></jsp:include>
									</c:when>
									<c:when test="${role == 'ROLE_USER'}">
										<jsp:include page="templates/user.jsp"></jsp:include>
									</c:when>
								</c:choose>
							</ul>
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
					
			</div>
		</nav>
		
		
		
		
		<div id="slider" class="carousel slide" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#slider" data-slide-to="0" class="active"></li>
					<li data-target="#slider" data-slide-to="1"></li>
				</ol>
			<div class="carousel-inner">
				<div class="item active">
					<img class="img-responsive" src="<c:url value="/resources/images/Wal1.jpg" />" style="width:1920px;height:1080px"/>
					<div class="carousel-caption" >
						<div class="caption text-left">
               				<h1>Walentynkowa promocja </h1>
               				<strong><h3>Przyjdź razem ze swoim partnerem, pograj w ulubione gry na najlepszym sprzęcie i zapłać tylko 69% od osoby !</h3>
          					<h3>Promocja trwa od 8:00 do 22:00, dnia 14 Lutego </h3></strong>
               				<a href="#" class="btn btn-info" role="button">Zarezerwuj</a>
              
            			</div>
					</div>
				</div>
				<div class="item">
					<img class="img-responsive" src="<c:url value="/resources/images/Wal2.jpg" />" style="width:1920px;height:1080px"/>
					<div class="carousel-caption" >
						<div class="caption text-left">
               				<h1>Chiński nowy rok </h1>
               				<strong><h3>Świętuj Chiński Nowy Rok razem z CyberCafe ! </h3>
               				<h3>Tylko teraz przez najbliższy tydzień do każdego zamówienia powyżej 15zł dostaniesz 30min gratis ! </h3>
               				<h3>Nie przegap takiej okazji i przyjdź do nas już dziś </h3>
          					<h3>Promocja trwa od 15.02.2016 do 21.02.2016 </h3></strong>
               				<a href="#" class="btn btn-info" role="button">Zarezerwuj</a>
              
            			</div>
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