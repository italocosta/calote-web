package br.triadworks.javaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contador")
public class ServletContador extends HttpServlet {
	
	private int cont = 0;
	
	protected void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		cont ++;
		PrintWriter print = res.getWriter();
		print.println("<html>");
		print.println("<body>");
		print.println("Servlet de numero : "+cont);
		print.println("</body>");
		print.println("</html>");
	}

}
