package dao;

import metodos.LoginMetodos;
import conexao.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroDAO {

    /**
     * Este método valida se os usuários cadastrados já existem. Caso não
     * existam, realiza a inserção do novo usuário no banco de dados.
     */
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

            if (rs.next()) { //VALIDA SE O NOME DE USUARIO JÁ É EXISTENTE NO BANCO DE DADOS

                validacaoUsuario = true; 

            }

            rs.close();
            stmt.close();

            stmt = conn.prepareStatement("SELECT * FROM loginlistudo.login WHERE email = ?");
            stmt.setString(1, login.getEmail());
            rs = stmt.executeQuery();

            if (rs.next()) { //VALIDA SE O EMAIL JÁ É EXISTENTE NO BANDO DE DADOS

                validacaoEmail = true;

            }

            rs.close();
            stmt.close();

            String nome = login.getNomeUsuario();

            if (!validacaoUsuario && !validacaoEmail) { //VALIDA SE O USUARIO DEIXOU DE PREENCHER ALGUM CAMPO

                if (login.getNomeUsuario().equals("")
                        || login.getNome().equals("")
                        || login.getEmail().equals("")
                        || login.getSenha().equals("")) {

                    validacaoCadastro = "VALOR NULO";

                } else { //REALIZA A INSERÇÃO DO NOVO USUARIO NO BANDO DE DADOS

                    String sqlInsert = "INSERT INTO login (nome_usuario, nome, email, senha) VALUES (?, ?, ?, ?)";
                    stmt = conn.prepareStatement(sqlInsert);
                    stmt.setString(1, login.getNomeUsuario());
                    stmt.setString(2, login.getNome());
                    stmt.setString(3, login.getEmail());
                    stmt.setString(4, login.getSenha());
                    stmt.executeUpdate();

                }

            } else if (validacaoUsuario && validacaoEmail) { //CASO O USUARIO E O EMAIL JÁ EXISTAM RETORNA "USUARIO E EMAIL EXISTENTE" 

                validacaoCadastro = "USUARIO E EMAIL EXISTENTE";

            } else if (validacaoUsuario) { //CASO O USUARIO JÁ EXISTAM RETORNA "USUARIO EXISTENTE" 

                validacaoCadastro = "USUARIO EXISTENTE";

            } else if (validacaoEmail) { //CASO O EMAIL JÁ EXISTAM RETORNA "EMAIL EXISTENTE"

                validacaoCadastro = "EMAIL EXISTENTE";

            }

        } catch (SQLException e) {

            System.err.println("ERRO NO SQL: " + e);

        } finally {

            if (rs != null) {

                rs.close();

            }

            if (stmt != null) {

                stmt.close();

            }

            if (conn != null) {

                conn.close();

            }

            return validacaoCadastro;

        }

    }

    /**
     * Metodo no qual será feito a validação do login no banco de dados. Após
     * acessar o banco de dados, será feito a validação se o "nomeUsuario" e
     * "senha" estão presente na tabela "login", caso sim, retorna "true" e
     * permite o acesso do usuario no sistema.
     */
    public boolean validacaoLoginUsuario(String nomeUsuario, String senha, LoginMetodos loginMetodos) throws SQLException {

        Connection conn = conexao.ConexaoBD.conexaoBD();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        boolean validacao = false;

        preparedStatement = conn.prepareStatement("SELECT * FROM loginlistudo.login WHERE nome_usuario = ? and senha = ?");
        preparedStatement.setString(1, nomeUsuario);
        preparedStatement.setString(2, senha);

        rs = preparedStatement.executeQuery();

        if (rs.next()) {

            loginMetodos.setNome(rs.getString(3)); //Armazenando o Nome do usuario.
            loginMetodos.setId(rs.getInt(1)); //Armazenando o ID do usuario que foi gerado através AUTO INCREMENT no banco da dados. 

            validacao = true;

        }

        return validacao;

    }

}
