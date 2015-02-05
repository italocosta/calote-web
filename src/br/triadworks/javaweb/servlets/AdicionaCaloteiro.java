package br.triadworks.javaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.triadworks.javaweb.dao.CaloteiroDAO;
import br.triadworks.javaweb.modelo.Caloteiro;
import br.triadworks.javaweb.servlets.exception.CaloteiroServletException;

@WebServlet("/adicionaCaloteiro")
public class AdicionaCaloteiro extends HttpServlet {
	
	protected void service(HttpServletRequest req,
						   HttpServletResponse res)
			throws ServletException, IOException{
		
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
			System.out.println("Erro na conversão da data. Erro: "+e.getMessage());
			throw new CaloteiroServletException();
		}
		
		CaloteiroDAO dao = new CaloteiroDAO();
		dao.adiciona(caloteiro);
		
		PrintWriter print = res.getWriter();
		print.println("<html>");
		print.println("<body>");
		print.println("Caloteiro "+caloteiro.getNome() + " adicionado com sucesso !!");
		print.println("</body>");
		print.println("</html>");
		
		
	}

}
