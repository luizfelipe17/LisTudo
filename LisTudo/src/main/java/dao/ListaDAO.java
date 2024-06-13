package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexao.ConexaoBD;
import java.sql.Statement;

public class ListaDAO {

    ConexaoBD conexao = new ConexaoBD();
    PreparedStatement preparedStatement = null;
    Connection conn = null;

    public void addItensBD(String produtos) throws SQLException {

        Connection conn = ConexaoBD.conexaoBD();

        preparedStatement = conn.prepareStatement("INSERT INTO listadecompras (itens, preço) VALUES (?, ?)");
        preparedStatement.setString(1, produtos);
        preparedStatement.setDouble(2, 0);

        preparedStatement.executeUpdate();

    }

    public void listaCestaBasica() throws SQLException {

        Connection conn = ConexaoBD.conexaoBD();

        preparedStatement = conn.prepareStatement("INSERT INTO listadecompras (itens, preço) VALUES (?, ?)");
        preparedStatement.setString(1, "Arroz");
        preparedStatement.setDouble(2, 0);
        preparedStatement.executeUpdate();
        preparedStatement.setString(1, "Feijão");
        preparedStatement.setDouble(2, 0);
        preparedStatement.executeUpdate();
        preparedStatement.setString(1, "Óleo");
        preparedStatement.setDouble(2, 0);
        preparedStatement.executeUpdate();
        preparedStatement.setString(1, "Açúcar");
        preparedStatement.setDouble(2, 0);
        preparedStatement.executeUpdate();
        preparedStatement.setString(1, "Café");
        preparedStatement.setDouble(2, 0);
        preparedStatement.executeUpdate();
        preparedStatement.setString(1, "Sal");
        preparedStatement.setDouble(2, 0);
        preparedStatement.executeUpdate();
        preparedStatement.setString(1, "Macarrão");
        preparedStatement.setDouble(2, 0);
        preparedStatement.executeUpdate();
        preparedStatement.setString(1, "Leite");
        preparedStatement.setDouble(2, 0);
        preparedStatement.executeUpdate();

    }

    public void precoItensBD(Double preco) throws SQLException {

        Connection conn = ConexaoBD.conexaoBD();

        preparedStatement = conn.prepareStatement("INSERT INTO listadecompras (preço) VALUES (?)");
        preparedStatement.setDouble(1, preco);

    }

    public void deleteItem(String id) throws SQLException {

        Connection conn = ConexaoBD.conexaoBD();

        preparedStatement = conn.prepareStatement("DELETE FROM listadecompras WHERE id = ?");
        preparedStatement.setString(1, id);
        preparedStatement.executeUpdate();

    }

    public void deleteLista() throws SQLException {

        Connection conn = ConexaoBD.conexaoBD();

        preparedStatement = conn.prepareStatement("DELETE FROM listadecompras");
        String resetAutoIncremente = "ALTER TABLE listadecompras AUTO_INCREMENT = 1";

        preparedStatement.executeUpdate(resetAutoIncremente);
        preparedStatement.executeUpdate();
        
    }

    public boolean imprimirLista() throws SQLException {

        boolean pLista = false;
        Connection conn = ConexaoBD.conexaoBD();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM listadecompras");

        System.out.println("");

        while (rs.next()) {

            System.out.println(rs.getString("id") + " - " + rs.getString("itens"));
            pLista = true;
            
        }
        
        return pLista;
        
    }

}
