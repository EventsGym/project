package DAO;
import java.sql.*; import java.util.*;
public class MonitorarVagasDAO {private int codigoWorkshop;public void setCodigoWorkshop(int v){codigoWorkshop=v;}
 public String consultar()throws SQLException{Object[] x=buscar();return x==null?"Nenhum workshop encontrado para o código informado.":"Workshop: "+x[1]+" | vagas: "+x[3]+" | inscritos: "+x[4]+" | disponíveis: "+x[5];}
 public java.util.List<Object[]> listar()throws SQLException{java.util.List<Object[]> l=new java.util.ArrayList<>();try(Connection c=Conexao.abrir();PreparedStatement p=c.prepareStatement("SELECT codigo,titulo,data,vagas,(SELECT COUNT(*) FROM presencas pr WHERE pr.codigo_workshop=w.codigo) inscritos FROM workshops w ORDER BY codigo");ResultSet r=p.executeQuery()){while(r.next()){int v=r.getInt(4),i=r.getInt(5);l.add(new Object[]{r.getInt(1),r.getString(2),r.getString(3),v,i,v-i,v-i<=0?"LOTADO":"DISPONÍVEL"});}}return l;}
 public Object[] buscar()throws SQLException{try(Connection c=Conexao.abrir();PreparedStatement p=c.prepareStatement("SELECT codigo,titulo,data,vagas,(SELECT COUNT(*) FROM presencas pr WHERE pr.codigo_workshop=w.codigo) inscritos FROM workshops w WHERE codigo=?")){p.setInt(1,codigoWorkshop);try(ResultSet r=p.executeQuery()){if(!r.next())return null;return new Object[]{r.getInt(1),r.getString(2),r.getString(3),r.getInt(4),r.getInt(5),r.getInt(4)-r.getInt(5)};}}}
}
