package negocio;

import java.sql.SQLException;

import DAO.WorkshopDAO;

public class Workshop {
	private int codigo;
	private String titulo;
	private String instrutor;
	private String data;
	private String carga;
	private int vagas;
	private String local;
	
	public void setCodigo(int codigo) { this.codigo = codigo; }
	public void setTitulo(String titulo) { this.titulo = titulo; }
	public void setInstrutor(String instrutor) { this.instrutor = instrutor; }
	public void setData(String data) { this.data = data; }
	public void setCarga(String carga) { this.carga = carga; }
	public void setVagas(int vagas) { this.vagas = vagas; }
	public void setLocal(String local) { this.local = local; }
	
	public String cadastrar() throws SQLException, ClassNotFoundException {
		WorkshopDAO objeto = criarDAO();
		return objeto.cadastrar();
	}
	
	public String alterar() throws SQLException, ClassNotFoundException {
		WorkshopDAO objeto = criarDAO();
		return objeto.alterar();
	}
	
	public String excluir() throws SQLException, ClassNotFoundException {
		WorkshopDAO objeto = criarDAO();
		return objeto.excluir();
	}
	
	private WorkshopDAO criarDAO() {
		WorkshopDAO objeto = new WorkshopDAO();
		objeto.setCodigo(this.codigo);
		objeto.setTitulo(this.titulo);
		objeto.setInstrutor(this.instrutor);
		objeto.setData(this.data);
		objeto.setCarga(this.carga);
		objeto.setVagas(this.vagas);
		objeto.setLocal(this.local);
		return objeto;
	}
}
