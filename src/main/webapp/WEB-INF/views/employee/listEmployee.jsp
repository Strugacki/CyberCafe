<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
		<title> Cyber Cafe - Pracownicy</title>
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
						<c:set var="user" value="${user}"/>
						<c:set var="role" value="${role}"/>
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
		
	<!-- Page Content -->
    <div class="container">
	    <div class="well lead">
			<h2 class="text-center">Lista pracowników</h2>
			<div class="row text-center">
		    	<c:if test="${role == 'ROLE_ADMIN'}">
					<a href="/cyberCafe/customer/add" class="btn btn-success text-center">Dodaj <span class="glyphicon glyphicon-plus-sign"></span></a>
				</c:if>
			</div>
		</div>
		<table class="table table-bordered" style="background-color: #F5F5F5">
 			<thead>
  				<tr>
  					<th class="text-center">#</th>
  					<th class="text-center">Imię</th>
  					<th class="text-center">Nazwisko</th>
  					<th class="text-center">Data urodzenia</th>
  					<th class="text-center">Nick</th>
  					<th class="txt-center">Aktywny</th>
  				</tr>
  			</thead>
  			<tbody>
	    <c:forEach items="${employees}" var="employee">	    
	    		<tr>
	    			<td></td>
					<td class="text-center">${employee.firstName}</td>
					<td class="text-center">${employee.lastName}</td>
					<td class="text-center">${employee.dateOfBirth}</td>
					<td class="text-center">${employee.nickname}</td>
					<c:choose>
						<c:when test="${employee.active == true }">
							<td class="text-center success">Tak</td>
						</c:when>
						<c:otherwise>
							<td class="text-center danger">Nie</td>
						</c:otherwise>
					</c:choose>
					<td class="text-center"> <a href="/cyberCafe/employee/edit?id=${employee.idUser}" class="btn btn-primary">Edytuj <span class="glyphicon glyphicon-wrench"></span></a> 
						<c:choose>
							<c:when test="${employee.active == true}">
								<a href="/cyberCafe/employee/deactive?id=${employee.idUser}" class="btn btn-warning">Dezaktywuj <span class="glyphicon glyphicon-ban-circle"></span></a>
							</c:when>
							<c:otherwise>
								<a href="/cyberCafe/employee/active?id=${employee.idUser}" class="btn btn-success">Aktywuj <span class="glyphicon glyphicon-ok-circle"></span></a>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
	    </c:forEach>
	    </tbody>
 	</table>    
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
	</body>
</html>