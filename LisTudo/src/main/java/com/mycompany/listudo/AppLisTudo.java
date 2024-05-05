package com.mycompany.listudo;

import java.util.ArrayList;
import java.util.Scanner;

public class AppLisTudo {

    public static void main(String[] args) {

        ArrayList<String> listaCompras = new ArrayList<String>();
        ConsultarLista consultarLista = new ConsultarLista();
        AdicionarProduto addProdutos = new AdicionarProduto();
        LisTudo lista = new LisTudo();
        Scanner ler = new Scanner(System.in);

        System.out.println("REGISTRO");
        System.out.print("USUARIO: ");
        String usuario = ler.nextLine();

        lista.setNome(usuario);

        System.out.print("SENHA: ");
        int senha = ler.nextInt();

        System.out.println("");

        System.out.println("Bem vindo, " + lista.getNome() + "!!!");
        lista.TelaInicial(ler, lista, addProdutos, consultarLista, listaCompras);

    }
}
