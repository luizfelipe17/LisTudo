package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoBD {

    private static final String URL = "jdbc:mysql://localhost:3306/loginlistudo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1704";

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

    public static void closeConexao(Connection conn) {

        try {

            if (conn != null) {

                conn.close();

            }
            
        } catch (SQLException ex) {

            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
            
        }

    }
    
    public static void closeStmt(Connection conn, PreparedStatement stmt) {

        closeConexao(conn);
        
        try {

            if (stmt != null) {

                stmt.close();

            }
            
        } catch (SQLException ex) {

            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
            
        }

    }
    
    public static void closeRs(Connection conn, PreparedStatement stmt, ResultSet rs) {

        closeStmt(conn, stmt);
        
        try {

            if (rs != null) {

                rs.close();

            }
            
        } catch (SQLException ex) {

            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
