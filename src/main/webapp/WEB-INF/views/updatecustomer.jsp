<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Customer Registration</title>
  </head>
  <body>
    <div class="container mt-10">
    <h1>Customer Registration Form<h1><br>
    <form action="updateuser" method="post">


<div class="form-group" class="align-items-center">
    <label for="name">Name</label>
    <input type="text" 
    class="form-control" id="name" 
    placeholder="Your name" 
    name="name" value="${customer.name} ">
  </div>

  <div class="form-group">
    <label for="username">Username</label>
    <input type="text" 
    class="form-control" id="username" 
    placeholder="Enter username" 
    name="username" value="${customer.username} ">
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" 
    class="form-control" id="password" 
    placeholder=" Enter Password" 
    name="password" value="${customer.password} ">
  </div>
  
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" 
    class="form-control" 
    id="exampleInputEmail1" aria-describedby="emailHelp" 
    placeholder="Enter email"
    name="email" value="${customer.email} ">
    
  </div>
  <div class="form-group">
    <label for="phone">Phone</label>
    <input type="text" 
    class="form-control" 
    id="phone" aria-describedby="phone" 
    placeholder="Enter your Contact number"
    name="phone" value="${customer.phone} ">
   </div>
    
  
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
    </div>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
  </body>
</html>