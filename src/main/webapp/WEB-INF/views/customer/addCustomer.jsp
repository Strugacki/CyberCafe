<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html"; charset="UTF-8">
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
		<title> Cyber Cafe - dodawanie klienta</title>
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
    		<h2 class="text-center">Formularz dodawania klienta</h2>
    	</div>
			<form class="form-horizontal" id="registrationForm" enctype="multipart/form-data" action="" method="post">
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="firstName">Imie</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newUser.firstName">
							<input id="firstName" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
						</spring:bind>
						</div>
						<form:errors path="newUser.firstName" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="lastName">Nazwisko</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newUser.lastName">
							<input id="lastName" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
						</spring:bind>
						</div>
						<form:errors path="newUser.lastName" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="email">Adres email</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newUser.email">
							<input id="email" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
						</spring:bind>
						</div>
						<form:errors path="newUser.email" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="active">Aktywny</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
							<form:select id="active" class="form-control input-sm" path="newUser.active">
								<form:option value="true">Tak</form:option>
								<form:option value="false">Nie</form:option>
							</form:select>
						</div>
						<form:errors path="newUser.active" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="dateOfBirth">Data urodzenia</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newUser.dateOfBirth">
							<input id="dateOfBirth" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
						</spring:bind>
						</div>
						<form:errors path="newUser.dateOfBirth" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4" />
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="nickname">Pseudonim</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newUser.nickname">
							<input id="nickname" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
						</spring:bind>
						<form:errors path="newUser.nickname" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="login">Login</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newUser.login" >
							<input id="login" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
						</spring:bind>
						</div>
						<form:errors path="newUser.login" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="password">Hasło</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newUser.password">
							<input id="password" type="password" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
						</spring:bind>
						</div>
						<form:errors path="newUser.password" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="avatar">Avatar</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newUser.avatar">
							<input id="avatar" name="avatar" type="file" class="form-control input-sm"/>
						</spring:bind>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="city">Miasto</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newAddress.city">
							<input id="city" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
						</spring:bind>
						</div>
						<form:errors path="newAddress.city" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="postalCode">Kod pocztowy</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newAddress.postalCode">
							<input id="postalCode" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
						</spring:bind>
						</div>
						<form:errors path="newAddress.postalCode" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="street">Ulica</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newAddress.street">
							<input id="street" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
						</spring:bind>
						</div>
						<form:errors path="newAddress.street" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="localNumber">Numer</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newAddress.localNumber">
							<input id="localNumber" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
						</spring:bind>
						</div>
						<form:errors path="newAddress.localNumber" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<div class="row">
					<div class="form-actions col-lg-8 col-md-8 col-sm-8 pull-right">
						<input type="submit" value="Dodaj" class="btn btn-primary btn-sm"/> albo <a
						href="<c:url value='/' />">wróć</a>
					</div>
				</div>
			</form>
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