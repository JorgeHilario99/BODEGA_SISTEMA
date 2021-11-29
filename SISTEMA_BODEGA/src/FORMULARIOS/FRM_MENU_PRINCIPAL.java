
package FORMULARIOS;

import BASE.conectaBD;
import java.security.Principal;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Cursor;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
public class FRM_MENU_PRINCIPAL extends javax.swing.JFrame {
     conectaBD cnx=new conectaBD();
                       
 public FRM_MENU_PRINCIPAL() {
  initComponents();
  this.setResizable(false);
  this.setLocationRelativeTo(this);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }

 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMMantenimiento = new javax.swing.JMenu();
        jMiCliente1 = new javax.swing.JMenuItem();
        jMiProducto1 = new javax.swing.JMenuItem();
        jMiMarca1 = new javax.swing.JMenuItem();
        jMiCategoria1 = new javax.swing.JMenuItem();
        jMiEmpleado1 = new javax.swing.JMenuItem();
        jMiCargo1 = new javax.swing.JMenuItem();
        jMTransaciones = new javax.swing.JMenu();
        jMiVentaProd = new javax.swing.JMenuItem();
        jMConsultas = new javax.swing.JMenu();
        jMiVentas = new javax.swing.JMenuItem();
        jMiVencimientoPr = new javax.swing.JMenuItem();
        jMiClientes = new javax.swing.JMenuItem();
        jMiProductos = new javax.swing.JMenuItem();
        jMiMarca = new javax.swing.JMenuItem();
        jMiCategoria = new javax.swing.JMenuItem();
        jMiEmpleado = new javax.swing.JMenuItem();
        jMiCargo = new javax.swing.JMenuItem();
        jMsalir = new javax.swing.JMenu();
        jMiSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BODEGA R.Y.C.H.");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLblNombre.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblNombre.setText("SISTEMA DE VENTAS R.Y.C.H.");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/almacen.jpeg"))); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jMMantenimiento.setBackground(new java.awt.Color(204, 204, 204));
        jMMantenimiento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/mantenimiento.jpg"))); // NOI18N
        jMMantenimiento.setText("MANTENIMIENTO");
        jMMantenimiento.setToolTipText("Mantenimiento ");
        jMMantenimiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMMantenimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMiCliente1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMiCliente1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiCliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/iempleado.jpg"))); // NOI18N
        jMiCliente1.setText("CLIENTE");
        jMiCliente1.setToolTipText("Mantenimiento Cliente");
        jMiCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiCliente1ActionPerformed(evt);
            }
        });
        jMMantenimiento.add(jMiCliente1);

        jMiProducto1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMiProducto1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiProducto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/process.png"))); // NOI18N
        jMiProducto1.setText("PRODUCTO");
        jMiProducto1.setToolTipText("Mantenimiento Producto");
        jMiProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiProducto1ActionPerformed(evt);
            }
        });
        jMMantenimiento.add(jMiProducto1);

        jMiMarca1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMiMarca1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiMarca1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/editar.gif"))); // NOI18N
        jMiMarca1.setText("MARCA");
        jMiMarca1.setToolTipText("Mantenimineto Categoria");
        jMiMarca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiMarca1ActionPerformed(evt);
            }
        });
        jMMantenimiento.add(jMiMarca1);

        jMiCategoria1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMiCategoria1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiCategoria1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/mantenimiento.gif"))); // NOI18N
        jMiCategoria1.setText("CATEGORIA");
        jMiCategoria1.setToolTipText("Mantenimineto Categoria");
        jMiCategoria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiCategoria1ActionPerformed(evt);
            }
        });
        jMMantenimiento.add(jMiCategoria1);

        jMiEmpleado1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMiEmpleado1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiEmpleado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/sunat.png"))); // NOI18N
        jMiEmpleado1.setText("EMPLEADO");
        jMiEmpleado1.setToolTipText("Mantenimiento Empleado");
        jMiEmpleado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiEmpleado1ActionPerformed(evt);
            }
        });
        jMMantenimiento.add(jMiEmpleado1);

        jMiCargo1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMiCargo1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiCargo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/cargo.png"))); // NOI18N
        jMiCargo1.setText("CARGO");
        jMiCargo1.setToolTipText("Mantenimineto Categoria");
        jMiCargo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiCargo1ActionPerformed(evt);
            }
        });
        jMMantenimiento.add(jMiCargo1);

        jMenuBar1.add(jMMantenimiento);

        jMTransaciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMTransaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/edit_32x32.png"))); // NOI18N
        jMTransaciones.setText("TRANSACCIONES");
        jMTransaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMTransaciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMTransaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMiVentaProd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMiVentaProd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiVentaProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/add_32x32.png"))); // NOI18N
        jMiVentaProd.setText("VENTA_PRODUCTOS");
        jMiVentaProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiVentaProdActionPerformed(evt);
            }
        });
        jMTransaciones.add(jMiVentaProd);

        jMenuBar1.add(jMTransaciones);

        jMConsultas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar.png"))); // NOI18N
        jMConsultas.setText("CONSULTAS");
        jMConsultas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMConsultas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMiVentas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMiVentas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/lens_32x32.png"))); // NOI18N
        jMiVentas.setText("VENTAS");
        jMiVentas.setToolTipText("Consulta Ventas");
        jMiVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiVentasActionPerformed(evt);
            }
        });
        jMConsultas.add(jMiVentas);

        jMiVencimientoPr.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMiVencimientoPr.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiVencimientoPr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/lens_32x32.png"))); // NOI18N
        jMiVencimientoPr.setText("VENCIMIENTO_PRODUCTOS");
        jMiVencimientoPr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiVencimientoPrActionPerformed(evt);
            }
        });
        jMConsultas.add(jMiVencimientoPr);

        jMiClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMiClientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/lens_32x32.png"))); // NOI18N
        jMiClientes.setText("CLIENTES");
        jMiClientes.setToolTipText("Consulta Clientes");
        jMiClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiClientesActionPerformed(evt);
            }
        });
        jMConsultas.add(jMiClientes);

        jMiProductos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMiProductos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/lens_32x32.png"))); // NOI18N
        jMiProductos.setText("PRODUCTO");
        jMiProductos.setToolTipText("Consulta Producto");
        jMiProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiProductosActionPerformed(evt);
            }
        });
        jMConsultas.add(jMiProductos);

        jMiMarca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMiMarca.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/lens_32x32.png"))); // NOI18N
        jMiMarca.setText("MARCA");
        jMiMarca.setToolTipText("Consulta Empleado");
        jMiMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiMarcaActionPerformed(evt);
            }
        });
        jMConsultas.add(jMiMarca);

        jMiCategoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMiCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/lens_32x32.png"))); // NOI18N
        jMiCategoria.setText("CATEGORIA");
        jMiCategoria.setToolTipText("Consulta Empleado");
        jMiCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiCategoriaActionPerformed(evt);
            }
        });
        jMConsultas.add(jMiCategoria);

        jMiEmpleado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMiEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/lens_32x32.png"))); // NOI18N
        jMiEmpleado.setText("EMPLEADO");
        jMiEmpleado.setToolTipText("Consulta Empleado");
        jMiEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiEmpleadoActionPerformed(evt);
            }
        });
        jMConsultas.add(jMiEmpleado);

        jMiCargo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMiCargo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/lens_32x32.png"))); // NOI18N
        jMiCargo.setText("CARGO");
        jMiCargo.setToolTipText("Consulta Empleado");
        jMiCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiCargoActionPerformed(evt);
            }
        });
        jMConsultas.add(jMiCargo);

        jMenuBar1.add(jMConsultas);

        jMsalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/exit.png"))); // NOI18N
        jMsalir.setText("SALIR");
        jMsalir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMsalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMiSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/sali.jpg"))); // NOI18N
        jMiSalir.setText("SALIR");
        jMiSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiSalirActionPerformed(evt);
            }
        });
        jMsalir.add(jMiSalir);

        jMenuBar1.add(jMsalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 private void jMiProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiProducto1ActionPerformed
  FRM_MANTENIMIENTO_PRODUCTO producto = new FRM_MANTENIMIENTO_PRODUCTO();  
  producto.setLocationRelativeTo(null); 
  producto.setVisible(true);
  setCursor(Cursor.getDefaultCursor());
 }//GEN-LAST:event_jMiProducto1ActionPerformed

 private void jMiEmpleado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiEmpleado1ActionPerformed
  FRM_MANTENIMIENTO_EMPLEADO empleado = new FRM_MANTENIMIENTO_EMPLEADO();
  empleado.setLocationRelativeTo(null); 
  empleado.setVisible(true);
  setCursor(Cursor.getDefaultCursor());
 }//GEN-LAST:event_jMiEmpleado1ActionPerformed

 private void jMiCategoria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiCategoria1ActionPerformed
  FRM_MANTENIMIENTO_CATEGORIA categori = new FRM_MANTENIMIENTO_CATEGORIA();
  categori.setVisible(true);
 }//GEN-LAST:event_jMiCategoria1ActionPerformed

 private void jMiVentaProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiVentaProdActionPerformed
  FRM_VENTA_PRODUCTO_BOLETA venta = new FRM_VENTA_PRODUCTO_BOLETA();
  venta.setLocationRelativeTo(null); 
  venta.setVisible(true);
  venta.toFront();
  venta.requestFocusInWindow();
  setCursor(Cursor.getDefaultCursor());
 }//GEN-LAST:event_jMiVentaProdActionPerformed

 private void jMiProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiProductosActionPerformed
FRM_CONSULTA_PRODUCTO producto=new FRM_CONSULTA_PRODUCTO();
producto.setLocationRelativeTo(null); 
producto.setVisible(true);
setCursor(Cursor.getDefaultCursor());
 }//GEN-LAST:event_jMiProductosActionPerformed

 private void jMiEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiEmpleadoActionPerformed
 FRM_CONSULTA_EMPLEADO empleado =new FRM_CONSULTA_EMPLEADO();
 empleado.setLocationRelativeTo(null); 
 empleado.setVisible(true);
 setCursor(Cursor.getDefaultCursor());
 }//GEN-LAST:event_jMiEmpleadoActionPerformed

 private void jMiClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiClientesActionPerformed
 FRM_CONSULTA_CLIENTES cliente=new FRM_CONSULTA_CLIENTES();
cliente.setLocationRelativeTo(null); 
cliente.setVisible(true);
setCursor(Cursor.getDefaultCursor());
 }//GEN-LAST:event_jMiClientesActionPerformed

 private void jMiMarca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiMarca1ActionPerformed
FRM_MANTENIMIENTO_MARCA M=new FRM_MANTENIMIENTO_MARCA(); 
M.setLocationRelativeTo(null); 
M.setVisible(true);
setCursor(Cursor.getDefaultCursor());
 }//GEN-LAST:event_jMiMarca1ActionPerformed

 private void jMiCargo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiCargo1ActionPerformed
  FRM_MANTENIMIENTO_CARGO C=new FRM_MANTENIMIENTO_CARGO();
  C.setLocationRelativeTo(null); 
  C.setVisible(true);
  setCursor(Cursor.getDefaultCursor());
 }//GEN-LAST:event_jMiCargo1ActionPerformed

 private void jMiMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiMarcaActionPerformed
FRM_MANTENIMIENTO_MARCA M=new FRM_MANTENIMIENTO_MARCA(); 
M.setLocationRelativeTo(null); 
M.setVisible(true);
setCursor(Cursor.getDefaultCursor());
 }//GEN-LAST:event_jMiMarcaActionPerformed

 private void jMiCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiCategoriaActionPerformed
  FRM_CONSULTA_CATEGORIA C=new FRM_CONSULTA_CATEGORIA();
  C.setLocationRelativeTo(null); 
  C.setVisible(true);
  setCursor(Cursor.getDefaultCursor());
 }//GEN-LAST:event_jMiCategoriaActionPerformed

 private void jMiCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiCargoActionPerformed
  FRM_CONSULTA_CARGO CARGO=new FRM_CONSULTA_CARGO();
 CARGO.setLocationRelativeTo(null); 
 CARGO.setVisible(true);
 setCursor(Cursor.getDefaultCursor());
 }//GEN-LAST:event_jMiCargoActionPerformed

    private void jMiVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiVentasActionPerformed
    FRM_CONSULTA_VENTAS ventas = new FRM_CONSULTA_VENTAS();
    ventas.setLocationRelativeTo(null); 
    ventas.setVisible(true);
    setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_jMiVentasActionPerformed

    private void jMiVencimientoPrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiVencimientoPrActionPerformed
    FRM_VENCIMIENTO_PRODUCTO producto = new FRM_VENCIMIENTO_PRODUCTO();
    producto.setLocationRelativeTo(null); 
    producto.setVisible(true);
    setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_jMiVencimientoPrActionPerformed

    private void jMiSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiSalirActionPerformed
        dispose();        
    }//GEN-LAST:event_jMiSalirActionPerformed

    private void jMiCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiCliente1ActionPerformed
        FRM_MANTENIMIENTO_CLIENTE cliente = new FRM_MANTENIMIENTO_CLIENTE();
        cliente.setVisible(true);
    }//GEN-LAST:event_jMiCliente1ActionPerformed


 public static void main(String args[]) {
  
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new FRM_MENU_PRINCIPAL().setVisible(true);
   }
  });
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLblNombre;
    private javax.swing.JMenu jMConsultas;
    private javax.swing.JMenu jMMantenimiento;
    private javax.swing.JMenu jMTransaciones;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMiCargo;
    private javax.swing.JMenuItem jMiCargo1;
    private javax.swing.JMenuItem jMiCategoria;
    private javax.swing.JMenuItem jMiCategoria1;
    private javax.swing.JMenuItem jMiCliente1;
    private javax.swing.JMenuItem jMiClientes;
    private javax.swing.JMenuItem jMiEmpleado;
    private javax.swing.JMenuItem jMiEmpleado1;
    private javax.swing.JMenuItem jMiMarca;
    private javax.swing.JMenuItem jMiMarca1;
    private javax.swing.JMenuItem jMiProducto1;
    private javax.swing.JMenuItem jMiProductos;
    private javax.swing.JMenuItem jMiSalir;
    private javax.swing.JMenuItem jMiVencimientoPr;
    private javax.swing.JMenuItem jMiVentaProd;
    private javax.swing.JMenuItem jMiVentas;
    private javax.swing.JMenu jMsalir;
    // End of variables declaration//GEN-END:variables
}
