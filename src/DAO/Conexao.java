package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Centraliza a abertura de conexoes JDBC. Configure as variaveis EVG_DB_URL, EVG_DB_USER e EVG_DB_PASSWORD. */
public final class Conexao {
    private static final String URL_PADRAO = "jdbc:mysql://localhost:3306/projeto?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private Conexao() { }
    public static Connection abrir() throws SQLException {
        String url = System.getenv("EVG_DB_URL");
        String usuario = System.getenv("EVG_DB_USER");
        String senha = System.getenv("EVG_DB_PASSWORD");
        if (url == null || url.trim().isEmpty()) url = URL_PADRAO;
        if (usuario == null) usuario = "root";
        if (senha == null) senha = "saulo24";
        return DriverManager.getConnection(url, usuario, senha);
    }
}
