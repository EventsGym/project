package DAO;
import java.sql.*;
import java.security.SecureRandom;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;
public class UsuarioDAO {
 private int idUsuario; private String nomeUsuario, usuario, email, senha;
 public void setIdUsuario(int v){idUsuario=v;} public void setNomeUsuario(String v){nomeUsuario=v;} public void setUsuario(String v){usuario=v;} public void setEmail(String v){email=v;} public void setSenha(String v){senha=v;}
 private String[] hashSenha(String valor) throws SQLException { try { byte[] salt=new byte[16]; new SecureRandom().nextBytes(salt); PBEKeySpec spec=new PBEKeySpec(valor.toCharArray(),salt,120000,256); byte[] hash=SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded(); spec.clearPassword(); return new String[]{Base64.getEncoder().encodeToString(hash),Base64.getEncoder().encodeToString(salt)}; } catch(Exception e){throw new SQLException("Não foi possível proteger a senha.",e);} }
 public String cadastrar() throws SQLException { String[] cred=hashSenha(senha); String sql="INSERT INTO usuarios(nome,usuario,email,senha,salt) VALUES(?,?,?,?,?)"; try(Connection c=Conexao.abrir(); PreparedStatement ps=c.prepareStatement(sql)){ps.setString(1,nomeUsuario);ps.setString(2,usuario);ps.setString(3,email);ps.setString(4,cred[0]);ps.setString(5,cred[1]);ps.executeUpdate();return "Usuário cadastrado com sucesso.";} }
 public boolean existeUsuario(String login) throws SQLException {try(Connection c=Conexao.abrir();PreparedStatement ps=c.prepareStatement("SELECT 1 FROM usuarios WHERE usuario=? OR email=?")){ps.setString(1,login);ps.setString(2,login);try(ResultSet r=ps.executeQuery()){return r.next();}}}
 public ResultSet consultarPorLogin(String login) throws SQLException { Connection c=Conexao.abrir(); PreparedStatement ps=c.prepareStatement("SELECT id_usuario,nome,usuario,email FROM usuarios WHERE usuario=? OR email=?");ps.setString(1,login);ps.setString(2,login);return ps.executeQuery(); }
}
