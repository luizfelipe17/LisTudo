package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean validacaoLogin(String nomeUsuario, String senha) throws SQLException {

        Connection conn = conexao.ConexaoBD.conexaoBD();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        boolean validacao = false;

        preparedStatement = conn.prepareStatement("SELECT * FROM loginlistudo.login WHERE nome_usuario = ? and senha = ?");
        preparedStatement.setString(1, nomeUsuario);
        preparedStatement.setString(2, senha);
        
        rs = preparedStatement.executeQuery();

        if (rs.next()) {

            validacao = true;

        }

        return validacao;
        
    }
    
}