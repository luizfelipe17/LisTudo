package listudo;

import interfaces.I_ConsultarLista;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsultarLista implements I_ConsultarLista {

    Scanner ler = new Scanner(System.in);
    LisTudo lista = new LisTudo();

    @Override
    public void consultarItens(ArrayList<String> listaCompras) {

        int contador = 0;

        if (listaCompras.size() > 0) { //IMPRIME TODO O ARRAYLIST CASO O MESMO SEJA DE TAMANHO MAIOR QUE 0

            System.out.println("\nItens da lista: ");

            for (String item : listaCompras) {

                System.out.println((contador + 1) + " " + item);
                contador++;

            }

        } else { //CASO NÃO TENHA NENHUM VALOR DENTRO DO ARRAYLIST O MESMO INFORMA O ERRO

            System.out.println("\nNão foi encontrada um lista.\n");
            lista.telaInicial(listaCompras); //VOLTAR PARA A TELA INICIAL

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

                System.out.println("Qual Item deseja excluir? (INFORME O NÚMERO)");
                int opcaoNumeroExcluir = ler.nextInt();

                System.out.println("\n" + (listaCompras.get(--opcaoNumeroExcluir)) + " ITEM REMOVIDO\n"); //ITEM EXCLUIDO DENTRO DO ARRAYLIST

                listaCompras.remove(opcaoNumeroExcluir);

                lista.telaInicial(listaCompras); //VOLTAR PARA A TELA INICIAL
                break;
                
            case 4:
                
                listaCompras.clear();
                System.out.println("\nLISTA DELETADA COM SUCESSO!");
                break;
                
            default: 
                
                System.out.println("\nINFORME UM VÁLOR VÁLIDO\n");
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
