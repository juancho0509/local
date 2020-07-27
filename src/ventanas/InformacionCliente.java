package ventanas;

//base de datos
import java.sql.*;
import clases.Conexion;

//pdf
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.awt.Color;

//imagenes jdk java
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


public class InformacionCliente extends javax.swing.JFrame {
    
    DefaultTableModel model = new DefaultTableModel();//permite interactuar con la tabla en caso d que se elija un registro
//ambito global
    int IDcliente_update = 0;//recuperar valor de otra variable 
    public static int IDequipo = 0;//enviar datos entre interfaces

    String user = "";
    
    public InformacionCliente() {

        //estos valores vienen desde otras interfaces
        user = Login.user;
        IDcliente_update = Gestionar_clientes.IDcliente_update;
        
        initComponents();
        setSize(635, 450);
        setResizable(false);
        //setTitle("Información del usuario " + user_update + " - Sesión de " + user);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/nuevo wallpaper.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from clientes where id_cliente = '" + IDcliente_update + "'");
            //selecciona todo de la tabla clientes donde la variable de cliente sea la misma enviada desde la interfaz

            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {//si se encuentra el id o valor
                setTitle("Información del cliente " + rs.getString("nombre_cliente") + " - Sesión de " + user);
                //quiero el valor de nombre_cliente y en esos textos pon quie es el cliente y el que esta usando el programa

                jLabel_Titulo.setText("Información del cliente " + rs.getString("nombre_cliente"));
                //llenado del j label titulo 

                //llena los campos de texto con los datos de la BD
                txt_nombre.setText(rs.getString("nombre_cliente"));
                txt_email.setText(rs.getString("mail_cliente"));
                txt_telefono.setText(rs.getString("tel_cliente"));
                txt_direccion.setText(rs.getString("dir_cliente"));
                txt_ultima_modificacion.setText(rs.getString("ultima_modificacion"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error en la conexion ala BD , mostrar datos del cliente" + e);
            JOptionPane.showMessageDialog(null, "Error al mostra los datos del cliente , porfavor contacte al administrador.");
        }
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente ='"
                    + IDcliente_update + "'");
            //selecciona todos esos datos donde el id cliente debe ser igualalo ingresado en id_cliente_update

            ResultSet rs = pst.executeQuery();

            //objeto tipo model para la tabla
            jTable_equipos = new JTable(model);
            jScrollPane_equipos.setViewportView(jTable_equipos);
            
            model.addColumn("ID equipo");
            model.addColumn("Tipo de equipo");
            model.addColumn("Marca");
            model.addColumn("Estatus");

            //bucle de lo equipos del cliente
            while (rs.next()) {//dice cuantos equipos perrtenecen al cliente
                Object[] fila = new Object[4];
                
                for (int i = 0; i < 4; i++) {//aqui carga en cada fila los datos
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);//contiene la informacion de la base de datos
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("ERROR en el llenado de la tabla equipos.");
        }
        
        jTable_equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {//guarda el evento de manera temporal
                int fila_point = jTable_equipos.rowAtPoint(e.getPoint());
            //punto exacto de la fila donde este precionando

                //evento para las columnas
                int columna_point = 0;//solo porque queremos obtener el id de cada cliente paara la consulta en la BD

                //indicaciones al programa de cuando ya se tengas los dos valores osea que si el usuario dio click en las columns que tiene datos entonces
                if (fila_point > -1) {
                    IDequipo = (int) model.getValueAt(fila_point, columna_point);

                    //conexion entre faces cuando se toque algun dato en la tabla
                    Informacion_equipo informacion_equipo = new Informacion_equipo();
                    informacion_equipo.setVisible(true);
                    
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

        jScrollPane_equipos = new javax.swing.JScrollPane();
        jTable_equipos = new javax.swing.JTable();
        jLabel_Titulo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        jLabel_mail = new javax.swing.JLabel();
        jLabel_telefono = new javax.swing.JLabel();
        jLabel_direccion = new javax.swing.JLabel();
        jLabel_ultima_modificacion = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_ultima_modificacion = new javax.swing.JTextField();
        jButton_Registrar = new javax.swing.JButton();
        jButton_actualizar = new javax.swing.JButton();
        jButton_imprimir_reporte = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_equipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane_equipos.setViewportView(jTable_equipos);

        getContentPane().add(jScrollPane_equipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 73, 377, 180));

        jLabel_Titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Información del cliente");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel_mail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_mail.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_mail.setText("Em@il :");
        getContentPane().add(jLabel_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel_telefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_telefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_telefono.setText("Teléfono :");
        getContentPane().add(jLabel_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 175, -1, -1));

        jLabel_direccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_direccion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_direccion.setText("Dirección :");
        getContentPane().add(jLabel_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel_ultima_modificacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_ultima_modificacion.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ultima_modificacion.setText("Ultima modificación por :");
        getContentPane().add(jLabel_ultima_modificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 303, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(102, 102, 102));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 75, 210, -1));

        txt_email.setBackground(new java.awt.Color(102, 102, 102));
        txt_email.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_email.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 135, 210, -1));

        txt_telefono.setBackground(new java.awt.Color(102, 102, 102));
        txt_telefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 210, -1));

        txt_direccion.setBackground(new java.awt.Color(102, 102, 102));
        txt_direccion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_direccion.setForeground(new java.awt.Color(255, 255, 255));
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_direccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 266, 210, -1));

        txt_ultima_modificacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_ultima_modificacion.setForeground(new java.awt.Color(0, 0, 0));
        txt_ultima_modificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ultima_modificacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ultima_modificacion.setCaretColor(new java.awt.Color(102, 102, 102));
        txt_ultima_modificacion.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txt_ultima_modificacion.setEnabled(false);
        txt_ultima_modificacion.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        getContentPane().add(txt_ultima_modificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 330, 210, -1));

        jButton_Registrar.setBackground(new java.awt.Color(255, 0, 0));
        jButton_Registrar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Registrar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Registrar.setText("Registrar equipo");
        jButton_Registrar.setBorder(null);
        jButton_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 265, 210, 35));

        jButton_actualizar.setBackground(new java.awt.Color(255, 0, 0));
        jButton_actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_actualizar.setText("Actualizar cliente");
        jButton_actualizar.setBorder(null);
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 210, 35));

        jButton_imprimir_reporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        jButton_imprimir_reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_imprimir_reporteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_imprimir_reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 260, 119, 100));

        jLabel7.setText("Creado por Ingetec ®");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarActionPerformed
        
        Registra_equipo registrar_equipo = new Registra_equipo();
        registrar_equipo.setVisible(true);

    }//GEN-LAST:event_jButton_RegistrarActionPerformed

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        int validacion = 0; // validad vacio o lleno

        String nombre, mail, telefono, direccion;
        
        nombre = txt_nombre.getText().trim();
        mail = txt_email.getText().trim();
        telefono = txt_telefono.getText().trim();
        direccion = txt_direccion.getText().trim();
        
        if (nombre.equals("")) {
            txt_nombre.setBackground(Color.red);
            validacion++;
        }
        if (mail.equals("")) {
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
        //validaciones
        if (validacion == 0) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "update clientes set nombre_cliente =?, mail_cliente=?, tel_cliente=?, dir_cliente=?, ultima_modificacion=? "
                        + "where id_cliente = '" + IDcliente_update + "'");
                //guarda los datos siguientes dependiendo de que id de usuariomtienes

                pst.setString(1, nombre);
                pst.setString(2, mail);
                pst.setString(3, telefono);
                pst.setString(4, direccion);
                pst.setString(5, user);
                
                pst.executeUpdate();
                cn.close();
                
                limpiar();
                
                txt_direccion.setBackground(Color.GREEN);
                txt_email.setBackground(Color.GREEN);
                txt_nombre.setBackground(Color.green);
                txt_telefono.setBackground(Color.GREEN);
                txt_ultima_modificacion.setBackground(Color.green);
                
                JOptionPane.showMessageDialog(null, "Actualización correcta. ");
                
                this.dispose();
            } catch (SQLException e) {
                System.err.println("error al actulizar cliente , boton actualizar");
                JOptionPane.showMessageDialog(null, "ERROR al actulizar cliente, porfavor contacte al administrador");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Porfavor rellene todos los campos.");
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_imprimir_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_imprimir_reporteActionPerformed
        Document documento = new Document();//generar pdf
        try {
            String ruta = System.getProperty("user.home");//dentro del escritorio
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + txt_nombre.getText().trim() + ".pdf"));
            //pdf con el nombre del usuario que estamos consultando

            //imagen
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/ingetec informatico.png");
            header.scaleToFit(650, 1000);//dimenciones
            header.setAlignment(Chunk.ALIGN_CENTER);//centrar

            Paragraph parrafo = new Paragraph();//texto centrado
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Información del cliente \n \n");
            //tipo de letra tamaño de letra negrita y color de letrass
            parrafo.setFont(FontFactory.getFont("tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            //armamos el pdf aqui
            documento.open();
            documento.add(header);//imagen
            documento.add(parrafo);//texto

            //crear una tabla que viene los datos de la BD
            PdfPTable tabla_cliente = new PdfPTable(5);//5 columnas
            tabla_cliente.addCell("ID");
            tabla_cliente.addCell("Nombre");
            tabla_cliente.addCell("E-mail");
            tabla_cliente.addCell("Telefono");
            tabla_cliente.addCell("Dirección");

            //base de datos
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from clientes where id_cliente = '" + IDcliente_update + "'");
                //seleciona todo de la tabla clientes , dependiendo del id del cliente que se esta consultado
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    do {     //no sabemos cuatos datos tenemos en la base d edatos asi que usamos esto                   
                        tabla_cliente.addCell(rs.getString(1));//id
                        tabla_cliente.addCell(rs.getString(2));//nombre del cliente
                        tabla_cliente.addCell(rs.getString(3));//email del cliente
                        tabla_cliente.addCell(rs.getString(4));//telefono
                        tabla_cliente.addCell(rs.getString(5));//direccion
                    } while (rs.next());//y no se detiene hasta que ya no haya ningun registro

                    documento.add(tabla_cliente);//porque ya esta echo el llenado de esta tabla

                }
                Paragraph parrafo2 = new Paragraph();
                parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo2.add("\n \n Equipos registrados \n \n");
                parrafo2.setFont(FontFactory.getFont("tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));
                
                documento.add(parrafo2);
                
                PdfPTable tabla_equipos = new PdfPTable(4);
                tabla_equipos.addCell("ID equipo");//titulo de cada columna
                tabla_equipos.addCell("Tipo");
                tabla_equipos.addCell("Marca");
                tabla_equipos.addCell("Estatus");

                //base de datos
                try {
                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement(
                            "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = '" + IDcliente_update + "'");
                    //selecciona esos datos de la tabla equipos donde lo que esta dentro de id _cliente sea lo msimo que tenemos en la 

                    ResultSet rs2 = pst2.executeQuery();
                    
                    if (rs2.next()) {
                        do {
                            tabla_equipos.addCell(rs2.getString(1)); //id
                            tabla_equipos.addCell(rs2.getString(2));//tipo
                            tabla_equipos.addCell(rs2.getString(3));//marca
                            tabla_equipos.addCell(rs2.getString(4));//estatus

                        } while (rs2.next());
                        documento.add(tabla_equipos);
                    }
                } catch (SQLException e) {
                    
                    System.err.println("Error al cargar equipos en la tabla" + e);
                }
                
            } catch (SQLException e) {
                System.err.println("Error al obtener datos del cliente y llenar en la tabla" + e);
            }
            documento.close();//cerramos el docuemnto
            JOptionPane.showMessageDialog(null, "Reporte creado correctamente.");
        } catch (DocumentException | IOException e) {//entrada y salida de datos y creaccion de docúmento
            System.err.println("ERROR en pdf o ruta de imagen.");
            JOptionPane.showMessageDialog(null, "ERROR al generar archivo PDF , contacte al administrador.");
        }

    }//GEN-LAST:event_jButton_imprimir_reporteActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Registrar;
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_imprimir_reporte;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_direccion;
    private javax.swing.JLabel jLabel_mail;
    private javax.swing.JLabel jLabel_telefono;
    private javax.swing.JLabel jLabel_ultima_modificacion;
    private javax.swing.JScrollPane jScrollPane_equipos;
    private javax.swing.JTable jTable_equipos;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_ultima_modificacion;
    // End of variables declaration//GEN-END:variables
public void limpiar() {
        txt_direccion.setText("");
        txt_email.setText("");
        txt_nombre.setText("");
        txt_telefono.setText("");
    }
}
