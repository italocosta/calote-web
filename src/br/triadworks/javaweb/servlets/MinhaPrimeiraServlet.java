package br.triadworks.javaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OlaMundo")
public class MinhaPrimeiraServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter escreva = res.getWriter();
		escreva.println("<html>");
		escreva.println("<body>");
		escreva.println("Ebaa, meu primeiro servlet !");
		escreva.println("</body>");
		escreva.println("</html>");
		
	}
	

}
