package Ventanas;

import javax.swing.JOptionPane;
import Clases.ConexionMysql;

/**
 *
 * @author jhona
 */
public class Loggin extends javax.swing.JFrame {

    public Loggin() {
        initComponents();
        LogBtnIngresar.getFocusListeners();
    }
    private final ConexionMysql l = new ConexionMysql();
    private final Principal pr = new Principal();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogBtnIngresar = new javax.swing.JButton();
        log_btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LogTxCodigo = new javax.swing.JTextField();
        LogTxPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(255, 102, 51));
        setName("Login"); // NOI18N

        LogBtnIngresar.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 16)); // NOI18N
        LogBtnIngresar.setText("Ingresar");
        LogBtnIngresar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                LogBtnIngresarFocusGained(evt);
            }
        });
        LogBtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogBtnIngresarActionPerformed(evt);
            }
        });

        log_btnSalir.setFont(new java.awt.Font("Gill Sans MT Condensed", 0, 16)); // NOI18N
        log_btnSalir.setText("Salir");
        log_btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_btnSalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo Usuario: ");

        jLabel2.setText("Password:");

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 1, 36)); // NOI18N
        jLabel3.setText("Sistema Bancario ");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/log2.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LogTxPass, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LogTxCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel5))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(LogBtnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(log_btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(LogTxCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(LogTxPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LogBtnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(log_btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogBtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogBtnIngresarActionPerformed
        String respuesta = l.buscarUsuario(LogTxCodigo.getText(), LogTxPass.getText());
        if (respuesta.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Usuario o Contraseña invalido");
        } else {
            // menu.lblTipo.setText(respuesta);
            System.out.println(respuesta);
            pr.setSetCurrentUser(LogTxCodigo.getText());
            pr.lbUsuPrinc.setText(respuesta);
            pr.show();
            this.hide();
        }

    }//GEN-LAST:event_LogBtnIngresarActionPerformed

    private void log_btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_log_btnSalirActionPerformed

    private void LogBtnIngresarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LogBtnIngresarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_LogBtnIngresarFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(final String args[]) {
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
            java.util.logging.Logger.getLogger(Loggin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loggin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loggin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loggin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loggin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogBtnIngresar;
    private javax.swing.JTextField LogTxCodigo;
    private javax.swing.JPasswordField LogTxPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton log_btnSalir;
    // End of variables declaration//GEN-END:variables
}
