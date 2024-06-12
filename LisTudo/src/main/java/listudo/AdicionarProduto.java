package listudo;

import interfaces.I_AdicionarProduto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import dao.listaDAO;
import javax.swing.JOptionPane;
import metodos.*;

public class AdicionarProduto implements I_AdicionarProduto {

    Scanner ler = new Scanner(System.in);
    LisTudo lista = new LisTudo();
    listaDAO listaDB = new listaDAO();
    MetodosBD metodosBD = new MetodosBD();

    public void adicionarProdutos(ArrayList<String> listaCompras) {

        try {

            System.out.println("\nAdicionar Produtos\n");
            System.out.println("1 - Criar Nova Lista");
            System.out.println("2 - Criar Nova Lista (CESTA BASICA)");
            System.out.print("INFORME: ");
            int opcao = ler.nextInt();

            opcoesAdicionarProdutos(opcao, listaCompras);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "INFORME UM VÁLOR VÁLIDO");

        } finally {

            adicionarProdutos(listaCompras);
            
        }

    }

    @Override
    public void opcoesAdicionarProdutos(int opcao, ArrayList<String> listaCompras) {

        switch (opcao) {

            case 1:

                novaLista(listaCompras);
                break;

            case 2:

                novaListaCesta(listaCompras);
                break;

            default:

                JOptionPane.showMessageDialog(null, "INFORME UM VALOR VÁLIDO");
                adicionarProdutos(listaCompras);
                break;

        }
    }

    @Override
    public void novaLista(ArrayList<String> listaCompras) { // VALIDAÇÃO CASO JÁ EXISTA COM ARRAY COM ALGUM ITEM, NÃO SENDO PERMITIDO CRIAR OUTRO

        if (listaCompras.size() == 0) {

            ler.nextLine();
            addItens(listaCompras);

        } else {

            JOptionPane.showMessageDialog(null, "JÁ EXISTE UMA LISTA CRIADA!!");
            lista.telaInicial(listaCompras);

        }
    }

    @Override
    public void novaListaCesta(ArrayList<String> listaCompras) {

        if (listaCompras.size() == 0) { //CRIAÇÃO DE UM NOVO ARRAYLIST, COM INCREMENTO DE ITENS PERTENCENTES A CESTA BASICA

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

            if (opcao.equalsIgnoreCase("SIM")) { //VALIDAÇÃO PARA CASO O MESMO QUEIRA ADICIONAR MAIS ITENS

                addItens(listaCompras);

            } else {

                System.out.println("");
                lista.telaInicial(listaCompras);

            }

        } else {

            JOptionPane.showMessageDialog(null, "JÁ EXISTE UMA LISTA CRIADA!!");
            lista.telaInicial(listaCompras);

        }

    }

    @Override
    public void addItens(ArrayList<String> listaCompras) {

        String produtos;
        int contador = 0;

        try {

            do {

                System.out.print("Q - SAIR / Item " + (contador + 1) + ": ");
                produtos = ler.nextLine();

                metodosBD.setItens(produtos);

                if (!produtos.equalsIgnoreCase("Q")) {

                    listaDB.addItensBD(metodosBD.getItens());

                } else {

                    System.out.println("");
                    lista.telaInicial(listaCompras);

                }

            } while (!produtos.equalsIgnoreCase("Q"));

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "ERRO AO ADICIONAR O PRODUTO");

        } finally {

            contador++;

        }

    }

}
