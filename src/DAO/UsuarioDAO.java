package DAO;

import java.sql.SQLException;

public class UsuarioDAO {
    private int idUsuario;
    private String nomeUsuario;
    private String usuario;
    private String email;
    private String senha;

    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public void setEmail(String email) { this.email = email; }
    public void setSenha(String senha) { this.senha = senha; }

    public String cadastrar() throws SQLException, ClassNotFoundException {
        Conexao objeto = new Conexao();
        String sql = "INSERT INTO usuarios (nome, usuario, email, senha) "
                + "VALUES ('" + this.nomeUsuario + "','" + this.usuario + "','" + this.email + "','" + this.senha + "');";
        objeto.setSQL(sql);
        objeto.update();
        return "Cadastrado com Sucesso";
    }
}
