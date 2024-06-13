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

    public void adicionarProdutos() {

        try {

            System.out.println("\nAdicionar Produtos\n");
            System.out.println("1 - Criar Nova Lista");
            System.out.println("2 - Criar Nova Lista (CESTA BASICA)");
            System.out.print("INFORME: ");
            int opcao = ler.nextInt();

            opcoesAdicionarProdutos(opcao);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "INFORME UM VÁLOR VÁLIDO");

        }

    }

    @Override
    public void opcoesAdicionarProdutos(int opcao) {

        switch (opcao) {

            case 1:

                novaLista();
                break;

            case 2:

                novaListaCesta();
                break;

            default:

                JOptionPane.showMessageDialog(null, "INFORME UM VALOR VÁLIDO");
                adicionarProdutos();
                break;

        }
    }

    @Override
    public void novaLista() { // VALIDAÇÃO CASO JÁ EXISTA COM ARRAY COM ALGUM ITEM, NÃO SENDO PERMITIDO CRIAR OUTRO

        try {

            if (!listaBD.imprimirLista()) {

                ler.nextLine();
                addItens();

            } else {

                JOptionPane.showMessageDialog(null, "JÁ EXISTE UMA LISTA CRIADA!!");
                lista.telaInicial();

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO!!!");

        }

    }

    @Override
    public void novaListaCesta() {

        try {
            
            if (!listaBD.imprimirLista()) {

                listaBD.listaCestaBasica();

                System.out.println("Deseja adicionar outros itens? SIM / NAO: ");
                String opcao = ler.next();
                ler.nextLine();

                if (opcao.equalsIgnoreCase("SIM")) { //VALIDAÇÃO PARA CASO O MESMO QUEIRA ADICIONAR MAIS ITENS

                    addItens();

                } else {

                    System.out.println("");
                    lista.telaInicial();

                }

            } else {

                JOptionPane.showMessageDialog(null, "JÁ EXISTE UMA LISTA CRIADA!!");
                lista.telaInicial();

            }

        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO!!!");
            
        }

    }

    @Override
    public void addItens() {

        String produtos;
        int contador = 0;

        try {

            do {

                System.out.print("Q - SAIR / Item " + (contador + 1) + ": ");
                produtos = ler.nextLine();

                metodosBD.setItens(produtos);

                if (!produtos.equalsIgnoreCase("Q")) {

                    listaBD.addItensBD(metodosBD.getItens());
                    contador++;

                } else {

                    System.out.println("");
                    lista.telaInicial();

                }

            } while (!produtos.equalsIgnoreCase("Q"));

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "ERRO AO ADICIONAR O PRODUTO");

        } finally {

            addItens();

        }

    }

}
