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
    public void consultarItens(LoginMetodos loginMetodos) {

        try {

            listaDAO.verificarItensLista(true, loginMetodos);
          
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "ENCONTRAMOS UM ERRO, TENTE NOVAMENTE!!!");

        }

    }

   
    @Override
    public void opcoesConsultarItens(int opcao, LoginMetodos loginMetodos) {

        switch (opcao) {

            case 1: // VOLTAR PARA O MENU PRINCIPAL

                lista.telaInicial(loginMetodos);
                break;

            case 2: // ADICIONAR MAIS ITENS NA LISTA

                AdicionarProduto addProduto = new AdicionarProduto();
                addProduto.addItens(loginMetodos);
                break;

            case 3: // REMOVER ITEM DA LISTA

                try {

                    System.out.println("Qual Item deseja excluir? (INFORME O NÚMERO)");
                    int opcaoNumeroExcluir = ler.nextInt();

                    metodosBD.setIdItens(opcaoNumeroExcluir);

                    listaDAO.deleteItem(metodosBD.getIdItens());

                    JOptionPane.showMessageDialog(null, "ITEM EXCLUIDO!!");

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR O PRODUTO!!");

                } finally {

                    lista.telaInicial(loginMetodos); //VOLTAR PARA A TELA INICIAL
                    break;

                }

            case 4:

                try {

                    listaDAO.deleteLista(loginMetodos);
                    JOptionPane.showMessageDialog(null, "LISTA DELETADA COM SUCESSO!");

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR A LISTA!!");

                }

                lista.telaInicial(loginMetodos);
                break;

            default:

                JOptionPane.showMessageDialog(null, "INFORME UM VÁLOR VÁLIDO");
                lista.telaInicial(loginMetodos);

        }

    }

    @Override
    public void itensComprados(LoginMetodos loginMetodos) {

        int numeroEscolhido;

        try {

            do { 

                System.out.println("0 - SAIR");
                System.out.print("\nQual item: ");
                numeroEscolhido = ler.nextInt();

                metodosBD.setIdItens(numeroEscolhido);

                if (numeroEscolhido != 0) {

                    System.out.print("Valor Unitario: R$");
                    double valorItem = ler.nextDouble();
                    System.out.print("Quantidade: ");
                    int qtdItem = ler.nextInt();

                    double valorTotalItem = valorItem * qtdItem;

                    listaDAO.precoItensBD(valorTotalItem, metodosBD.getIdItens());

                }

            } while (numeroEscolhido != 0);

            listaDAO.verificarItensLista(true, loginMetodos);
            precoTotal(numeroEscolhido, loginMetodos);
            

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "ENCONTRAMOS UM ERRO, TENTE NOVAMENTE!!!");

        }

    }

    @Override
    public void precoTotal(double precoCompra, LoginMetodos loginMetodos) {

        System.out.printf("\nValor total da compra foi de R$%.2f", precoCompra);
        System.out.print(", pague no caixa!!!\n");

        validarLista(loginMetodos);

    }

    @Override
    public void validarLista(LoginMetodos loginMetodos) {

        try {
            
            System.out.println("\nPENDENTES: ");

            listaDAO.verificarItensLista(false, loginMetodos);

            System.out.println("9 - VOLTAR  /  0 - SAIR DO PROGRAMA");
            int opcao = ler.nextInt();
            System.out.println("");

            switch (opcao) {

                case 9:

                    lista.telaInicial(loginMetodos);
                    break;

                case 0:

                    System.out.println("ATÉ A PRÓXIMA :)");
                    break;

                default:

                    System.out.print("INFORME UM VALOR VÁLIDO");
                    validarLista(loginMetodos);
                    break;

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ENCONTRAMOS UM ERRO, TENTE NOVAMENTE!!!");

        }

    }

}
