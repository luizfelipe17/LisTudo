package listudo;

import conexao.ConexaoBD;
import frmtelalogin.FrmViewLogin;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppLisTudo {
    
    public static void main(String[] args) throws SQLException {
        
        FrmViewLogin viewLogin = new FrmViewLogin();
        ConexaoBD conexao = new ConexaoBD();
        
        conexao.conexaoBD();
        viewLogin.setVisible(true);
        
    }
}
