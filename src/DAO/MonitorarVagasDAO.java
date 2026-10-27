package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MonitorarVagasDAO {
    private int codigoWorkshop;

    public void setCodigoWorkshop(int codigoWorkshop) { this.codigoWorkshop = codigoWorkshop; }

    public String consultar() throws SQLException, ClassNotFoundException {
        Conexao conexao = new Conexao();
        conexao.setSQL("SELECT codigo, titulo, data, vagas FROM workshops WHERE codigo=" + codigoWorkshop);
        ResultSet resultado = conexao.query();
        try {
            if (resultado.next()) {
                return "Workshop encontrado: " + resultado.getString("titulo");
            }
            return "Nenhum workshop encontrado para o código informado.";
        } finally {
            if (resultado != null) resultado.close();
        }
    }
}
