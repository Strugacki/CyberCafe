<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html"; charser="UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >
		<link rel="stylesheet" href="css/styles.css" >
		<title> Cyber Cafe - registration</title>
	</head>

	<body>
	<div class="navbar navbar-default">
		<div class="row">
			<div class="col-lg-8 col-md-8 col-sm-12">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mynavbar-content">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="home">Cyber Cafe</a>
					</div>
					
					<div class="collapse navbar-collapse" id="mynavbar-content">
						<ul class="nav navbar-nav">
							<li><a href="#">O nas</a></li>
							<li><a href="#">Kontakt</a></li>
							<li><a href="#">Cennik</a></li>
							<li><a href="#">Promocje</a></li>
							<li><a href="#">Sprzęt</a></li>
							<li><a href="#">Turnieje</a></li>
						</ul>
					</div>
				</div>
				<form class="col-lg-4 col-md-4 col-sm-6">
				
				<div class="row">
				<div class="form-group">
					<input class="form-control input-sm" type="text" name="username" placeholder="Login"/>
				</div>
				<div class="form-group">
					<input class="form-control input-sm" type="text" name="password" placeholder="Hasło" />
				</div>
				</div>
				<div class="row">
				<a class="btn btn-primary pull-right" href="<c:url value='/user/login' />" >Zaloguj</a>
				
				
				<a class="btn btn-info pull-right" href="<c:url value='/user/registration' />" >Rejestracja</a>
				</div>
				</form>
		</div>
	</div>
	
	<div class="generic-container">
    	<div class="well lead">User Registration Form</div>
			<form:form modelAttribute="newUser" class="form-horizontal">
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-3 col-md-3 col-sm-3" for="firstName">Imie</label>
						<div class="col-lg-5 col-md-5 col-sm-5">
							<form:input id="firstName" path="firstName" type="text" class="form-control input-sm"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-3 col-md-3 col-sm-3" for="lastName">Nazwisko</label>
						<div class="col-lg-5 col-md-5 col-sm-5">
							<form:input id="lastName" path="lastName" type="text" class="form-control input-sm"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-3 col-md-3 col-sm-3" for="email">Adres email</label>
						<div class="col-lg-5 col-md-5 col-sm-5">
							<form:input id="email" path="email" type="text" class="form-control input-sm"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-3 col-md-3 col-sm-3 col-sm-3" for="dateOfBirth">Data urodzenia</label>
						<div class="col-lg-5 col-md-5 col-sm-5">
							<form:input id="dateOfBirth" path="dateOfBirth" type="text" class="form-control input-sm"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-3 col-md-3 col-sm-3" for="nickname">Pseudonim</label>
						<div class="col-lg-5 col-md-5 col-sm-5">
							<form:input id="nickname" path="nickname" type="text" class="form-control input-sm"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-3 col-md-3 col-sm-3" for="login">Login</label>
						<div class="col-lg-5 col-md-5 col-sm-5">
							<form:input id="login" path="login" type="text" class="form-control input-sm"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-3 col-md-3 col-sm-3" for="password">Hasło</label>
						<div class="col-lg-5 col-md-5 col-sm-5">
							<form:input id="password" path="password" type="password" class="form-control input-sm"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-3 col-md-3 col-sm-3" for="avatar">Avatar</label>
						<div class="col-lg-5 col-md-5 col-sm-5">
							<form:input id="avatar" path="avatar" type="file" class="form-control input-sm"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-actions col-lg-5 col-md-5 col-sm-5 pull-right">
						<input type="submit" value="Rejestruj" class="btn btn-primary btn-sm"/> or <a
						href="<c:url value='/home' />">Cancel</a>
					</div>
				</div>
			</form:form>
		</div>
		
	<body>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" 
			integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" 
			crossorigin="anonymous">
	</script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</html>