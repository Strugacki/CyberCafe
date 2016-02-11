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
			<section>
				<div class="jumbotron">
					<div class="container">
						<h1>Witaj na Cyber Cafe!!</h1>
						<p>Z nami możesz się zrelaksować w Świecie gier</p>
					</div>
				</div>
			</section>
			
			<div class="col-lg-8 col-lg-offset-2 col-md-7 col-md-offset-2 col-sm-10 col-sm-offset-1">
				<img class="img-responsive" src="<c:url value="/resources/images/banner_1.jpg" />" alt="banner" style="width:800px;height:400px">
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
		<script src="<c:url value="/resources/js/jquery.js" />" ></script>
		<script src="<c:url value="/resources/js/bootstrap.js" />" ></script>
	</body>
</html>