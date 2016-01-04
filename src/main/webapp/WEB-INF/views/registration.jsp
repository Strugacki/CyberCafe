<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html"; charser="UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >
		<link rel="stylesheet" href="css/styles.css" >
		<title> Cyber Cafe </title>
	</head>

	<body>
	<div class="navbar navbar-default">
		<div class="row">
			<div class="col-lg-10">
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
				<form class="col-lg-2" action="">
				<input class="form-control input-sm" type="text" name="username" placeholder="Login"/>
				<input class="form-control input-sm" type="text" name="password" placeholder="Hasło" />
				<a class="btn btn-primary" href="login">Zaloguj</button>
				<a class="btn btn-info" href="../user/registration">Rejestracja</a>
				</form>
		</div>
	</div>
		
	<form:form modelAttribute="newUser" class="form-horizontal">
	
	</form:form>
		
		
	<body>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" 
			integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" 
			crossorigin="anonymous">
	</script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
</html>