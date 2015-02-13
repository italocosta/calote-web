package br.triadworks.javaweb.modelo;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.triadworks.javaweb.dao.UsuarioDAO;

public class AutenticaUsuarioLogica implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		HttpSession session = req.getSession();
		Connection conn = (Connection)req.getAttribute("conexao");
		UsuarioDAO dao = new UsuarioDAO(conn);
		
		Usuario user = dao.autentica(login, senha);
		
		if(user != null){
			session.setAttribute("user", user);
			req.setAttribute("nome", "RequestScope");
			session.setAttribute("nome", "sessionScope");
			res.sendRedirect("menu.jsp");
		}else{
			req.setAttribute("msg", "Login e/ou senha incorreto.");
			res.sendRedirect("login.jsp");
			
		}
		

	}

}
