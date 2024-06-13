package listudo;

import dao.ListaDAO;
import interfaces.I_ConsultarLista;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import metodos.*;

public class ConsultarLista implements I_ConsultarLista {

    Scanner ler = new Scanner(System.in);
    LisTudo lista = new LisTudo();
    MetodosBD metodosBD = new MetodosBD();
    ListaDAO listaDAO = new ListaDAO();

    @Override
    public void consultarItens() {

        try {

            if (listaDAO.imprimirLista()) {

                listaDAO.imprimirLista();
                
            } else {

                JOptionPane.showMessageDialog(null, "NÃO EXISTE LISTA CRIADA!!");
                lista.telaInicial();

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "ENCONTRAMOS UM ERRO, TENTE NOVAMENTE!!!");

        }

    }

    @Override
    public void opcoesConsultarItens(int opcao) {

        switch (opcao) {

            case 1: // VOLTAR PARA O MENU PRINCIPAL

                lista.telaInicial();
                break;

            case 2: // ADICIONAR MAIS ITENS NA LISTA

                AdicionarProduto addProduto = new AdicionarProduto();
                addProduto.addItens();
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

                    lista.telaInicial(); //VOLTAR PARA A TELA INICIAL
                    break;

                }

            case 4:

                try {

                    listaDAO.deleteLista();
                    JOptionPane.showMessageDialog(null, "LISTA DELETADA COM SUCESSO!");

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR A LISTA!!");

                }

                lista.telaInicial();
                break;

            default:

                JOptionPane.showMessageDialog(null, "INFORME UM VÁLOR VÁLIDO");
                lista.telaInicial();

        }

    }

    @Override
    public void itensComprados() {

        int numeroEscolhido;
        int contador = 0;
        double precoCompra = 0;

        try {

            do { // LAÇO DE REPETIÇÃO PARA ADIÇÃO DE ITENS AO ARRAYLIST

                System.out.println("0 - SAIR");
                System.out.print("\nQual item: ");
                numeroEscolhido = ler.nextInt();

                metodosBD.setId(numeroEscolhido);

                if (numeroEscolhido != 0) {

                    listaDAO.deleteItem(String.valueOf(metodosBD.getId()));

                    System.out.print("Valor Unitario: R$");
                    double valorItem = ler.nextDouble();
                    System.out.print("Quantidade: ");
                    int qtdItem = ler.nextInt();

                    double valorTotal = valorItem * qtdItem; //VALOR TOTAL DA COMPRA FEITA PELO USUARIO

                    precoCompra += valorTotal;

                    contador++;

                    consultarItens();

                }

            } while (numeroEscolhido != 0);

            precoTotal(precoCompra);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "ENCONTRAMOS UM ERRO, TENTE NOVAMENTE!!!");

        }

    }

    @Override
    public void precoTotal(double precoCompra) {

        System.out.printf("\nValor total da compra foi de R$%.2f", precoCompra);
        System.out.print(", pague no caixa!!!\n");

        validarLista(precoCompra);

    }

    @Override
    public void validarLista(double precoCompra) {

        try {

            if (listaDAO.imprimirLista()) { //IMPRIME ITENS QUE ESTÃO PENDENTES NO ARRAYLIST CASO HAJA

                System.out.println("\nPENDENTES: ");
                listaDAO.imprimirLista();

            }

            System.out.println("9 - VOLTAR  /  0 - SAIR DO PROGRAMA");
            int opcao = ler.nextInt();
            System.out.println("");

            switch (opcao) {

                case 9:

                    lista.telaInicial();
                    break;

                case 0:

                    System.out.println("ATÉ A PRÓXIMA :)");
                    break;

                default:

                    System.out.print("INFORME UM VALOR VÁLIDO");
                    validarLista(precoCompra);
                    break;

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ENCONTRAMOS UM ERRO, TENTE NOVAMENTE!!!");

        }

    }

}
