<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
		<title> Cyber Cafe - klienci</title>
	</head>

	<body>
	<div class="wrapper">
		<div class="header">
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
		</div>
		
	<!-- Page Content -->
    <div class="container">
	    <div class="well lead">
			<h2 class="text-center">Lista klientów</h2>
			<div class="row text-center">
		    	<c:if test="${role == 'ROLE_ADMIN' or role == 'ROLE_EMPLOYEE'}">
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
	    <c:forEach items="${customers}" var="customer">	    
	    		<tr>
	    			<td></td>
					<td class="text-center">${customer.firstName}</td>
					<td class="text-center">${customer.lastName}</td>
					<td class="text-center">${customer.dateOfBirth}</td>
					<td class="text-center">${customer.nickname}</td>
					<c:choose>
						<c:when test="${customer.active == true }">
							<td class="text-center success">Tak</td>
						</c:when>
						<c:otherwise>
							<td class="text-center danger">Nie</td>
						</c:otherwise>
					</c:choose>
					<td class="text-center"> <a href="/cyberCafe/customer/edit?id=${customer.idUser}" class="btn btn-primary">Edytuj <span class="glyphicon glyphicon-wrench"></span></a> 
						<c:choose>
							<c:when test="${customer.active == true}">
								<a href="/cyberCafe/customer/deactive?id=${customer.idUser}" class="btn btn-warning">Dezaktywuj <span class="glyphicon glyphicon-ban-circle"></span></a>
							</c:when>
							<c:otherwise>
								<a href="/cyberCafe/customer/active?id=${customer.idUser}" class="btn btn-success">Aktywuj <span class="glyphicon glyphicon-ok-circle"></span></a>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
	    </c:forEach>
	    </tbody>
 	</table>    
    </div>
    <jsp:include page="../templates/footer.jsp"></jsp:include>			
	<script src="<c:url value="/resources/js/jquery.js" />" ></script>
	<script src="<c:url value="/resources/js/bootstrap.js" />" ></script>	
	</div>
	</body>
</html>