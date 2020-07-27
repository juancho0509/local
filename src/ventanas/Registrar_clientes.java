package ventanas;

import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Registrar_clientes extends javax.swing.JFrame {

    String user;

    public Registrar_clientes() {
        initComponents();

        user = Login.user;

        setTitle("Registrar nuevo cliente - Sesión de " + user);

        setSize(550, 370);
        setResizable(false);
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

        jLabel_titulo = new javax.swing.JLabel();
        jLabel_nombre = new javax.swing.JLabel();
        jLabel_email = new javax.swing.JLabel();
        jLabel_telefono = new javax.swing.JLabel();
        jlabe_direccion = new javax.swing.JLabel();
        jLabel_registrar_cliente = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        jButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Registro de usuarios");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jLabel_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nombre.setText("Nombre:");
        getContentPane().add(jLabel_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel_email.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_email.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_email.setText("Em@il :");
        getContentPane().add(jLabel_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel_telefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_telefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_telefono.setText("Teléfono :");
        getContentPane().add(jLabel_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jlabe_direccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabe_direccion.setForeground(new java.awt.Color(255, 255, 255));
        jlabe_direccion.setText("Dirección :");
        getContentPane().add(jlabe_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel_registrar_cliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_registrar_cliente.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_registrar_cliente.setText("Registrar cliente ");
        getContentPane().add(jLabel_registrar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(102, 102, 102));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txt_email.setBackground(new java.awt.Color(102, 102, 102));
        txt_email.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_email.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        txt_telefono.setBackground(new java.awt.Color(102, 102, 102));
        txt_telefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 195, 210, -1));

        txt_direccion.setBackground(new java.awt.Color(102, 102, 102));
        txt_direccion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_direccion.setForeground(new java.awt.Color(255, 255, 255));
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_direccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 255, 210, -1));

        jButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });
        getContentPane().add(jButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 120, 100));

        jLabel8.setText("Creado por Ingetec ®");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 304, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 551, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionPerformed

        //bandera para ver si esta vacios los campos o no 
        int validacion = 0;
        String nombre, email, telefono, direccion;

        //recuperramos los valores en los txt
        nombre = txt_nombre.getText().trim();
        email = txt_email.getText().trim();
        telefono = txt_telefono.getText().trim();
        direccion = txt_direccion.getText().trim();

        //si hay campos vacios 
        if (nombre.equals("")) {
            txt_nombre.setBackground(Color.red);
            validacion++;//para mandar la orden si esta o no vacio los datos
        }
        if (email.equals("")) {
            txt_email.setBackground(Color.red);
            validacion++;

        }
        if (telefono.equals("")) {
            txt_telefono.setBackground(Color.red);
            validacion++;
        }
        if (direccion.equals("")) {
            txt_direccion.setBackground(Color.red);
            validacion++;
        }
        //base de datos 
        if (validacion == 0) {//validamos que los campos no estan vacios y empezamos a enviar datos
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "insert into clientes values(?,?,?,?,?,?)");
                //enviamos 6 valores

                pst.setInt(1, 0);//primer campo id y es automatico es entero
                pst.setString(2, nombre);//segundo campo es String igual alos demas
                pst.setString(3, email);
                pst.setString(4, telefono);
                pst.setString(5, direccion);
                pst.setString(6, user);//nombre de usuario que esta usando el sistema en este momento

                pst.executeUpdate();//ejecuta estas lineas de codigo sube datos
                cn.close();

                limpiar();//limpia los campos de texto una vez registrado los datos

                txt_direccion.setBackground(Color.GREEN);
                txt_email.setBackground(Color.GREEN);//indica que fue correcto el registro
                txt_nombre.setBackground(Color.GREEN);
                txt_telefono.setBackground(Color.GREEN);

                JOptionPane.showMessageDialog(null, "Cliente registrado con exito.");

                //liberamos recursos
                this.dispose();

            } catch (SQLException e) {
                System.out.println("Error en registrar cliente" + e);
                JOptionPane.showMessageDialog(null, "Error al registrar nuevo cliente , por favor contacte al administrador.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Porfavor rellene todos los campos.");
        }
    }//GEN-LAST:event_jButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Registrar_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar_clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_email;
    private javax.swing.JLabel jLabel_nombre;
    private javax.swing.JLabel jLabel_registrar_cliente;
    private javax.swing.JLabel jLabel_telefono;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JLabel jlabe_direccion;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
//metodo limpiar

    public void limpiar() {
        txt_direccion.setText("");
        txt_email.setText("");
        txt_nombre.setText("");
        txt_telefono.setText("");
    }

}
