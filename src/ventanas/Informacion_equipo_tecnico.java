package ventanas;

import clases.Conexion;

import java.sql.*;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Informacion_equipo_tecnico extends javax.swing.JFrame {

   
            int IDequipo = 0;
    String user = "", nom_cliente = "";

    public Informacion_equipo_tecnico() {
        initComponents();

        user = Login.user;//quien inicio sesion
        IDequipo = Gestionar_equipos_tecnico.IDcliente;//datos del equipo
        //Dcliente_update = Gestionar_equipos_tecnico.clienteID;//enviamos el id para que se guarde los datos actualizadso

        //recuperacion del nombre del cliente desde la BD
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombre_cliente from clientes where id_cliente = '" + IDequipo + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nom_cliente = rs.getString("nombre_cliente");
            }
        } catch (SQLException e) {
            System.err.println("error al consultar el nombre del cliente" + e);
        }
        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst2 = cn2.prepareStatement(
                    "select * from equipos where id_cliente = '" + IDequipo + "'");

            ResultSet rs = pst2.executeQuery();

            if (rs.next()) {
                cmb_tipo_equipo.setSelectedItem(rs.getString("tipo_equipo"));
                cmb_marca.setSelectedItem(rs.getString("marca"));
                cmb_estatus.setSelectedItem(rs.getString("estatus"));

                txt_modelo.setText(rs.getString("modelo"));
                txt_num_serie.setText(rs.getString("num_serie"));
                txt_ultimaM.setText(rs.getString("ultima_modificacion"));

                String dia = "", mes = "", anno = "";
                dia = rs.getString("dia_ingreso");
                mes = rs.getString("mes_ingreso");
                anno = rs.getString("anno_ingreso");

                txt_fecha.setText(dia + " / " + mes + " / " + anno);

                jTextPane_datos_instalacion.setText(rs.getString("observaciones"));
                jTextPane_comentarios_tecnico.setText(rs.getString("comentarios_tecnicos"));

                jLabel_revision_tecnicaDe.setText("Comentarios y actualizacion del tecnico " + rs.getString("revision_tecnica_de"));

            }

        } catch (SQLException e) {
            System.err.println("ERROR al consultar la informacion del equipo " + e);
        }
        setTitle("Equipo del cliente " + nom_cliente);
        setSize(670, 530);
        setResizable(false);
        setTitle("Datos del cliente " + nom_cliente + " - Sesión de " + user);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/nuevo wallpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jlabel_Wallpaper.getWidth(),
                jlabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jlabel_Wallpaper.setIcon(icono);
        this.repaint();

        txt_NombreCliente_T.setText(nom_cliente);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/logo ingetec 80.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Titulo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        jLabel_tipoEquipo = new javax.swing.JLabel();
        jLabel_marca = new javax.swing.JLabel();
        jLabel_modelo = new javax.swing.JLabel();
        jLabel_numeroSerie = new javax.swing.JLabel();
        jLabel_fecha = new javax.swing.JLabel();
        jLabel_UltimaM = new javax.swing.JLabel();
        jLabel_estatus = new javax.swing.JLabel();
        jLabel_dañoR = new javax.swing.JLabel();
        jLabel_revision_tecnicaDe = new javax.swing.JLabel();
        txt_NombreCliente_T = new javax.swing.JTextField();
        txt_modelo = new javax.swing.JTextField();
        txt_num_serie = new javax.swing.JTextField();
        txt_ultimaM = new javax.swing.JTextField();
        txt_fecha = new javax.swing.JTextField();
        cmb_tipo_equipo = new javax.swing.JComboBox();
        cmb_marca = new javax.swing.JComboBox();
        cmb_estatus = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane_datos_instalacion = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane_comentarios_tecnico = new javax.swing.JTextPane();
        jButton_actualizar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jlabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Información de equipo");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre del cliente:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel_tipoEquipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_tipoEquipo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_tipoEquipo.setText("Tipo de equipo :");
        getContentPane().add(jLabel_tipoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel_marca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_marca.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_marca.setText("Marca :");
        getContentPane().add(jLabel_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel_modelo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_modelo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_modelo.setText("Modelo :");
        getContentPane().add(jLabel_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel_numeroSerie.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_numeroSerie.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_numeroSerie.setText("Numero de Serie :");
        getContentPane().add(jLabel_numeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel_fecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_fecha.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_fecha.setText("Fecha de instalación :");
        getContentPane().add(jLabel_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        jLabel_UltimaM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_UltimaM.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_UltimaM.setText("Ultima modificación por :");
        getContentPane().add(jLabel_UltimaM, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel_estatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_estatus.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_estatus.setText("Estatus :");
        getContentPane().add(jLabel_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 57, -1, -1));

        jLabel_dañoR.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_dañoR.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_dañoR.setText("Datos de la instalación :");
        getContentPane().add(jLabel_dañoR, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        jLabel_revision_tecnicaDe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_revision_tecnicaDe.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_revision_tecnicaDe.setText("Comentarios y actualización del Técnico :");
        getContentPane().add(jLabel_revision_tecnicaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        txt_NombreCliente_T.setEditable(false);
        txt_NombreCliente_T.setBackground(new java.awt.Color(102, 102, 102));
        txt_NombreCliente_T.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_NombreCliente_T.setForeground(new java.awt.Color(255, 255, 255));
        txt_NombreCliente_T.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NombreCliente_T.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_NombreCliente_T, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, -1));

        txt_modelo.setEditable(false);
        txt_modelo.setBackground(new java.awt.Color(102, 102, 102));
        txt_modelo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_modelo.setForeground(new java.awt.Color(255, 255, 255));
        txt_modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, -1));

        txt_num_serie.setEditable(false);
        txt_num_serie.setBackground(new java.awt.Color(102, 102, 102));
        txt_num_serie.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_num_serie.setForeground(new java.awt.Color(255, 255, 255));
        txt_num_serie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_num_serie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_num_serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 210, -1));

        txt_ultimaM.setEditable(false);
        txt_ultimaM.setBackground(new java.awt.Color(102, 102, 102));
        txt_ultimaM.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_ultimaM.setForeground(new java.awt.Color(255, 255, 255));
        txt_ultimaM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ultimaM.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_ultimaM, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 210, -1));

        txt_fecha.setEditable(false);
        txt_fecha.setBackground(new java.awt.Color(102, 102, 102));
        txt_fecha.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_fecha.setForeground(new java.awt.Color(255, 255, 255));
        txt_fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 180, -1));

        cmb_tipo_equipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "cctv", "alarma domiciliaria", "ZKTeco control de acceso", "cerco electrico" }));
        cmb_tipo_equipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_tipo_equipoActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_tipo_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 142, -1, -1));

        cmb_marca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hikvision", "dahua", "intelbras", "dcs", "ZTKeco" }));
        getContentPane().add(cmb_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, -1, -1));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "En garantia", "Fuera de garantia", "Mantenimiento pendiente", "Mantenimiento listo " }));
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 78, 152, -1));

        jTextPane_datos_instalacion.setEditable(false);
        jScrollPane1.setViewportView(jTextPane_datos_instalacion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 385, 120));

        jScrollPane2.setViewportView(jTextPane_comentarios_tecnico);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 385, 120));

        jButton_actualizar.setBackground(new java.awt.Color(255, 0, 0));
        jButton_actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_actualizar.setText("Agregar comentarios");
        jButton_actualizar.setBorder(null);
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 420, 210, 35));

        jLabel7.setText("Creado por Ingetec ®");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, -1, -1));
        getContentPane().add(jlabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_tipo_equipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_tipo_equipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_tipo_equipoActionPerformed

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
     int validacion = 0;

        String  observacionesTecnicas;

       
        observacionesTecnicas = jTextPane_comentarios_tecnico.getText();
 
        if (observacionesTecnicas.equals("")) {
            jTextPane_datos_instalacion.setText("El técnico no dejo comentarios");
        }
       
        if(validacion == 0){
       
        //conexion a base de datos con validacion
        
            try {
                Connection cn3 = Conexion.conectar();
                PreparedStatement pst3 = cn3.prepareStatement(
                        "update equipos set comentarios_tecnicos=?, revision_tecnica_de=? "
                        + "where id_cliente = '" + IDequipo + "'");
//modifica en la tabla equipos esos valores dependiendo del id del equipo

                
              
               
               
                pst3.setString(1, observacionesTecnicas);
               
                pst3.setString(2, user);

                pst3.executeUpdate();
                
                cn3.close();

                limpiar();

                JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
                this.dispose();

            } catch (SQLException e) {
                System.err.println("error en actuliar datos del tecnico" + e);
                JOptionPane.showMessageDialog(null, "ERROR al ingresar comentarios del tecnico,porfavor contacte al administrador.");
            }
            
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

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
            java.util.logging.Logger.getLogger(Informacion_equipo_tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion_equipo_tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion_equipo_tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion_equipo_tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacion_equipo_tecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JComboBox cmb_marca;
    private javax.swing.JComboBox cmb_tipo_equipo;
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_UltimaM;
    private javax.swing.JLabel jLabel_dañoR;
    private javax.swing.JLabel jLabel_estatus;
    private javax.swing.JLabel jLabel_fecha;
    private javax.swing.JLabel jLabel_marca;
    private javax.swing.JLabel jLabel_modelo;
    private javax.swing.JLabel jLabel_numeroSerie;
    private javax.swing.JLabel jLabel_revision_tecnicaDe;
    private javax.swing.JLabel jLabel_tipoEquipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane_comentarios_tecnico;
    private javax.swing.JTextPane jTextPane_datos_instalacion;
    private javax.swing.JLabel jlabel_Wallpaper;
    private javax.swing.JTextField txt_NombreCliente_T;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_modelo;
    private javax.swing.JTextField txt_num_serie;
    private javax.swing.JTextField txt_ultimaM;
    // End of variables declaration//GEN-END:variables
public void limpiar() {
        txt_NombreCliente_T.setText("");
        txt_fecha.setText("");
        txt_modelo.setText("");
        txt_num_serie.setText("");
        jTextPane_datos_instalacion.setText("");
        jTextPane_comentarios_tecnico.setText("");
    }

}
