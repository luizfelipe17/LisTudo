package listudo;

import java.util.ArrayList;
import java.util.Scanner;

public class LisTudo implements I_LisTudo {

    Scanner ler = new Scanner(System.in);

    @Override
    public void telaInicial(ArrayList<String> listaCompras) { // MENU PRINCIPAL
        
        boolean continuar = true;
        
        while(continuar) {
            
            try{
                
                System.out.println("MENU");
                System.out.println("1 - ADICIONAR ITENS");
                System.out.println("2 - CONSULTAR LISTA");
                System.out.println("3 - IR AO MERCADO");
                System.out.println("4 - SAIR");
                System.out.print("INFORME: ");
                int opcao = ler.nextInt();

                opcoes(opcao, listaCompras);
            
            
            } catch (Exception e){
            
                System.out.println("\nOCORREU UM ERRO, TENTE NOVAMENTE!!\n");
                ler.next();
                
            }   
        }
    }
    
    @Override
    public void opcoes(int opcao, ArrayList<String> listaCompras) {

        ConsultarLista consulta = new ConsultarLista();

        try {
            
            switch (opcao) {
            
                case 1: // CRIAR NOVA LISTA

                    AdicionarProduto addProduto = new AdicionarProduto();
                    addProduto.adicionarProdutos(listaCompras);
                    break;

                case 2: // CONSULTAR ITENS DA LISTA

                    consulta.consultarItens(listaCompras);

                    System.out.println("\n1 - VOLTAR  /  2 - ADICIONAR  / 3 - DELETAR ITEM / 4 - DELETAR LISTA");
                    int opcaoConsultarItem = ler.nextInt();

                    consulta.opcoesConsultarItens(opcaoConsultarItem, listaCompras);
                    break;

                case 3: // IR AO MERCADO

                    consulta.consultarItens(listaCompras);
                    consulta.itensComprados(listaCompras);
                    break;

                case 4: // SAIR

                    System.out.println("\nATÉ A PRÓXIMA :)");
                    System.exit(0);
                    break;

                default:

                    System.out.println("\nINFORME UM VALOR VÁLIDO\n");
                    telaInicial(listaCompras); //VOLTAR PARA A TELA INICIAL EM CASO DE UM VALOR INVALIDO
                    break;
            }
            
        } catch (Exception e) {
                            
            System.out.println("\nOCORREU UM ERRO, TENTE NOVAMENTE!!\n");
            ler.next();
                    
        }
            
    }
}
