package listudo;

import dao.ListaDAO;
import interfaces.I_ConsultarLista;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import metodos.*;

public class ConsultarLista implements I_ConsultarLista {

    Scanner ler = new Scanner(System.in);
    LisTudo lista = new LisTudo();
    MetodosBD metodosBD = new MetodosBD();
    ListaDAO listaDAO = new ListaDAO();

    @Override
    public void consultarItens(ArrayList<String> listaCompras) {

        int contador = 0;

        try {
            
            listaDAO.imprimirLista();

//            if () { //CASO NÃO TENHA NENHUM VALOR DENTRO DO ARRAYLIST O MESMO INFORMA O ERRO
//
//                System.out.println("\nNão foi encontrada um lista.\n");
//                lista.telaInicial(listaCompras); //VOLTAR PARA A TELA INICIAL
//            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarLista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void opcoesConsultarItens(int opcao, ArrayList<String> listaCompras) {

        switch (opcao) {

            case 1: // VOLTAR PARA O MENU PRINCIPAL

                lista.telaInicial(listaCompras);
                break;

            case 2: // ADICIONAR MAIS ITENS NA LISTA

                AdicionarProduto addProduto = new AdicionarProduto();
                addProduto.addItens(listaCompras);
                break;

            case 3: // REMOVER ITEM DA LISTA

                try {

                    System.out.println("Qual Item deseja excluir? (INFORME O NÚMERO)");
                    int opcaoNumeroExcluir = ler.nextInt();

                    metodosBD.setId(opcaoNumeroExcluir);

                    listaDAO.deleteItem(String.valueOf(metodosBD.getId()));

                    JOptionPane.showMessageDialog(null, "ITEM EXCLUIDO!!");

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR O PRODUTO!!");

                } finally {

                    lista.telaInicial(listaCompras); //VOLTAR PARA A TELA INICIAL
                    break;

                }

            case 4:

                try {

                    listaDAO.deleteLista();
                    JOptionPane.showMessageDialog(null, "LISTA DELETADA COM SUCESSO!");

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR A LISTA!!");

                }

                lista.telaInicial(listaCompras);
                break;

            default:

                JOptionPane.showMessageDialog(null, "INFORME UM VÁLOR VÁLIDO");
                lista.telaInicial(listaCompras);

        }

    }

    @Override
    public void itensComprados(ArrayList<String> listaCompras) {

        int numeroEscolhido;
        int contador = 0;
        double precoCompra = 0;

        do { // LAÇO DE REPETIÇÃO PARA ADIÇÃO DE ITENS AO ARRAYLIST

            System.out.println("0 - SAIR");
            System.out.print("\nQual item: ");
            numeroEscolhido = ler.nextInt();

            if (numeroEscolhido != 0) {

                listaCompras.remove(numeroEscolhido - 1);

                System.out.print("Valor Unitario: R$");
                double valorItem = ler.nextDouble();
                System.out.print("Quantidade: ");
                int qtdItem = ler.nextInt();

                double valorTotal = valorItem * qtdItem; //VALOR TOTAL DA COMPRA FEITA PELO USUARIO

                precoCompra += valorTotal;

                contador++;

                consultarItens(listaCompras);

            }

        } while (numeroEscolhido != 0);

        precoTotal(precoCompra, listaCompras);

    }

    @Override
    public void precoTotal(double precoCompra, ArrayList<String> listaCompras) {

        System.out.printf("\nValor total da compra foi de R$%.2f", precoCompra);
        System.out.print(", pague no caixa!!!\n");

        validarLista(precoCompra, listaCompras);

    }

    @Override
    public void validarLista(double precoCompra, ArrayList<String> listaCompras) {

        if (listaCompras.size() > 0) { //IMPRIME ITENS QUE ESTÃO PENDENTES NO ARRAYLIST CASO HAJA

            System.out.println("\nPENDENTES: ");
            consultarItens(listaCompras);
            System.out.println("");

        }

        System.out.println("9 - VOLTAR  /  0 - SAIR DO PROGRAMA");
        int opcao = ler.nextInt();
        System.out.println("");

        switch (opcao) {

            case 9:

                lista.telaInicial(listaCompras);
                break;

            case 0:

                System.out.println("ATÉ A PRÓXIMA :)");
                break;

            default:

                System.out.print("INFORME UM VALOR VÁLIDO");
                validarLista(precoCompra, listaCompras);
                break;

        }

    }

}
