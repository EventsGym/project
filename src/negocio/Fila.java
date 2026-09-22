package negocio;

import java.sql.SQLException;

import DAO.FilaDAO;

public class Fila {
	private int posicao;
	private String aluno;
	private String evento;
	
	public void setPosicao(int posicao) { this.posicao = posicao; }
	public void setAluno(String aluno) { this.aluno = aluno; }
	public void setEvento(String evento) { this.evento = evento; }
	
	public String cadastrar() throws SQLException, ClassNotFoundException {
		FilaDAO objeto = new FilaDAO();
		objeto.setPosicao(this.posicao);
		objeto.setAluno(this.aluno);
		objeto.setEvento(this.evento);
		return objeto.cadastrar();
	}
}
