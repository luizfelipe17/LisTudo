package listudo;

import interfaces.I_LisTudo;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class LisTudo implements I_LisTudo {

    Scanner ler = new Scanner(System.in);

    @Override
    public void telaInicial() {

        boolean continuar = true;
        int opcao = 0;

        while (continuar) {

            try {

                System.out.println("MENU");
                System.out.println("1 - ADICIONAR ITENS");
                System.out.println("2 - CONSULTAR LISTA");
                System.out.println("3 - IR AO MERCADO");
                System.out.println("4 - SAIR");
                System.out.print("INFORME: ");
                opcao = ler.nextInt();

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "OCORREU UM ERRO, TENTE NOVAMENTE!!");
                System.out.println("");
                ler.next();

            } 
        }
    }

    @Override
    public void opcoes(int opcao) {

        ConsultarLista consulta = new ConsultarLista();

        try {

            switch (opcao) {

                case 1: // CRIAR NOVA LISTA

                    AdicionarProduto addProduto = new AdicionarProduto();
                    addProduto.adicionarProdutos();
                    break;

                case 2: // CONSULTAR ITENS DA LISTA

                    int opcaoConsultarItem = 0;
                    
                    try {

                        consulta.consultarItens();

                        System.out.println("\n1 - VOLTAR  /  2 - ADICIONAR  / 3 - DELETAR ITEM / 4 - DELETAR LISTA");
                        opcaoConsultarItem = ler.nextInt();

                        consulta.opcoesConsultarItens(opcaoConsultarItem);

                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(null, "OCORREU UM ERRO, TENTE NOVAMENTE!!");
                        ler.next();

                    } finally {

                        break;

                    }

                case 3: // IR AO MERCADO

                    consulta.consultarItens();
                    consulta.itensComprados();
                    break;

                case 4: // SAIR

                    System.out.println("\nATÉ A PRÓXIMA :)");
                    System.exit(0);
                    break;

                default:

                    System.out.println("\nINFORME UM VALOR VÁLIDO\n");
                    telaInicial(); //VOLTAR PARA A TELA INICIAL EM CASO DE UM VALOR INVALIDO
                    break;
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO, TENTE NOVAMENTE!!" + e);
            telaInicial();
            ler.next();

        }

    }
}
