package com.studentmanagement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		
		String DB_URL="jdbc:mysql://localhost/studentmanagement";
        String USER="root";
        String PASS="Ansh@2403";
        String Query="insert into student(name,email,mobile) values(?,?,?)";
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        try {
			Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
			PreparedStatement ps=conn.prepareStatement(Query);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, mobile);
			
			int i=ps.executeUpdate();
			
			RequestDispatcher rd=request.getRequestDispatcher("addStudent.jsp");
			
			if(i!=0) {
				response.sendRedirect("Home.jsp");
			}
			else {
				out.println("<h3>Student not added</h3>");
				rd.include(request, response);
			}
			ps.close();
			conn.close();
			
		} 
        catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
		
	}

}
