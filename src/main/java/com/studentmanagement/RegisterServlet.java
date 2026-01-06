package com.studentmanagement;

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

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		String DB_URL="jdbc:mysql://localhost/studentmanagement";
        String USER="root";
        String PASS="Ansh@2403";
        String Query="insert into register(email,password) values(?,?)";
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        try {
			Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
			PreparedStatement ps=conn.prepareStatement(Query);
			ps.setString(1, email);
			ps.setString(2, password);
			
			int i=ps.executeUpdate();
			
			if(i!=0) {
				
				response.sendRedirect("alert.html");
			}
			else {
				out.println("<h3>Register Failed</h3>");
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
