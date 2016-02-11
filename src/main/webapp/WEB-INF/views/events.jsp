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
								<li><a href="<c:url value="/about/" /> ">O nas</a></li>
								<li><a href="<c:url value="/contact/" /> ">Kontakt</a></li>
								<li><a href="<c:url value="/pricing/" /> ">Cennik</a></li>
								<li><a href="<c:url value="/promotions/" /> ">Promocje</a></li>
								<li><a href="<c:url value="/devices/" /> ">Sprzęt</a></li>
								<li class="active"><a href="<c:url value="/events/" /> ">Turnieje</a></li>
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
    	<div class="jumbotron">

      
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Turnieje CS:GO</h2>
            </div>
            <div class="col-lg-6 col-sm-6 text-center">
               <img class="img" src="<c:url value="/resources/images/Puchar1.jpg" />" alt="banner" style="width:1024px;height:683px">
            </div>   
        </div>
      
      	
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Mistrzostwa CyberCafe
                    <small></small>
                </h1>
                <p>		Pierwszy raz w Gdańsku odbędzie się CyberCafe Extreme Masters – mistrzostwa świata gier komputerowych. 
               			W dniach 04 – 06.03.2016 należy zarezerwować sobie czas na to, 
               		 	aby przenieść się na tą fantastyczną imprezę, która udowadnia kolejny raz, 
              		 	że w Polsce też potrafimy przygotowywać wydarzenia e-sportowe na najwyższym poziomie!
                </p>
                <p>	Kolejny raz będziemy mogli na żywo oglądać zmagania najlepszych zawodników na świecie ze sceny  Counter Strike: Global Offensive! Drużyny będą walczyły o niezwykłe trofeum – puchar CyberCafe Extreme Masters!

					Co ciekawe, to pierwszy raz gdy, oficjalnie włączono CS: GO do tytułów finału CCEM. Wcześniej były to tylko turnieje towarzyszące, w których pamiętną chwilą dla fanów, było zwycięstwo Virtus Pro w 2014 roku.

					W Gdańsku będziemy świadkami finałów CS: GO i kolejnych tytułów, które zostaną potwierdzone wkrótce.

					Finał Mistrzostw Świata CyberCafe Extreme Masters to łączna pula nagród w wysokości 350 tys. dolarów! Z których 250 tys. zostanie rozdysponowane pomiędzy drużynami walczącymi w CS: GO, a 100 tys. dolarów trafi do teamów walczących w innych kategoriach.
                </p>
                
                
            </div>
        </div>
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