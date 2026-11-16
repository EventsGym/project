package DAO;
import java.sql.*; import java.security.MessageDigest; import javax.crypto.SecretKeyFactory; import javax.crypto.spec.PBEKeySpec; import java.util.Base64;
public class LoginDAO { private String usuario,senha; public void setUsuario(String v){usuario=v;} public void setSenha(String v){senha=v;}
 private String hash(String valor,String salt)throws Exception{byte[] b=Base64.getDecoder().decode(salt);PBEKeySpec spec=new PBEKeySpec(valor.toCharArray(),b,120000,256);byte[] h=SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded();spec.clearPassword();return Base64.getEncoder().encodeToString(h);}
 public boolean autenticar() throws SQLException {try(Connection c=Conexao.abrir();PreparedStatement ps=c.prepareStatement("SELECT senha,salt FROM usuarios WHERE usuario=?")){ps.setString(1,usuario);try(ResultSet r=ps.executeQuery()){if(!r.next())return false;try{return MessageDigest.isEqual(hash(senha,r.getString("salt")).getBytes("UTF-8"),r.getString("senha").getBytes("UTF-8"));}catch(Exception e){throw new SQLException("Falha ao validar credenciais.",e);}}}}
}
