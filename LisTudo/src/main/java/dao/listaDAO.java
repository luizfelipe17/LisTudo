package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class listaDAO {

    PreparedStatement preparedStatement = null;

    public void addItensBD(String produtos) throws SQLException {

        Connection conn = conexao.ConexaoBD.conexaoBD();

        preparedStatement = conn.prepareStatement("INSERT INTO listadecompras (itens, preço) VALUES (?, ?)");
        preparedStatement.setString(1, produtos);
        preparedStatement.setDouble(2, 0);

        int rs = preparedStatement.executeUpdate();

    }

    public void precoItensBD(Double preco) throws SQLException {

        Connection conn = conexao.ConexaoBD.conexaoBD();

        preparedStatement = conn.prepareStatement("INSERT INTO listadecompras (itens) VALUES (?)");
        preparedStatement.setDouble(1, preco);


    }

    public void deleteItem(String produtos) throws SQLException {

        Connection conn = conexao.ConexaoBD.conexaoBD();

        preparedStatement = conn.prepareStatement("INSERT INTO listadecompras (itens) VALUES (?)");
        preparedStatement.setString(1, produtos);


    }

    public void deleteLista(String produtos) throws SQLException {

        Connection conn = conexao.ConexaoBD.conexaoBD();

        preparedStatement = conn.prepareStatement("INSERT INTO listadecompras (itens) VALUES (?)");
        preparedStatement.setString(1, produtos);


    }
    
}
