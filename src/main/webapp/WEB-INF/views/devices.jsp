<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html"; charser="UTF-8">
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
		<link rel="stylesheet" href="css/styles.css" >
		<title> Cyber Cafe - devices</title>
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
							<li><a href="<c:url value="/home/about/" /> ">O nas</a></li>
							<li><a href="<c:url value="/home/contact/" /> ">Kontakt</a></li>
							<li><a href="<c:url value="/home/pricing/" /> ">Cennik</a></li>
							<li><a href="<c:url value="/home/promotions/" /> ">Promocje</a></li>
							<li class="active"><a href="<c:url value="/devices/" /> ">Sprzęt</a></li>
							<li><a href="<c:url value="/home/events/" /> ">Turnieje</a></li>
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
    	<div class="well lead">Formularz dodawania sprzętu</div>
			<form:form modelAttribute="newTerminal" class="form-horizontal">
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-3 col-md-3 col-sm-3" for="type">Typ</label>
						<div class="col-lg-5 col-md-5 col-sm-5">
							<form:input id="type" path="type" type="text" class="form-control input-sm"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-3 col-md-3 col-sm-3" for="available">Dostępność</label>
						<div class="col-lg-5 col-md-5 col-sm-5">
							<form:select id="available" path="available" class="form-control input-sm">
								<form:option value="TRUE">Tak</form:option>
								<form:option value="FALSE">Nie</form:option>
							</form:select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-actions col-lg-5 col-md-5 col-sm-5 pull-right">
						<input type="submit" value="Dodaj" class="btn btn-primary btn-sm"/> albo <a
						href="<c:url value='/home' />">wróć</a>
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