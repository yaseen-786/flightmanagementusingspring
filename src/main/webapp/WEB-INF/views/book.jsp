<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>BookTicket</title>
</head>
<body>
<center>
<h1>Book Ticket</h1><br>
</center>

<!-- <table class="table table-dark"> -->
<!--   <thead> -->
<!--     <tr> -->
<!--       <th scope="col">Id</th> -->
<!--       <th scope="col">Name</th> -->
<!--       <th scope="col">Username</th> -->
<!--       <th scope="col">Password</th> -->
<!--       <th scope="col">Email</th> -->
<!--       <th scope="col">Phone</th> -->
<!--     </tr> -->
<!--   </thead> -->
<!--   <tbody> -->
<%--   <c:forEach items="${customer}" var="c"> --%>
<!--     <tr> -->
<%--       <th scope="row">${c.custid}</th> --%>
<%--       <td>${c.name}</td> --%>
<%--       <td>${c.username}</td> --%>
<%--       <td>${c.password}</td> --%>
<%--       <td>${c.email}</td> --%>
<%--       <td>${c.phone}</td> --%>
      
      
      
<!--     </tr> -->
<%--     </c:forEach> --%>
    
<!--   </tbody> -->
<!-- </table> -->
<form action="bookingdetails" method="post">
<center>
<h2>
<label for="source" >Choose a Source Location:</label>
</h2>
<select name="source" id="source" style="width: 50px !important; min-width: 150px; max-width: 250px; height: 50px">
<c:forEach items="${source}" var="s">
  <option value="${s}" >${s}</option>
  </c:forEach>
</select>
<h2>
<label for="destination" >Choose a Destination Location:</label>
</h2>
<select name="destination" id="destination"  style="width: 50px !important; min-width: 150px; max-width: 250px; height: 50px">
<c:forEach items="${destination}" var="d">
  <option value="${d}" >${d}</option>
  </c:forEach>
</select>
<h2>
<label for="source" >Choose a Number of passenger:</label>
</h2>
<select name="capacity" id="passenger" style="width: 50px !important; min-width: 150px; max-width: 250px; height: 50px">
<c:forEach begin="0" end="10" var="i">
  <option value="${i}" >${i}</option>
  </c:forEach>
</select><br><br>
<button type="submit" class="btn btn-success">Show Flights</button>
</center>
</form>
 <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  

</body>
</html>