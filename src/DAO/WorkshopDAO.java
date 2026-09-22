package DAO;

import java.sql.SQLException;

public class WorkshopDAO {
    private int codigo;
    private String titulo;
    private String instrutor;
    private String data;
    private String carga;
    private int vagas;
    private String local;

    public void setCodigo(int codigo) { this.codigo = codigo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setInstrutor(String instrutor) { this.instrutor = instrutor; }
    public void setData(String data) { this.data = data; }
    public void setCarga(String carga) { this.carga = carga; }
    public void setVagas(int vagas) { this.vagas = vagas; }
    public void setLocal(String local) { this.local = local; }

    public String cadastrar() throws SQLException, ClassNotFoundException {
        Conexao objeto = new Conexao();
        String sql = "INSERT INTO workshops (codigo, titulo, instrutor, data, carga, vagas, local) "
                + "VALUES (" + this.codigo + ", '" + this.titulo + "', '" + this.instrutor + "', '" + this.data + "', '" + this.carga + "', " + this.vagas + ", '" + this.local + "');";
        objeto.setSQL(sql);
        objeto.update();
        return "Cadastrado com Sucesso";
    }

    public String alterar() throws SQLException, ClassNotFoundException {
        Conexao objeto = new Conexao();
        String sql = "UPDATE workshops SET titulo='" + this.titulo + "', instrutor='" + this.instrutor
                + "', data='" + this.data + "', carga='" + this.carga + "', vagas=" + this.vagas
                + ", local='" + this.local + "' WHERE codigo=" + this.codigo + ";";
        objeto.setSQL(sql);
        objeto.update();
        return "Alterado com Sucesso";
    }

    public String excluir() throws SQLException, ClassNotFoundException {
        Conexao objeto = new Conexao();
        String sql = "DELETE FROM workshops WHERE codigo=" + this.codigo + ";";
        objeto.setSQL(sql);
        objeto.update();
        return "Excluído com Sucesso";
    }
}
