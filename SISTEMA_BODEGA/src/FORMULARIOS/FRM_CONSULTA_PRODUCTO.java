
package FORMULARIOS;

import BASE.conectaBD;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class FRM_CONSULTA_PRODUCTO extends javax.swing.JFrame {
conectaBD cnx=new conectaBD();

public void CargaCombocategoria(){
 String sql="SELECT nombre from CATEGORIA  ORDER BY 1";
try{
cnx.rs=cnx.stm.executeQuery(sql);
while(cnx.rs.next()){
jcbocategoria.addItem(cnx.rs.getString(1));

}
}catch(Exception e){
System.out.println(e.getMessage());
}
}
public void CargaCombomarca(){
try{
cnx.rs=cnx.stm.executeQuery("SELECT  nombre FROM MARCA ORDER BY 1");
jcbomarca.removeAllItems();
while(cnx.rs.next()){
jcbomarca.addItem(cnx.rs.getString(1));
}
}catch(Exception e){
System.out.println(e.getMessage());
}
}
  public void icono(){
      Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IMAGENES/iconpais.jpg"));
      setIconImage(icon);
      setVisible(true);
    }
    
 public void LimpiarTabla(DefaultTableModel model){
  int x;
  for (x=model.getRowCount()-1; x>=0;x--){
   model.removeRow(x);
   
  }  
 }
  public void LlenarTabla(String sql){
 
   try{
    //consulta
    cnx.rs=cnx.stm.executeQuery(sql);
    //defino la variable
    DefaultTableModel model=(DefaultTableModel) jtbproducto.getModel();
    //limpio los datos
    LimpiarTabla (model);
    //llenar los datos
    while(cnx.rs.next()){
     String col1=cnx.rs.getString(1);
     String col2=cnx.rs.getString(2);
     String col3=cnx.rs.getString(3);
     String col4=cnx.rs.getString(4);
     String col5=cnx.rs.getString(5);
     String col6=cnx.rs.getString(6);
     String col7=cnx.rs.getString(7);   
     String col8=cnx.rs.getString(8);
       
     //vRow es ifual a una fila
     Vector vRow=new Vector ();
     vRow.addElement(col1);
     vRow.addElement(col2);
     vRow.addElement(col3);
     vRow.addElement(col4);
     vRow.addElement(col5); 
     vRow.addElement(col6);
     vRow.addElement(col7);
     vRow.addElement(col8);
     
     model.addRow(vRow);     
    }
   }
   catch (Exception e){
    System.out.println(e.getMessage());
     
   }
  }
  

  
  
 

 public FRM_CONSULTA_PRODUCTO() {
  initComponents();
    this.setLocationRelativeTo(this);
    this.setResizable(false);
 }

 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbgbuscar = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbproducto = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jrb1 = new javax.swing.JRadioButton();
        jrb4 = new javax.swing.JRadioButton();
        jtxtnombre = new javax.swing.JTextField();
        jcbocategoria = new javax.swing.JComboBox();
        jbttodos = new javax.swing.JButton();
        jbtnmostrar = new javax.swing.JButton();
        jbtnsalir = new javax.swing.JButton();
        jrb2 = new javax.swing.JRadioButton();
        jrb3 = new javax.swing.JRadioButton();
        jtxtcodigo = new javax.swing.JTextField();
        jcbomarca = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CONSULTA PRODUCTOS");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jtbproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "PRODUCTO", "COSTO", "PRECIO", "STOCK", "FECHA.V", "MARCA", "CATEGORIA"
            }
        ));
        jScrollPane1.setViewportView(jtbproducto);
        if (jtbproducto.getColumnModel().getColumnCount() > 0) {
            jtbproducto.getColumnModel().getColumn(0).setMinWidth(20);
            jtbproducto.getColumnModel().getColumn(0).setMaxWidth(60);
            jtbproducto.getColumnModel().getColumn(2).setMinWidth(60);
            jtbproducto.getColumnModel().getColumn(2).setMaxWidth(40);
            jtbproducto.getColumnModel().getColumn(3).setMinWidth(50);
            jtbproducto.getColumnModel().getColumn(3).setMaxWidth(200);
            jtbproducto.getColumnModel().getColumn(4).setMinWidth(40);
            jtbproducto.getColumnModel().getColumn(4).setMaxWidth(100);
            jtbproducto.getColumnModel().getColumn(5).setMinWidth(120);
            jtbproducto.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SELECCIONE CRITERIO DE BUSQUEDA:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        jbgbuscar.add(jrb1);
        jrb1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrb1.setForeground(new java.awt.Color(255, 51, 51));
        jrb1.setText("CODIGO");
        jrb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb1ActionPerformed(evt);
            }
        });

        jbgbuscar.add(jrb4);
        jrb4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrb4.setForeground(new java.awt.Color(255, 51, 51));
        jrb4.setText("CATEGORIA");
        jrb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb4ActionPerformed(evt);
            }
        });

        jtxtnombre.setBackground(new java.awt.Color(255, 255, 204));
        jtxtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtnombreKeyReleased(evt);
            }
        });

        jbttodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/save_32x32.png"))); // NOI18N
        jbttodos.setText("MOSTRAR ");
        jbttodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttodosActionPerformed(evt);
            }
        });

        jbtnmostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar.png"))); // NOI18N
        jbtnmostrar.setText("BUSCAR");
        jbtnmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnmostrarActionPerformed(evt);
            }
        });

        jbtnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/sali.jpg"))); // NOI18N
        jbtnsalir.setText("SALIR");
        jbtnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnsalirActionPerformed(evt);
            }
        });

        jbgbuscar.add(jrb2);
        jrb2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrb2.setForeground(new java.awt.Color(255, 51, 51));
        jrb2.setText("PRODUCTO");
        jrb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb2ActionPerformed(evt);
            }
        });

        jbgbuscar.add(jrb3);
        jrb3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrb3.setForeground(new java.awt.Color(255, 51, 51));
        jrb3.setText("MARCA");
        jrb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb3ActionPerformed(evt);
            }
        });

        jtxtcodigo.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jrb2)
                        .addGap(19, 19, 19)
                        .addComponent(jtxtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jrb1)
                        .addGap(39, 39, 39)
                        .addComponent(jtxtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jrb4)
                        .addGap(21, 21, 21)
                        .addComponent(jcbocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jrb3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jcbomarca, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(222, 222, 222)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnmostrar)
                    .addComponent(jbtnsalir)
                    .addComponent(jbttodos))
                .addGap(0, 253, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtnmostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbttodos)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnsalir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrb1)
                            .addComponent(jtxtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jrb2)
                            .addComponent(jtxtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbomarca, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrb3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrb4)
                            .addComponent(jcbocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
   String sql="SELECT*FROM V_MANTENIMIENTO_PRODUCTO";
  icono();
  this.jrb1.setSelected(true);
  this.jcbomarca.setEnabled(false);
  this.jtxtnombre.setEnabled(false);

  this.jcbocategoria.setEnabled(false);
  cnx.conectar();
  CargaCombocategoria();
   CargaCombomarca();
  LlenarTabla(sql);
 }//GEN-LAST:event_formWindowOpened

 private void jrb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb1ActionPerformed
this.jtxtnombre.setEnabled(false);
  this.jtxtcodigo.setEnabled(true);
  this.jcbomarca.setEnabled(false);
   this.jcbocategoria.setEnabled(false);
 }//GEN-LAST:event_jrb1ActionPerformed

 private void jrb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb4ActionPerformed
  this.jtxtnombre.setEnabled(false);
   this.jtxtcodigo.setEnabled(false);
 this.jcbomarca.setEnabled(false);
   this.jcbocategoria.setEnabled(true);
 }//GEN-LAST:event_jrb4ActionPerformed

 private void jbtnmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnmostrarActionPerformed
 if(this.jrb1.isSelected()){
if(this.jtxtcodigo.getText().equals("")){
 JOptionPane.showMessageDialog(null, "INGRESE CODIGO A BUSCAR","Consulta",0);
 this.jtxtcodigo.requestFocus();
 return;
}
String dato=this.jtxtcodigo.getText();
String sql1="SELECT*FROM V_MANTENIMIENTO_PRODUCTO where idproducto='"+dato+"'";
try{
 cnx.rs=cnx.stm.executeQuery(sql1);
 if(cnx.rs.next()){
  LlenarTabla(sql1);
  this.jtxtcodigo.setText("");
 }
 else{
  JOptionPane.showMessageDialog(null, "CODIGO NO ENCONTRADO","Error",0);
  this.jtxtcodigo.setText("");
  this.jtxtcodigo.requestFocus();
 }
}
catch (Exception e){
 System.out.println(e.getMessage());
}
 }
 if(this.jrb3.isSelected()){
  String dato =this.jcbomarca.getSelectedItem().toString();
  String sql2="SELECT*FROM V_MANTENIMIENTO_PRODUCTO where marca='"+dato+"'";
  try{
   LlenarTabla(sql2);
  }
  catch(Exception e){
   System.out.println(e.getMessage());
  }
 }
 if(this.jrb4.isSelected()){
  String dato =this.jcbocategoria.getSelectedItem().toString();
  String sql2="SELECT*FROM V_MANTENIMIENTO_PRODUCTO where categoria='"+dato+"'";
  try{
   LlenarTabla(sql2);
  }
  catch(Exception e){
   System.out.println(e.getMessage());
  }
 }
 }//GEN-LAST:event_jbtnmostrarActionPerformed

 private void jbttodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttodosActionPerformed
   String sql ="SELECT*FROM V_MANTENIMIENTO_PRODUCTO";
  try{
   LlenarTabla(sql);
  }
  catch(Exception e){
   System.out.println(e.getMessage());
  }
 }//GEN-LAST:event_jbttodosActionPerformed

 private void jbtnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnsalirActionPerformed
this.dispose();  // TODO add your handling code here:
 }//GEN-LAST:event_jbtnsalirActionPerformed

 private void jrb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb2ActionPerformed
  this.jtxtcodigo.setEnabled(false);
this.jcbomarca.setEnabled(false);
this.jtxtnombre.setEnabled(true);
   this.jcbocategoria.setEnabled(false);  // TODO add your handling code here:
 }//GEN-LAST:event_jrb2ActionPerformed

 private void jrb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb3ActionPerformed
  this.jtxtcodigo.setEnabled(false);
this.jcbomarca.setEnabled(true);
this.jtxtnombre.setEnabled(false);
this.jcbocategoria.setEnabled(false);   // TODO add your handling code here:
 }//GEN-LAST:event_jrb3ActionPerformed

 private void jtxtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtnombreKeyReleased
 String dato= this.jtxtnombre.getText();
  String sql1;
  try{
   if(jrb2.isSelected()){
    sql1="SELECT *FROM V_MANTENIMIENTO_PRODUCTO WHERE nombre LIKE '%"+dato+"%'";
    cnx.rs=cnx.stm.executeQuery(sql1);
    LlenarTabla(sql1);;
   }
   
  
  }
  catch(Exception e){
   System.out.println(e.getMessage());
  }
 }//GEN-LAST:event_jtxtnombreKeyReleased

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      
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
   java.util.logging.Logger.getLogger(FRM_CONSULTA_PRODUCTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   java.util.logging.Logger.getLogger(FRM_CONSULTA_PRODUCTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   java.util.logging.Logger.getLogger(FRM_CONSULTA_PRODUCTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
   java.util.logging.Logger.getLogger(FRM_CONSULTA_PRODUCTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }
        //</editor-fold>

  /* Create and display the form */
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new FRM_CONSULTA_PRODUCTO().setVisible(true);
   }
  });
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup jbgbuscar;
    private javax.swing.JButton jbtnmostrar;
    private javax.swing.JButton jbtnsalir;
    private javax.swing.JButton jbttodos;
    private javax.swing.JComboBox jcbocategoria;
    private javax.swing.JComboBox jcbomarca;
    private javax.swing.JRadioButton jrb1;
    private javax.swing.JRadioButton jrb2;
    private javax.swing.JRadioButton jrb3;
    private javax.swing.JRadioButton jrb4;
    private javax.swing.JTable jtbproducto;
    private javax.swing.JTextField jtxtcodigo;
    private javax.swing.JTextField jtxtnombre;
    // End of variables declaration//GEN-END:variables
}
