package negocio;

import java.sql.SQLException;

import DAO.HistoricoDAO;

public class Historico {
	private String cpf;
	private String evento;
	private String data;
	
	public void setCpf(String cpf) { this.cpf = cpf; }
	public void setEvento(String evento) { this.evento = evento; }
	public void setData(String data) { this.data = data; }
	
	public String consultar() throws SQLException, ClassNotFoundException {
		HistoricoDAO objeto = new HistoricoDAO();
		objeto.setCpf(this.cpf);
		objeto.setEvento(this.evento);
		objeto.setData(this.data);
		return objeto.consultar();
	}
}
