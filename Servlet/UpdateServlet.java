package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/updateUser")
public class UpdateServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String id=req.getParameter("id");
		String pass=req.getParameter("pass");
		 
		PrintWriter pw=res.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db","root","root");
			
			PreparedStatement ps=c.prepareStatement("update user set password=? where id=?");
			ps.setString(1,pass);
			ps.setInt(2, Integer.parseInt(id));
			
		    ps.executeUpdate();
		      
		      pw.print("<h1> Data Updated </h1>");
//		      c.close();
//		      ps.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
