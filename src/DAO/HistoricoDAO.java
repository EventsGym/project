package DAO;

import java.sql.SQLException;

public class HistoricoDAO {
    private String cpf;
    private String evento;
    private String data;

    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setEvento(String evento) { this.evento = evento; }
    public void setData(String data) { this.data = data; }

    public String consultar() throws SQLException, ClassNotFoundException {
        Conexao objeto = new Conexao();
        String sql = "SELECT * FROM historico WHERE cpf='" + this.cpf + "'";
        if (this.evento != null && !this.evento.isEmpty() && !this.evento.equals("Todos")) {
            sql += " AND evento='" + this.evento + "'";
        }
        if (this.data != null && !this.data.isEmpty()) {
            sql += " AND data='" + this.data + "'";
        }
        sql += ";";
        objeto.setSQL(sql);
        objeto.query();
        return "Consulta realizada com Sucesso";
    }
}
