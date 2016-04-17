<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
		<title> Cyber Cafe - newsy</title>
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
	    <h2 class="text-center">Lista News'ów</h2>
	    <div class="row text-center">
	    	<c:if test="${role == 'ROLE_ADMIN' or role == 'ROLE_EMPLOYEE'}">
				<a href="/cyberCafe/news/add" class="btn btn-success text-center">Dodaj <span class="glyphicon glyphicon-plus-sign"></span></a>
			</c:if>
		</div>
		</div>
		<table class="table table-bordered" style="background-color: #F5F5F5">
 			<thead>
  				<tr>
  					<th class="text-center">#</th>
  					<th class="text-center">Tytuł</th>
  					<th class="text-center">Data dodania</th>
  					<th class="text-center">Autor</th>
  					<th class="text-center"> </th>
  				</tr>
  			</thead>
  			<tbody>
	    <c:forEach items="${news}" var="single">	    
	    	<c:choose>
	    		<c:when test="${role == 'ROLE_ADMIN' or role == 'ROLE_EMPLOYEE'}">
	    		<tr>
	    			<td>
					<td class="text-center">${single.title}</td>
					<td class="text-center">${single.uploadDate}</td>
					<td class="text-center">${single.user.nickname}</td>
					<td class="text-center"> <a href="/cyberCafe/news/update?id=${single.idNews}" class="btn btn-primary">Edytuj <span class="glyphicon glyphicon-wrench"></span></a> <a href="/cyberCafe/news/delete?id=${single.idNews}" class="btn btn-danger">Usuń <span class="glyphicon glyphicon-remove-circle"></span></a></td>
				</tr>
				</c:when>
	    	</c:choose>
	    </c:forEach>
	    </tbody>
 	</table>    
    </div>
	<jsp:include page="../templates/footer.jsp"></jsp:include>	
	<script src="<c:url value="/resources/js/jquery.js" />" ></script>
	<script src="<c:url value="/resources/js/bootstrap.js" />" ></script>
	<script type="text/javascript">
		$(function(){
			var docHeight = $(window).height();
		    var footerHeight = $('footer').height();
		    var footerTop = $('footer').position().top + footerHeight;

		    if (footerTop < docHeight) {
		    	$('footer').css('margin-top', 10+ (docHeight - footerTop) + 'px');
		   }
		})
	</script>
	</body>
</html>