<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
		<title> Cyber Cafe - terminale</title>
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
								<li class="active"><a href="<c:url value="/device/list" /> ">Sprzęt</a></li>
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
						</div>
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
		</nav>
		
	<!-- Page Content -->
    <div class="container">
	    <div class="well lead">
			<h2 class="text-center">Nasz sprzęt</h2>
		</div>
		<div class="row">
			<div class="col-lg-9 col-md-7  col-sm-12">
				
			</div>
		</div>
		<table class="table table-bordered" style="background-color: #F5F5F5">
 			<thead>
  				<tr>
  					<th class="text-center">#</th>
  					<th class="text-center">Typ</th>
  					<th class="text-center">Opis</th>
  					<th class="text-center"> </th>
  				</tr>
  			</thead>
  			<tbody>
	    <c:forEach items="${terminals}" var="terminal">	    
	    	<c:choose>
	    		<c:when test="${role == 'ROLE_ADMIN' or role == 'ROLE_EMPLOYEE'}">
	    		<tr>
	    			<td>
					<td class="text-center">${terminal.type}</td>
					<td class="text-center">${terminal.description}</td>
					<td class="text-center"> <a href="/cyberCafe/device/update?id=${terminal.idTerminal}" class="btn btn-primary">Edytuj <span class="glyphicon glyphicon-wrench"></span></a> <a href="/cyberCafe/device/delete?id=${terminal.idTerminal}" class="btn btn-danger">Usuń <span class="glyphicon glyphicon-remove-circle"></span></a></td>
				</tr>
				</c:when>
				<c:otherwise>
					<c:if test="${terminal.available == true }">
						<tr>	
							<td>					
							<td class="text-center">${terminal.type}</td>
							<td class="text-center">${terminal.description}</td>
							<td class="text-center"><p class="alert alert-success"> Dostępny!! </p></td>
						</tr>
		    		</c:if>
				</c:otherwise>
	    	</c:choose>
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