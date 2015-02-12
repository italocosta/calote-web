package br.triadworks.javaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.triadworks.javaweb.modelo.Usuario;

public class UsuarioDAO {

	private Connection conn;
	
	public UsuarioDAO(Connection conexao){
		this.conn = conexao;
	}
	
	public Usuario autentica(String login, String senha){
		String sql = "select * from usuario where login = ? and senha = ?";
		PreparedStatement ps;
		try {
			ps = this.conn.prepareStatement(sql);
		
			ps.setString(1, login);
			ps.setString(2, senha);
			
			ResultSet rs = ps.executeQuery();
			Usuario user = null;
			
			if( rs.next()){
				user = new Usuario();
				user.setId(rs.getLong(1));
				user.setNome(rs.getString(2));
				user.setLogin(rs.getString(3));
				user.setSenha(rs.getString(4));
			}
			rs.close();
			ps.close();
			
			return user;
		
		} catch (SQLException e) {			
			throw new RuntimeException(e);
		}
		
	}
}

