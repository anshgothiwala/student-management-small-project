<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A+ University</title>
<%@include file="allcssjs.jsp" %>
</head>
<body>
	<div class="container">
    	<%@include file="navbar.jsp" %>
    <br>
    <h2>Manage Students</h2>
    <br>
    	<%
		String DB_URL="jdbc:mysql://localhost/studentmanagement";
        String USER="root";
        String PASS="Ansh@2403";
        String Query="select * from student";
        response.setContentType("text/html");
        
        try {
			Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
			Statement stmt=conn.createStatement();
			
			ResultSet rs=stmt.executeQuery(Query);
			%>
			<table border="1" style="width:70%; font-size: 18px;">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Mobile</th>
					<th>Operations</th>
				</tr>
			<%
			while(rs.next()) {
				int id=rs.getInt("sid");
				String name=rs.getString("name");
				String email=rs.getString("email");
				String mobile=rs.getString("mobile");
				%>
				<tr>
					<td><%=id %></td>
					<td><%=name %></td>
					<td><%=email %></td>
					<td><%=mobile %></td>
					<td><a href="editStudent.jsp?studentid=<%=id%>">Edit</a> | <a href="DeleteStudentServlet?studentid=<%=id%>">Delete</a></td>
				</tr>
			<% 
				}
			%>
			</table>
			
			<%
			rs.close();
			stmt.close();
			conn.close();
			
		} 
        catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
    	
    	%>
    <br>
    <a href="addStudent.jsp"><button class="btn btn-primary">Add Student</button></a>
    </div>
</body>
</html>