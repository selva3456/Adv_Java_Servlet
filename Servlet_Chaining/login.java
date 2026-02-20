package Servlet_Chaining;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/login")
public class login extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("pass");

		PrintWriter out = res.getWriter();

		if (email.equals("selva@gmail.com")) {
			if (password.equals("1234")) {
				RequestDispatcher d = req.getRequestDispatcher("homepage.html");
				d.forward(req, res);
			} else {
				out.print("<h1 style='color:red'>Incorrect Password</h1>");
				RequestDispatcher d = req.getRequestDispatcher("login.html");
				d.include(req, res);
			}
		} else {
			out.print("<h1 style='color:red'>Invalid Email</h1>");

			RequestDispatcher d = req.getRequestDispatcher("login.html");
			d.include(req, res);
		}
		
	}
}
