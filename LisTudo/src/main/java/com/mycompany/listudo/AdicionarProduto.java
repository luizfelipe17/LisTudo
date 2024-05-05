package com.mycompany.listudo;

import java.util.ArrayList;
import java.util.Scanner;

public class AdicionarProduto {

    public static void AdicionarProdutos(Scanner ler, AdicionarProduto addProdutos, LisTudo lista, ConsultarLista consultarLista, ArrayList<String> listaCompras) {

        System.out.println("\nAdicionar Produtos\n");
        System.out.println("1 - Criar Nova Lista");
        System.out.println("2 - Criar Nova Lista (CESTA BASICA)");
        System.out.print("INFORME: ");
        int opcao = ler.nextInt();

        addProdutos.OpcoesAdicionarProdutos(opcao, lista, ler, addProdutos, consultarLista, listaCompras);

    }

    public static void OpcoesAdicionarProdutos(int opcao, LisTudo lista, Scanner ler, AdicionarProduto addProdutos, ConsultarLista consultarLista, ArrayList<String> listaCompras) {

        if (opcao == 1) {

            addProdutos.NovaLista(ler, addProdutos, lista, consultarLista, listaCompras);

        } else if (opcao == 2) {

            addProdutos.NovaListaCesta(ler, addProdutos, lista, consultarLista, listaCompras);

        } else {

            System.out.print("\nINFORME UM VALOR VÁLIDO\n");
            addProdutos.AdicionarProdutos(ler, addProdutos, lista, consultarLista, listaCompras);

        }

    }

    public static void NovaLista(Scanner ler, AdicionarProduto addProdutos, LisTudo lista, ConsultarLista consultarLista, ArrayList<String> listaCompras) {

        if (listaCompras.size() == 0) {

            ler.nextLine();
            addProdutos.AddItens(ler, listaCompras, addProdutos, lista, consultarLista);

        } else {

            System.out.println("\nJá existe uma lista criada\n");
            lista.TelaInicial(ler, lista, addProdutos, consultarLista, listaCompras);

        }
    }

    public static void NovaListaCesta(Scanner ler, AdicionarProduto addProdutos, LisTudo lista, ConsultarLista consultarLista, ArrayList<String> listaCompras) {

        if (listaCompras.size() == 0) {

            listaCompras.add("Arroz");
            listaCompras.add("Feijão");
            listaCompras.add("Óleo");
            listaCompras.add("Açúcar");
            listaCompras.add("Café");
            listaCompras.add("Sal");
            listaCompras.add("Macarrão");
            listaCompras.add("Leite");

            System.out.println("Deseja adicionar outros itens? SIM / NAO: ");
            String opcao = ler.next();
            ler.nextLine();

            if (opcao.equalsIgnoreCase("SIM")) {

                addProdutos.AddItens(ler, listaCompras, addProdutos, lista, consultarLista);

            } else {

                System.out.println("");
                lista.TelaInicial(ler, lista, addProdutos, consultarLista, listaCompras);

            }

        } else {

            System.out.println("\nJá existe uma lista criada\n");
            lista.TelaInicial(ler, lista, addProdutos, consultarLista, listaCompras);

        }

    }

    public static void AddItens(Scanner ler, ArrayList<String> listaCompras, AdicionarProduto addProdutos, LisTudo lista, ConsultarLista consultarLista) {

        String produtos = "A";
        int contador = 0;

        while (!produtos.equalsIgnoreCase("Q")) {

            System.out.println("\nQ - SAIR");
            System.out.print("Item " + (contador + 1) + ": ");
            produtos = ler.nextLine();

            if (!produtos.equalsIgnoreCase("Q")) {
                listaCompras.add(produtos);
                contador++;
            } else {

                System.out.println("");
                lista.TelaInicial(ler, lista, addProdutos, consultarLista, listaCompras);

            }

        }
    }

}
