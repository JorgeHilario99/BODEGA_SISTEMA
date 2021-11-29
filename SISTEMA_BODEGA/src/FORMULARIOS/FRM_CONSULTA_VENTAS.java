

package FORMULARIOS;

import BASE.conectaBD;
import static FORMULARIOS.FRM_DETALLE_VENTA.jTbDetalle;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class FRM_CONSULTA_VENTAS extends javax.swing.JFrame {
      conectaBD cnx = new conectaBD();
      
        String sql ="SELECT * FROM V_CONSULTA_DETALLE";

          Date now = new Date(System.currentTimeMillis());
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
       
    
    public void MostrarenDetalle(){
        String cod=jTblDetalle.getValueAt(jTblDetalle.getSelectedRow(),0).toString();
       String sql="SELECT*FROM V_ENCABEZADO WHERE numventa='"+cod+"'";
    try{
     cnx.rs=cnx.stm.executeQuery(sql);
       if(cnx.rs.next()){
     FRM_DETALLE_VENTA.jLblFecha.setText(cnx.rs.getString(2));
     FRM_DETALLE_VENTA.jLblCli.setText(cnx.rs.getString(3));
     FRM_DETALLE_VENTA.jLblEmp.setText(cnx.rs.getString(4));
 }LlenarTablaDetalle();
}
catch (Exception e){
 System.out.println(e.getMessage());
}
 
  }
    public void LlenarTablaDetalle(){
        int col1=1;
        String cod=jTblDetalle.getValueAt(jTblDetalle.getSelectedRow(),0).toString();
        String detalle="SELECT *FROM V_DETALLE_VENTA WHERE numventa='"+cod+"'";
          try{
              cnx.rs= cnx.stm.executeQuery(detalle);//Se hace la consulta
             DefaultTableModel model= (DefaultTableModel) jTbDetalle.getModel(); //Defino la variabe
            Limpiar(model); //limpiamos
             while(cnx.rs.next()){
                  //Llenar datos
                 String col2 = cnx.rs.getString(2);
                 String col3 = cnx.rs.getString(3);
                 String col4 = cnx.rs.getString(4);
                 String col5 = cnx.rs.getString(5);
                 
                 Vector vRow = new Vector();
                 vRow.add(col1);
                 vRow.add(col2);
                 vRow.add(col3);
                 vRow.add(col4);
                 vRow.add(col5);
                 
                 model.addRow(vRow);
                 col1++;
             }
              
          }
          catch(Exception e){
              System.out.println(e.getMessage());
          }
    }

    public void CalcularGanancia() {
  double precio = 0;
  double costo = 0;
  double ganancia=0;
  for (int fila = 0; fila <= this.jTblDetalle.getRowCount() - 1; fila++) {
   precio=  precio + Double.parseDouble(this.jTblDetalle.getValueAt(fila, 3).toString());
   costo=  costo + Double.parseDouble(this.jTblDetalle.getValueAt(fila, 8).toString());
   ganancia= (double)(precio-costo);
  }
 }
    
    
    
     public void CargarComboEmpleado(){
        try{
            this.jCboEmpleado.removeAllItems();
            cnx.rs= cnx.stm.executeQuery("SELECT nombre FROM Empleado");
             while(cnx.rs.next()){
                 jCboEmpleado.addItem(cnx.rs.getString(1));
             } 
        }
        catch(Exception e){
            
        }
    }
    
      
      public void Limpiar(DefaultTableModel model) {
        int x;
        for (x = model.getRowCount() - 1; x >= 0; x--) {
            model.removeRow(x);
        }
    }

    public void LlenarTabla(String sql) {
       
        try {
            cnx.rs = cnx.stm.executeQuery(sql);
            DefaultTableModel model = (DefaultTableModel) jTblDetalle.getModel();
            Limpiar(model);
            while (cnx.rs.next()) {
                String col1 = cnx.rs.getString(1);
                String col2 = cnx.rs.getString(2);
                String col3 = cnx.rs.getString(3);
                String col4 = cnx.rs.getString(4);
                String col5 = cnx.rs.getString(5);
                String col6 = cnx.rs.getString(6);
                String col7 = cnx.rs.getString(7);
                String col8 = cnx.rs.getString(8);
                String col9 = cnx.rs.getString(9);
                
                Vector vRow = new Vector();
                vRow.add(col1);
                vRow.add(col2);
                vRow.add(col3);
                vRow.add(col4);
                vRow.add(col5);
                vRow.add(col6);
                vRow.add(col7);
                vRow.add(col8);
                vRow.add(col9);
                
                model.addRow(vRow);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
     public void CalcularTotal() {
         try{
  double total = 0;
  for (int fila = 0; fila <= this.jTblDetalle.getRowCount() - 1; fila++) {
   total = total + Double.parseDouble(this.jTblDetalle.getValueAt(fila, 6).toString());
  }
  this.jlbltotal.setText(String.valueOf(total));
         }
         catch(Exception e){
             System.out.println("HAY ERROR");
         }
 }
      
      
    
    public FRM_CONSULTA_VENTAS() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgBuscar = new javax.swing.ButtonGroup();
        jRbFecha = new javax.swing.JRadioButton();
        jBtnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblDetalle = new javax.swing.JTable();
        jdcfecha = new com.toedter.calendar.JDateChooser();
        jRbProducto = new javax.swing.JRadioButton();
        jtxtProducto = new javax.swing.JTextField();
        jRbEmpleado = new javax.swing.JRadioButton();
        jCboEmpleado = new javax.swing.JComboBox();
        jBtnMotrar = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jlbltotal = new javax.swing.JLabel();
        jdcfecha2 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CONSULTA DE VENTAS");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        bgBuscar.add(jRbFecha);
        jRbFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRbFecha.setForeground(new java.awt.Color(255, 0, 0));
        jRbFecha.setText("FECHA");
        jRbFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbFechaActionPerformed(evt);
            }
        });

        jBtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar.png"))); // NOI18N
        jBtnBuscar.setText("BUSCAR");
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });

        jTblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "CANTIDAD", "PRODUCTO", "PRECIO", "CLIENTE", "FECHA", "IMPORTE", "CLIENTE", "COSTO"
            }
        ));
        jTblDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblDetalleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblDetalle);
        if (jTblDetalle.getColumnModel().getColumnCount() > 0) {
            jTblDetalle.getColumnModel().getColumn(0).setMinWidth(80);
            jTblDetalle.getColumnModel().getColumn(0).setMaxWidth(70);
            jTblDetalle.getColumnModel().getColumn(1).setMinWidth(80);
            jTblDetalle.getColumnModel().getColumn(1).setMaxWidth(70);
            jTblDetalle.getColumnModel().getColumn(3).setMinWidth(80);
            jTblDetalle.getColumnModel().getColumn(3).setMaxWidth(70);
            jTblDetalle.getColumnModel().getColumn(4).setMinWidth(0);
            jTblDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
            jTblDetalle.getColumnModel().getColumn(7).setMinWidth(0);
            jTblDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
            jTblDetalle.getColumnModel().getColumn(8).setMinWidth(0);
            jTblDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        jdcfecha.setDateFormatString("dd-MM-yyyy");

        bgBuscar.add(jRbProducto);
        jRbProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRbProducto.setForeground(new java.awt.Color(255, 0, 0));
        jRbProducto.setText("PRODUCTO");
        jRbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbProductoActionPerformed(evt);
            }
        });

        jtxtProducto.setBackground(new java.awt.Color(255, 255, 204));
        jtxtProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtxtProducto.setForeground(new java.awt.Color(0, 0, 255));
        jtxtProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtProductoActionPerformed(evt);
            }
        });
        jtxtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtProductoKeyReleased(evt);
            }
        });

        bgBuscar.add(jRbEmpleado);
        jRbEmpleado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRbEmpleado.setForeground(new java.awt.Color(255, 0, 0));
        jRbEmpleado.setText("EMPLEADO");
        jRbEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbEmpleadoActionPerformed(evt);
            }
        });

        jCboEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboEmpleadoActionPerformed(evt);
            }
        });

        jBtnMotrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Reporte I.png"))); // NOI18N
        jBtnMotrar.setText("MOSTRAR");
        jBtnMotrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMotrarActionPerformed(evt);
            }
        });

        jBtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/sali.jpg"))); // NOI18N
        jBtnSalir.setText("SALIR");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("TOTAL VENTAS");

        jlbltotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbltotal.setForeground(new java.awt.Color(255, 51, 51));
        jlbltotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbltotal.setToolTipText("");
        jlbltotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jdcfecha2.setDateFormatString("dd-MM-yyyy");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("DEL");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("AL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRbEmpleado)
                        .addGap(18, 18, 18)
                        .addComponent(jCboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRbProducto)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRbFecha)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jdcfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jdcfecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnMotrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(253, 253, 253))
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jlbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jdcfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRbFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jdcfecha2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRbProducto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRbEmpleado)
                            .addComponent(jCboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jBtnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnMotrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cnx.conectar();
        LlenarTabla(sql);
        this.jdcfecha.setDate(now);
        this.jdcfecha2.setDate(now);
        CargarComboEmpleado();
        CalcularTotal();
        CalcularGanancia();
        this.jRbFecha.setSelected(true);
        this.jdcfecha.setEnabled(true);
        this.jdcfecha2.setEnabled(true);
        this.jtxtProducto.setEnabled(false);
        this.jCboEmpleado.setEnabled(true);
        
    }//GEN-LAST:event_formWindowOpened

    private void jtxtProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtProductoKeyReleased
       String dato =this.jtxtProducto.getText();
       String sql1="SELECT *FROM V_CONSULTA_DETALLE WHERE nombre LIKE '%"+dato+"%'";
       
       try{
           LlenarTabla(sql1);
           CalcularTotal();
       }
       catch(Exception e){
           System.out.println(e.getMessage());
       }
       //convertiraMayusculas(jtxtbuscnombre);
    }//GEN-LAST:event_jtxtProductoKeyReleased

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
         if(jRbFecha.isSelected()){
            String fecha,fecha2;
            fecha=date.format(this.jdcfecha.getDate());
            fecha2=date.format(this.jdcfecha2.getDate());
             String sql3="SELECT * FROM V_CONSULTA_DETALLE WHERE fecha >='"+fecha+"'AND fecha <= '"+fecha2+"'";
           
           try{
               cnx.rs=cnx.stm.executeQuery(sql3);
               if(cnx.rs.next()){
                   
                   LlenarTabla(sql3);
                   CalcularTotal();
                   CalcularGanancia();
               }
               else{
                   JOptionPane.showMessageDialog(null,"fecha no encontrada", "Aviso",0);
               }
               
           }
          catch(Exception e){
              System.out.println(e.getMessage());
          } 
        }
         
          if(jRbEmpleado.isSelected()){
            String empleado;
            empleado=this.jCboEmpleado.getSelectedItem().toString();
            String sql2="SELECT * FROM V_CONSULTA_DETALLE WHERE nombreempleado ='"+empleado+"'";
           try{
               cnx.rs=cnx.stm.executeQuery(sql2);
               if(cnx.rs.next()){
                   
                   LlenarTabla(sql2);
                   CalcularTotal();
                   CalcularGanancia();
               }
               else{
                   JOptionPane.showMessageDialog(null,"Este empleado no ah realizado ventas", "Aviso",1);
               }
               
           }
          catch(Exception e){
              System.out.println(e.getMessage());
          } 
        }
         
         
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void jRbFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbFechaActionPerformed
        this.jdcfecha.setEnabled(true);
        this.jdcfecha.setEnabled(true);
        this.jtxtProducto.setEnabled(false);
        this.jCboEmpleado.setEnabled(false);
    }//GEN-LAST:event_jRbFechaActionPerformed

    private void jRbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbProductoActionPerformed
        this.jdcfecha.setEnabled(false);
        this.jdcfecha2.setEnabled(false);
        this.jtxtProducto.setEnabled(true);
        this.jCboEmpleado.setEnabled(false);
    }//GEN-LAST:event_jRbProductoActionPerformed

    private void jRbEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbEmpleadoActionPerformed
        this.jdcfecha.setEnabled(false);
        this.jdcfecha2.setEnabled(false);
        this.jtxtProducto.setEnabled(false);
        this.jCboEmpleado.setEnabled(true);
    }//GEN-LAST:event_jRbEmpleadoActionPerformed

    private void jBtnMotrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMotrarActionPerformed
        
        String sql4="SELECT * FROM V_CONSULTA_DETALLE";
        LlenarTabla(sql4);
        CalcularTotal();
        CalcularGanancia();
    }//GEN-LAST:event_jBtnMotrarActionPerformed

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed

    private void jTblDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblDetalleMouseClicked
        
        FRM_DETALLE_VENTA ven=new FRM_DETALLE_VENTA();
        MostrarenDetalle();
        
        ven.show();
    }//GEN-LAST:event_jTblDetalleMouseClicked

    private void jtxtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtProductoActionPerformed

    private void jCboEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboEmpleadoActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_CONSULTA_VENTAS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgBuscar;
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnMotrar;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JComboBox jCboEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRbEmpleado;
    private javax.swing.JRadioButton jRbFecha;
    private javax.swing.JRadioButton jRbProducto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblDetalle;
    private com.toedter.calendar.JDateChooser jdcfecha;
    private com.toedter.calendar.JDateChooser jdcfecha2;
    private javax.swing.JLabel jlbltotal;
    private javax.swing.JTextField jtxtProducto;
    // End of variables declaration//GEN-END:variables
}
