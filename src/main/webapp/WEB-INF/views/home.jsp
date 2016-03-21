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
							<a style="padding-top: 0"class="navbar-brand " href="">
								<img class="img-responsive" src="<c:url value="/resources/images/logo.png" />"/>
							</a>
						</div>
						<c:set var="user" value="${user}"/>
						<c:set var="role" value="${role}"/>
						<c:set var="deviceMenu" value="${deviceMenu}"/>
						<div class="collapse navbar-collapse" id="mynavbar-content">
							<ul class="nav navbar-nav">
								<li><a href="<c:url value="/about/" /> ">O nas</a></li>
								<li><a href="<c:url value="/contact/" /> ">Kontakt</a></li>
								<li><a href="<c:url value="/pricing/" /> ">Cennik</a></li>
								<li><a href="<c:url value="/promotions/" /> ">Promocje</a></li>
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
									<li><a class="btn btn-primary-outline " href="<c:url value='/user/login' />" ><span class="glyphicon glyphicon-log-in" ></span> Logowanie</a></li>
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
								<c:if test="${(role == 'ROLE_EMPLOYEE') || (role == 'ROLE_ADMIN')}">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12">
										<div class="col-lg-3 col-lg-push-8 col-md-5 col-md-push-6 col-sm-12 text-center">
										<a href="/cyberCafe/news/update?id=${single.idNews}" class="btn btn-primary">Edytuj <span class="glyphicon glyphicon-wrench"></span></a> <a href="/cyberCafe/news/delete?id=${single.idNews}" class="btn btn-danger">Usuń <span class="glyphicon glyphicon-remove-circle"></span></a>
									</div>
									</div>
								</div>
								</c:if>
							</div>
							<div class="panel-body">
								<p>${single.body}</p>
							</div>
							<div class="panel-footer">
								<p><span class="glyphicon glyphicon-calendar"></span> ${single.uploadDate}  <span class="text-muted">@${single.user.nickname}</span></p>
							</div>
						</div>
						
						</c:forEach>
					</div>
				
					<div class="col-lg-3 col-md-5 col-sm-12">
						
						<div class="panel panel-default">
							<div class="panel-heading-dark">
								<h3><span class="glyphicon glyphicon-tags"></span> Short newsy </h3>
							</div>
							<c:forEach items="${news}" var="single">
								<ul class="list-group">
									<li class="list-group-item"><a href="#<c:out value="${single.title}"/>">${single.title}</a></li>
								</ul>
							</c:forEach>
						</div>
				</div>
			
			</div>
		</div>
		<jsp:include page="templates/footer.jsp"></jsp:include>
		<script src="<c:url value="/resources/js/jquery.js" />" ></script>
		<script src="<c:url value="/resources/js/bootstrap.js" />" ></script>
	</body>
</html>