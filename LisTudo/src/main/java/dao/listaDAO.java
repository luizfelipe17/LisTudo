package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexao.ConexaoBD;

public class listaDAO {

    PreparedStatement preparedStatement = null;

    public void addItensBD(String produtos) throws SQLException {

        Connection conn = ConexaoBD.conexaoBD();

        preparedStatement = conn.prepareStatement("INSERT INTO listadecompras (itens, preço) VALUES (?, ?)");
        preparedStatement.setString(1, produtos);
        preparedStatement.setDouble(2, 0);

        preparedStatement.executeUpdate();

    }

    public void precoItensBD(Double preco) throws SQLException {

        Connection conn = ConexaoBD.conexaoBD();

        preparedStatement = conn.prepareStatement("INSERT INTO listadecompras (preço) VALUES (?)");
        preparedStatement.setDouble(1, preco);


    }

    public void deleteItem(String produtos) throws SQLException {

        Connection conn = ConexaoBD.conexaoBD();

        preparedStatement = conn.prepareStatement("INSERT INTO listadecompras (itens) VALUES (?)");
        preparedStatement.setString(1, produtos);


    }

    public void deleteLista(String produtos) throws SQLException {

        Connection conn = ConexaoBD.conexaoBD();

        preparedStatement = conn.prepareStatement("INSERT INTO listadecompras (itens) VALUES (?)");
        preparedStatement.setString(1, produtos);


    }
    
}
