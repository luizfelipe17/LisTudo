package interfaces;

import dao.ListaDAO;
import metodos.LoginMetodos;

public interface I_Sistema {

    public void telaInicial(LoginMetodos loginMetodos, ListaDAO listaDAO);

    public void opcoes(int opcao, LoginMetodos loginMetodos, ListaDAO listaDAO);

    public void consultarItens(LoginMetodos loginMetodos, ListaDAO listaDAO);

    public void opcoesConsultarItens(int opcao, LoginMetodos loginMetodos, ListaDAO listaDAO);

    public void irAoMercado(LoginMetodos loginMetodos, ListaDAO listaDAO);

    public void novaListaCesta(LoginMetodos loginMetodos, ListaDAO listaDAO);

    public void addProdutos(LoginMetodos loginMetodos, ListaDAO listaDAO);

}
