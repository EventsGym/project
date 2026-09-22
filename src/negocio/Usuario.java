package negocio;

import java.sql.SQLException;

import DAO.UsuarioDAO;

public class Usuario {
	private int idUsuario;
	private String nomeUsuario;
	private String usuario;
	private String email;
	private String senha;
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String cadastrar() throws SQLException, ClassNotFoundException {
		UsuarioDAO objeto = new UsuarioDAO();
		objeto.setIdUsuario(this.idUsuario);
		objeto.setNomeUsuario(this.nomeUsuario);
		objeto.setUsuario(this.usuario);
		objeto.setEmail(this.email);
		objeto.setSenha(this.senha);
		return objeto.cadastrar();
	}
}
