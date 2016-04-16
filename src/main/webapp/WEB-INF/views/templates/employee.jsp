<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<li class="dropdown">
	<a class="dropdown-toggle" data-toggle="dropdown" href="#">Klient
	<span class="caret"></span></a>
	<ul class="dropdown-menu">
	  <li><a href="<c:url value="/customer/list" />" >Lista</a></li>
	  <li><a href="<c:url value="/customer/add" />" >Dodaj</a></li>
	</ul>
</li>
<li class="dropdown">
	<a class="dropdown-toggle" data-toggle="dropdown" href="#">Sprzęt
	<span class="caret"></span></a>
	<ul class="dropdown-menu">
	  <li><a href="<c:url value="/device/list" />" >Lista</a></li>
	  <li><a href="<c:url value="/device/add" />" >Dodaj</a></li>
	</ul>
</li>
<li class="dropdown">
	<a class="dropdown-toggle" data-toggle="dropdown" href="#">Newsy
	<span class="caret"></span></a>
	<ul class="dropdown-menu">
	  <li><a href="<c:url value="/news/list" />" >Lista</a></li>
	  <li><a href="<c:url value="/news/add" />" >Dodaj</a></li>
	</ul>
</li>
<li class="dropdown">
	<a class="dropdown-toggle" data-toggle="dropdown" href="#">Wypożyczenia
	<span class="caret"></span></a>
	<ul class="dropdown-menu">
	  <li><a href="<c:url value="/rent/list" />" >Lista</a></li>
	  <li><a href="<c:url value="/rent/add" />" >Dodaj</a></li>
	</ul>
</li>