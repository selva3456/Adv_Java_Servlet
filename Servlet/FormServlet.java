package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Form")
public class FormServlet extends GenericServlet{
	
	@Override
	public void service(ServletRequest req,ServletResponse res)throws IOException,ServletException{
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		PrintWriter pw=res.getWriter();
		String html="<html>"
				+"<body>"
				+"<h1> id="+id+"</h1>"
				+"<h1> name="+name+"</h1>"
				+"</body>"
				+"</html>";
		pw.print(html);
		
	}
}

