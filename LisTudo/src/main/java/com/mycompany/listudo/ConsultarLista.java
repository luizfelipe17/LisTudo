package com.mycompany.listudo;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsultarLista {

    public static void ConsultarItens(Scanner ler, AdicionarProduto addProdutos, ArrayList<String> listaCompras, LisTudo lista, ConsultarLista consultarLista) {

        int contador = 0;

        if (listaCompras.size() > 0) {

            System.out.println("\nItens da lista: ");

            for (String item : listaCompras) {

                System.out.println((contador + 1) + " " + item);
                contador++;

            }

        } else {

            System.out.println("\nNão foi encontrada um lista.\n");
            lista.TelaInicial(ler, lista, addProdutos, consultarLista, listaCompras);

        }

    }

    public static void OpcoesConsultarItens(Scanner ler, AdicionarProduto addProdutos, ArrayList<String> listaCompras, LisTudo lista, ConsultarLista consultarLista, int opcao) {

        if (opcao == 1) {

            lista.TelaInicial(ler, lista, addProdutos, consultarLista, listaCompras);

        } else if (opcao == 2) {

            ler.nextLine();
            addProdutos.AddItens(ler, listaCompras, addProdutos, lista, consultarLista);

        } else if (opcao == 3) {

            System.out.print("Qual Item deseja excluir? ");
            int opcaoNumeroExcluir = ler.nextInt();

            System.out.println("\n" + (listaCompras.get(opcaoNumeroExcluir - 1)) + " ITEM REMOVIDO\n");

            listaCompras.remove(opcaoNumeroExcluir - 1);

            lista.TelaInicial(ler, lista, addProdutos, consultarLista, listaCompras);

        }

    }

    public static void ItensComprados(Scanner ler, ArrayList<String> listaCompras, ConsultarLista consultarLista, AdicionarProduto addProdutos, LisTudo lista) {

        int numeroEscolhido = 1;
        int i = 0;
        double precoCompra = 0;

        while (numeroEscolhido != 0) {

            System.out.println("0 - SAIR");
            System.out.print("\nQual item: ");
            numeroEscolhido = ler.nextInt();

            if (numeroEscolhido != 0) {

                listaCompras.remove(numeroEscolhido - 1);

                System.out.print("Valor Unitario: R$");
                double valorItem = ler.nextDouble();
                System.out.print("Quantidade: ");
                int qtdItem = ler.nextInt();

                double valorTotal = valorItem * qtdItem;

                precoCompra += valorTotal;

                i++;

                consultarLista.ConsultarItens(ler, addProdutos, listaCompras, lista, consultarLista);

            }

        }

        consultarLista.precoTotal(ler, precoCompra, listaCompras, addProdutos, lista, consultarLista);

    }

    public static void precoTotal(Scanner ler, double precoCompra, ArrayList<String> listaCompras, AdicionarProduto addProdutos, LisTudo lista, ConsultarLista consultarLista) {

        System.out.printf("\nValor total da compra foi de R$%.2f", precoCompra);
        System.out.print(", pague no caixa!!!\n");

        consultarLista.validarLista(ler, precoCompra, listaCompras, addProdutos, lista, consultarLista);

    }

    public static void validarLista(Scanner ler, double precoCompra, ArrayList<String> listaCompras, AdicionarProduto addProdutos, LisTudo lista, ConsultarLista consultarLista) {

        if (listaCompras.size() > 0) {

            System.out.println("\nPENDENTES: ");
            consultarLista.ConsultarItens(ler, addProdutos, listaCompras, lista, consultarLista);
            System.out.println("");

        }

        System.out.println("9 - Realizar novamente  /  0 - SAIR");
        int opcao = ler.nextInt();
        System.out.println("");

        if (opcao == 9) {

            lista.TelaInicial(ler, lista, addProdutos, consultarLista, listaCompras);

        } else if (opcao == 0) {

            System.out.println("ATÉ A PROXÍMA :)");
            System.exit(0);

        } else {

            System.out.print("INFORME UM VALOR VÁLIDO");
            consultarLista.validarLista(ler, precoCompra, listaCompras, addProdutos, lista, consultarLista);

        }

    }

}
