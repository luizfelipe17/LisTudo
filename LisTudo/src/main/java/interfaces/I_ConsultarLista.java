package interfaces;

import java.util.ArrayList;


public interface I_ConsultarLista {
    
    public void consultarItens(ArrayList<String> listaCompras);
    public void opcoesConsultarItens(int opcao, ArrayList<String> listaCompras);
    public void itensComprados(ArrayList<String> listaCompras);
    public void precoTotal(double precoCompra, ArrayList<String> listaCompras);
    public void validarLista(double precoCompra, ArrayList<String> listaCompras);
    
}
