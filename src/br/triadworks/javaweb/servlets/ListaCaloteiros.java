package br.triadworks.javaweb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.triadworks.javaweb.dao.CaloteiroDAO;
import br.triadworks.javaweb.modelo.Caloteiro;

@WebServlet("/listaCaloteiros")
public class ListaCaloteiros extends HttpServlet {

	protected void service(HttpServletRequest req,
						   HttpServletResponse res)
		throws ServletException, IOException{
		
		
		CaloteiroDAO dao = new CaloteiroDAO();
		List<Caloteiro> lista = dao.getLista();
		/*print.println("<html>");
		print.println("<body>");
		print.println("Servlet de numero : "+cont);
		print.println("</body>");
		print.println("</html>");*/
		
	}
}
