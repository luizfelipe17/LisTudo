package dao;

import metodos.LoginMetodos;
import conexao.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroDAO {

    public String cadastrarUsuario(LoginMetodos login) throws SQLException {

        Connection conn = ConexaoBD.conexaoBD();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean validacaoUsuario = false;
        boolean validacaoEmail = false;
        String validacaoCadastro = "";

        try {

            stmt = conn.prepareStatement("SELECT * FROM loginlistudo.login WHERE nome_usuario = ?");
            stmt.setString(1, login.getNomeUsuario());
            rs = stmt.executeQuery();

            if (rs.next()) {

                validacaoUsuario = true;

            }

            rs.close();
            stmt.close();

            stmt = conn.prepareStatement("SELECT * FROM loginlistudo.login WHERE email = ?");
            stmt.setString(1, login.getEmail());
            rs = stmt.executeQuery();

            if (rs.next()) {

                validacaoEmail = true;

            }

            rs.close();
            stmt.close();

            String nome = login.getNomeUsuario();

            if (!validacaoUsuario && !validacaoEmail) {

                if (login.getNomeUsuario().equals("") 
                        || login.getNome().equals("") 
                        || login.getEmail().equals("") 
                        || login.getSenha().equals("")) {
                    
                    validacaoCadastro = "VALOR NULO";

                } else {

                    String sqlInsert = "INSERT INTO login (nome_usuario, nome, email, senha) VALUES (?, ?, ?, ?)";
                    stmt = conn.prepareStatement(sqlInsert);
                    stmt.setString(1, login.getNomeUsuario());
                    stmt.setString(2, login.getNome());
                    stmt.setString(3, login.getEmail());
                    stmt.setString(4, login.getSenha());
                    stmt.executeUpdate();

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

            ConexaoBD.closeRs(conn, stmt, rs);

            return validacaoCadastro;

        }

    }
}
