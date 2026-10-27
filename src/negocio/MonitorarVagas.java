package negocio;

import DAO.MonitorarVagasDAO;
import java.sql.SQLException;

/** Regras de negócio da consulta de vagas de workshops. */
public class MonitorarVagas {
    private int codigoWorkshop;

    public void setCodigoWorkshop(int codigoWorkshop) { this.codigoWorkshop = codigoWorkshop; }

    public String consultar() throws SQLException, ClassNotFoundException {
        if (codigoWorkshop <= 0) {
            throw new IllegalArgumentException("O código do workshop deve ser maior que zero.");
        }
        MonitorarVagasDAO dao = new MonitorarVagasDAO();
        dao.setCodigoWorkshop(codigoWorkshop);
        return dao.consultar();
    }
}
