<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Admin Menu</title>
  </head>
<body>
	<center>
	<h1>Welcome to Admin menu</h1>
	</center>
	<div class="container">
	<div class = "row ">
	
	
 	<div class="card" style="width: 18rem;"> 
  <div class="card-body"> 
      <h5 class="card-title">Add Flight Details</h5>
    
     <p class="card-text">Here admin can add flight details</p> 
     <a href="addflight" class="card-link">ADD FLIGHT</a> 
     
   </div> 
 </div> 
 <div class="card" style="width: 18rem;"> 
   <div class="card-body"> 
     <h5 class="card-title">Update Flight details</h5> 
     
     <p class="card-text">Here admin can update his flight details</p> 
     <a href="updateflight" class="card-link">UPDATE FLIGHT</a> 
      
   </div> 
 </div> 
 <div class="card" style="width: 18rem;"> 
   <div class="card-body"> 
     <h5 class="card-title">Delete Flight details</h5> 
     
     <p class="card-text">Here admin can delete his flight details</p> 
     <a href="deleteflight" class="card-link">DELETE FLIGHT</a> 
      
   </div> 
 </div> 
 <div class="card" style="width: 18rem;"> 
   <div class="card-body"> 
     <h5 class="card-title">Show Flight</h5> 
    
     <p class="card-text">Here Admin can see all the flight.</p> 
     <a href="showflight" class="card-link">SHOW FLIGHT</a> 
        </div> 
 </div> 
 <div class="card" style="width: 18rem;"> 
   <div class="card-body"> 
     <h5 class="card-title">Show Customer</h5> 
     <p class="card-text">Here admin can see all his customer.</p> 
     <a href="showcustomer" class="card-link">SHOW CUSTOMERS</a> 
    
   </div> 
 </div> 
 <div class="card" style="width: 18rem;"> 
   <div class="card-body"> 
     <h5 class="card-title">Show Booking</h5> 
      
     <p class="card-text">Here admin will be able to see  his bookings</p> 
     <a href="showbooking" class="card-link">SHOW BOOKING</a> 
     
   </div> 
 </div> 

	
	
	</div>
	</div>
		
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
</body>
</html>