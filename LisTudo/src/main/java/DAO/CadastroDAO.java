package DAO;

import conexao.LoginMetodos;
import conexao.ConexaoBD;
import java.sql.PreparedStatement;

public class CadastroDAO {
    
    public void cadastrarUsario(LoginMetodos login){
        
        String sql = "INSERT INTO login (nome_usuario, nome, email, senha) VALUES (?, ?, ?, ?)"; //Comando que será executado no Banco de Dados
        
        PreparedStatement preparedStatement = null;
        
        try {
            
            preparedStatement = ConexaoBD.conexaoBD().prepareStatement(sql);
            
            preparedStatement.setString(1, login.getNomeUsuario());
            preparedStatement.setString(2, login.getNome());
            preparedStatement.setString(3, login.getEmail());
            preparedStatement.setString(4, login.getSenha());   
            
            preparedStatement.execute();
            preparedStatement.close();
            
        } catch (Exception e) {
        }
        
    }
    
}
