package Servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/life")
public class LifeCycleServlet extends GenericServlet{
	
	@Override
	public void service(ServletRequest req,ServletResponse res)throws IOException,ServletException{
		System.out.println("Hi... This is service method");	
	}
	@Override
	public void init() {
		System.out.println("Hi... This is init method");
	}
	@Override
	public void destroy() {
		System.out.println("Hi... This is destroy method");
	}
}
