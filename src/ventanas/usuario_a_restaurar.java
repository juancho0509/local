package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 *
 * @author juancho
 */
public class usuario_a_restaurar extends javax.swing.JFrame {

    String user_update = "", user_buscar = "";
    String userBD = "";

    public usuario_a_restaurar() {

        initComponents();
        setSize(400, 320);
        setResizable(false);
        setTitle("Cambio de password");
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/nuevo wallpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/logo ingetec 80.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_buscar_user = new javax.swing.JButton();
        jTextField_user = new javax.swing.JTextField();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_buscar_user.setText("Buscar usuario");
        jButton_buscar_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscar_userActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_buscar_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 171, 190, 38));
        getContentPane().add(jTextField_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 95, 190, 38));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 399, 304));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_buscar_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscar_userActionPerformed
        try {
            String user = jTextField_user.getText().trim();
            user_buscar = user;

            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombre_usuario from usuarios where nombre_usuarios='" + user_buscar + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                userBD = rs.getString("nombre_usuario");
            }
            if (userBD == user) {
                RestaurarPassword_login R_P = new RestaurarPassword_login();
                R_P.setVisible(true);
            }

        } catch (SQLException e) {

        }
    }//GEN-LAST:event_jButton_buscar_userActionPerformed

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(usuario_a_restaurar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usuario_a_restaurar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usuario_a_restaurar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usuario_a_restaurar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usuario_a_restaurar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_buscar_user;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JTextField jTextField_user;
    // End of variables declaration//GEN-END:variables
}
