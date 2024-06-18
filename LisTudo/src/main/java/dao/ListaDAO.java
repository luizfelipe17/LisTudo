package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexao.ConexaoBD;
import javax.swing.JOptionPane;
import listudo.Sistema;
import metodos.LoginMetodos;

public class ListaDAO {

    PreparedStatement preparedStatement = null;
    Connection conn = null;
    Sistema sistema = new Sistema();

    /**
     * Este método é utilizado para inserir novos itens em um banco de dados.
     * Ele garante que os dados sejam validados antes da inserção e que a
     * operação seja realizada de forma eficiente e segura.
     */
    public void addItensBD(String produtos, LoginMetodos loginMetodos) throws SQLException {

        try {

            Connection conn = ConexaoBD.conexaoBD();

            preparedStatement = conn.prepareStatement("INSERT INTO listadecompras (itens, preço, id_usuario) VALUES (?, ?, ?)");
            preparedStatement.setString(1, produtos);
            preparedStatement.setDouble(2, 0);
            preparedStatement.setInt(3, loginMetodos.getId());

            preparedStatement.executeUpdate();

            conn.close();
            preparedStatement.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO NO BANCO DE DADOS, TENTE NOVAMENTE!");
            System.out.println("");

        }
    }

    /**
     * Este método é utilizado para inserir todos os itens de uma cesta basica
     * em um banco de dados. Ele garante que os dados sejam validados antes da
     * inserção e que a operação seja realizada de forma eficiente e segura.
     */
    public void listaCestaBasica(LoginMetodos loginMetodos) throws SQLException {

        try {

            Connection conn = ConexaoBD.conexaoBD();

            String itensCesta[] = {"Arroz", "Feijão", "Óleo", "Açúcar", "Café", "Sal", "Macarrão", "Leite"};
            int preco = 0;

            for (String itens : itensCesta) {

                preparedStatement = conn.prepareStatement("INSERT INTO listadecompras (itens, preço, id_usuario) VALUES (?, ?, ?)");

                preparedStatement.setString(1, itens);
                preparedStatement.setDouble(2, preco);
                preparedStatement.setInt(3, loginMetodos.getId());

                preparedStatement.executeUpdate();

            }

            conn.close();
            preparedStatement.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO NO BANCO DE DADOS, TENTE NOVAMENTE!");
            System.out.println("");

        }

    }

    /**
     * Método para atualizar o preço do produto ao banco de dados.
     */
    public void precoItensBD(Double preco, int idItens) throws SQLException {

        try {

            Connection conn = ConexaoBD.conexaoBD();

            preparedStatement = conn.prepareStatement("UPDATE listadecompras SET PREÇO = ? WHERE id = ?");
            preparedStatement.setDouble(1, preco);
            preparedStatement.setInt(2, idItens);

            preparedStatement.executeUpdate();

            conn.close();
            preparedStatement.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO NO BANCO DE DADOS, TENTE NOVAMENTE!");
            System.out.println("");

        }
    }

    /**
     * Método eficiente para calcular a soma dos preços de todos os itens
     * armazenados no banco de dados.
     */
    public void valorTotalCompra(LoginMetodos loginMetodos) throws SQLException {

        try {

            boolean pLista = false;
            Connection conn = ConexaoBD.conexaoBD();
            ResultSet rs = null;

            preparedStatement = conn.prepareStatement("SELECT * FROM listadecompras WHERE preço > 0 AND id_usuario = ?");
            preparedStatement.setInt(1, loginMetodos.getId());

            rs = preparedStatement.executeQuery();

            System.out.print("\nITENS COMPRADOS:\n");

            while (rs.next()) {

                pLista = true;
                System.out.println(rs.getString("id") + " - " + rs.getString("itens") + " - R$" + rs.getDouble("preço"));

            }

            if (!pLista) {

                JOptionPane.showMessageDialog(null, "NÃO HOUVE ITENS COMPRADOS!");
                System.out.println("");
                sistema.telaInicial(loginMetodos, this);

            }

            preparedStatement = conn.prepareStatement("SELECT sum(preço) FROM listadecompras WHERE id_usuario = ?");
            preparedStatement.setDouble(1, loginMetodos.getId());

            rs = preparedStatement.executeQuery();

            if (rs.next()) {

                double precoCompra = rs.getDouble("sum(preço)");
                System.out.print("\nValor total da compra foi de R$" + precoCompra);
                System.out.println(", pague no caixa!!!\n");

                preparedStatement = conn.prepareStatement("DELETE FROM listadecompras WHERE preço > 0 AND id_usuario = ?");
                preparedStatement.setInt(1, loginMetodos.getId());

                preparedStatement.executeUpdate();

                sistema.finalizarPrograma(loginMetodos, this);

            }

            rs.close();
            conn.close();
            preparedStatement.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO NO BANCO DE DADOS, TENTE NOVAMENTE!");
            System.out.println("");

        }
    }

    /**
     * Método para excuir um item específico do banco de dados.
     */
    public void deleteItem(int idItens, LoginMetodos loginMetodos) throws SQLException {

        try {

            Connection conn = ConexaoBD.conexaoBD();

            preparedStatement = conn.prepareStatement("DELETE FROM listadecompras WHERE id_usuario = ? AND id = ?");
            preparedStatement.setInt(1, loginMetodos.getId());
            preparedStatement.setInt(2, idItens);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "ITEM EXCLUIDO!!");

            conn.close();
            preparedStatement.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR O PRODUTO!!");
            System.out.println("");

        }

    }

    /**
     * Método para excluir completamente a lista de compras do banco de dados.
     */
    public void deleteLista(LoginMetodos loginMetodos) throws SQLException {

        try {

            Connection conn = ConexaoBD.conexaoBD();

            preparedStatement = conn.prepareStatement("DELETE FROM listadecompras WHERE id_usuario = ?");
            preparedStatement.setInt(1, loginMetodos.getId());

            preparedStatement.executeUpdate();

            conn.close();
            preparedStatement.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR O PRODUTO!!");
            System.out.println("");

        }
    }

    /**
     * Este método valida se há itens na lista. Se o método retornar "true", os
     * itens da lista serão impressos. Se retornar "false", e uma lista já
     * existir, será informado que "JÁ EXISTE UMA LISTA!!"; caso contrário,
     * continuará normalmente.
     */
    public void verificarItensLista(boolean validarLista, LoginMetodos loginMetodos, ListaDAO listaDAO) throws SQLException {

        try {

            boolean pLista = false;
            Connection conn = ConexaoBD.conexaoBD();

            preparedStatement = conn.prepareStatement("SELECT * FROM listadecompras WHERE id_usuario = ?");
            preparedStatement.setInt(1, loginMetodos.getId());

            ResultSet rs = preparedStatement.executeQuery();

            System.out.println("");

            if (validarLista) {

                while (rs.next()) {

                    pLista = true;

                    if (pLista) {

                        System.out.println(rs.getString("id") + " - " + rs.getString("itens") + " - R$" + rs.getDouble("preço"));

                    }

                }

                if (!pLista) {

                    JOptionPane.showMessageDialog(null, "NÃO FOI ENCONTRADO UMA LISTA!!");
                    sistema.telaInicial(loginMetodos, listaDAO);

                }

            } else {

                if (rs.next()) {

                    pLista = true;

                    if (pLista) {

                        JOptionPane.showMessageDialog(null, "JÁ EXISTE UMA LISTA!!");
                        sistema.telaInicial(loginMetodos, listaDAO);

                    }

                }

            }

            rs.close();
            conn.close();
            preparedStatement.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO NO BANCO DE DADOS, TENTE NOVAMENTE!");
            System.out.println("");

        }

    }

    /**
     * Metodo para imprimir a lista enquanto estiver no metodo "IR AO MERCADO",
     * pois irá imprimir somente os itens da lista que o usuario ainda não
     * adicionou.
     */
    public void imprimirItensMercado(LoginMetodos loginMetodos, ListaDAO listaDAO) throws SQLException {

        boolean pLista = false;
        Connection conn = ConexaoBD.conexaoBD();

        preparedStatement = conn.prepareStatement("SELECT * FROM listadecompras WHERE preço = 0 AND id_usuario = ?");
        preparedStatement.setInt(1, loginMetodos.getId());

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {

            pLista = true;
            System.out.println(rs.getString("id") + " - " + rs.getString("itens") + " - R$" + rs.getDouble("preço"));

        }

        if (!pLista) {

            valorTotalCompra(loginMetodos);

        }

        rs.close();
        conn.close();
        preparedStatement.close();

    }

    /**
     * Método para atualizar o preço do produto ao banco de dados.
     */
    public void editarItem(int idItens, String novoNomeProduto, LoginMetodos loginMetodos) throws SQLException {

        try {

            Connection conn = ConexaoBD.conexaoBD();

            preparedStatement = conn.prepareStatement("UPDATE listadecompras SET itens = ? WHERE id = ?");
            preparedStatement.setString(1, novoNomeProduto);
            preparedStatement.setInt(2, idItens);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "ITEM EDITADO!!");

            conn.close();
            preparedStatement.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO AO EDITAR O PRODUTO!!");
            System.out.println("");

        }

    }

}
