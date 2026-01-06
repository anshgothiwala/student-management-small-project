<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
<%@include file="allcssjs.jsp" %>
</head>
<body>
	<div class="container">
    	<%@include file="navbar.jsp" %>
    </div>
    <br>
    <h2 class="container">Add Student</h2>
    <br>
    <%
    int student_id=Integer.parseInt(request.getParameter("studentid").trim());
    
    String DB_URL="jdbc:mysql://localhost/studentmanagement";
    String USER="root";
    String PASS="Ansh@2403";
    String Query="select * from student where sid=?";
    response.setContentType("text/html");
    
		String name="",email="",mobile="";
    	try 
    	{
    	Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
    	PreparedStatement ps=conn.prepareStatement(Query);
		ps.setInt(1, student_id);
		
		ResultSet rs= ps.executeQuery();
		
		if(rs.next())
		{
			name=rs.getString("name");
			email=rs.getString("email");
			mobile=rs.getString("mobile");
		}
		rs.close();
		ps.close();
		conn.close();
    	}
    	catch (Exception e) 
		{
			e.printStackTrace();
		}
    %>
    <!-- This is add form -->
    <form class="container" action="EditStudentServlet" method="post">
  	<div class="form-group">
  		<input type="hidden" name="studentid" value="<%= student_id%>">
    	<label for="name">Student Name</label>
    	<input 
    		name="name"
    		value="<%= name %>"
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
    		value="<%= email %>"
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
    		value="<%= mobile %>"
    		required
    		type="tel" 
    		class="form-control" 
    		id="mobile" 
    		aria-describedby="emailHelp" 
    		placeholder="Enter Student Mobile Number">
  	</div>
  	<div class="container text-center">
  		<button type="submit" class="btn btn-primary">Edit Student</button>
  	</div>
</form>
</body>
</html>