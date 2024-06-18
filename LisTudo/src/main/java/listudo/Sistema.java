package listudo;

import dao.ListaDAO;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import metodos.LoginMetodos;
import metodos.Produto;
import interfaces.I_Sistema;

public class Sistema implements I_Sistema {

    Scanner ler = new Scanner(System.in);
    Produto metodosBD = new Produto();

    /**
     * Este método gerencia a tela inicial do sistema. A partir dessa tela, o
     * usuário pode navegar e acessar todas as funcionalidades disponíveis no
     * sistema de forma eficiente e rápida.
     */
    @Override
    public void telaInicial(LoginMetodos loginMetodos, ListaDAO listaDAO) {

        boolean continuar = true;
        int opcao = 0;

        while (continuar) {

            try {

                System.out.println("MENU");
                System.out.println("1 - ADICIONAR ITENS");
                System.out.println("2 - EXIBIR LISTA");
                System.out.println("3 - ADICIONAR CESTA BÁSICA");
                System.out.println("4 - IR AO MERCADO");
                System.out.println("5 - EDITAR ITEM");
                System.out.println("6 - EXCLUIR ITEM");
                System.out.println("7 - SAIR");
                System.out.print("INFORME: ");
                opcao = ler.nextInt();

                opcoes(opcao, loginMetodos, listaDAO);

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "OCORREU UM ERRO, TENTE NOVAMENTE!!!");
                System.out.println("");
                ler.next();

            }
        }
    }

    /**
     * Esse método é responsável por validar a opção selecionada pelo usuário na
     * tela inicial da aplicação. Ele verifica se a escolha é válida e executa
     * as ações correspondentes.
     */
    @Override
    public void opcoes(int opcao, LoginMetodos loginMetodos, ListaDAO listaDAO) {

        switch (opcao) {

            case 1: // ADICIONAR ITENS

                System.out.println("\nITENS:");
                ler.nextLine();
                addProdutos(loginMetodos, listaDAO);
                break;

            case 2: // EXIBIR LISTA

                try {

                    consultarItens(loginMetodos, listaDAO); //REALIZA A VALIDAÇÃO SE JÁ EXISTE LISTA CRIADA
                    System.out.print("\nITENS: ");
                    System.out.print("\n1 - VOLTAR  /  2 - ADICIONAR  / 3 - DELETAR ITEM / 4 - DELETAR LISTA \nINFORME: ");
                    int opcaoConsultarItem = ler.nextInt();

                    opcoesConsultarItens(opcaoConsultarItem, loginMetodos, listaDAO); //VALIDAR A OPÇÃO INFORMADA PELO USUARIO

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "INFORME UM VALOR VÁLIDO!");
                    ler.next();
                    System.out.println("");

                }

                break;

            case 3: // CRIAR LISTA CESTA BASICA ITEM

                novaListaCesta(loginMetodos, listaDAO);
                break;

            case 4: // IR AO MERCADO

                consultarItens(loginMetodos, listaDAO); //REALIZA A VALIDAÇÃO SE JÁ EXISTE LISTA CRIADA
                irAoMercado(loginMetodos, listaDAO);
                break;

            case 5: //EDITAR ITEM

                try {

                    consultarItens(loginMetodos, listaDAO);
                    System.out.print("\nQUAL ITEM DESEJA EDITAR?\nINFORME O NÚMERO: ");
                    int opcaoNumeroExcluir = ler.nextInt();
                    metodosBD.setIdItens(opcaoNumeroExcluir); //ARMAZENAR O ID DO ITEM
                    ler.nextLine();
                    System.out.print("INFORME O NOVO NOME: ");
                    String novoNomeProduto = ler.nextLine();
                    System.out.println("");

                    listaDAO.editarItem(metodosBD.getIdItens(), novoNomeProduto, loginMetodos); //ACESSA O METODO DE DELETE ITENS QUE IRÁ ACESSAR O BANCO DE DADOS

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "HOUVE UM ERRO... FAVOR TENTE NOVAMENTE!");

                }

                break;

            case 6: //EXCLUIR ITEM

                opcoesConsultarItens(3, loginMetodos, listaDAO);
                break;

            case 7: // SAIR

                System.out.println("\nATÉ A PRÓXIMA :)");
                System.exit(0);
                break;

            default:

                JOptionPane.showMessageDialog(null, "INFORME UM VALOR VÁLIDO!");
                System.out.println("");
                telaInicial(loginMetodos, listaDAO); //VOLTAR PARA A TELA INICIAL EM CASO DE UM VALOR INVALIDO
                break;
        }

    }

    /**
     * Este metodo tem a funcao de apresentar uma lista pre-definida de produtos
     * considerados "essenciais", para que o usuario consiga adiciona-los de uma
     * vez.Antes de finalizar a execucao do metodo, o programa pergunta ao
     * usuario se deseja adicionar mais algum item personalizado na lista,
     * atraves do metodo addProdutos().
     */
    @Override
    public void novaListaCesta(LoginMetodos loginMetodos, ListaDAO listaDAO) {

        try {

            listaDAO.verificarItensLista(false, loginMetodos, listaDAO); //ACESSA A VALIDAÇÃO SE JÁ EXISTE LISTA CRIADA

            String itensCesta[] = {"Arroz", "Feijão", "Óleo", "Açúcar", "Café", "Sal", "Macarrão", "Leite"};

            System.out.println("ITENS CESTA BÁSICA:");

            for (String itens : itensCesta) { //IMPRIME AS OPÇÕES QUE SERÃO ADICIONADAS NA LISTA CESTA BASICA

                System.out.println(itens);

            }

            System.out.print("\nDESEJA ADICIONAR OS ITENS ACIMA?\n1 - SIM / 2 - NÃO\nINFORME: ");
            int opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) { //VALIDA SE O USUARIO DESEJA CONTINUAR

                case 1: //SIM

                    listaDAO.listaCestaBasica(loginMetodos); //ACESSA O METODO QUE INCLUI OS ITENS NA LISTA
                    listaDAO.verificarItensLista(true, loginMetodos, listaDAO); //IMPRIME TODOS OS ITENS ADICIONADOS

                    System.out.print("\nDESEJA ADICIONAR MAIS ITENS?\n1 - SIM / 2 - NÃO\nINFORME: ");
                    opcao = ler.nextInt();

                    if (opcao == 1) { //VALIDA SE VAI ADICIONAR MAIS ITENS

                        addProdutos(loginMetodos, listaDAO); //ACESSA O METODO PARA ADICIONAR MAIS ITENS A LISTA

                    } else if (opcao == 2) {

                        System.out.println("");
                        telaInicial(loginMetodos, listaDAO);

                    } else {

                        JOptionPane.showMessageDialog(null, "INFORME UM VALOR VÁLIDO!");
                        System.out.println("");

                    }

                    break;

                case 2://NÃO

                    System.out.println("\nNOVA LISTA: ");
                    addProdutos(loginMetodos, listaDAO);
                    break;

                default:

                    JOptionPane.showMessageDialog(null, "INFORME UM VALOR VÁLIDO!");
                    System.out.println("");
                    break;

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO!!!");

        }

    }

    /**
     * Esse método é responsável por adicionar produtos a uma lista existente.
     * Ele recebe os detalhes do produto como entrada e os insere na lista,
     * garantindo que os produtos sejam corretamente armazenados.
     */
    @Override
    public void addProdutos(LoginMetodos loginMetodos, ListaDAO listaDAO) {

        String produtos;
        int contador = 0;

        try {

            do {

                System.out.print("Q - SAIR / Item " + (contador + 1) + ": ");
                produtos = ler.nextLine();

                metodosBD.setItens(produtos); //ARMAZENA O NOME DO PRODUTO

                if (!produtos.equalsIgnoreCase("Q")) {

                    listaDAO.addItensBD(metodosBD.getItens(), loginMetodos); //ACESSA O METODO PARA ADICIONAR OS ITENS AO BANCO DE DADOS
                    contador++;

                } else {

                    System.out.println("");
                    telaInicial(loginMetodos, listaDAO);

                }

            } while (!produtos.equalsIgnoreCase("Q"));

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "ERRO AO ADICIONAR O PRODUTO");

        }

    }

    /**
     * Esse método é responsável por verificar se uma lista já foi criada. Se a
     * lista existir, o método a imprime.
     */
    @Override
    public void consultarItens(LoginMetodos loginMetodos, ListaDAO listaDAO) {

        try {

            listaDAO.verificarItensLista(true, loginMetodos, listaDAO); //VALIDAR SE A LISTA EXISTE E IMPRIMI-LA

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "ENCONTRAMOS UM ERRO, TENTE NOVAMENTE!!!");

        }

    }

    /**
     * Esse método é responsável por validar a opção selecionada pelo usuário no
     * método "OPÇÔES" classe "LISTUDO" da aplicação. Ele verifica se a escolha
     * é válida e executa as ações correspondentes.
     */
    @Override
    public void opcoesConsultarItens(int opcao, LoginMetodos loginMetodos, ListaDAO listaDAO) {

        switch (opcao) {

            case 1: // VOLTAR PARA O MENU PRINCIPAL

                System.out.println("");
                telaInicial(loginMetodos, listaDAO);
                break;

            case 2: // ADICIONAR MAIS ITENS NA LISTA

                System.out.println("");
                ler.nextLine();
                addProdutos(loginMetodos, listaDAO);
                break;

            case 3: // REMOVER ITEM DA LISTA

                try {

                    consultarItens(loginMetodos, listaDAO);
                    System.out.print("\nQual Item deseja excluir?\nINFORME O NÚMERO: ");
                    int opcaoNumeroExcluir = ler.nextInt();
                    System.out.println("");
                    metodosBD.setIdItens(opcaoNumeroExcluir); //ARMAZENAR O ID DO ITEM

                    listaDAO.deleteItem(metodosBD.getIdItens(), loginMetodos); //ACESSA O METODO DE DELETE ITENS QUE IRÁ ACESSAR O BANCO DE DADOS

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "HOUVE UM ERRO... FAVOR TENTE NOVAMENTE!");

                }

                break;

            case 4: //DELETAR LISTA COMPLETA

                try {

                    System.out.print("\nTEM CERTEZA DE DESEJA EXCLUIR?\n1 - SIM / 2 - NÃO\nINFORME: ");
                    int opcaoExcluir = ler.nextInt();
                    System.out.println("");

                    switch (opcaoExcluir) {

                        case 1:

                            listaDAO.deleteLista(loginMetodos); //ACESSA O METODO PARA DELETAR A LISTA TODA NO BANCO DE DADOS
                            JOptionPane.showMessageDialog(null, "LISTA DELETADA COM SUCESSO!");
                            System.out.println("");

                            break;

                        case 2:

                            telaInicial(loginMetodos, listaDAO);

                        default:

                            JOptionPane.showMessageDialog(null, "INFORME UM VALOR VÁLIDO!");
                            ler.next();
                            opcoesConsultarItens(4, loginMetodos, listaDAO);

                    }

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR A LISTA!!");
                    System.out.println("");

                }

                telaInicial(loginMetodos, listaDAO);
                break;

            default:

                JOptionPane.showMessageDialog(null, "INFORME UM VÁLOR VÁLIDO");
                telaInicial(loginMetodos, listaDAO);

        }

    }

    /**
     * Atraves da execucao deste metodo, o usuario consegue adicionar a cada
     * produto o preco encontrado. A partir desta entrada o programa calcula o
     * preco total de cada produto e o preco total da compra do usuario.
     */
    @Override
    public void irAoMercado(LoginMetodos loginMetodos, ListaDAO listaDAO) {

        int numeroEscolhido = 0;

        try {

            do {

                try {

                    System.out.println("\nITENS:");
                    listaDAO.imprimirItensMercado(loginMetodos, listaDAO); //REALIZA A VALIDAÇÃO SE JÁ EXISTE LISTA CRIADA
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

                        listaDAO.precoItensBD(valorTotalItem, metodosBD.getIdItens()); //ACESSA O METODO PARA CALCULAR O VALOR ATRAVÉS DO BANCO DE DADOS

                    }

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "INFORME UM VALOR VÁLIDO!");
                    ler.next();
                    irAoMercado(loginMetodos, listaDAO);
                    System.out.println("");

                }

            } while (numeroEscolhido != 0);

            listaDAO.valorTotalCompra(loginMetodos); //ACESSA O METÓDO PARA INFORMAR O PREÇO TOTAL DA COMPRA

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "ENCONTRAMOS UM ERRO, TENTE NOVAMENTE!!!");
            irAoMercado(loginMetodos, listaDAO);

        }

    }

    /**
     * Este método será utilizado no final do programa para verificar se o
     * usuário deseja sair após finalizar as compras ou se deseja utilizá-lo
     * novamente.
     */
    public void finalizarPrograma(LoginMetodos loginMetodos, ListaDAO listaDAO) {

        int opcao = 0;

        try {

            do {

                System.out.print("9 - NOVA LISTA / 0 - FECHAR PROGRAMA\nINFORME: ");
                opcao = ler.nextInt();

                switch (opcao) {

                    case 9:

                        telaInicial(loginMetodos, listaDAO);

                        break;

                    case 0:

                        System.out.println("\nATÉ A PRÓXIMA :)");
                        System.exit(0);

                    default:

                        JOptionPane.showMessageDialog(null, "INFORME UMA VÁLOR ");

                }

            } while (opcao != 0);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "OCORREU UM ERRO, TENTE NOVAMENTE!!");
            ler.next();
            finalizarPrograma(loginMetodos, listaDAO);

        }

    }

}
