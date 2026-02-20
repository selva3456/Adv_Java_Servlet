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

@WebServlet("/deleteUser")
public class DeleteServlet extends GenericServlet{
	public void service(ServletRequest req,ServletResponse res)throws IOException,ServletException{
		
	      String id=req.getParameter("id");
	      PrintWriter pw=res.getWriter();
	      
	      try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      
	      Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db","root","root");
	      
	      PreparedStatement ps=c.prepareStatement("delete from user where id=?");
	      ps.setInt(1, Integer.parseInt(id));
	      ps.executeUpdate();
	      
	      pw.print("<h1> Data Deleted </h1>");
	      c.close();
	      ps.close();
	      }
	      catch(Exception e) {
	    	  e.printStackTrace();
	      }
	}
	

}
