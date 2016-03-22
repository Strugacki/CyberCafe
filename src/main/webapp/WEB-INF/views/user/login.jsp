<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html"; charset="UTF-8">
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
		<title> Cyber Cafe - logowanie</title>
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
							<a style="padding-top: 0"class="navbar-brand " href="/home">
								<img class="img-responsive" src="<c:url value="/resources/images/logo.png" />"/>
							</a>
						</div>
						
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
										<jsp:include page="../templates/admin.jsp"></jsp:include>
									</c:when>
									<c:when test="${role == 'ROLE_EMPLOYEE'}">
										<jsp:include page="../templates/employee.jsp"></jsp:include>
									</c:when>
									<c:when test="${role == 'ROLE_USER'}">
										<jsp:include page="../templates/user.jsp"></jsp:include>
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
	
	<div class="generic-container">
    	<div class="well lead">
    		<h2 class="text-center">Formularz logowania</h2>
    		<c:url var="loginUrl" value="/login" />
    	</div>
    	<c:if test="${param.login_error != null}">
    			<div class="alert alert-danger" role="alert">
 					 <p class="text-center"><strong>Uwaga!</strong> Nieprawidłowy login lub hasło!!</p>
				</div>
    	</c:if>
    	<c:if test="${param.logout != null}">
    			<div class="alert alert-success" role="alert">
 					 <p class="text-center"><strong>Do zobaczenia!</strong> Wylogowałeś się pomyślnie</p>
				</div>
    		</c:if>
			<form action="${loginUrl}" method="POST" class="form-horizontal">
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-3 col-md-3 col-sm-3" for="username">Login</label>
						<div class="col-lg-5 col-md-5 col-sm-5">
							<input id="username" name="username" type="text" class="form-control input-sm"/>
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
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<div class="row">
					<div class="form-actions col-lg-5 col-md-5 col-sm-5 pull-right">
						<input type="submit" name="submit" value="Zaloguj" class="btn btn-primary btn-sm"/> albo <a
						href="<c:url value='/home' />">wróć</a>
					</div>
				</div>
			</form>
		</div>
	<jsp:include page="../templates/footer.jsp"></jsp:include>
	<script src="<c:url value="/resources/js/jquery.js" />" ></script>
	<script src="<c:url value="/resources/js/bootstrap.js" />" ></script>		
	<body>
</html>