package interfaces;

import metodos.LoginMetodos;

public interface I_ConsultarLista {
    
    public void consultarItens(LoginMetodos loginMetodos);
    public void opcoesConsultarItens(int opcao, LoginMetodos loginMetodos);
    public void itensComprados(LoginMetodos loginMetodos);
    public void precoTotal(double precoCompra, LoginMetodos loginMetodos);
    public void validarLista(LoginMetodos loginMetodos);
    
}
