<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel ="stylesheet" href ="/MyStyle.css"/>
</head>
<body>
<div>


<h4>${hotel.hotelName }</h4>
<p>Located in beautiful downtown ${hotel.city }</p>
<p>At a cost of $${hotel.price } per night</p>
<c:if test="${hotel.rating != null }">
<p>Rating: ${hotel.rating }</p>
</c:if>
<p>Did You Enjoy Your Stay?</p>
<form action="/rateUp" ><button  type="${click}" name="id" value="${hotel.hotelId }">Yes</button></form>

<form action="/rateDown"><button type="${click}" name="id" value="${hotel.hotelId }" >No</button></form>
</div>

<a href="/">Back to Search</a>
</body>
</html>