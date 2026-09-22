package DAO;

import java.sql.SQLException;

public class FilaDAO {
    private int posicao;
    private String aluno;
    private String evento;

    public void setPosicao(int posicao) { this.posicao = posicao; }
    public void setAluno(String aluno) { this.aluno = aluno; }
    public void setEvento(String evento) { this.evento = evento; }

    public String cadastrar() throws SQLException, ClassNotFoundException {
        Conexao objeto = new Conexao();
        String sql = "INSERT INTO fila_espera (posicao, aluno, evento) "
                + "VALUES (" + this.posicao + ", '" + this.aluno + "', '" + this.evento + "');";
        objeto.setSQL(sql);
        objeto.update();
        return "Cadastrado com Sucesso";
    }
}
