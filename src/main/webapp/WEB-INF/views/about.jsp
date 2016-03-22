<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
		<title> Cyber Cafe - o nas</title>
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
							<a style="padding-top: 0"class="navbar-brand " href="<c:url value="/home" /> ">
								<img class="img-responsive" src="<c:url value="/resources/images/logo.png" />"/>
							</a>
						</div>
						
						<div class="collapse navbar-collapse" id="mynavbar-content">
							<ul class="nav navbar-nav">
								<li class="active"><a href="<c:url value="/about/" /> ">O nas</a></li>
								<li><a href="<c:url value="/contact/" /> ">Kontakt</a></li>
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
                <a href="https://www.facebook.com/marcin.hallman?fref=nf" class="btn btn-info" role="button">Facebook</a>
                <a href="https://github.com/Strugacki" class="btn btn-info" role="button">Github</a>
                <p></p>
            </div>
            <div class="col-lg-6 col-sm-6 text-center">
                <img class="img-circle  img-center" src="<c:url value="/resources/images/Adam.jpg" />" alt="banner" style="width:200px;height:200px">
                <h3>Adam Chlebba
                    <small>Developer</small>
                </h3>
                <p>PC Master Race</p>
                <a href="https://www.facebook.com/adam.chlebba" class="btn btn-info" role="button">Facebook</a>
                <a href="https://github.com/AChlebba" class="btn btn-info" role="button">Github</a>
                <p></p>
            </div>
            <div class="col-lg-6 col-sm-6 text-center">
                 <img class="img-circle  img-center" src="<c:url value="/resources/images/Slawek.jpg" />" alt="banner" style="width:200px;height:200px">
                <h3>Sławek Rzeppa
                    <small>Developer</small>
                </h3>
                <p>Coooooooooooo</p>
                <a href="https://www.facebook.com/rslawek5" class="btn btn-info" role="button">Facebook</a>
                <a href="https://github.com/srzeppa" class="btn btn-info" role="button">Github</a>
                <p></p>
            </div>
            <div class="col-lg-6 col-sm-6 text-center">
                <img class="img-circle  img-center" src="<c:url value="/resources/images/Michal.jpg" />" alt="banner" style="width:200px;height:200px">
                <h3>Michał Górski
                    <small>Developer</small>
                </h3>
                <p>Hello World</p>
                <a href="https://www.facebook.com/dajminazwe?fref=ufi" class="btn btn-info" role="button">Facebook</a>
                <a href="https://github.com/DajMiNazwe" class="btn btn-info" role="button">Github</a>
                <p></p>
            </div>
        </div>
		</div>
		
		<jsp:include page="templates/footer.jsp"></jsp:include>	
		<script src="<c:url value="/resources/js/jquery.js" />" ></script>
		<script src="<c:url value="/resources/js/bootstrap.js" />" ></script>
	</body>
</html>