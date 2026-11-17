package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.Conexao;
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

    public List<Object[]> listar()throws SQLException{List<Object[]> l=new ArrayList<>();StringBuilder s=new StringBuilder("SELECT p.id_presenca,u.nome,p.cpf, w.titulo,p.data,p.status,p.status FROM presencas p LEFT JOIN usuarios u ON u.cpf=p.cpf LEFT JOIN workshops w ON w.codigo=p.codigo_workshop WHERE 1=1");if(cpf!=null&&!cpf.trim().isEmpty())s.append(" AND p.cpf=?");if("Aula".equals(evento))s.append(" AND 1=0");if(data!=null&&!data.isEmpty())s.append(" AND p.data=?");s.append(" ORDER BY p.data DESC");try(Connection c= Conexao.abrir(); PreparedStatement p=c.prepareStatement(s.toString())){int i=1;if(cpf!=null&&!cpf.trim().isEmpty())p.setString(i++,cpf);if(data!=null&&!data.isEmpty())p.setString(i++,data);try(ResultSet r=p.executeQuery()){while(r.next())l.add(new Object[]{r.getInt(1),r.getString(2)==null?"(não informado)":r.getString(2),r.getString(3),r.getString(4)==null?"(workshop removido)":r.getString(4),r.getString(5),r.getString(6),r.getString(7)});}}return l;}

}
