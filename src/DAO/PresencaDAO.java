package DAO;
import java.sql.*; import java.util.*;
public class PresencaDAO {private String cpf,data,status;private int codigoWorkshop;public void setCpf(String v){cpf=v;}public void setCodigoWorkshop(int v){codigoWorkshop=v;}public void setData(String v){data=v;}public void setStatus(String v){status=v;}
 public String cadastrar()throws SQLException{try(Connection c=Conexao.abrir();PreparedStatement p=c.prepareStatement("INSERT INTO presencas(cpf,codigo_workshop,data,status) VALUES(?,?,?,?)")){p.setString(1,cpf);p.setInt(2,codigoWorkshop);p.setString(3,data);p.setString(4,status);p.executeUpdate();return "Presença registrada.";}}
 public List<Object[]> listar(String cpfFiltro)throws SQLException{List<Object[]> l=new ArrayList<>();String sql="SELECT id_presenca,cpf,codigo_workshop,data,status FROM presencas"+(cpfFiltro==null||cpfFiltro.isEmpty()?"":" WHERE cpf=?")+" ORDER BY data DESC";try(Connection c=Conexao.abrir();PreparedStatement p=c.prepareStatement(sql)){if(cpfFiltro!=null&&!cpfFiltro.isEmpty())p.setString(1,cpfFiltro);try(ResultSet r=p.executeQuery()){while(r.next())l.add(new Object[]{r.getInt(1),r.getString(2),r.getInt(3),r.getString(4),r.getString(5)});}}return l;}
}
