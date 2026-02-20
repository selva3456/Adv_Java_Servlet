package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/getByid")
public class getUserValueServlet extends GenericServlet {
	
	public void service(ServletRequest req,ServletResponse res)throws IOException,ServletException{
		
		String id=req.getParameter("id");
		
		PrintWriter p=res.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db","root","root");
			PreparedStatement ps=c.prepareStatement("delete from  where id=?");
			ps.setInt(1, Integer.parseInt(id));		
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
			p.print("<h1> id= "+rs.getInt(1)+"</h1>");
			p.print("<h1> FName= "+rs.getString(2)+"</h1>");
			p.print("<h1> LName= "+rs.getString(3)+"</h1>");
			p.print("<h1> Email= "+rs.getString(4)+"</h1>");
			p.print("<h1> Password= "+rs.getString(5)+"</h1>");
			p.print("<h1> phone= "+rs.getLong(6)+"</h1>");
			}
			
		}
		catch(ClassNotFoundException | SQLException e) {
			p.print(e);
			e.printStackTrace();
		}
	}
}
