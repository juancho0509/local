package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.util.Calendar;//permite registra la fecha y hora 
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Registra_equipo extends javax.swing.JFrame {

    int IDcliente_update = 0;
    String user = "", nomb_cliente = "";

    public Registra_equipo() {
        initComponents();
        user = Login.user;
        IDcliente_update = Gestionar_clientes.IDcliente_update;

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombre_cliente from clientes where id_cliente = '" + IDcliente_update + "'");
            //selecciona el nombre del cliente de la tabla clientes donde el id se aigual alo que tenemos en idcliente update
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nomb_cliente = rs.getString("nombre_cliente");
            }

        } catch (SQLException e) {
            System.err.println("error al consultar el nombre del cliente de la BD.");
        }

        setSize(630, 445);
        setResizable(false);
        setTitle("Registra nuevo equipo para " + nomb_cliente + " - Sesión de " + user);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//evita cerrar el prpgrama cuando se cierra la interfaz

        ImageIcon wallpaper = new ImageIcon("src/images/nuevo wallpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        txt_nombreClient.setText(nomb_cliente);

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
        jLabel_tipo_equipo = new javax.swing.JLabel();
        jLabel_marca = new javax.swing.JLabel();
        jLabel_modelo = new javax.swing.JLabel();
        jLabel_numero_serie = new javax.swing.JLabel();
        jLabel_daño_reportado = new javax.swing.JLabel();
        txt_nombreClient = new javax.swing.JTextField();
        txt_modelo = new javax.swing.JTextField();
        txt_num_serie = new javax.swing.JTextField();
        cmb_tipo_equipo = new javax.swing.JComboBox();
        cmb_marca = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane_observaciones = new javax.swing.JTextPane();
        jButton_Registrar2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Registro de equipo");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre del cliente :");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel_tipo_equipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_tipo_equipo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_tipo_equipo.setText("Tipo de equipo :");
        getContentPane().add(jLabel_tipo_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel_marca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_marca.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_marca.setText("Marca :");
        getContentPane().add(jLabel_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel_modelo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_modelo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_modelo.setText("Modelo :");
        getContentPane().add(jLabel_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel_numero_serie.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_numero_serie.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_numero_serie.setText("Numero de serie :");
        getContentPane().add(jLabel_numero_serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel_daño_reportado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_daño_reportado.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_daño_reportado.setText("Datos del equipo ");
        getContentPane().add(jLabel_daño_reportado, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        txt_nombreClient.setBackground(new java.awt.Color(102, 102, 102));
        txt_nombreClient.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombreClient.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombreClient.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombreClient.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombreClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, 210, -1));

        txt_modelo.setBackground(new java.awt.Color(102, 102, 102));
        txt_modelo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_modelo.setForeground(new java.awt.Color(255, 255, 255));
        txt_modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 262, 210, -1));

        txt_num_serie.setBackground(new java.awt.Color(102, 102, 102));
        txt_num_serie.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_num_serie.setForeground(new java.awt.Color(255, 255, 255));
        txt_num_serie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_num_serie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_num_serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 322, 210, -1));

        cmb_tipo_equipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "cctv", "alarma domiciliaria", "control de asistencia", "cerco electrico" }));
        getContentPane().add(cmb_tipo_equipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 142, -1, -1));

        cmb_marca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hikvision", "dahua", "intelbras", "dcs", "ZTKeco" }));
        getContentPane().add(cmb_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, -1, -1));

        jScrollPane1.setViewportView(jTextPane_observaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 85, 361, 230));

        jButton_Registrar2.setBackground(new java.awt.Color(255, 0, 0));
        jButton_Registrar2.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Registrar2.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Registrar2.setText("Registrar equipo");
        jButton_Registrar2.setBorder(null);
        jButton_Registrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Registrar2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Registrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 210, 35));

        jLabel7.setText("Creado por Ingetec ®");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 390, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 445));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Registrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Registrar2ActionPerformed
        int validacion = 0; //bandera para verrificar campos vacios
        //datos ingresados en String
        String tipo_equipo, marca, modelo, num_serie, dia_ingreso, mes_ingreso, anno_ingreso,
                estatus, observaciones;
        tipo_equipo = cmb_tipo_equipo.getSelectedItem().toString();
        //seleccionamos el item y lo cambiamis con toString
        marca = cmb_marca.getSelectedItem().toString();

        modelo = txt_modelo.getText().trim();
        num_serie = txt_num_serie.getText().trim();
        observaciones = jTextPane_observaciones.getText(); //no importa si exiten espacios

        estatus = "nuevo ingreso";//enviamos esto ala base de dtos porque ella no lo hace

        Calendar calendario = Calendar.getInstance();//calendario libreria
        //se debe hacer parseos para usar esto
        dia_ingreso = Integer.toString(calendario.get(Calendar.DATE));
        //aqui capturamos el dia qeu se e¿ingreso el equipo
        mes_ingreso = Integer.toString(calendario.get(Calendar.MONTH));//mes
        anno_ingreso = Integer.toString(calendario.get(Calendar.YEAR));//año

        //validacion de campos
        if (modelo.equals("")) {
            txt_modelo.setBackground(Color.red);
            validacion++;
        }
        if (num_serie.equals("")) {
            txt_num_serie.setBackground(Color.red);
            validacion++;
        }
        if (observaciones.equals("")) {
            jTextPane_observaciones.setText("No se ingreso detalles");
        }
        //si validacion cambio de 0 no se puede continuar
        if (validacion == 0) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "insert into equipos values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                //inserta dentro de la tabla equipos ñlos siguientes datos

                pst.setInt(1, 0);
                pst.setInt(2, IDcliente_update);
                pst.setString(3, tipo_equipo);
                pst.setString(4, marca);
                pst.setString(5, modelo);
                pst.setString(6, num_serie);
                pst.setString(7, dia_ingreso);
                pst.setString(8, mes_ingreso);
                pst.setString(9, anno_ingreso);
                pst.setString(10, observaciones);
                pst.setString(11, estatus);
                pst.setString(12, user);
                pst.setString(13, "");//observaciones del tecnico
                pst.setString(14, "");//tecnico que dio la valoracion o hizo el trabajo

                pst.executeUpdate();//subida de datos
                cn.close();

                //registroso exitoso
                txt_nombreClient.setBackground(Color.GREEN);
                txt_modelo.setBackground(Color.GREEN);
                txt_num_serie.setBackground(Color.GREEN);

                JOptionPane.showMessageDialog(null, "Registro exitoso");
                this.dispose();//cierra esta interfaz al guardar datos
                
            } catch (SQLException e) {
                System.err.println("Error en interfaz registrar equipo");
                JOptionPane.showMessageDialog(null, "ERROR ,No se pudo guardar los datos , porfavor comtacte al administrador.");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Porfavor rellene todos los campos.");
        }


    }//GEN-LAST:event_jButton_Registrar2ActionPerformed

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
            java.util.logging.Logger.getLogger(Registra_equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registra_equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registra_equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registra_equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registra_equipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmb_marca;
    private javax.swing.JComboBox cmb_tipo_equipo;
    private javax.swing.JButton jButton_Registrar2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_daño_reportado;
    private javax.swing.JLabel jLabel_marca;
    private javax.swing.JLabel jLabel_modelo;
    private javax.swing.JLabel jLabel_numero_serie;
    private javax.swing.JLabel jLabel_tipo_equipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane_observaciones;
    private javax.swing.JTextField txt_modelo;
    private javax.swing.JTextField txt_nombreClient;
    private javax.swing.JTextField txt_num_serie;
    // End of variables declaration//GEN-END:variables
}
