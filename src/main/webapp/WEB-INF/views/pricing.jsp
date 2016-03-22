<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
		<title> Cyber Cafe - cennik</title>
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
								<li class="active"><a href="<c:url value="/pricing/" /> ">Cennik</a></li>
								<li><a href="<c:url value="/promotions/" /> ">Promocje</a></li>
								<li><a href="<c:url value="/device/list" /> ">Sprzęt</a></li>
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
			
		<div class="container">
		
			<div class="well lead">
				<h2 class="text-center">Cennik</h2>
			</div>
			
			<div class="panel panel-default">
				<div class="panel-heading-dark">
					<h3><span class="glyphicon glyphicon-list-alt"></span> Normalne</h3>
				</div>
				<div class="panel-body">
					<ul>
						<li> 10zł/1h</li>
						<li> 15zł/2h</li>
						<li> 30zł/6h</li>
					</ul>
				</div>
				<div class="panel-footer">
					<span class="glyphicon glyphicon-warning-sign"></span><em> *Ceny obowiązują klientów bez zniżek</em>
				</div>
			</div>
			<div class="panel panel-default">	
				<div class="panel-heading-dark">
					<h3><span class="glyphicon glyphicon-list-alt"></span> Ulgowe</h3>
				</div>
				<div class="panel-body">
					<ul>
						<li> 6zł/1h</li>
						<li> 12zł/2h</li>
						<li> 20zł/6h</li>
					</ul>
				</div>
				<div class="panel-footer">
					<span class="glyphicon glyphicon-warning-sign"></span><em> *Ceny obowiązują uczniów, studentów za okazaniem legitymacji</em>
				</div>
			</div>
			<div class="panel panel-default">	
				<div class="panel-heading-dark">
					<h3><span class="glyphicon glyphicon-list-alt"></span> Grupowe</h3>
				</div>
				<div class="panel-body">
					<ul>
						<li> 20zł/1h</li>
						<li> 30zł/2h</li>
						<li> 55zł/6h</li>
						<br>
						<li> karnet treningowy 100zł/1 dzień</li>
						<li> karnet treningowy 150zł/1 dzień</li>
						<li> karnet treningowy 300zł/7 dni</li>
					</ul>
				</div>
				<div class="panel-footer">
					<span class="glyphicon glyphicon-warning-sign"></span><em> *Ceny obowiązują grupy osób powyżej 3 graczy oraz drużyny e-sportowe( cena ulega ododatkowej obniżce o 20%) </em>
				</div>
			</div>
		
		
		
		
		</div>
		<jsp:include page="templates/footer.jsp"></jsp:include>	
		<script src="<c:url value="/resources/js/jquery.js" />" ></script>
		<script src="<c:url value="/resources/js/bootstrap.js" />" ></script>
	</body>
</html>