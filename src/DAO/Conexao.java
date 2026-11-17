package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static String env(String k, String def) {
        String v = System.getenv(k);
        return (v == null || v.isEmpty()) ? def : v;
    }

    public static Connection abrir() throws SQLException {
        String url = env("EVG_DB_URL",
            "jdbc:mysql://localhost:3306/projeto?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL Connector/J não encontrado no Build Path.", e);
        }
        return DriverManager.getConnection(url, env("EVG_DB_USER", "root"), env("EVG_DB_PASSWORD", "saulo24"));
    }
}
