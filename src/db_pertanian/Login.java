/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_pertanian;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author Rokhis
 */
public class Login extends javax.swing.JFrame {

    Connection conn=null;
    PreparedStatement pst = null;
    ResultSet res = null;
    Object set;
    
    public Login() {
        con = new Koneksi2();
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        if (frameSize.height > screenSize.height){
            frameSize.height = screenSize.height ;
        }
        if (frameSize.width > screenSize.width){
            frameSize.width = screenSize.width ;
        }
        this.setLocation((screenSize.width - frameSize.width) /2,
                          (screenSize.height - frameSize.height) /2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TxtUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BtLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(TxtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 110, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel1.setText("Username");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 60, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 60, -1));

        BtLogin.setText("Login");
        BtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtLoginActionPerformed(evt);
            }
        });
        jPanel1.add(BtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 110, -1));

        jLabel3.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabel3.setText("Yuk Login Dulu Yuk!");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 110, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/db_pertanian/bg.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, -190, 580, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtLoginActionPerformed
        
        try {
            Connection conn = Koneksi2.koneksi();
            String sql = "SELECT * FROM tb_admin Where Nama ='" + TxtUsername.getText()
                    + "' and Password = '" + txtPassword.getText() + "'";
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);

            if (r.next()) {
                JOptionPane.showMessageDialog(null, "Login Berhasil");
                new MenuBaru().setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Username atau Password Salah");
            }
        } catch (SQLException e) {
            System.out.println("error");
        }
    }//GEN-LAST:event_BtLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    Koneksi2 con;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtLogin;
    private javax.swing.JTextField TxtUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
