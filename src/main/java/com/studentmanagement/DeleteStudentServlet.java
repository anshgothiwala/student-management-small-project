package com.studentmanagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int student_id=Integer.parseInt(request.getParameter("studentid").trim());
		
		String DB_URL="jdbc:mysql://localhost/studentmanagement";
        String USER="root";
        String PASS="Ansh@2403";
        String Query="delete from student where sid=?";
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
		
		try 
		{
			Connection conn=DriverManager.getConnection(DB_URL,USER,PASS);
			PreparedStatement ps=conn.prepareStatement(Query);
			ps.setInt(1, student_id);
			
			int i=ps.executeUpdate();
			
			if(i!=0)
			{
				response.sendRedirect("Home.jsp");
			}
			else
			{
				response.sendRedirect("notDeletedAlert.jsp");
			}
			ps.close();
			conn.close();
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
