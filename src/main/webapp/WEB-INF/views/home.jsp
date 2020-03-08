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

<form action="/searchPrice" method="post"> 
<select name="city">
<!--  
  <option value="London">London</option>
   <option value="Detroit">Detroit</option>
    <option value="Cleveland">Cleveland</option>
     <option value="Cheyenne">Cheyenne</option>
     <option value="New York">New York</option>
     -->
  <c:forEach items="${cities }" var="city"> 
     <option>${city}</option>
     
    </c:forEach>
  
</select>
<input type="number" name="max">

 <button type="submit"> Search Lowest Price</button>

 <button formaction="/searchRating">Search Highest Rated</button>

</form>


<div>
<h4>Or Search for a Specific Hotel</h4>
<form method="post" action="/search"> 
<input name ="key" type="text">
<button type="submit">Search</button>
</form>

</div>


</div>

</body>
</html>