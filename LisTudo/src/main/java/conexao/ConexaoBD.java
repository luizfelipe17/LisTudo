package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexaoBD {

    private static final String URL = "jdbc:mysql://localhost:3306/loginlistudo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static Connection conexaoBD() {

        Connection conn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "ERRO NA CONEXÃO COM BANCO DE DADOS: " + erro);

        }

        return conn;
        
    }

}
