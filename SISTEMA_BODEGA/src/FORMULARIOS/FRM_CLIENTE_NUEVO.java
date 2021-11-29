
package FORMULARIOS;
import BASE.conectaBD;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
public class FRM_CLIENTE_NUEVO extends javax.swing.JFrame {
 conectaBD cnx=new conectaBD();
 int Sw;
 
  Date now=new Date(System.currentTimeMillis());
    SimpleDateFormat date= new SimpleDateFormat("yyyy-MM-dd");
       public void convertiraMayusculas(javax.swing.JTextField jTextfieldS){
 String cadena= (jTextfieldS.getText()).toUpperCase();
 jTextfieldS.setText(cadena);
 }
       
 public void MOSTRAR_DATOS_EN_VENTA(){
 String cod,sql;
 cod=this.jtxtdni.getText();
 sql="SELECT * FROM CLIENTE WHERE dni='" + cod +"'";
try{
 cnx.rs=cnx.stm.executeQuery(sql);
 if(cnx.rs.next()){
 FRM_VENTA_PRODUCTO_BOLETA.jtxtcodcliente.setText(cnx.rs.getString(1));
 FRM_VENTA_PRODUCTO_BOLETA.jtxtdni.setText(cnx.rs.getString(2));
 FRM_VENTA_PRODUCTO_BOLETA.jlblcliente.setText(cnx.rs.getString(3));
 FRM_VENTA_PRODUCTO_BOLETA.jlbldireccion.setText(cnx.rs.getString(7));
 this.dispose();

 }
}
catch (Exception e){
 System.out.println(e.getMessage());
}
} 
   
      public void Limpiar(){
          this.jtxtcodigo.setText("");
          this.jtxtdni.setText("");
          this.jtxtnombre.setText("");
          this.jtxttelefono.setText("");
          this.jcbosexo.setSelectedItem("");
          this.jdcfecha.setDate(now);
          this.jtxtdireccion.setText("");
          this.jtxtdni.requestFocus();
      }
      
   
      
      public void Botones(boolean estado){
         this.jBtnGuardar.setEnabled(!estado);
         this.jBtnCancelar.setEnabled(!estado);          
        } 
   
      public void Guardar(){
         String sql="SELECT *FROM V_MANTENIMIENTO_CLIENTE";
          String dni,nombre,telefono,sexo,fecha,direccion,codigo;
          int r;
          codigo=this.jtxtcodigo.getText();
          dni=this.jtxtdni.getText();
          nombre=this.jtxtnombre.getText();
          telefono=this.jtxttelefono.getText();
          sexo=this.jcbosexo.getSelectedItem().toString();
          fecha=date.format(this.jdcfecha.getDate());
          direccion=this.jtxtdireccion.getText();
          
           if (dni.equals("")||nombre.equals("")|| telefono.equals("")||sexo.equals("")||
  fecha.equals("")|| direccion.equals("")){
  JOptionPane.showMessageDialog(null,"existe espacios en blanco","error", JOptionPane.ERROR_MESSAGE);
           }
       else{
          try{
              if(Sw==0) {
                 cnx.stm.execute("INSERT INTO CLIENTE VALUES ('"+dni+"','"+nombre+"','"+telefono+"','"+sexo+"','"+fecha+"','"+direccion+"')");
                   JOptionPane.showMessageDialog(null,"DATOS GUARDADOS CORRECTAMENTE","Grabar",1);
                  
                }
              
               }
         catch(Exception e)    {
             System.out.println(e.getMessage());
         }     
       
        Botones(true);
        Limpiar();
         dispose();
        }
      } 
      
 public FRM_CLIENTE_NUEVO() {
  initComponents();
     this.setLocationRelativeTo(this);
        this.setResizable(false);
        solonumeros(jtxtdni);
        sololetras(jtxtnombre);
        solonumeros(jtxttelefono);
    
 }


 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JGB1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jBtnGuardar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtxtnombre = new javax.swing.JTextField();
        jtxttelefono = new javax.swing.JTextField();
        jtxtdni = new javax.swing.JTextField();
        jcbosexo = new javax.swing.JComboBox();
        jtxtdireccion = new javax.swing.JTextField();
        jtxtcodigo = new javax.swing.JTextField();
        jlblc = new javax.swing.JLabel();
        jdcfecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("CONTROLES"));

        jBtnGuardar.setBackground(new java.awt.Color(102, 102, 255));
        jBtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/guardar.png"))); // NOI18N
        jBtnGuardar.setText("GUARDAR");
        jBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarActionPerformed(evt);
            }
        });

        jBtnCancelar.setBackground(new java.awt.Color(102, 102, 255));
        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/cancel.png"))); // NOI18N
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
                .addGap(35, 35, 35)
                .addComponent(jBtnGuardar)
                .addGap(48, 48, 48)
                .addComponent(jBtnCancelar)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS DEL CLIENTE"));

        jLabel2.setText("DNI");

        jLabel5.setText("NOMBRE");

        jLabel6.setText("TELEFONO");

        jLabel7.setText("SEXO");

        jLabel8.setText("FECHA.NAC");

        jLabel9.setText("DIRECCION");

        jtxtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtnombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtnombreKeyReleased(evt);
            }
        });

        jtxttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxttelefonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxttelefonoKeyTyped(evt);
            }
        });

        jtxtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtdniKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtdniKeyTyped(evt);
            }
        });

        jcbosexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "F", "M" }));
        jcbosexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbosexoKeyPressed(evt);
            }
        });

        jtxtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtdireccionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtdireccionKeyReleased(evt);
            }
        });

        jtxtcodigo.setEditable(false);
        jtxtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtcodigoActionPerformed(evt);
            }
        });

        jlblc.setText("CODIGO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jdcfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jlblc))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxttelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jdcfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   public void solonumeros (JTextField a){
  a.addKeyListener(new KeyAdapter(){
    public void keyTyped (KeyEvent e){
    char c=e.getKeyChar();
    if(!Character.isDigit(c)){
     getToolkit().beep();
     e.consume();
    }     
            
   }
  }); 
 }
 public void sololetras (JTextField a){
  a.addKeyListener(new KeyAdapter(){
    public void keyTyped (KeyEvent e){
    char c=e.getKeyChar();
    if(!Character.isLetter(c) && !Character.isSpaceChar(c) ){        
     getToolkit().beep();
     e.consume();
    }
   }
  }); 
 }
 private void jdcfechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdcfechaKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   this.jtxtdireccion.requestFocus();
  }
 }//GEN-LAST:event_jdcfechaKeyPressed

 private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       String sql;
        sql="SELECT * FROM V_MANTENIMIENTO_CLIENTE";
        cnx.conectar();
        this.jdcfecha.setDate(now);
        this.jtxtdni.requestFocus();
   
 }//GEN-LAST:event_formWindowOpened

 private void jBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarActionPerformed
 try{
  this.jlblc.setVisible(false);
  this.jtxtcodigo.setVisible(false);
   Guardar();
  MOSTRAR_DATOS_EN_VENTA();
  }
  catch(Exception e){
   System.out.println(e.getMessage());
  }
 }//GEN-LAST:event_jBtnGuardarActionPerformed

 private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed

 dispose();
  

 }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jtxtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtcodigoActionPerformed

    }//GEN-LAST:event_jtxtcodigoActionPerformed

    private void jtxtdireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdireccionKeyReleased
        convertiraMayusculas(jtxtdireccion);  // TODO add your handling code here:
    }//GEN-LAST:event_jtxtdireccionKeyReleased

    private void jtxtdireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdireccionKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            this.jBtnGuardar.requestFocus();
        }
    }//GEN-LAST:event_jtxtdireccionKeyPressed

    private void jcbosexoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbosexoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            this.jdcfecha.requestFocus();
        }
    }//GEN-LAST:event_jcbosexoKeyPressed

    private void jtxtdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdniKeyTyped
        String Caracteres = jtxtdni.getText();
        if(Caracteres.length()>=8){
            evt.consume();
        }
    }//GEN-LAST:event_jtxtdniKeyTyped

    private void jtxtdniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdniKeyPressed
        String sql,dni;
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            dni=this.jtxtdni.getText();
            sql="SELECT * FROM V_MANTENIMIENTO_CLIENTE WHERE dni='"+ dni +"'";
            try{
                cnx.rs=cnx.stm.executeQuery(sql);
                if(cnx.rs.next()){
                    JOptionPane.showMessageDialog(null,"CLIENTE YA ESTA REGISTRADO","Aviso",1);
                    Limpiar();
                }
                else{

                    this.jtxtnombre.requestFocus();

                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_jtxtdniKeyPressed

    private void jtxttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxttelefonoKeyTyped
        String Caracteres = jtxttelefono.getText();
        if(Caracteres.length()>=9){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxttelefonoKeyTyped

    private void jtxttelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxttelefonoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            this.jcbosexo.requestFocus();
        }
    }//GEN-LAST:event_jtxttelefonoKeyPressed

    private void jtxtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtnombreKeyReleased
        convertiraMayusculas(jtxtnombre);  // TODO add your handling code here:
    }//GEN-LAST:event_jtxtnombreKeyReleased

    private void jtxtnombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtnombreKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            this.jtxttelefono.requestFocus();
        }
    }//GEN-LAST:event_jtxtnombreKeyPressed

 /**
  * @param args the command line
  * arguments
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
   java.util.logging.Logger.getLogger(FRM_CLIENTE_NUEVO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   java.util.logging.Logger.getLogger(FRM_CLIENTE_NUEVO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   java.util.logging.Logger.getLogger(FRM_CLIENTE_NUEVO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
   java.util.logging.Logger.getLogger(FRM_CLIENTE_NUEVO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }
        //</editor-fold>
        //</editor-fold>

  /* Create and display the form */
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new FRM_CLIENTE_NUEVO().setVisible(true);
   }
  });
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup JGB1;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnGuardar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox jcbosexo;
    private com.toedter.calendar.JDateChooser jdcfecha;
    private javax.swing.JLabel jlblc;
    private javax.swing.JTextField jtxtcodigo;
    private javax.swing.JTextField jtxtdireccion;
    public static javax.swing.JTextField jtxtdni;
    private javax.swing.JTextField jtxtnombre;
    private javax.swing.JTextField jtxttelefono;
    // End of variables declaration//GEN-END:variables
}
