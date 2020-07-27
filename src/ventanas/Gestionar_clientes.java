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

public class Gestionar_clientes extends javax.swing.JFrame {
//variables 

    String user;
    public static int IDcliente_update = 0;

    //para click en la tabla o interacion con los datos en la tabla 
    DefaultTableModel model = new DefaultTableModel();
    
    public Gestionar_clientes() {
        initComponents();
        
        user = Login.user;
        
        setSize(630, 340);
        setTitle("Sesión de " + user);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/nuevo wallpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        //conexion base de datos
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select id_cliente, nombre_cliente, mail_cliente, tel_cliente, ultima_modificacion from clientes");

            //ejecutamos la orden 
            ResultSet rs = pst.executeQuery();

//model del jtable creado anteriormente se debe poner dentro del jscroppanel
            jTable_clientes = new JTable(model);
            jScrollPane1.setViewportView(jTable_clientes);//tabla dentro del jscroppanel

            //creamos las columnas para los datos 
            model.addColumn(" ");
            model.addColumn("Nombre");
            model.addColumn("Em@il");
            model.addColumn("Teléfono");
            model.addColumn("Modificado por");

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
        //evento que escucha los clicks en la tabla
        jTable_clientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {//guarda el evento de manera temporal
                int fila_point = jTable_clientes.rowAtPoint(e.getPoint());
            //punto exacto de la fila donde este precionando

                //evento para las columnas
                int columna_point = 0;//solo porqwue queremos obtener el id de cada cliente paara la consulta en la BD

                //indicaciones al programa de cuando ya se tengas los dos valores osea que si el usuario dio click en las columns que tiene datos entonces
                if (fila_point > -1) {
                    IDcliente_update = (int) model.getValueAt(fila_point, columna_point);

                    //conexion entre faces cuando se toque algun dato en la tabla
                    InformacionCliente informacion_cliente = new InformacionCliente();
                    informacion_cliente.setVisible(true);
                    
                   
                }
            }
        });
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_clientes = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Clientes registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jTable_clientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_clientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 630, 180));

        jLabel7.setText("Creado por Ingetec ®");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 285, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Gestionar_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestionar_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestionar_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestionar_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestionar_clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_clientes;
    // End of variables declaration//GEN-END:variables
}
