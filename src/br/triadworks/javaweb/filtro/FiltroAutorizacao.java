package br.triadworks.javaweb.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.triadworks.javaweb.modelo.Usuario;

@WebFilter("/*")
public class FiltroAutorizacao implements Filter {


	@Override
	public void init(FilterConfig arg0) throws ServletException {}

	@Override
	public void doFilter(ServletRequest sreq, ServletResponse sres,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) sreq;
		
		String uri = req.getRequestURI();
		String logica = req.getParameter("acao");
		
		if(logica == null){
			logica = "";
		}
		
		if(uri.endsWith("login.jsp")
			|| logica.endsWith("AutenticaUsuario")
			|| uri.endsWith(".png")){
			
			chain.doFilter(sreq, sres);
		}else{
			Usuario usuarioLogado = (Usuario) req.getSession().getAttribute("user");
			if(usuarioLogado != null){
				chain.doFilter(sreq, sres);
			}else{
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				req.setAttribute("msg", "Você não tem autorização");
				rd.forward(sreq, sres);
			}
		}
			

	}

	@Override
	public void destroy() {}


}
