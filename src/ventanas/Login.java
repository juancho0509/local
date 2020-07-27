package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.*;
import clases.Conexion;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public static String user = ""; //Se declara así para enviar datos entre interfaces
    String pass = "";
    private char i;

    private boolean a = true;

    public Login() {

        //medidas
        initComponents();
        setSize(824, 568);
        setResizable(false);
        setTitle("Acceso al sistema");
        setLocationRelativeTo(null);

        //fondo wallpaper
        ImageIcon wallpaper = new ImageIcon("src/images/camara domo blanca.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        //jlabel de logo sobre ingreso de datos
        ImageIcon wallapper_logo = new ImageIcon("src/images/tras_ingetec.png");
        Icon icono_logo = new ImageIcon(wallapper_logo.getImage().getScaledInstance(jLabel_Logo.getWidth(),
                jLabel_Logo.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Logo.setIcon(icono_logo);
        this.repaint();

        //jlabel del user logo
    }

    //icon de programa
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/logo ingetec 80.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Logo = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jButton_Acceder = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        boton_verP = new javax.swing.JButton();
        jlabe_logoUser = new javax.swing.JLabel();
        jLabel_candado = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        haz_clickAqui = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 0, 228, 190));

        txt_user.setBackground(new java.awt.Color(153, 153, 153));
        txt_user.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_user.setForeground(java.awt.Color.darkGray);
        txt_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_user.setOpaque(false);
        txt_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_userKeyTyped(evt);
            }
        });
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 247, 35));

        txt_password.setBackground(new java.awt.Color(153, 153, 153));
        txt_password.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_password.setForeground(new java.awt.Color(51, 51, 51));
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_password.setCaretColor(new java.awt.Color(102, 102, 102));
        txt_password.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        txt_password.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_passwordKeyTyped(evt);
            }
        });
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 338, 247, 35));

        jButton_Acceder.setBackground(new java.awt.Color(204, 0, 0));
        jButton_Acceder.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        jButton_Acceder.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Acceder.setText("Acceder");
        jButton_Acceder.setBorder(null);
        jButton_Acceder.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton_Acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AccederActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, 247, 35));

        jLabel1.setFont(new java.awt.Font("Segoe Script", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Usuario :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe Script", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Contraseña :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Creado por Ingetec ®");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 513, 190, 19));

        boton_verP.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        boton_verP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lado.png"))); // NOI18N
        boton_verP.setBorder(null);
        boton_verP.setBorderPainted(false);
        boton_verP.setContentAreaFilled(false);
        boton_verP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_verPActionPerformed(evt);
            }
        });
        getContentPane().add(boton_verP, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 318, 74, 74));

        jlabe_logoUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        getContentPane().add(jlabe_logoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 190, 133, 76));

        jLabel_candado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/candado1.png"))); // NOI18N
        getContentPane().add(jLabel_candado, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 304, 133, 95));

        jLabel3.setText("¿olvidaste tu contraseña? haz click ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 453, 209, 38));

        haz_clickAqui.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        haz_clickAqui.setForeground(new java.awt.Color(153, 0, 0));
        haz_clickAqui.setText("AQUI");
        haz_clickAqui.setBorderPainted(false);
        haz_clickAqui.setContentAreaFilled(false);
        haz_clickAqui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                haz_clickAquiActionPerformed(evt);
            }
        });
        getContentPane().add(haz_clickAqui, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 456, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 836, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton_AccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AccederActionPerformed

        user = txt_user.getText().trim();
        pass = txt_password.getText().trim();
        if (!user.equals("") || !pass.equals("")) {

            try {

                //conexion a base de datos
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select tipo_nivel, estatus from usuarios where username = '" + user
                        + "' and password = '" + pass + "'");

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {

                    String tipo_nivel = rs.getString("tipo_nivel");
                    String estatus = rs.getString("estatus");

                    if (tipo_nivel.equalsIgnoreCase("Administrador") && estatus.equalsIgnoreCase("Activo")) {
                        //dispose(); Hace que el JFrame sea destruido y limpiado por el sistema operativo.
                        dispose();
                        new Administrador().setVisible(true);
                    } else if (tipo_nivel.equalsIgnoreCase("Capturista") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new Capturista().setVisible(true);
                    } else if (tipo_nivel.equalsIgnoreCase("Tecnico") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new Tecnico().setVisible(true);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos.");
                    txt_user.setText("");
                    txt_password.setText("");
                }

            } catch (SQLException e) {
                System.err.println("Error en el botón Acceder." + e);
                JOptionPane.showMessageDialog(null, "¡¡ERROR al iniciar!!, contacte al administrador.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }


    }//GEN-LAST:event_jButton_AccederActionPerformed
//metodos para eel enter
    private void txt_userKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_userKeyTyped
        char tecla_precionada = evt.getKeyChar();//anula las demas teclas
        //obtenemos caracter por caracter y lo guardamos en el texto

        if (tecla_precionada == KeyEvent.VK_ENTER) {//si se preciona la tecla enter
            jButton_Acceder.doClick();
        }


    }//GEN-LAST:event_txt_userKeyTyped
//metodo para usar el enter
    private void txt_passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyTyped

        char tecla_precionada = evt.getKeyChar();//anula las demas teclas

        if (tecla_precionada == KeyEvent.VK_ENTER) {//si se preciona la tecla enter
            jButton_Acceder.doClick();
        }
    }//GEN-LAST:event_txt_passwordKeyTyped

//metodo para ver la clave
    private void boton_verPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_verPActionPerformed
        if (a) { // a es una variable boolean en true

            txt_password.setEchoChar((char) 0); // este método es el que hace visible el texto del jPasswordField
            a = false;

            ImageIcon icon = new ImageIcon("src/images/cerrado.png");
            Icon icono = new ImageIcon(icon.getImage().getScaledInstance(boton_verP.getWidth(),
                    boton_verP.getHeight(), Image.SCALE_DEFAULT));
            boton_verP.setIcon(icono);
            this.repaint();

        } else {
            txt_password.setEchoChar('*'); // i es el char
            a = true;

            ImageIcon icon = new ImageIcon("src/images/lado.png");
            Icon icono = new ImageIcon(icon.getImage().getScaledInstance(boton_verP.getWidth(),
                    boton_verP.getHeight(), Image.SCALE_DEFAULT));
            boton_verP.setIcon(icono);
            this.repaint();

        }

    }//GEN-LAST:event_boton_verPActionPerformed

    private void haz_clickAquiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_haz_clickAquiActionPerformed
        user = txt_user.getText().trim();
        if (!user.equals("")) {

            try {

                Connection cn2 = Conexion.conectar();
                PreparedStatement pst2 = cn2.prepareStatement(
                        "select tipo_nivel, estatus from usuarios where username = '" + user
                        + "'");
                ResultSet rs2 = pst2.executeQuery();
                if (rs2.next()) {
                    String txTipo_nivel = rs2.getString("tipo_nivel");
                    String txt_status2 = rs2.getString("estatus");

                    if (txTipo_nivel.equalsIgnoreCase("Administrador") || txTipo_nivel.equalsIgnoreCase("Capturista")
                            || txTipo_nivel.equalsIgnoreCase("Tecnico") && txt_status2.equalsIgnoreCase("Activo")) {
                        dispose();
                        new RestaurarPassword_login().setVisible(true);
                    }
                }
            } catch (SQLException e) {
                System.out.println("error en restauar usuario password" + e);
                JOptionPane.showMessageDialog(null, " error al acceder alos datos de la base de datos , por favor contacte al administrador");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingresa tu usuario para poder continuar");
        }


    }//GEN-LAST:event_haz_clickAquiActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_verP;
    private javax.swing.JButton haz_clickAqui;
    private javax.swing.JButton jButton_Acceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_candado;
    private javax.swing.JLabel jlabe_logoUser;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables

}
