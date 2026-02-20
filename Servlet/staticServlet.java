package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/static")
public class staticServlet extends GenericServlet {
	public void service(ServletRequest req,ServletResponse res)throws IOException,ServletException{
		PrintWriter pw=res.getWriter();
		String html="<html>"
				+"<body>"
				+"<h1>Hi I'm from static Resource</h1>"
				+"</body>"
				+"</html>";
		pw.print(html);
	}

}
