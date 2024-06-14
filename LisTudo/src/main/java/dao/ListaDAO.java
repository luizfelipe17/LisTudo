package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexao.ConexaoBD;
import javax.swing.JOptionPane;
import listudo.LisTudo;
import metodos.LoginMetodos;

public class ListaDAO {

    ConexaoBD conexao = new ConexaoBD();
    PreparedStatement preparedStatement = null;
    Connection conn = null;
    LisTudo lista = new LisTudo();

    public void addItensBD(String produtos, LoginMetodos loginMetodos) throws SQLException {

        Connection conn = ConexaoBD.conexaoBD();

        preparedStatement = conn.prepareStatement("INSERT INTO listadecompras (itens, preço, id_usuario) VALUES (?, ?, ?)");
        preparedStatement.setString(1, produtos);
        preparedStatement.setDouble(2, 0);
        preparedStatement.setInt(3, loginMetodos.getId());

        preparedStatement.executeUpdate();

    }

    public void listaCestaBasica(LoginMetodos loginMetodos) throws SQLException {

        Connection conn = ConexaoBD.conexaoBD();

        String itensCesta[] = {"Arroz", "Feijão", "Óleo", "Açúcar", "Café", "Sal", "Macarrão", "Leite"};
        int preco = 0;

        preparedStatement = conn.prepareStatement("INSERT INTO listadecompras (itens, preço, id_usuario) VALUES (?, ?, ?)");

        for (String itens : itensCesta) {

            preparedStatement.setString(1, itens);
            preparedStatement.setDouble(2, preco);
            preparedStatement.setInt(3, loginMetodos.getId());
            
            preparedStatement.executeUpdate();

        }

    }

    public void precoItensBD(Double preco, int idItens) throws SQLException {

        Connection conn = ConexaoBD.conexaoBD();

        preparedStatement = conn.prepareStatement("UPDATE listadecompras SET PREÇO = ? WHERE id = ?");
        preparedStatement.setDouble(1, preco);
        preparedStatement.setInt(2, idItens);
        
        preparedStatement.executeUpdate();

    }

    public void deleteItem(int idItens) throws SQLException {

        Connection conn = ConexaoBD.conexaoBD();

        preparedStatement = conn.prepareStatement("DELETE FROM listadecompras WHERE id = ?");
        preparedStatement.setInt(1, idItens);
        preparedStatement.executeUpdate();

    }

    public void deleteLista(LoginMetodos loginMetodos) throws SQLException {

        Connection conn = ConexaoBD.conexaoBD();

        preparedStatement = conn.prepareStatement("DELETE FROM listadecompras WHERE id_usuario = ?");
        preparedStatement.setInt(1, loginMetodos.getId());
        
        preparedStatement.executeUpdate();

    }

    public void verificarItensLista(boolean validarLista, LoginMetodos loginMetodos) throws SQLException {

        boolean pLista = false;
        Connection conn = ConexaoBD.conexaoBD();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        preparedStatement = conn.prepareStatement("SELECT * FROM listadecompras WHERE id_usuario = ?");
        preparedStatement.setInt(1, loginMetodos.getId());

        rs = preparedStatement.executeQuery();
        
        System.out.println("");

        if (validarLista) {
            
            while (rs.next()) {

                pLista = true;

                if (pLista) {

                    System.out.println(rs.getString("id") + " - " + rs.getString("itens") + " - R$" + rs.getDouble("preço"));

                } 

            }
            
            if (!pLista){
                
                JOptionPane.showMessageDialog(null, "NÃO FOI ENCONTRADO UMA LISTA!!");
                lista.telaInicial(loginMetodos);
                
            }

        } else {
            
            if (rs.next()) {

                pLista = true;

                if (pLista) {

                    JOptionPane.showMessageDialog(null, "JÁ EXISTE UMA LISTA!!");
                    lista.telaInicial(loginMetodos);
                    
                } 

            }
            
        }

        conn.close();
        preparedStatement.close();
        rs.close();

    }
}
