package FORMULARIOS;

import BASE.conectaBD;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class FRM_MANTENIMIENTO_MARCA extends javax.swing.JFrame {

    conectaBD cnx = new conectaBD();
    int Sw;

    public void convertiraMayusculas(javax.swing.JTextField jTextfieldS) {
        String cadena = (jTextfieldS.getText()).toUpperCase();
        jTextfieldS.setText(cadena);
    }
    private TableRowSorter trsFiltro;

    public void buscarcategoria() {
        int Buscar = 0;
        if (jtxtbuscar.getText() == "MARCA") {
            Buscar = 0;
        }
        trsFiltro.setRowFilter(RowFilter.regexFilter(jtxtbuscar.getText(), 1, Buscar));
    }

    public void Limpiar() {
        this.jtxtcodigo.setText("");
        this.jtxtmarca.setText("");
        this.jtxtcodigo.requestFocus();

    }

    public void Cajas(boolean estado) {
        this.jtxtcodigo.setEnabled(estado);
        this.jtxtmarca.setEnabled(estado);

    }

    public void Botones(boolean estado) {
        this.jBtnNuevo.setEnabled(estado);
        this.jBtnGuardar.setEnabled(!estado);
        this.jBtnCancelar.setEnabled(!estado);
        this.jBtnEditar.setEnabled(estado);
        this.jBtnEliminar.setEnabled(estado);
        this.jBtnSalir.setEnabled(estado);
    }

    public void LimpiarTabla(DefaultTableModel model) {
        int x;
        for (x = model.getRowCount() - 1; x >= 0; x--) {
            model.removeRow(x);
        }
    }

    public void Mostrar() {
        String cod;
        try {
            cod = jtbcategoria.getValueAt(jtbcategoria.getSelectedRow(), 0).toString();
            cnx.rs = cnx.stm.executeQuery("SELECT * FROM V_MANTENIMIENTO_MARCA WHERE idmarca='" + cod + "'");
            if (cnx.rs.next()) {
                this.jtxtcodigo.setText(cnx.rs.getString(1));
                this.jtxtmarca.setText(cnx.rs.getString(2));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void LlenarTabla() {
        String sql;
        sql = "SELECT*FROM V_MANTENIMIENTO_MARCA ORDER BY nombre";
        try {
            //consulta
            cnx.rs = cnx.stm.executeQuery(sql);
            //defino la variable
            DefaultTableModel model = (DefaultTableModel) jtbcategoria.getModel();
            //limpio los datos
            LimpiarTabla(model);
            //llenar los datos
            while (cnx.rs.next()) {
                String col1 = cnx.rs.getString(1);
                String col2 = cnx.rs.getString(2);

                //vRow es ifual a una fila
                Vector vRow = new Vector();
                vRow.addElement(col1);
                vRow.addElement(col2);

                model.addRow(vRow);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public FRM_MANTENIMIENTO_MARCA() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        //  this.getContentPane().setBackground(Color.CYAN);
        sololetras(jtxtmarca);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbcategoria = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jtxtbuscar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jlblcodigo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtcodigo = new javax.swing.JTextField();
        jtxtmarca = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jBtnNuevo = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();
        jBtnGuardar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADMINISTRACION DE MARCA");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jtbcategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "CADIGO", "MARCA"
            }
        ));
        jtbcategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbcategoriaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbcategoriaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbcategoria);
        if (jtbcategoria.getColumnModel().getColumnCount() > 0) {
            jtbcategoria.getColumnModel().getColumn(0).setMinWidth(80);
            jtbcategoria.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("BUSCAR POR MARCA:");

        jtxtbuscar.setBackground(new java.awt.Color(255, 255, 204));
        jtxtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtbuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtbuscarKeyTyped(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("[REGISTRO DE DATOS MARCA]"));

        jlblcodigo.setText("CODIGO");

        jLabel2.setText("MARCA");

        jtxtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtcodigoKeyPressed(evt);
            }
        });

        jtxtmarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtmarcaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtmarcaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblcodigo)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblcodigo)
                    .addComponent(jtxtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jBtnNuevo.setBackground(new java.awt.Color(255, 51, 51));
        jBtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/nuevo.png"))); // NOI18N
        jBtnNuevo.setText("NUEVO");
        jBtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNuevoActionPerformed(evt);
            }
        });

        jBtnEditar.setBackground(new java.awt.Color(255, 51, 51));
        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Reporte I.png"))); // NOI18N
        jBtnEditar.setText("EDITAR");
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnEliminar.setBackground(new java.awt.Color(255, 51, 51));
        jBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Eliminarr.png"))); // NOI18N
        jBtnEliminar.setText("ELIMINAR");
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });

        jBtnSalir.setBackground(new java.awt.Color(255, 51, 51));
        jBtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/sali.jpg"))); // NOI18N
        jBtnSalir.setText("SALIR");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });

        jBtnGuardar.setBackground(new java.awt.Color(255, 51, 51));
        jBtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/guardar.png"))); // NOI18N
        jBtnGuardar.setText("GUADAR");
        jBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarActionPerformed(evt);
            }
        });

        jBtnCancelar.setBackground(new java.awt.Color(255, 51, 51));
        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/cancela.png"))); // NOI18N
        jBtnCancelar.setText("CANCELAR");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnEliminar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jBtnGuardar)
                        .addGap(33, 33, 33)
                        .addComponent(jBtnCancelar)))
                .addGap(18, 18, 18)
                .addComponent(jBtnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxtbuscar)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void sololetras(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c) && !Character.isSpaceChar(c)) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
    }
 private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     cnx.conectar();
     LlenarTabla();
     jtbcategoria.changeSelection(0, 0, false, true);
     Botones(true);
     Cajas(false);

 }//GEN-LAST:event_formWindowOpened

 private void jtbcategoriaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbcategoriaMousePressed

 }//GEN-LAST:event_jtbcategoriaMousePressed

 private void jtxtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbuscarKeyTyped
     jtxtbuscar.addKeyListener(new KeyAdapter() {
         public void keyReleased(final KeyEvent e) {
             String cadena = (jtxtbuscar.getText());
             jtxtbuscar.setText(cadena);
             repaint();
             buscarcategoria();
         }
     });
     trsFiltro = new TableRowSorter(jtbcategoria.getModel());
     jtbcategoria.setRowSorter(trsFiltro);
 }//GEN-LAST:event_jtxtbuscarKeyTyped

 private void jtbcategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbcategoriaMouseClicked
     Mostrar();
 }//GEN-LAST:event_jtbcategoriaMouseClicked

 private void jtxtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbuscarKeyReleased
     convertiraMayusculas(jtxtbuscar);  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtbuscarKeyReleased

 private void jBtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNuevoActionPerformed
     Sw = 0;
     Limpiar();
     Botones(false);
     Cajas(true);
     this.jtxtcodigo.setVisible(false);
     this.jlblcodigo.setVisible(false);
     this.jtxtmarca.requestFocus();
 }//GEN-LAST:event_jBtnNuevoActionPerformed
    public void guardar() {
        int r;
        String cod, marca;
        cod = this.jtxtcodigo.getText();
        marca = this.jtxtmarca.getText();

        if (marca.equals("")) {
            JOptionPane.showMessageDialog(null, "REGISTRE LA MARCA PORFAVOR", "error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {

                if (Sw == 0) {
                    cnx.stm.execute("INSERT INTO MARCA VALUES('" + marca + "')");
                    JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE ", "Grabar", 1);
                }
                if (Sw == 1) {

                    cnx.stm.execute("UPDATE  MARCa SET nombre='" + marca + "' WHERE idmarca='" + cod + "'");
                    JOptionPane.showMessageDialog(null, "DATOS MODIFICADOS CORRECTAMENTE ", "Grabar", 1);
                }
            } catch (SQLException a) {
                System.out.println(a.getMessage());
            }
            LlenarTabla();
            jtbcategoria.changeSelection(0, 0, false, true);
            Mostrar();
            Botones(true);
            Cajas(false);
        }
    }
 private void jBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarActionPerformed
     try {
         guardar();

     } catch (Exception e) {
         System.out.println(e.getMessage());
     }
 }//GEN-LAST:event_jBtnGuardarActionPerformed

 private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
     jtbcategoria.changeSelection(0, 0, false, true);
     Mostrar();
     Botones(true);
     Cajas(false);
 }//GEN-LAST:event_jBtnCancelarActionPerformed

 private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
     Sw = 1;
     Mostrar();
     Botones(false);
     Cajas(true);
     this.jtxtcodigo.setVisible(true);
     this.jlblcodigo.setVisible(true);
     this.jtxtmarca.requestFocus();
 }//GEN-LAST:event_jBtnEditarActionPerformed

 private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
     String sql, cod;
     int r;
     cod = this.jtbcategoria.getValueAt(this.jtbcategoria.getSelectedRow(), 0).toString();
     sql = "DELETE FROM MARCA WHERE idmarca='" + cod + "'";
     try {
         r = JOptionPane.showConfirmDialog(null, "DESEA ELIMINAR REGISTRO", "ESTA SEGURO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
         if (r == JOptionPane.YES_OPTION) {
             cnx.stm.execute(sql);
         }
     } catch (Exception e) {
         System.out.println(e.getMessage());
     }
     LlenarTabla();
     jtbcategoria.changeSelection(0, 0, false, true);
     Mostrar();
 }//GEN-LAST:event_jBtnEliminarActionPerformed

 private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
     this.dispose();
 }//GEN-LAST:event_jBtnSalirActionPerformed

 private void jtxtcodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcodigoKeyPressed
     if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
         this.jtxtmarca.requestFocus();

     }  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtcodigoKeyPressed

 private void jtxtmarcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtmarcaKeyReleased
     convertiraMayusculas(jtxtmarca);  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtmarcaKeyReleased

    private void jtxtmarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtmarcaKeyPressed
        String sql,nombre;
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   nombre=this.jtxtmarca.getText();
   sql="SELECT * FROM V_MANTENIMIENTO_MARCA WHERE nombre='"+nombre+"'";
   try{
    cnx.rs=cnx.stm.executeQuery(sql);
    if(cnx.rs.next()){
     JOptionPane.showMessageDialog(null,"MARCA YA ESTA REGISTRADO","Aviso",1);
     Limpiar();
    }
    else{

     this.jtxtmarca.requestFocus();

    }
   }catch(Exception e){
    System.out.println(e.getMessage());
   }
  }
    }//GEN-LAST:event_jtxtmarcaKeyPressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
        LlenarTabla();
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_MARCA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_MARCA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_MARCA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_MARCA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_MANTENIMIENTO_MARCA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnGuardar;
    private javax.swing.JButton jBtnNuevo;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlblcodigo;
    private javax.swing.JTable jtbcategoria;
    private javax.swing.JTextField jtxtbuscar;
    private javax.swing.JTextField jtxtcodigo;
    private javax.swing.JTextField jtxtmarca;
    // End of variables declaration//GEN-END:variables
}
