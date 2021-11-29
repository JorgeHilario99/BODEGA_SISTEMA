

package FORMULARIOS;

import BASE.conectaBD;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class FRM_VENCIMIENTO_PRODUCTO extends javax.swing.JFrame {
    conectaBD cnx=new conectaBD();
    
    Date now = new Date(System.currentTimeMillis());
 SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    
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
    DefaultTableModel model=(DefaultTableModel) jtbcliente.getModel();
    //limpio los datos
    LimpiarTabla (model);
    //llenar los datos
    while(cnx.rs.next()){
     String col1=cnx.rs.getString(1);
     String col2=cnx.rs.getString(2);
     String col3=cnx.rs.getString(4);
     String col4=cnx.rs.getString(5);
     String col5=cnx.rs.getString(6);
     String col6=cnx.rs.getString(7);
     String col7=cnx.rs.getString(8);   
    
       
     //vRow es ifual a una fila
     Vector vRow=new Vector ();
     vRow.addElement(col1);
     vRow.addElement(col2);
     vRow.addElement(col3);
     vRow.addElement(col4);
     vRow.addElement(col5); 
     vRow.addElement(col6);
     vRow.addElement(col7);
     
     model.addRow(vRow);     
    }
   }
   catch (Exception e){
    System.out.println(e.getMessage());
     
   }
  }
   
   
    
    public FRM_VENCIMIENTO_PRODUCTO() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbcliente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jdcfecha1 = new com.toedter.calendar.JDateChooser();
        jdcfecha2 = new com.toedter.calendar.JDateChooser();
        jBtnBuscar = new javax.swing.JButton();
        jBtnMostrar = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jtbcliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "PRODUCTO", "PRECIO", "STOCK", "FECHA.V", "MARCA", "CATEGORIA"
            }
        ));
        jScrollPane1.setViewportView(jtbcliente);
        if (jtbcliente.getColumnModel().getColumnCount() > 0) {
            jtbcliente.getColumnModel().getColumn(0).setMinWidth(80);
            jtbcliente.getColumnModel().getColumn(0).setMaxWidth(70);
            jtbcliente.getColumnModel().getColumn(1).setMinWidth(200);
            jtbcliente.getColumnModel().getColumn(1).setMaxWidth(100);
            jtbcliente.getColumnModel().getColumn(2).setMinWidth(80);
            jtbcliente.getColumnModel().getColumn(2).setMaxWidth(70);
            jtbcliente.getColumnModel().getColumn(3).setMinWidth(70);
            jtbcliente.getColumnModel().getColumn(3).setMaxWidth(60);
            jtbcliente.getColumnModel().getColumn(4).setMinWidth(120);
            jtbcliente.getColumnModel().getColumn(4).setMaxWidth(100);
            jtbcliente.getColumnModel().getColumn(5).setMinWidth(200);
            jtbcliente.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("DEL");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("AL");

        jdcfecha1.setDateFormatString("dd-MM-yyyy");

        jdcfecha2.setDateFormatString("dd-MM-yyyy");

        jBtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar.png"))); // NOI18N
        jBtnBuscar.setText("BUSCAR");
        jBtnBuscar.setToolTipText("");
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });

        jBtnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/notebook_32x32.png"))); // NOI18N
        jBtnMostrar.setText("MOSTRAR");
        jBtnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMostrarActionPerformed(evt);
            }
        });

        jBtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/sali.jpg"))); // NOI18N
        jBtnSalir.setText("SALIR");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jdcfecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jdcfecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jBtnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnMostrar)
                        .addGap(26, 26, 26)
                        .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jdcfecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcfecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String sql="SELECT * FROM V_MANTENIMIENTO_PRODUCTO ORDER BY nombre";
        cnx.conectar();
       LlenarTabla(sql);
       this.jdcfecha1.setDate(now);
       this.jdcfecha2.setDate(now);
    }//GEN-LAST:event_formWindowOpened

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
        String fecha1,fecha2;
        fecha1=date.format(this.jdcfecha1.getDate());
        fecha2=date.format(this.jdcfecha2.getDate());
        String sql1="SELECT * FROM PRODUCTO WHERE fecha_venci >='"+fecha1+"'AND fecha_venci <= '"+fecha2+"'";
        try{
            cnx.rs=cnx.stm.executeQuery(sql1);
            if(cnx.rs.next()){
                LlenarTabla(sql1);
            }
            else{
                JOptionPane.showMessageDialog(null, "No existe productos", "AVISO",1);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void jBtnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMostrarActionPerformed
        String sql1 ="SELECT * FROM V_MANTENIMIENTO_PRODUCTO";
        LlenarTabla(sql1);
    }//GEN-LAST:event_jBtnMostrarActionPerformed

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed

  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_VENCIMIENTO_PRODUCTO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnMostrar;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcfecha1;
    private com.toedter.calendar.JDateChooser jdcfecha2;
    private javax.swing.JTable jtbcliente;
    // End of variables declaration//GEN-END:variables
}
