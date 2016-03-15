<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<PUBLIC! html>
	<head>
		<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />">
		<link rel="stylesheet" href="<c:url value="/resources/css/datepicker.css" />">
		<title> Cyber Cafe - dodawanie wypożyczenia</title>
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
			<h2 class="text-center">Dodaj wypożyczenie</h2>
		</div>
		<div class="col-lg-8 col-lg-push-2 col-md-8 col-md-push-2 col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading-dark text-center">
				
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-5 col-md-5 col-sm-10">
						    <select class="form-control customers">
						    	<option value="null">-- Wybierz klienta --</option>
						    	<c:forEach items="${customers}" var="customer">
						    		<option value="<c:out value="${customer.idUser}" />"><c:out value="${customer.firstName}"></c:out> '<c:out value="${customer.nickname}"></c:out>' <c:out value="${customer.lastName}"></c:out></option>
						    	</c:forEach>
						    </select>
				    	</div>
					</div>
					<br>
					<div class="row">
						<div class="col-lg-5 col-md-5 col-sm-10">
							<select class="form-control terminals">
								<option value="null">-- Wybierz terminal --</option>
						    	<c:forEach items="${terminals}" var="terminal">
						    		<option value="<c:out value="${terminal.idTerminal}" />"><c:out value="${terminal.type}"></c:out></option>
						    	</c:forEach>
					   		</select>
					   	</div>
					</div>
				</div>
				<div class="panel-footer">
					<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#checkTerm" id="checkTermModalButton" disabled>Sprawdź termin</button>
				</div>
			</div>
		</div>
			<!-- Modal -->
		  <div class="modal fade" id="checkTerm" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Sprawdzanie terminu rezerwacji</h4>
		        </div>
		        <div class="modal-body">
		        	<form:form modelAttribute="newRent" class="form-horizontal" accept-charset="UTF-8">
		        		<div class="row">
							<div class="form-group col-lg-12 col-md-12 col-sm-12">
								<label class="control-label col-lg-3 col-md-3 col-sm-3" for="userDetails">Klient: </label>
								<div class="col-lg-8 col-md-8 col-sm-8">
									<div class="form-control col-lg-8 col-md-8 col-sm-8" id="userDetails"></div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-lg-12 col-md-12 col-sm-12">
								<label class="control-label col-lg-3 col-md-3 col-sm-3" for="terminalType">Terminal: </label>
								<div class="col-lg-8 col-md-8 col-sm-8">
									<div class="form-control col-lg-8 col-md-8 col-sm-8" id="terminalType"></div>
								</div>
							</div>
						</div>
		        		<form:input  path="terminal" type="text" required="reguired" class="terminal" hidden="hidden"/>
		        		<form:input  path="customer" type="text" required="reguired" class="customer" hidden="hidden"/>
				        <form:input id="type" path="employee" type="text" required="reguired" value="${idEmployee}" hidden="hidden"/>
					   	<div class="row">
							<div class="form-group col-lg-12 col-md-12 col-sm-12">
								<label class="control-label col-lg-3 col-md-3 col-sm-3" for="rentDate">Data: </label>
								<div class="col-lg-8 col-md-8 col-sm-8">
									<div class="input-group date" data-provide="datepicker">
					 					<form:input type="text" path="date" class="form-control" id="rentDate" />
								 		<div class="input-group-addon">
								    		<span class="glyphicon glyphicon-calendar"></span>
										</div>
					   				</div>
								</div>
							</div>
						</div>
					   
					   <br>
					   <div class="row text-center">
					   		<div class="form-label">
					     		<a href="<c:url value="/rent/search" />" class="btn btn-success btn-sm" id="search">Sprawdź</a>
					   		</div>
					   </div>
					   <div class="results">
					   	<ul id="radioHoursList">
					   		
					   	</ul>
					   </div>
					   
					   <form:input type="text" hidden="hidden" path="timeStart" id="timeStart" />
					   
					   	<div class="row">
							<div class="form-group col-lg-12 col-md-12 col-sm-12">
								<label class="control-label col-lg-3 col-md-3 col-sm-3" for="hours">Ilość godzin: </label>
								<div class="col-lg-8 col-md-8 col-sm-8">
									<form:input type="text" path="hours" class="form-control" id="hours" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-lg-12 col-md-12 col-sm-12">
								<label class="control-label col-lg-3 col-md-3 col-sm-3" for="price">Cena: </label>
								<div class="col-lg-8 col-md-8 col-sm-8">
									<form:input type="text" path="price" class="form-control" id="price" />
								</div>
							</div>
						</div>
						<div class="row text-center">
							<div class="form-actions col-lg-12 col-md-12 col-sm-12">
								<input type="submit" value="Dodaj" class="btn btn-primary btn-sm"/> albo <a
								href="<c:url value='/' />">wróć</a>
							</div>
						</div>
					</form:form>
			</div>
		        <div class="modal-footer">
		          <button type="button" class="btn btn-danger" data-dismiss="modal">Zamknij</button>
		        </div>
		      </div>
		    </div>
		  </div>	
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
		<script src="<c:url value="/resources/js/locales.js" />" ></script>
		<script src="<c:url value="/resources/js/moment.js" />" ></script>
		<script src="<c:url value="/resources/js/collapse.js" />" ></script>
		<script src="<c:url value="/resources/js/transition.js" />" ></script>
		<script src="<c:url value="/resources/js/bootstrap.js" />" ></script>
		<script src="<c:url value="/resources/js/bootstrap-datepicker.js" />" ></script>
		<script src="<c:url value="/resources/js/datepickerpl.min.js" />" ></script>
		<script>
		$(document).ready(function(){
		        $("#myModal").modal();
		    });
		</script>
		<script type="text/javascript">
			$(function(){
				$('select.terminals').change(function(){
					var idTerminal = $(this).val();
					var terminalDetails = $('select.terminals option:selected').text();
					$('.terminal').val(idTerminal);
					$('div#terminalType').text(terminalDetails);
				});
				$('select.customers').change(function(){
					var idCustomer = $(this).val();
					var customerDetails = $('select.customers option:selected').text();
					$('.customer').val(idCustomer);
					$('div#userDetails').text(customerDetails);
				});
				
				$.fn.datepicker.defaults.language = 'pl';
				$('.datepicker').datepicker({});
				
				$('a#search').on('click',function(e){
					e.preventDefault();
					var idTerminal = $('input.terminal').val();
					var date = $('input#rentDate').val();
					$.ajax({
						type: "GET",
						url: "${pageContext.request.contextPath}/rent/search",
						data: "idTerminal="+idTerminal+"&date="+date,
						success: function(data){
							console.log("response:",data);
							$('.radioHours').remove();
							$(data).insertAfter("#radioHoursList");
						},
						error: function(e){
							console.log("ERROR:",e);
							$('div.results').text(e)
						}
					})
				});
				
				$(document).change(function(){
						var terminalsValue = $('select.terminals').val();
						var customersValue = $('select.customers').val();
						console.log(terminalsValue);
						console.log(customersValue);
						
						if(terminalsValue === 'null' || customersValue === 'null'){
							$('button#checkTermModalButton').prop('disabled',true);
						}else{
							$('button#checkTermModalButton').removeAttr('disabled');
						}
				});
				
				$(document).on('click','div.results input[type=radio]',function(){
					var timeStart = $(this).val();
					$('#timeStart').val(timeStart);
				});
					
			});
		</script>		
	</body>
</html>