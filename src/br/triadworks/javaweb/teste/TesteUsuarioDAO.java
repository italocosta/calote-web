package br.triadworks.javaweb.teste;

import java.sql.Connection;

import br.triadworks.javaweb.dao.ConnectionFactory;
import br.triadworks.javaweb.dao.UsuarioDAO;
import br.triadworks.javaweb.modelo.Usuario;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		Connection con = new ConnectionFactory().getConnection();
		
		UsuarioDAO dao = new UsuarioDAO(con);
		
		Usuario user = dao.autentica("italo", "irrc1991");
		if(user == null){
			System.out.println("Usuário e/ou senha incorretos.");
		}else{
			System.out.println("Logou com sucesso");
		}
		
		Usuario user2 = dao.autentica("teste", "irrc1991");
		if(user2 == null){
			System.out.println("Usuário e/ou senha incorretos.");
		}else{
			System.out.println("Logou com sucesso");
		}

	}

}
