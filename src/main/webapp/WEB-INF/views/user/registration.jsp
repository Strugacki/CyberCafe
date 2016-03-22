<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
		<title> Cyber Cafe - rejestracja</title>
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
	
	<div class="generic-container">
    	<div class="well lead">
    		<h2 class="text-center">Formularz rejestracji</h2>
    	</div>
			<form class="form-horizontal" id="registrationForm" enctype="multipart/form-data" action="" method="post">
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="firstName">Imię</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newUser.firstName">
							<input id="firstName" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
						</spring:bind>
						</div>
						<form:errors path="newUser.firstName" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="lastName">Nazwisko</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newUser.lastName">
							<input id="lastName" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
						</spring:bind>
						</div>
						<form:errors path="newUser.lastName" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="email">Adres email</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newUser.email">
							<input id="email" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
						</spring:bind>
						</div>
						<form:errors path="newUser.email" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="dateOfBirth">Data urodzenia</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newUser.dateOfBirth">
							<input id="dateOfBirth" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
						</spring:bind>
						</div>
						<form:errors path="newUser.dateOfBirth" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4" />
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="nickname">Pseudonim</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
							<div class="input-group has-warning" id="checkNicknameDiv">
								<spring:bind path="newUser.nickname">
									<input id="nickname" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm" aria-decscribedBy="chechNickname"/>
								</spring:bind>
								<div class="input-group-addon" id="checkNickname"><span class="glyphicon glyphicon-warning-sign"></span></div>
							</div>
						</div>
						<form:errors path="newUser.nickname" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4" />
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="login">Login</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
							<div class="input-group has-warning" id="checkLoginDiv">
								<spring:bind path="newUser.login" >
									<input id="login" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm" aria-describedBy="checkLogin"/>
								</spring:bind>
								<div class="input-group-addon" id="checkLogin"><span class="glyphicon glyphicon-warning-sign"></span></div>
							</div>
						</div>
						<form:errors path="newUser.login" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="password">Hasło</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newUser.password">
							<input id="password" type="password" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
						</spring:bind>
						</div>
						<form:errors path="newUser.password" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="avatar">Avatar</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newUser.avatar">
							<input id="avatar" name="avatar" type="file" class="form-control input-sm"/>
						</spring:bind>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="city">Miasto</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newAddress.city">
							<input id="city" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
						</spring:bind>
						</div>
						<form:errors path="newAddress.city" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="postalCode">Kod pocztowy</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newAddress.postalCode">
							<input id="postalCode" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
						</spring:bind>
						</div>
						<form:errors path="newAddress.postalCode" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="street">Ulica</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newAddress.street">
							<input id="street" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
						</spring:bind>
						</div>
						<form:errors path="newAddress.street" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-lg-12 col-md-12 col-sm-12">
						<label class="control-label col-lg-4 col-md-4 col-sm-4" for="localNumber">Numer</label>
						<div class="col-lg-3 col-md-3 col-sm-3">
						<spring:bind path="newAddress.localNumber">
							<input id="localNumber" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
						</spring:bind>
						</div>
						<form:errors path="newAddress.localNumber" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
					</div>
				</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<div class="row">
					<div class="form-actions col-lg-8 col-md-8 col-sm-8 pull-right">
						<input type="submit" name="submit" value="Rejestruj" class="btn btn-primary btn-sm"/> albo <a
						href="<c:url value='/' />">wróć</a>
					</div>
				</div>
			</form>
		</div>
		<c:set var="warning" value="${warn}"/>
		<c:if test="${!empty warning}">
			<div id="myModal" class="modal fade" role="dialog">
				  <div class="modal-dialog">
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal">&times;</button>
					        <h4 class="modal-title">Informacja</h4>
					      </div>
					      <div class="modal-body">
					        <p>${warn}</p>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">Zamknij</button>
					      </div>
					    </div>				
				  </div>
			</div>
		</c:if>
	<jsp:include page="../templates/footer.jsp"></jsp:include>
	<script src="<c:url value="/resources/js/jquery.js" />" ></script>
	<script src="<c:url value="/resources/js/bootstrap.js" />" ></script>
	<script>
		$(document).ready(function(){
		        $("#myModal").modal();
		    });
		
		$("input#nickname").keyup(function(){
			var nickname = $(this).val();
			$.ajax({
				type: "GET",
				url: "${pageContext.request.contextPath}/user/checkNickname",
				data: "nickname="+nickname,
				success: function(data){
					var response = $.trim(data);
					if(data === 'yes' && nickname.length !== 0){
						$('div#checkNickname > span').removeClass("glyphicon-warning-sign").addClass("glyphicon-ok");
						$('div#checkNicknameDiv').removeClass('has-warning').addClass("has-success");
					}else{
						$('div#checkNickname > span').removeClass("glyphicon-ok").addClass("glyphicon-warning-sign");
						$('div#checkNicknameDiv').removeClass("has-success").addClass('has-warning');
					}
				},
				error: function(){
					console.log("ERROR");
				}
			})
		});
		
		$("input#login").keyup(function(){
			var login = $(this).val();
			$.ajax({
				type: "GET",
				url: "${pageContext.request.contextPath}/user/checkLogin",
				data: "login="+login,
				success: function(data){
					var response = $.trim(data);
					if(data === 'yes' && login.length !== 0){
						$('div#checkLogin > span').removeClass("glyphicon-warning-sign").addClass("glyphicon-ok");
						$('div#checkLoginDiv').removeClass('has-warning').addClass("has-success");
					}else{
						$('div#checkLogin > span').removeClass("glyphicon-ok").addClass("glyphicon-warning-sign");
						$('div#checkLoginDiv').removeClass("has-success").addClass('has-warning');
					}
				},
				error: function(){
					console.log("ERROR");
				}
			})
		});
		
		$("input[name='submit']").on('click',function(e){
			if($('div#checkLoginDiv').hasClass('has-warning') || $('div#checkNicknameDiv').hasClass('has-warning')){
			e.preventDefault();
			
			}
		});
</script>		
	<body>
</html>