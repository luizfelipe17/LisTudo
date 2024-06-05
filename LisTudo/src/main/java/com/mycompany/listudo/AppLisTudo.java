package com.mycompany.listudo;

import conexao.ConexaoBD;
import conexao.LoginMetodos;
import frmtelalogin.FrmViewLogin;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppLisTudo {
    
    public static void main(String[] args) throws SQLException {
        
        
        ArrayList<String> listaCompras = new ArrayList<String>();
        ArrayList<Double> valorCompra = new ArrayList<Double>();
        LisTudo lista = new LisTudo();
        FrmViewLogin viewLogin = new FrmViewLogin();
        
        ConexaoBD conexao = new ConexaoBD();
        
        conexao.conexaoBD();
        
        viewLogin.setVisible(true);
        
    }
}
