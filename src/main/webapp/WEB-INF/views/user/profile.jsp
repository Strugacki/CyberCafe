<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
		<title> Cyber Cafe - profil</title>
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
	
    	<c:choose>
    		<c:when test="${!empty edit}" >
    			<div class="generic-container">
			    	<div class="well lead">
			    		<h2 class="text-center">Formularz edycji</h2>
			    	</div>
			    	<div class="row">
    				<div class="col-lg-6 col-lg-push-3 col-md-8 col-md-push-2 col-sm-12">
    					<div class="panel panel-default">
	    					<form class="form-horizontal" id="registrationForm" enctype="multipart/form-data" action="" method="post">	
			    				<div class="panel-heading-dark text-center">
				    				<div class="row">
										<div class="form-group col-lg-12 col-md-12 col-sm-12">
											<label class="control-label col-lg-4 col-md-4 col-sm-4" for="avatar">Avatar</label>
											<a class="btn btn-primary btn-sm avatarChangeBtn">Zmień avatar</a>
											<div class="col-lg-3 col-md-3 col-sm-3 avatar">
												<c:if test="${!empty userImage}">
													<img  class="img-rounded" src="data:image/jpeg;base64,${userImage}" width="150" height="150" />
												</c:if>
												<spring:bind path="userProfil.avatar">
													<input id="avatar" type="file" name="${status.expression}" value="${status.expression}" />
												</spring:bind>
											</div>
										</div>
									</div>
			    					<div class="row">
										<div class="form-group col-lg-12 col-md-12 col-sm-12">
											<label class="control-label col-lg-4 col-md-4 col-sm-4" for="nickname">Pseudonim</label>
											<div class="col-lg-3 col-md-3 col-sm-3">
											<spring:bind path="userProfil.nickname">
												<input id="nickname" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
											</spring:bind>
											<form:errors path="userProfil.nickname" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4" />
											</div>
										</div>
									</div>
			    				</div>
			    				<div class="panel-body">
			    					<div class="row">
										<div class="form-group col-lg-12 col-md-12 col-sm-12">
											<label class="control-label col-lg-4 col-md-4 col-sm-4" for="firstName">Imie</label>
											<div class="col-lg-3 col-md-3 col-sm-3">
											<spring:bind path="userProfil.firstName">
												<input id="firstName" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
											</spring:bind>
											</div>
											<form:errors path="userProfil.firstName" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
										</div>
									</div>
			    					<div class="row">
										<div class="form-group col-lg-12 col-md-12 col-sm-12">
											<label class="control-label col-lg-4 col-md-4 col-sm-4" for="lastName">Nazwisko</label>
											<div class="col-lg-3 col-md-3 col-sm-3">
											<spring:bind path="userProfil.lastName">
												<input id="lastName" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
											</spring:bind>
											</div>
											<form:errors path="userProfil.lastName" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
										</div>
									</div>
									<div class="row">
										<div class="form-group col-lg-12 col-md-12 col-sm-12">
											<label class="control-label col-lg-4 col-md-4 col-sm-4" for="dateOfBirth">Data urodzenia</label>
											<div class="col-lg-3 col-md-3 col-sm-3">
											<spring:bind path="userProfil.dateOfBirth">
												<input id="dateOfBirth" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
											</spring:bind>
											</div>
											<form:errors path="userProfil.dateOfBirth" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4" />
										</div>
									</div>
									<div class="row">
										<div class="form-group col-lg-12 col-md-12 col-sm-12">
											<label class="control-label col-lg-4 col-md-4 col-sm-4" for="email">Adres email</label>
											<div class="col-lg-3 col-md-3 col-sm-3">
											<spring:bind path="userProfil.email">
												<input id="email" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
											</spring:bind>
											</div>
											<form:errors path="userProfil.email" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
										</div>
									</div>
									<a class="btn btn-info btn-sm" id="moreDetailss">Pokaż więcej <span class="glyphicon glyphicon-chevron-down"></span></a>
			    					<div class="details-slideDown">
			    						<hr>
			    						<div class="row">
											<div class="form-group col-lg-12 col-md-12 col-sm-12">
												<label class="control-label col-lg-4 col-md-4 col-sm-4" for="login">Login</label>
												<div class="col-lg-3 col-md-3 col-sm-3">
												<spring:bind path="userProfil.login" >
													<input id="login" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
												</spring:bind>
												</div>
												<form:errors path="userProfil.login" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
											</div>
										</div>
			    						<div class="row">
											<div class="form-group col-lg-12 col-md-12 col-sm-12">
												<label class="control-label col-lg-4 col-md-4 col-sm-4" for="password">Hasło</label>
												<div class="col-lg-3 col-md-3 col-sm-3">
			    								<spring:bind path="userProfil.password">
													<input id="password" type="password" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
												</spring:bind>
												</div>
			    								<form:errors path="userProfil.password" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
			    							</div>
			    						</div>
			    						<div class="row">
											<div class="form-group col-lg-12 col-md-12 col-sm-12">
												<label class="control-label col-lg-4 col-md-4 col-sm-4" for="city">Miasto</label>
												<div class="col-lg-3 col-md-3 col-sm-3">
												<spring:bind path="userAddress.city">
													<input id="city" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
												</spring:bind>
												</div>
												<form:errors path="userAddress.city" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-lg-12 col-md-12 col-sm-12">
												<label class="control-label col-lg-4 col-md-4 col-sm-4" for="postalCode">Kod pocztowy</label>
												<div class="col-lg-3 col-md-3 col-sm-3">
												<spring:bind path="userAddress.postalCode">
													<input id="postalCode" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
												</spring:bind>
												</div>
												<form:errors path="userAddress.postalCode" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-lg-12 col-md-12 col-sm-12">
												<label class="control-label col-lg-4 col-md-4 col-sm-4" for="street">Ulica</label>
												<div class="col-lg-3 col-md-3 col-sm-3">
												<spring:bind path="userAddress.street">
													<input id="street" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
												</spring:bind>
												</div>
												<form:errors path="userAddress.street" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
											</div>
										</div>
										<div class="row">
											<div class="form-group col-lg-12 col-md-12 col-sm-12">
												<label class="control-label col-lg-4 col-md-4 col-sm-4" for="localNumber">Numer</label>
												<div class="col-lg-3 col-md-3 col-sm-3">
												<spring:bind path="userAddress.localNumber">
													<input id="localNumber" type="text" name="${status.expression}" value="${status.value}" class="form-control input-sm"/>
												</spring:bind>
												</div>
												<form:errors path="userAddress.localNumber" cssClass="alert alert-danger col-lg-4 col-md-4 col-sm-4"/>
											</div>
										</div>
			    					</div>
			    				</div>
			    				<div class="panel-footer">
			    					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
										<div class="row">
											<div class="form-actions col-lg-8 col-md-8 col-sm-8 pull-right">
												<input type="submit" value="Aktualizuj profil" class="btn btn-primary btn-sm"/> albo <a
												href="<c:url value='/user/profil' />">wróć</a>
											</div>
										</div>
			    				</div>
			    			</form>
			    		</div>
		    		</div>
				</div>
				</div>
	    	</c:when>
	    	<c:otherwise>
    			<c:set var="userDetails" value="${currentUser}" />
    			<c:set var="userAddressDetails" value="${currentAddress}" />
    			<div class="row">
    				<div class="col-lg-6 col-lg-push-3 col-md-8 col-md-push-2 col-sm-12">
    					<div class="panel panel-default">
		    				<div class="panel-heading-dark text-center">
		    					<c:if test="${!empty userImage}">
											<img  class="img-rounded" src="data:image/jpeg;base64,${userImage}" width="150" height="150" />
								</c:if>
								<p><c:out value="${userDetails.nickname}"></c:out></p>
		    				</div>
		    				<div class="panel-body">
		    					<p class="small text-center">Podstawowe informacje</p>
		    					<hr>
		    					<p><label class="control-label">Imię:</label> <c:out value="${userDetails.firstName}"></c:out></p>
			    				<p><label class="control-label">Nazwisko:</label> <c:out value="${userDetails.lastName}"></c:out></p>
			    				<p><label class="control-label">Data urodzenia:</label> <c:out value="${userDetails.dateOfBirth}"></c:out></p>
			    				<p><label class="control-label">Adres email:</label> <c:out value="${userDetails.email}"></c:out></p>
		    					<button class="btn btn-info btn-sm" id="moreDetails">Pokaż więcej <span class="glyphicon glyphicon-chevron-down"></span></button>
		    					<div class="details-fadeIn">
		    						<hr>
		    						<p><label class="control-label">Login:</label> <c:out value="${userDetails.login}"></c:out></p>
		    						<div class="form-inline">
		    							<div class="form-group">
		    								<label class="form-control-label" for="password">Hasło:</label><input id="password" type="password" class="form-control input-sm" value="<c:out value="${userDetails.password}"></c:out>" disabled/>
		    								<div class="checkbox">
		    									<label><input type="checkbox" id="showPassword" /> Pokaż</label>
		    								</div>
		    							</div>
		    						</div>
		    						<p><label class="control-label">Miejscowość:</label> <c:out value="${userAddressDetails.city}"></c:out> <c:out value="${userAddressDetails.postalCode}"></c:out></p>
		    						<p><label class="control-label">Ulica:</label> <c:out value="${userAddressDetails.street}"></c:out> <c:out value="${userAddressDetails.localNumber}"></c:out></p>
		    					</div>
		    				</div>
		    				<div class="panel-footer">
		    					<a href="<c:url value="/user/profile/edit" />" class="btn btn-primary text-center">Edytuj <span class="glyphicon glyphicon-wrench"></span></a>
		    				</div>
    					</div>
    				</div>
    			</div>
    		</c:otherwise>
    	</c:choose>
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
	<script type="text/javascript">
		$(function(){
			$('input#avatar').css("display", "none");
			$("div.details-fadeIn").hide();
			$('#moreDetails').on('click',function(){
				$('div.details-fadeIn').slideToggle('slow');
				if($('#moreDetails > span').attr('class') == 'glyphicon glyphicon-chevron-down'){
					$('#moreDetails > span').attr('class','glyphicon glyphicon-chevron-up')
				}else{
					$('#moreDetails > span').attr('class','glyphicon glyphicon-chevron-down')
				}
			});
			$('#showPassword').change(function(){
				if($(this).is(":checked")){
					$('#password').attr('type','text')
				}else{
					$('#password').attr('type','password');
				}
			})
			
			$("div.details-slideDown").hide();
			$('a#moreDetailss').on('click',function(){
				$('div.details-slideDown').slideToggle('slow');
				if($('#moreDetailss > span').attr('class') == 'glyphicon glyphicon-chevron-down'){
					$('#moreDetailss > span').attr('class','glyphicon glyphicon-chevron-up')
				}else{
					$('#moreDetailss > span').attr('class','glyphicon glyphicon-chevron-down')
				}
			});
			
			$('a.avatarChangeBtn').on('click',function(){
					$('input#avatar').fadeToggle();
			});
			var docHeight = $(window).height();
		    var footerHeight = $('footer').height();
		    var footerTop = $('footer').position().top + footerHeight;

		    if (footerTop < docHeight) {
		    	$('footer').css('margin-top', 10+ (docHeight - footerTop) + 'px');
		   }
		})
	</script>	
	<body>
</html>