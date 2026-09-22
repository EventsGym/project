package DAO;

import java.sql.SQLException;

public class PresencaDAO {
    private String cpf;
    private int codigoWorkshop;
    private String data;
    private String status;

    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setCodigoWorkshop(int codigoWorkshop) { this.codigoWorkshop = codigoWorkshop; }
    public void setData(String data) { this.data = data; }
    public void setStatus(String status) { this.status = status; }

    public String cadastrar() throws SQLException, ClassNotFoundException {
        Conexao objeto = new Conexao();
        String sql = "INSERT INTO presencas (cpf, codigo_workshop, data, status) "
                + "VALUES ('" + this.cpf + "', " + this.codigoWorkshop + ", '" + this.data + "', '" + this.status + "');";
        objeto.setSQL(sql);
        objeto.update();
        return "Cadastrado com Sucesso";
    }
}
