package ventanas;

import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class Gestionar_equipos_tecnico extends javax.swing.JFrame {
//variables 

    String user;
  String nombre_cliente;
    public static int IDcliente = 0;

    //para click en la tabla o interacion con los datos en la tabla 
    DefaultTableModel model = new DefaultTableModel();

    public Gestionar_equipos_tecnico() {
        initComponents();

        user = Login.user;

        setSize(630, 380);
        setTitle("Sesión de " + user);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/nuevo wallpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        
        //para datos del equipo
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select id_equipo,id_cliente, tipo_equipo, marca, estatus from equipos");

            //ejecutamos la orden 
            ResultSet rs = pst.executeQuery();

          
//model del jtable creado anteriormente se debe poner dentro del jscroppanel
            jTable_equipos = new JTable(model);
            jScrollPanel_equipos.setViewportView(jTable_equipos);//tabla dentro del jscroppanel

            //creamos las columnas para los datos 
            model.addColumn("ID equipo");
            model.addColumn("ID cliente");
            model.addColumn("Tipo");
            model.addColumn("Marca");
            model.addColumn("Estatus");

            //nos permite colocar los datos de la base de datos dentro de las tablas 
            while (rs.next()) {
                Object[] fila = new Object[5];//crea 5 elementos

                for (int i = 0; i < 5; i++) {//i inicia en 0 y mientras i sea menor a 5 entonces aumenta de 1 en 1 

                    fila[i] = rs.getObject(i + 1);//el 1 por el rs.next por que es 0

                }
                //llenado del vector dentro de la tabla
                model.addRow(fila);
                 
            }
            cn.close();
             

        } catch (SQLException e) {
            System.out.println("error en conexion BD mostra tabla de clientes." + e);
            JOptionPane.showMessageDialog(null, "ERROR al mostrar los datos de la tabla clientes , porfavor contacte al administrador." + e);
        }
        obtenerTabla();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/logo ingetec 80.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPanel_equipos = new javax.swing.JScrollPane();
        jTable_equipos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        cmb_estatus = new javax.swing.JComboBox<String>();
        jButton_mostrar = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Equipos registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jTable_equipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Em@il", "Telefono", "Modificado por"
            }
        ));
        jScrollPanel_equipos.setViewportView(jTable_equipos);

        getContentPane().add(jScrollPanel_equipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 630, 180));

        jLabel7.setText("Creado por Ingetec ®");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "En garantia", "Fuera de garantia", "Mantenimiento pendiente", "Mantenimiento listo " }));
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 152, -1));

        jButton_mostrar.setBackground(new java.awt.Color(255, 0, 0));
        jButton_mostrar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_mostrar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_mostrar.setText("Mostrar");
        jButton_mostrar.setBorder(null);
        jButton_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_mostrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 260, 210, 35));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_mostrarActionPerformed
        String seleccion = cmb_estatus.getSelectedItem().toString();
        String query = "";//situacion en la que se encuentre el programa

        model.setRowCount(0);//limpia las filasa
        model.setColumnCount(0);//limpia columnas
        try {
            Connection cn = Conexion.conectar();
            if (seleccion.equals("En garantia")) {
                query = "select id_equipo, id_cliente, tipo_equipo, marca, estatus from equipos";
            } else {
                query = "select id_equipo, id_cliente, tipo_equipo, marca, estatus from equipos where estatus = '" + seleccion + "'";
            }
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            jTable_equipos = new JTable(model);
            jScrollPanel_equipos.setViewportView(jTable_equipos);

            model.addColumn("ID equipo");
            model.addColumn("ID cliente");
            model.addColumn("Tipo");
            model.addColumn("Marca");
            model.addColumn("Estatus");

            while (rs.next()) {
                Object[] fila = new Object[5];
                for (int i = 0; i < 5; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);//llena las filas
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("error al recuperar los registros del equipo" + e);
        }
        obtenerTabla();//ala escucha de cada ves que se presiona el boton mostra
    }//GEN-LAST:event_jButton_mostrarActionPerformed

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
            java.util.logging.Logger.getLogger(Gestionar_equipos_tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestionar_equipos_tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestionar_equipos_tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestionar_equipos_tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestionar_equipos_tecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JButton jButton_mostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPanel_equipos;
    private javax.swing.JTable jTable_equipos;
    // End of variables declaration//GEN-END:variables
public void obtenerTabla() {
        jTable_equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {//guarda el evento de manera temporal
                int fila_point = jTable_equipos.rowAtPoint(e.getPoint());
            //punto exacto de la fila donde este precionando

                //evento para las columnas
                int columna_point = 1;//solo porqwue queremos obtener el id de cada cliente paara la consulta en la BD

                //indicaciones al programa de cuando ya se tengas los dos valores osea que si el usuario dio click en las columns que tiene datos entonces
                if (fila_point > -1) {
                     IDcliente = (int) model.getValueAt(fila_point, columna_point);

                    //conexion entre faces cuando se toque algun dato en la tabla
                    Informacion_equipo_tecnico informcion_equipos_tecnico = new Informacion_equipo_tecnico();
                    informcion_equipos_tecnico.setVisible(true);
                    //revistar a que interfaz conectar por lo pronto uso mi programacion

                }
            }
        });
    }
}
