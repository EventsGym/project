package DAO;
import java.sql.*; import java.util.*;
public class FilaDAO {private int posicao;private String aluno,evento;public void setPosicao(int v){posicao=v;}public void setAluno(String v){aluno=v;}public void setEvento(String v){evento=v;}
 public String cadastrar()throws SQLException{try(Connection c=Conexao.abrir();PreparedStatement p=c.prepareStatement("INSERT INTO fila_espera(posicao,aluno,evento) VALUES(?,?,?)")){p.setInt(1,posicao);p.setString(2,aluno);p.setString(3,evento);p.executeUpdate();return "Aluno incluído na fila.";}}
 public List<Object[]> listar()throws SQLException{List<Object[]> l=new ArrayList<>();try(Connection c=Conexao.abrir();PreparedStatement p=c.prepareStatement("SELECT posicao,aluno,evento FROM fila_espera ORDER BY evento,posicao");ResultSet r=p.executeQuery()){while(r.next())l.add(new Object[]{r.getInt(1),r.getString(2),r.getString(3)});}return l;}
 public String excluir(String nome,String ev)throws SQLException{try(Connection c=Conexao.abrir();PreparedStatement p=c.prepareStatement("DELETE FROM fila_espera WHERE aluno=? AND evento=?")){p.setString(1,nome);p.setString(2,ev);return p.executeUpdate()>0?"Registro removido.":"Registro não encontrado.";}}
}
