package dao;

import conexao.LoginMetodos;
import conexao.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroDAO {

    public String cadastrarUsuario(LoginMetodos login) throws SQLException {

        Connection conn = ConexaoBD.conexaoBD();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        boolean validacaoUsuario = false;
        boolean validacaoEmail = false;
        String validacaoCadastro = "";

        try {

            preparedStatement = conn.prepareStatement("SELECT * FROM loginlistudo.login WHERE nome_usuario = ?");
            preparedStatement.setString(1, login.getNomeUsuario());
            rs = preparedStatement.executeQuery();

            if (rs.next()) {

                validacaoUsuario = true;

            }

            rs.close();
            preparedStatement.close();

            preparedStatement = conn.prepareStatement("SELECT * FROM loginlistudo.login WHERE email = ?");
            preparedStatement.setString(1, login.getEmail());
            rs = preparedStatement.executeQuery();

            if (rs.next()) {

                validacaoEmail = true;

            }

            rs.close();
            preparedStatement.close();

            String nome = login.getNomeUsuario();

            if (!validacaoUsuario && !validacaoEmail) {

                if (login.getNomeUsuario().equals("") 
                        || login.getNome().equals("") 
                        || login.getEmail().equals("") 
                        || login.getSenha().equals("")) {
                    
                    validacaoCadastro = "VALOR NULO";

                } else {

                    String sqlInsert = "INSERT INTO login (nome_usuario, nome, email, senha) VALUES (?, ?, ?, ?)";
                    preparedStatement = conn.prepareStatement(sqlInsert);
                    preparedStatement.setString(1, login.getNomeUsuario());
                    preparedStatement.setString(2, login.getNome());
                    preparedStatement.setString(3, login.getEmail());
                    preparedStatement.setString(4, login.getSenha());
                    preparedStatement.executeUpdate();

                }
                
            } else if (validacaoUsuario && validacaoEmail) {

                validacaoCadastro = "USUARIO E EMAIL EXISTENTE";

            } else if (validacaoUsuario) {

                validacaoCadastro = "USUARIO EXISTENTE";

            } else if (validacaoEmail) {

                validacaoCadastro = "EMAIL EXISTENTE";

            }

        } catch (SQLException e) {

            System.err.println("ERRO NO SQL: " + e);

        } finally {

            if (rs != null) {

                rs.close();

            }

            if (preparedStatement != null) {

                preparedStatement.close();

            }

            if (conn != null) {

                conn.close();

            }

            return validacaoCadastro;

        }

    }
}
