<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
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
							<a class="navbar-brand " href="<c:url value="/" /> ">CyberCafe</a>
						</div>
						
						<div class="collapse navbar-collapse" id="mynavbar-content">
							<ul class="nav navbar-nav">
								<li class="active"><a href="<c:url value="/about/" /> ">O nas</a></li>
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
		
	<!-- Page Content -->
    <div class="container">

        <!-- Introduction Row -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">O nas
                    <small></small>
                </h1>
                <p>CyberCafe to największa na świecie niezależna marka e-sportowa organizująca turnieje online i offline, podczas których rywalizują ze sobą gracze w wiele różnych gier. Działalność CyberCafe obejmuje organizację krajowych i międzynarodowych rozgrywek ligowych i turniejów, takich jak The Intel® Extreme Masters, ESL One, ESL Pro Series czy Starcraft® II World Championship Series. Wspierane są też lokalne rozgrywki ligowe i pucharowe oraz systemy umożliwiające grę wieloosobową. Rejestracja i uczestnictwo w lokalnych ladderach i pucharach jest darmowe. </p>
            </div>
        </div>

        <!-- Team Members Row -->
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Nasz zespół</h2>
            </div>
            <div class="col-lg-6 col-sm-6 text-center">
               <img class="img-circle img-center" src="<c:url value="/resources/images/Marcin.jpg" />" alt="banner" style="width:200px;height:200px">
                <h3>Marcin Hallman
                    <small>Developer</small>
                </h3>
                <p>Twarda bania i zaciśnięte pięści, uwalniam instynkt gdy atmosfera się zagęści</p>
            </div>
            <div class="col-lg-6 col-sm-6 text-center">
                <img class="img-circle  img-center" src="<c:url value="/resources/images/Adam.jpg" />" alt="banner" style="width:200px;height:200px">
                <h3>Adam Chlebba
                    <small>Developer</small>
                </h3>
                <p>PC Master Race</p>
            </div>
            <div class="col-lg-6 col-sm-6 text-center">
                 <img class="img-circle  img-center" src="<c:url value="/resources/images/Slawek.jpg" />" alt="banner" style="width:200px;height:200px">
                <h3>Sławek Rzeppa
                    <small>Developer</small>
                </h3>
                <p>Coooooooooooo</p>
            </div>
            <div class="col-lg-6 col-sm-6 text-center">
                <img class="img-circle  img-center" src="<c:url value="/resources/images/Michal.jpg" />" alt="banner" style="width:200px;height:200px">
                <h3>Michał Górski
                    <small>Developer</small>
                </h3>
                <p>Hello World</p>
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