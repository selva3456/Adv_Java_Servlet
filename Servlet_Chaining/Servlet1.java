package Servlet_Chaining;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/s1")
public class Servlet1 extends GenericServlet{
	 
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	 
		RequestDispatcher dispatcher =req.getRequestDispatcher("s2");
		dispatcher.forward(req, res);
		
	}
	

}
