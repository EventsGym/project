package negocio;

import DAO.LoginDAO;
import java.sql.SQLException;

/** Regras de negócio associadas à tela de login. */
public class Login {
    private String usuario;
    private String senha;

    public void setUsuario(String usuario) { this.usuario = usuario; }
    public void setSenha(String senha) { this.senha = senha; }

    public boolean validarCampos() {
        return usuario != null && !usuario.trim().isEmpty()
            && senha != null && !senha.trim().isEmpty();
    }

    /** Autenticação preparada para a etapa de integração com o banco. */
    public boolean autenticar() throws SQLException, ClassNotFoundException {
        if (!validarCampos()) return false;
        LoginDAO dao = new LoginDAO();
        dao.setUsuario(usuario.trim());
        dao.setSenha(senha);
        return dao.autenticar();
    }
}
