package br.triadworks.javaweb.modelo;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.triadworks.javaweb.dao.CaloteiroDAO;
import br.triadworks.javaweb.servlets.exception.CaloteiroServletException;

public class AdicionaCaloteiroLogica implements Logica{

	public void executa(HttpServletRequest req, HttpServletResponse res)
						throws Exception{
		Caloteiro caloteiro = new Caloteiro();
		caloteiro.setNome(req.getParameter("nome"));
		caloteiro.setEmail(req.getParameter("email"));
		caloteiro.setDevendo(Integer.parseInt(req.getParameter("devendo")));
		String dataDivida = req.getParameter("data");
		Calendar dataDividaConvertida = null;
		try{
			Date data = new SimpleDateFormat("dd/mm/yyyy").parse(dataDivida);
			dataDividaConvertida = Calendar.getInstance();
			dataDividaConvertida.setTime(data);
			caloteiro.setDataDivida(dataDividaConvertida);
			
		}catch(java.text.ParseException e){
			throw new CaloteiroServletException("Erro na conversão da data. Erro: "+e.getMessage());
		}
		
		Connection con = (Connection)req.getAttribute("conexao");
		
		CaloteiroDAO dao = new CaloteiroDAO(con);
		dao.adiciona(caloteiro);
		
		RequestDispatcher rd = req.getRequestDispatcher("/sistema?acao=ListaCaloteiro");
		rd.forward(req, res);
	}
}
