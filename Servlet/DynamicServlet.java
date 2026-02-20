package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/selva")
public class DynamicServlet extends GenericServlet{
	public void service(ServletRequest req,ServletResponse res)throws IOException,ServletException{
		
		Date d=new Date();
		
		PrintWriter pw=res.getWriter();
		String html="<html>"
				+"<body>"
				+"<h2>"+d+"</h2>"
				+"</body>"
				+"</html>";
		pw.print(html);	
	}
}
