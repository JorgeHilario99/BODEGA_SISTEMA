
package FORMULARIOS;
import BASE.conectaBD; 
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Image;
import java.awt.Cursor;
import java.sql.SQLException;
import javax.swing.JOptionPane; 
public class FRM_ACCESO_SISTEMA extends javax.swing.JFrame {
conectaBD cnx=new conectaBD();
int ban=0;

 public FRM_ACCESO_SISTEMA() {
  initComponents();
  this.setLocationRelativeTo(this);
     this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
     
 }


 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtUsuario = new javax.swing.JTextField();
        JpswdClave = new javax.swing.JPasswordField();
        jBtnIngresar = new javax.swing.JButton();
        jBtnSlalir = new javax.swing.JButton();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INGRESAR AL SISTEMA");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/almacen.jpeg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 255));
        jLabel2.setText("INGRESAR AL SISTEMA DE VENTAS R.Y.C.H.");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("USUARIO");

        jLabel4.setText("CONTRASEÑA");

        jTxtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtUsuarioKeyPressed(evt);
            }
        });

        JpswdClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JpswdClaveActionPerformed(evt);
            }
        });
        JpswdClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JpswdClaveKeyPressed(evt);
            }
        });

        jBtnIngresar.setBackground(new java.awt.Color(255, 255, 204));
        jBtnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/save_32x32.png"))); // NOI18N
        jBtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIngresarActionPerformed(evt);
            }
        });

        jBtnSlalir.setBackground(new java.awt.Color(255, 255, 204));
        jBtnSlalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/sali.jpg"))); // NOI18N
        jBtnSlalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSlalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBtnIngresar)
                        .addGap(90, 90, 90)
                        .addComponent(jBtnSlalir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(JpswdClave)
                    .addComponent(jTxtUsuario))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jTxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JpswdClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnSlalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnIngresar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void ingresar(){
 String usuario;
 char[]  clave;
 String pwd;
 usuario =jTxtUsuario.getText();
 clave=JpswdClave.getPassword();
 pwd= new String(clave);
 try{
        //cnx.rs=cnx.stm.executeQuery("SELECT idcargo FROM CARGO WHERE nombre='"+ cargo +"'");
          //  while(cnx.rs.next()){
          //      codcargo=cnx.rs.getString("idcargo");
         //   }
         System.out.println(usuario);
         System.out.println(clave);
         String query = "SELECT idusuario,cargo,nombre,idempleado FROM USUARIO WHERE usuario='"+usuario
                +"' and clave='" +pwd +"'";
         System.out.println(query);
         cnx.rs=cnx.stm.executeQuery(query);
            if(cnx.rs.next()){
               this.setVisible(false);
               FRM_MENU_PRINCIPAL  FRM_MENU=new FRM_MENU_PRINCIPAL ();
               FRM_MENU.setVisible(true);
               
            }else{
                JOptionPane.showConfirmDialog(null,"CONTRASEÑA Y/O USUARIO INCORRECTO","Seguridad del Sistema",2);
                jTxtUsuario.setText("");
                JpswdClave.setText("");
                ban=ban+1;
            }
            if (ban==3){
                JOptionPane.showConfirmDialog(null,"Usted a agotado sus intentos","Seguridad del Sistema",2);
                System.exit(0);
            }
   
  }
  catch (Exception e) {
   System.out.println(e.getMessage());
   
  }
  
}
 private void jBtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIngresarActionPerformed
  ingresar();
 }//GEN-LAST:event_jBtnIngresarActionPerformed

 private void jBtnSlalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSlalirActionPerformed
  int r= JOptionPane.showConfirmDialog(null,"DESEA CANCELAR LA OPERACION","Salir",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE); 
                 if (r==JOptionPane.YES_OPTION){      
                     this.dispose();   
                 }  
 }//GEN-LAST:event_jBtnSlalirActionPerformed

 private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
  cnx.conectar();
  this.jTxtUsuario.requestFocus();
 }//GEN-LAST:event_formWindowOpened

 private void jTxtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtUsuarioKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
  this.JpswdClave.requestFocus();
  
 }
 }//GEN-LAST:event_jTxtUsuarioKeyPressed

 private void JpswdClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JpswdClaveActionPerformed
  // TODO add your handling code here:
 }//GEN-LAST:event_JpswdClaveActionPerformed

 private void JpswdClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JpswdClaveKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
  this.jBtnIngresar.requestFocus();
  ingresar();
 }
 }//GEN-LAST:event_JpswdClaveKeyPressed

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
   java.util.logging.Logger.getLogger(FRM_ACCESO_SISTEMA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   java.util.logging.Logger.getLogger(FRM_ACCESO_SISTEMA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   java.util.logging.Logger.getLogger(FRM_ACCESO_SISTEMA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
   java.util.logging.Logger.getLogger(FRM_ACCESO_SISTEMA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }
        //</editor-fold>

  /* Create and display the form */
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new FRM_ACCESO_SISTEMA().setVisible(true);
   }
  });
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField JpswdClave;
    private javax.swing.JButton jBtnIngresar;
    private javax.swing.JButton jBtnSlalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTxtUsuario;
    // End of variables declaration//GEN-END:variables
}
