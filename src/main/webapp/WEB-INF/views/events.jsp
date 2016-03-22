<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
		<title> Cyber Cafe - turnieje</title>
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
								<li><a href="<c:url value="/about/" /> ">O nas</a></li>
								<li><a href="<c:url value="/contact/" /> ">Kontakt</a></li>
								<li><a href="<c:url value="/pricing/" /> ">Cennik</a></li>
								<li><a href="<c:url value="/promotions/" /> ">Promocje</a></li>
								<li><a href="<c:url value="/device/list" /> ">Sprzęt</a></li>
								<li class="active"><a href="<c:url value="/events/" /> ">Turnieje</a></li>
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
       
       <div class="container">
    	<div class="jumbotron">

      
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Turnieje League of Legends</h2>
            </div>
            <div class="col-lg-6 col-sm-6 text-center">
               <img class="img" src="<c:url value="/resources/images/Puchar2.png" />" alt="banner" style="width:1024px;height:683px">
            </div>   
        </div>
      
      	
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Wielki turniej LoL'a
                    <small></small>
                </h1>
                <p> 8 i 9 marca w CyberCafe, w Gdańsku, 
                	rozegrany zostanie wielki turniej 5vs5 League of Legends – MSI & Komputronik Gaming Days.
                	Jego organizatorami są MSI, producent laptopów i komponentów komputerowych, oraz sieć sklepów Komputronik.
                	Zapisy będą możliwe na miejscu od godziny 10:00. Na zwycięzców czekają atrakcyjne nagrody i moc turniejowych emocji,
                	którym będzie towarzyszyć puchar CyberCafe Extreme Masters 2016.
                </p>
                <p>	Tryb turnieju to klasyczne 5 vs5 na serwerze East. Sobotnie mecze startują o godzinie 11:00 
                – rozgrywane będą w trybie BO1. Zwycięski drużyny będą kontynuować rywalizację w niedzielę od godziny 12:00 
                – mecz o III miejsce oraz finał odbędą się w trybie BO3. Wielki finał przewidziano na godzinę 15:30.
				</p>
				<p>
				Podczas turnieju w CyberCafe na przybyłych fanów eSportu i elektronicznej rozrywki czekają obniżki 
				cen sprzętu komputerowego, stworzony specjalnie dla graczy, m.in. gamingowy laptop MSI GT70 2OC-1059XPL w  wyjątkowej
 				cenie 4999zł + GRATIS w postaci słuchawek SteelSeries Siberia v2 Black. Dodatkowo eksperci Komputronika pomogą w wyborze
 				najlepszego zestawu komputerowego przeznaczonego dla graczy.
				</p>
                
                
            </div>
        </div>
       </div>
      </div>
	<jsp:include page="templates/footer.jsp"></jsp:include>
	<script src="<c:url value="/resources/js/jquery.js" />" ></script>
	<script src="<c:url value="/resources/js/bootstrap.js" />" ></script>
	</body>
</html>