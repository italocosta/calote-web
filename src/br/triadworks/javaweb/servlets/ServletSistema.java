package br.triadworks.javaweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.triadworks.javaweb.modelo.Logica;

@WebServlet("/sistema")
public class ServletSistema extends HttpServlet {
	protected void service(HttpServletRequest req,
						   HttpServletResponse res)
				throws ServletException, IOException{
		
		String acao = req.getParameter("acao");
		String caminho = "br.triadworks.javaweb.modelo.";
		try {
			Class<?> classe = Class.forName(caminho+acao+"Logica");
			Object obj = classe.newInstance();
			Logica logica = (Logica) obj;
			logica.executa(req, res);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
