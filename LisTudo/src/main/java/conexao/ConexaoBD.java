package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexaoBD {
    
    public Connection conexaoBD(){
        
        Connection conn = null;
        
        try {
            
            String url = "jdbc:mysql://localhost:3306/loginlistudo?user=root&password=1704";
            conn = DriverManager.getConnection(url);
           
        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null, "CONEXÃO BANCO DE DADOS: " + erro);
            
        }
        
        return conn;
        
    }
    
}
