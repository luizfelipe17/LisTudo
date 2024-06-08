/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frmtelalogin;

import DAO.UsuarioDAO;
import conexao.LoginMetodos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import listudo.LisTudo;

/**
 *
 * @author luizf
 */
public class FrmViewLogin extends javax.swing.JFrame {

    /**
     * Creates new form viewLogin
     */
    public FrmViewLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campoUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnCadastro = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        campoSenha = new javax.swing.JPasswordField();
        labelLogin = new javax.swing.JLabel();

        jButton4.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(100, 100));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("USUARIO");

        campoUsuario.setBackground(new java.awt.Color(255, 255, 255));
        campoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoUsuarioActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("SENHA");

        btnCadastro.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastro.setForeground(new java.awt.Color(0, 0, 0));
        btnCadastro.setText("CADASTRE-SE");
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnLogin.setForeground(new java.awt.Color(0, 0, 0));
        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        campoSenha.setBackground(new java.awt.Color(255, 255, 255));
        campoSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoSenhaActionPerformed(evt);
            }
        });

        labelLogin.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        labelLogin.setForeground(new java.awt.Color(0, 0, 0));
        labelLogin.setText("INFORME O LOGIN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(labelLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCadastro))
                            .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(14, 14, 14)
                .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelLogin)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnCadastro))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void campoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoUsuarioActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        UsuarioDAO usuarioDao = new UsuarioDAO();

        try {
            
            if (usuarioDao.validacaoLogin(campoUsuario.getText(), campoSenha.getText())) {
                
                LisTudo lisTudo = new LisTudo();
                
                ArrayList<String> listaCompras = new ArrayList<String>();
                ArrayList<Double> valorCompra = new ArrayList<Double>();
               
                this.dispose();
                
                System.out.println("Boas Vindas, " + campoUsuario.getText() + "!!!\n");
                
                lisTudo.telaInicial(listaCompras);
                
                
            } else {
                
                JOptionPane.showMessageDialog(null, "USUARIO OU SENHA INVÁLIDOS!");
                
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(FrmViewLogin.class.getName()).log(Level.SEVERE, null, ex);
            
        }


    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed

        FrmViewLogin viewLogin = new FrmViewLogin();
        FrmCadastro viewCadastro = new FrmCadastro();

        viewCadastro.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnCadastroActionPerformed

    private void campoSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoSenhaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmViewLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnLogin;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelLogin;
    // End of variables declaration//GEN-END:variables
}
