package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/signin")
public class SignInServlet extends GenericServlet {
	
	public void service(ServletRequest req,ServletResponse res)throws IOException,ServletException{
		
		String id=req.getParameter("id");
		String fName=req.getParameter("fname");
		String lName=req.getParameter("lname");
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		String phno=req.getParameter("phone");
		
		PrintWriter p=res.getWriter();
//		String html=
//				"<h1> id="+id+"</h1>"
//				+"<h1> FName="+fName+"</h1>"
//				+"<h1> LName="+lName+"</h1>"
//				+"<h1> Email="+email+"</h1>"
//				+"<h1> Password="+pass+"</h1>"
//				+"<h1> Phonenumber="+phno+"</h1>";
//		p.print(html);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db","root","root");
			PreparedStatement ps=c.prepareStatement("insert into user values(?,?,?,?,?,?)");
			
			ps.setInt(1,Integer.parseInt(id));
			ps.setString(2, fName);
			ps.setString(3, lName);
			ps.setString(4, email);
			ps.setString(5, pass);
			ps.setLong(6, Long.parseLong(phno));
			
			ps.executeUpdate();
			c.close();
			p.print("<h1>Data Saved</h1>");
		}
		catch(ClassNotFoundException | SQLException e) {
			p.print(e);
			e.printStackTrace();
		}
	}
}
