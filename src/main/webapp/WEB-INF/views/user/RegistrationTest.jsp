<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html"; charset="UTF-8">
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
		<title> Cyber Cafe - rejestracja</title>
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
							<a class="navbar-brand " href="<c:url value="/" /> ">Cyber Cafe</a>
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
    		<h2 class="text-center">Formularz rejestracji</h2>
    	</div>
			<form:form modelAttribute="newUser" class="form-horizontal" id="registrationForm" enctype="multipart/form-data">
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="firstName">Imie</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
							<form:input id="firstName" path="firstName" type="text" required="reguired" class="form-control input-sm"/>
						</div>
						<form:errors path="firstName" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="lastName">Nazwisko</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
							<form:input id="lastName" path="lastName" type="text" required="reguired" class="form-control input-sm"/>
						</div>
						<form:errors path="lastName" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="email">Adres email</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
							<form:input id="email" path="email" type="text" required="reguired" class="form-control input-sm"/>
						</div>
						<form:errors path="email" class="alert alert-danger col-lg-4 col-md-4 col-sm-4" />
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="dateOfBirth">Data urodzenia</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
							<form:input id="dateOfBirth" path="dateOfBirth" type="text" required="reguired" class="form-control input-sm"/>
						</div>
						<form:errors path="dateOfBirth" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="nickname">Pseudonim</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
							<form:input id="nickname" path="nickname" type="text" required="reguired" class="form-control input-sm"/>
						</div>
						<form:errors path="nickname" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="login">Login</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
							<form:input id="login" path="login" type="text" required="reguired" class="form-control input-sm"/>
						</div>
						<form:errors path="login" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="password">Hasło</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
							<form:input id="password" path="password" type="password" required="reguired" class="form-control input-sm"/>
						</div>
						<form:errors path="password" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4" />
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="avatar">Avatar</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
							<form:input id="avatar" name="avatar" path="avatar" type="file" class="form-control input-sm"/>
						</div>
					</div>
				</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<div class="row">
					<div class="form-actions col-lg-8 col-md-8 col-sm-8 pull-right">
						<input type="submit" value="Rejestruj" class="btn btn-primary btn-sm"/> albo <a
						href="<c:url value='/' />">wróć</a>
					</div>
				</div>
			</form:form>
		</div>
		<c:set var="warning" value="${warn}"/>
		<c:if test="${!empty warning}">
			<div id="myModal" class="modal fade" role="dialog">
				  <div class="modal-dialog">
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal">&times;</button>
					        <h4 class="modal-title">Informacja</h4>
					      </div>
					      <div class="modal-body">
					        <p>${warn}</p>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">Zamknij</button>
					      </div>
					    </div>				
				  </div>
			</div>
		</c:if>
	
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
	<script>
		$(document).ready(function(){
		        $("#myModal").modal();
		    });
</script>		
	<body>
</html>