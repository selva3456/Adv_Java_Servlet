package Servlet_Chaining;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns ="/config2",
       initParams = 
       {
    		   @WebInitParam(name="email",value="kk@gmail.com"),
    		   @WebInitParam(name="password",value="546")
       }		
	   )
public class config2 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
	ServletConfig config=getServletConfig();
	
	String email=config.getInitParameter("email");
	String password=config.getInitParameter("password");
	
	PrintWriter out=res.getWriter();
	
	out.print("Email:"+email);
	out.print(" , password:"+password);
	
		
	}
}
