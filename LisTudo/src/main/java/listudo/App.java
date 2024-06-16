package listudo;

import conexao.ConexaoBD;
import frm_view.FrmViewLogin;

/**
 * Classe main responsável pela execução do aplicativo
 */
public class App {

    public static void main(String[] args) {

        FrmViewLogin viewLogin = new FrmViewLogin();
        ConexaoBD conexao = new ConexaoBD();

            conexao.conexaoBD();
            viewLogin.setVisible(true);
            
    }
}
