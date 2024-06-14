package listudo;

import conexao.ConexaoBD;
import interfaces.I_AdicionarProduto;
import java.sql.SQLException;
import java.util.Scanner;
import dao.ListaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import metodos.*;

public class AdicionarProduto implements I_AdicionarProduto {

    Scanner ler = new Scanner(System.in);
    LisTudo lista = new LisTudo();
    ListaDAO listaBD = new ListaDAO();
    MetodosBD metodosBD = new MetodosBD();
    ConexaoBD conexaoBD = new ConexaoBD();

    public void adicionarProdutos(LoginMetodos loginMetodos) {

        try {

            System.out.println("\nAdicionar Produtos\n");
            System.out.println("1 - Criar Nova Lista");
            System.out.println("2 - Criar Nova Lista (CESTA BASICA)");
            System.out.print("INFORME: ");
            int opcao = ler.nextInt();

            opcoesAdicionarProdutos(opcao, loginMetodos);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "INFORME UM VÁLOR VÁLIDO");

        }

    }

    @Override
    public void opcoesAdicionarProdutos(int opcao, LoginMetodos loginMetodos) {

        switch (opcao) {

            case 1:

                novaLista(loginMetodos);
                break;

            case 2:

                novaListaCesta(loginMetodos);
                break;

            default:

                adicionarProdutos(loginMetodos);
                break;

        }
    }

    @Override
    public void novaLista(LoginMetodos loginMetodos) {

        try {
            
            listaBD.verificarItensLista(false, loginMetodos);

            ler.nextLine();
            addItens(loginMetodos);

        } catch (SQLException ex) {
            Logger.getLogger(AdicionarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void novaListaCesta(LoginMetodos loginMetodos) {

        try {

            listaBD.verificarItensLista(false, loginMetodos);

            System.out.println("Deseja adicionar outros itens? SIM / NAO: ");
            String opcao = ler.next();
            ler.nextLine();

            if (opcao.equalsIgnoreCase("SIM")) { //VALIDAÇÃO PARA CASO O MESMO QUEIRA ADICIONAR MAIS ITENS

                addItens(loginMetodos);

            } else {

                System.out.println("");
                lista.telaInicial(loginMetodos);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO!!!");

        }

    }

    @Override
    public void addItens(LoginMetodos loginMetodos) {

        String produtos;
        int contador = 0;

        try {

            do {

                System.out.print("Q - SAIR / Item " + (contador + 1) + ": ");
                produtos = ler.nextLine();

                metodosBD.setItens(produtos);

                if (!produtos.equalsIgnoreCase("Q")) {

                    listaBD.addItensBD(metodosBD.getItens(), loginMetodos);
                    contador++;

                } else {

                    System.out.println("");
                    lista.telaInicial(loginMetodos);

                }

            } while (!produtos.equalsIgnoreCase("Q"));

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "ERRO AO ADICIONAR O PRODUTO");

        }

    }

}
