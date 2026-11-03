package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

/** Acesso aos dados necessário para autenticação. Não cria o banco/tabelas. */
public class LoginDAO {
    private String usuario;
    private String senha;

    public void setUsuario(String usuario) { this.usuario = usuario; }
    public void setSenha(String senha) { this.senha = senha; }

    public boolean autenticar() throws SQLException, ClassNotFoundException {
        Conexao conexao = new Conexao();
        String usuarioSeguro = usuario == null ? "" : usuario.replace("'", "''");
        String senhaSegura = senha == null ? "" : senha.replace("'", "''");
        conexao.setSQL("SELECT usuario FROM usuarios WHERE usuario='" + usuarioSeguro
                + "' AND senha='" + senhaSegura + "'");
        ResultSet resultado = conexao.query();
        try {
            return resultado.next();
        } finally {
            if (resultado != null) resultado.close();
        }
    }
}
