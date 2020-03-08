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

<table class="table">
  <tr>
    <th>Hotel Name</th>
    <th>City</th>
    <th>Price Per Night</th>
    
    <th>Likes</th>
  </tr>
  
  <c:forEach items="${hotels}" var="hotel">
 
  <tr>
  <c:choose> <c:when test="${maxPrice>0 }">
   <c:if test ="${hotel.price < maxPrice}">
    <td><a href="">${hotel.hotelName }</a></td>
    <td>${hotel.city }</td>
    <td>$${hotel.price}</td>
    <td>${hotel.rating }</td>
    <!-- use Java field Names -->
    </c:if>
    </c:when>
  	<c:otherwise> 
  	 <td><a href="/${hotel.hotelId }">${hotel.hotelName }</a></td>
  	  <td>${hotel.city }</td>
    <td>$${hotel.price}</td>
     <td>${hotel.rating }</td>
  	</c:otherwise>
    </c:choose>
  </tr>
  
  
  </c:forEach>
</table>



</body>
</html>