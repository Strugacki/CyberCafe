<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<li class="dropdown">
	<a class="dropdown-toggle" data-toggle="dropdown" href="#">Wypożyczenia
	<span class="caret"></span></a>
	<ul class="dropdown-menu">
	  <li><a href="<c:url value="/rent/list" />" >Lista</a></li>
	</ul>
</li>