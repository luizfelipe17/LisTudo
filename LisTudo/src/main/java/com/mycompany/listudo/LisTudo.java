package com.mycompany.listudo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LisTudo {

    private String Nome;

    public String getNome() {

        return Nome;

    }

    public void setNome(String Nome) {

        this.Nome = Nome;

    }

    public static void TelaInicial(Scanner ler, LisTudo lista, AdicionarProduto addProdutos, ConsultarLista consultarLista, ArrayList<String> listaCompras) {

        System.out.println("MENU");
        System.out.println("1 - ADICIONAR ITENS");
        System.out.println("2 - CONSULTAR LISTA");
        System.out.println("3 - IR AO MERCADO");
        System.out.println("4 - SAIR");
        System.out.print("INFORME: ");
        int opcao = ler.nextInt();

        lista.Opcoes(opcao, lista, ler, addProdutos, consultarLista, listaCompras);

    }

    public static void Opcoes(int opcao, LisTudo lista, Scanner ler, AdicionarProduto addProdutos, ConsultarLista consultarLista, ArrayList<String> listaCompras) {

        if (opcao == 1) {

            addProdutos.AdicionarProdutos(ler, addProdutos, lista, consultarLista, listaCompras);

        } else if (opcao == 2) {

            consultarLista.ConsultarItens(ler, addProdutos, listaCompras, lista, consultarLista);

            System.out.println("\n1 - VOLTAR  /  2 - ADICIONAR  / 3 - DELETAR ITEM");
            int opcaoConsultarItem = ler.nextInt();

            consultarLista.OpcoesConsultarItens(ler, addProdutos, listaCompras, lista, consultarLista, opcaoConsultarItem);

        } else if (opcao == 3) {

            consultarLista.ConsultarItens(ler, addProdutos, listaCompras, lista, consultarLista);
            consultarLista.ItensComprados(ler, listaCompras, consultarLista, addProdutos, lista);

        } else if (opcao == 4) {

            System.out.println("\nATÉ A PROXÍMA :)");
            System.exit(0);

        } else {

            System.out.println("\nINFORME UM VALOR VÁLIDO\n");
            lista.TelaInicial(ler, lista, addProdutos, consultarLista, listaCompras);

        }

    }
}
