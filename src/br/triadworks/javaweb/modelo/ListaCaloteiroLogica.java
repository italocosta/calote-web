package br.triadworks.javaweb.modelo;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.triadworks.javaweb.dao.CaloteiroDAO;

public class ListaCaloteiroLogica implements Logica{

	public void executa(HttpServletRequest req, 
						HttpServletResponse res)
				throws Exception{
		Connection con = (Connection) req.getAttribute("conexao");
		
		CaloteiroDAO dao = new CaloteiroDAO(con);
		req.setAttribute("lista",dao.getLista());
		RequestDispatcher rd = req.getRequestDispatcher("/listaCaloteirosJSTL.jsp");
		rd.forward(req, res);
		
	}
}
