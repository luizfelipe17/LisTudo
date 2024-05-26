package com.mycompany.listudo;

import java.util.ArrayList;

public interface I_AdicionarProduto {
    
    public void adicionarProdutos(ArrayList<String> listaCompras);
    public void opcoesAdicionarProdutos(int opcao, ArrayList<String> listaCompras);
    public void novaLista(ArrayList<String> listaCompras);
    public void novaListaCesta(ArrayList<String> listaCompras);
    public void addItens(ArrayList<String> listaCompras);
    
}
