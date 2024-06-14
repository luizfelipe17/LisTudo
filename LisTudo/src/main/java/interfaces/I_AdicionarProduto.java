package interfaces;

import metodos.LoginMetodos;

public interface I_AdicionarProduto {
    
    public void adicionarProdutos(LoginMetodos loginMetodos);
    public void opcoesAdicionarProdutos(int opcao, LoginMetodos loginMetodos);
    public void novaLista(LoginMetodos loginMetodos);
    public void novaListaCesta(LoginMetodos loginMetodos);
    public void addItens(LoginMetodos loginMetodos);
    
}
