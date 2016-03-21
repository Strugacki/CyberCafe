<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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