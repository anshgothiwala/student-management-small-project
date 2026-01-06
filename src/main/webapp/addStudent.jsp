<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
<%@include file="allcssjs.jsp" %>
</head>
<body>
	<div class="container">
    	<%@include file="navbar.jsp" %>
    </div>
    <br>
    <h2 class="container">Add Student</h2>
    <br>
    <!-- This is add form -->
    <form class="container" action="AddStudentServlet" method="post">
  	<div class="form-group">
    	<label for="name">Student Name</label>
    	<input 
    		name="name"
    		required
    		type="text" 
    		class="form-control" 
    		id="name" 
    		aria-describedby="emailHelp" 
    		placeholder="Enter Student Name">
    	
  	</div>
  	<div class="form-group">
    	<label for="email">Student Email</label>
    	<input 
    		name="email"
    		required
    		type="email" 
    		class="form-control" 
    		id="email" 
    		aria-describedby="emailHelp" 
    		placeholder="Enter Student Email">
  	</div>
  	<div class="form-group">
    	<label for="mobile">Student Mobile</label>
    	<input 
    		name="mobile"
    		required
    		type="tel" 
    		class="form-control" 
    		id="mobile" 
    		aria-describedby="emailHelp" 
    		placeholder="Enter Student Mobile Number">
  	</div>
  	<div class="container text-center">
  		<button type="submit" class="btn btn-primary">Add Student</button>
  	</div>
</form>
</body>
</html>