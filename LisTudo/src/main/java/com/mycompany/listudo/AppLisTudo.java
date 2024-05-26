package com.mycompany.listudo;

import conexao.LoginMetodos;
import frmtelalogin.FrmViewLogin;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.text.View;

public class AppLisTudo {

    public static void main(String[] args) {

        ArrayList<String> listaCompras = new ArrayList<String>();
        ArrayList<Double> valorCompra = new ArrayList<Double>();
        LisTudo lista = new LisTudo();
        FrmViewLogin viewLogin = new FrmViewLogin();
        LoginMetodos login = new LoginMetodos();
        
        viewLogin.setVisible(true);
        
        System.out.println("Boa Vindas, " + login.getNome() + "!!!");
        
        lista.telaInicial(listaCompras);
        

    }
}
