package negocio;

import java.sql.SQLException;

import DAO.PresencaDAO;

public class Presenca {
	private String cpf;
	private int codigoWorkshop;
	private String data;
	private String status;
	
	public void setCpf(String cpf) { this.cpf = cpf; }
	public void setCodigoWorkshop(int codigoWorkshop) { this.codigoWorkshop = codigoWorkshop; }
	public void setData(String data) { this.data = data; }
	public void setStatus(String status) { this.status = status; }
	
	public String cadastrar() throws SQLException, ClassNotFoundException {
		PresencaDAO objeto = new PresencaDAO();
		objeto.setCpf(this.cpf);
		objeto.setCodigoWorkshop(this.codigoWorkshop);
		objeto.setData(this.data);
		objeto.setStatus(this.status);
		return objeto.cadastrar();
	}
}
