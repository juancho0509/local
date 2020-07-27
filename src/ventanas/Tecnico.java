package ventanas;

import clases.Conexion;
import java.sql.*;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.WindowConstants;

public class Tecnico extends javax.swing.JFrame {

    String user, nombre_usuario;
    int sesion_usuario;

    public Tecnico() {
        initComponents();
        user = Login.user;
        sesion_usuario = Administrador.sesion_usuario;

        setSize(550, 310);
        setResizable(false);
        setTitle("Técnico - Sesión de " + user);
        setLocationRelativeTo(null);

        if (sesion_usuario == 1) {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } else {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

        ImageIcon wallpaper = new ImageIcon("src/images/nuevo wallpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombre_usuario from usuarios where username = '" + user + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nombre_usuario = rs.getString("nombre_usuario");
                jLabel_NombreUsuario.setText("Bienvenido " + nombre_usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error en consultar nombre de Tecnico.");
        }
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/logo ingetec 80.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_NombreUsuario = new javax.swing.JLabel();
        jButton_gestionarEquipos = new javax.swing.JButton();
        jButton_graficaEstatus = new javax.swing.JButton();
        jButton_graficvaMarcas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_NombreUsuario.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel_NombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NombreUsuario.setText("jLabel1");
        getContentPane().add(jLabel_NombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton_gestionarEquipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/apoyo-tecnico.png"))); // NOI18N
        jButton_gestionarEquipos.setBorderPainted(false);
        jButton_gestionarEquipos.setContentAreaFilled(false);
        jButton_gestionarEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_gestionarEquiposActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_gestionarEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 100));

        jButton_graficaEstatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grafica.png"))); // NOI18N
        jButton_graficaEstatus.setBorderPainted(false);
        jButton_graficaEstatus.setContentAreaFilled(false);
        jButton_graficaEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_graficaEstatusActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_graficaEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 120, 100));

        jButton_graficvaMarcas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grafica.png"))); // NOI18N
        jButton_graficvaMarcas.setBorderPainted(false);
        jButton_graficvaMarcas.setContentAreaFilled(false);
        jButton_graficvaMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_graficvaMarcasActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_graficvaMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 120, 100));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Gestion de equipo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Grafica de estatus");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Grafica de marcas");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 180, -1, -1));

        jLabel7.setText("Creado por Ingetec ®");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 247, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_gestionarEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_gestionarEquiposActionPerformed
        Gestionar_equipos_tecnico gestion_equipos = new Gestionar_equipos_tecnico();
        gestion_equipos.setVisible(true);

    }//GEN-LAST:event_jButton_gestionarEquiposActionPerformed

    private void jButton_graficaEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_graficaEstatusActionPerformed

    }//GEN-LAST:event_jButton_graficaEstatusActionPerformed

    private void jButton_graficvaMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_graficvaMarcasActionPerformed


    }//GEN-LAST:event_jButton_graficvaMarcasActionPerformed

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
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_gestionarEquipos;
    private javax.swing.JButton jButton_graficaEstatus;
    private javax.swing.JButton jButton_graficvaMarcas;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_NombreUsuario;
    private javax.swing.JLabel jLabel_Wallpaper;
    // End of variables declaration//GEN-END:variables
}
