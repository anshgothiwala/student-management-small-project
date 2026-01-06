package com.studentmanagement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		String DB_URL="jdbc:mysql://localhost/studentmanagement";
        String USER="root";
        String PASS="Ansh@2403";
        String Query="select * from register where email=? and password=?";
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        try {
			Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
			PreparedStatement ps=conn.prepareStatement(Query);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			
			if(rs.next()) {
				HttpSession session=request.getSession();
				session.setAttribute("usersession", email);
				response.sendRedirect("Home.jsp");
			}
			else {
				out.println("<h3>Login Failed</h3>");
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
