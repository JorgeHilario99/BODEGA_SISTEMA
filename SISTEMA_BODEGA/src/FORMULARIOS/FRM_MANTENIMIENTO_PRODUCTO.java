
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

public class FRM_MANTENIMIENTO_PRODUCTO extends javax.swing.JFrame {
 conectaBD cnx=new conectaBD();
 int Sw;
  Date now = new Date(System.currentTimeMillis());
 SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
 
    public void convertiraMayusculas(javax.swing.JTextField jTextfieldS){
 String cadena= (jTextfieldS.getText()).toUpperCase();
 jTextfieldS.setText(cadena);
 }
      public void icono(){
      Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/users.gif"));
      setIconImage(icon);
      setVisible(true);
    }
 private TableRowSorter trsFiltro;
public void buscarzona() {
        int Buscar = 0;
        if (jtxtbuscar.getText() =="PRODUCTO") {
            Buscar = 0;
        }       
        trsFiltro.setRowFilter(RowFilter.regexFilter(jtxtbuscar.getText(),1, Buscar));
    }
 public void Limpiar() {
this.jtxtcod.setText("");
this.jtxtstock.setText("");
this.jtxtproducto.setText("");
this.jtxtprecio.setText("");
this.jcbocategoria.setSelectedItem(0);
this.jcbomarca.setSelectedItem(0);
this.jdcfechav.setDate(now);
this.jtxtcod.requestFocus();
this.jtxtcosto.setText("");

}
public void Cajas(boolean estado ) {
this.jtxtcod.setEnabled(estado);
this.jtxtstock.setEnabled(estado);
this.jtxtproducto.setEnabled(estado);
this.jtxtprecio.setEnabled(estado);
this.jcbocategoria.setEnabled(estado);
this.jcbomarca.setEnabled(estado);
this.jdcfechav.setEnabled(estado);
this.jtxtcosto.setEnabled(estado);

}
public void Botones(boolean estado){
this.jBtnNuevo.setEnabled(estado);
this.jBtnGuardar.setEnabled(!estado);
this.jBtnCancelar.setEnabled(!estado);
this.jBtnEditar.setEnabled(estado);
this.jBtnEliminar.setEnabled(estado);
this.jBtnSalir.setEnabled(estado);
}
public void CargaComboCategoria(){
try{
cnx.rs=cnx.stm.executeQuery("SELECT  nombre FROM CATEGORIA ORDER BY 1");
jcbocategoria.removeAllItems();
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
public void Mostrar(){
String cod;
try{
cod=jtbproducto.getValueAt(jtbproducto.getSelectedRow(), 0).toString();
cnx.rs=cnx.stm.executeQuery("SELECT * FROM V_MANTENIMIENTO_PRODUCTO WHERE idproducto=' "+cod+" ' ");
if(cnx.rs.next()){
this.jtxtcod.setText(cnx.rs.getString(1));
this.jtxtproducto.setText(cnx.rs.getString(2));
this.jtxtcosto.setText(cnx.rs.getString(3));
this.jtxtprecio.setText(cnx.rs.getString(4));
this.jtxtstock.setText(cnx.rs.getString(5));
this.jdcfechav.setDate(cnx.rs.getDate(6));
this.jcbomarca.setSelectedItem(cnx.rs.getString(7));
this.jcbocategoria.setSelectedItem(cnx.rs.getString(8));

}
}catch(Exception a){
System.out.println(a.getMessage());
}
}
public void LimpiarTabla(DefaultTableModel model){
  int x;
  for (x=model.getRowCount()-1; x>=0;x--){
   model.removeRow(x); 
  }  
 }
   public void LlenarTabla(){
   String sql;
   //String fechav=date.format(this.jdcfechav.getDate());
   sql="SELECT * FROM V_MANTENIMIENTO_PRODUCTO";
   try{
    //consulta
    cnx.rs=cnx.stm.executeQuery(sql);
    //defino la variable
    DefaultTableModel model=(DefaultTableModel) jtbproducto.getModel();
    //limpio los datos
    LimpiarTabla(model);
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
 public FRM_MANTENIMIENTO_PRODUCTO() {
  initComponents();
   this.setLocationRelativeTo(this);
  this.setResizable(false);
   // this.getContentPane().setBackground(Color.CYAN);
    //sololetras(jtxtproducto);
    //solonumeros(jtxtprecio);
    solonumeros(jtxtstock);
   // solonumeros(jtxtprecio);
 }

 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jtxtbuscar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jBtnNuevo = new javax.swing.JButton();
        jBtnGuardar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbproducto = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtxtcod = new javax.swing.JTextField();
        jtxtproducto = new javax.swing.JTextField();
        jtxtstock = new javax.swing.JTextField();
        jcbocategoria = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jcbomarca = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jtxtprecio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jdcfechav = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jtxtcosto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("BUSCAR POR PRODUCTO");

        jtxtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtbuscarActionPerformed(evt);
            }
        });
        jtxtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtbuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtbuscarKeyTyped(evt);
            }
        });

        jBtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/nuevo.png"))); // NOI18N
        jBtnNuevo.setText("NUEVO");
        jBtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNuevoActionPerformed(evt);
            }
        });

        jBtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/guardar.png"))); // NOI18N
        jBtnGuardar.setText("GUARDAR");
        jBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/cancela.png"))); // NOI18N
        jBtnCancelar.setText("CANCELAR");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Reporte I.png"))); // NOI18N
        jBtnEditar.setText("EDITAR");
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/eliminar.jpg"))); // NOI18N
        jBtnEliminar.setText("ELIMINAR");
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });

        jBtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/exit.png"))); // NOI18N
        jBtnSalir.setText("SALIR");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });

        jtbproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "PRODUCTO", "COSTO", "PRECIO", "STOCK", "FECHA.V", "MARCA", "CATEGORIA"
            }
        ));
        jtbproducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbproductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbproducto);
        if (jtbproducto.getColumnModel().getColumnCount() > 0) {
            jtbproducto.getColumnModel().getColumn(0).setMinWidth(80);
            jtbproducto.getColumnModel().getColumn(0).setMaxWidth(60);
            jtbproducto.getColumnModel().getColumn(1).setMinWidth(200);
            jtbproducto.getColumnModel().getColumn(1).setMaxWidth(100);
            jtbproducto.getColumnModel().getColumn(2).setMinWidth(80);
            jtbproducto.getColumnModel().getColumn(2).setMaxWidth(60);
            jtbproducto.getColumnModel().getColumn(3).setMinWidth(80);
            jtbproducto.getColumnModel().getColumn(3).setMaxWidth(70);
            jtbproducto.getColumnModel().getColumn(4).setMinWidth(90);
            jtbproducto.getColumnModel().getColumn(4).setMaxWidth(80);
            jtbproducto.getColumnModel().getColumn(5).setMinWidth(90);
            jtbproducto.getColumnModel().getColumn(5).setMaxWidth(70);
            jtbproducto.getColumnModel().getColumn(6).setMinWidth(120);
            jtbproducto.getColumnModel().getColumn(6).setMaxWidth(100);
            jtbproducto.getColumnModel().getColumn(7).setMinWidth(280);
            jtbproducto.getColumnModel().getColumn(7).setMaxWidth(130);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "[DATOS DE PRODUCTO]", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("CODIGO");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("PRODUCTO");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("PRECIO-UNIT");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("MARCA");

        jtxtcod.setEditable(false);
        jtxtcod.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtcod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtcodKeyPressed(evt);
            }
        });

        jtxtproducto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtproductoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtproductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtproductoKeyTyped(evt);
            }
        });

        jtxtstock.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtstock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtstockKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtstockKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtstockKeyTyped(evt);
            }
        });

        jcbocategoria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("CATEGORIA");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Captura.JPG"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("STOCK");

        jcbomarca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbomarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbomarcaKeyPressed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Captura.JPG"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jtxtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtprecioKeyPressed(evt);
            }
        });

        jLabel1.setText("FECHA.V");

        jdcfechav.setDateFormatString("dd-MM-yyyy");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("COSTO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jcbomarca, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtproducto)
                            .addComponent(jcbocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtxtstock, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jdcfechav, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jtxtcosto, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(41, 41, 41)
                        .addComponent(jtxtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(430, 430, 430))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jtxtcod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcfechav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtxtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jtxtstock, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtxtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jtxtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jcbomarca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcbocategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnGuardar)
                        .addGap(31, 31, 31)
                        .addComponent(jBtnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnEditar)
                        .addGap(38, 38, 38)
                        .addComponent(jBtnEliminar)
                        .addGap(32, 32, 32)
                        .addComponent(jBtnSalir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addComponent(jtxtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5))
                    .addComponent(jtxtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
 public void solonumeros (JTextField a){
    a.addKeyListener(new KeyAdapter(){
    public void keyTyped (KeyEvent e){
    char c=e.getKeyChar();
    if(!Character.isDigit(c) && !Character.isDigit(c)){
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
    if(Character.isDigit(c) && !Character.isSpaceChar(c) ){        
     getToolkit().beep();
     e.consume();
    }
   }
  }); 
 }
 private void jBtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNuevoActionPerformed
  Sw = 0;
  Limpiar();
  Botones(false);
  Cajas(true);
  this.jtxtcod.setVisible(false);
  this.jLabel6.setVisible(false);
  this.jtxtproducto.requestFocus();
 }//GEN-LAST:event_jBtnNuevoActionPerformed
public void guardar(){
 int r;
 String cod,nombre,costo,precio,stock,fechav,marca,categoria;
   cod=this.jtxtcod.getText();
   nombre=this.jtxtproducto.getText();
   costo=this.jtxtcosto.getText();
   stock=this.jtxtstock.getText();
   precio=this.jtxtprecio.getText();
   fechav=date.format(this.jdcfechav.getDate());
   marca=this.jcbomarca.getSelectedItem().toString();
   categoria=this.jcbocategoria.getSelectedItem().toString();
   
String codcategoria="";
String codmarca="";

   if (nombre.equals("")||precio.equals("")||stock.equals("")|| marca.equals("")||categoria.equals("")){
  JOptionPane.showMessageDialog(null,"existe espacios en blanco","error", JOptionPane.ERROR_MESSAGE);
   }
  else{ 
      try{
       cnx.rs=cnx.stm.executeQuery("SELECT idmarca FROM MARCA WHERE nombre='"+ marca +"'");
            while(cnx.rs.next()){
                codmarca=cnx.rs.getString("idmarca");
            }
            cnx.rs=cnx.stm.executeQuery("SELECT idcategoria FROM CATEGORIA WHERE nombre='"+ categoria +"'");
            while(cnx.rs.next()){
                codcategoria=cnx.rs.getString("idcategoria");
            }
         if(Sw==0){
               
                    cnx.stm.execute("INSERT INTO PRODUCTO VALUES('"+ nombre +"','"+costo+"','"+precio+"','"+stock+"','"+fechav+"','"+ codmarca +"','"+ codcategoria+"')");
                 JOptionPane.showMessageDialog(null,"DATOS GUARDADOS CORRECTAMENTE ","Grabar",1);
            }
            if(Sw==1){
              
                    cnx.stm.execute("UPDATE PRODUCTO SET nombre='"+nombre+"',costo='"+costo+"',preciounit='"+precio+"',stock='"+stock+"',idmarca='"+codmarca+"',fecha_venci='"+fechav+"',idcategoria='"+codcategoria+"' WHERE idproducto='"+ cod +"'");
                JOptionPane.showMessageDialog(null,"DATOS MODIFICADOS CORRECTAMENTE ","Grabar",1);
                }
        }
        catch(SQLException a){
            System.out.println(a.getMessage());
        }
        LlenarTabla();
        jtbproducto.changeSelection(0, 0,false,true);
        Mostrar();
        Botones(true);
        Cajas(false);
}
}
 private void jBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarActionPerformed
  try{
   guardar();

  }
  catch(Exception e){
   System.out.println(e.getMessage());
  }
 }//GEN-LAST:event_jBtnGuardarActionPerformed

 private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
  jtbproducto.changeSelection(0, 0,false,true);
  Mostrar();
  Botones(true);
  Cajas(false);
 }//GEN-LAST:event_jBtnCancelarActionPerformed

 private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
  Sw = 1;
  Mostrar();
  Botones(false);
  Cajas(true);
    this.jtxtcod.setVisible(true);
  this.jLabel6.setVisible(true);
  this.jtxtcod.requestFocus();
 }//GEN-LAST:event_jBtnEditarActionPerformed

 private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
  String sql,cod;
  int r;
  cod=this.jtbproducto.getValueAt(this.jtbproducto.getSelectedRow(),0).toString();
  sql="DELETE FROM PRODUCTO WHERE idproducto='"+cod+"'";
  try{
   r=JOptionPane.showConfirmDialog(null,"DESEA ELIMINAR REGISTRO","ESTA SEGURO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
   if(r==JOptionPane.YES_OPTION){
    cnx.stm.execute(sql);
   }
  }
  catch(Exception e){
   System.out.println(e.getMessage());
  }
  LlenarTabla();
  jtbproducto.changeSelection(0,0,false,true);
  Mostrar();

 }//GEN-LAST:event_jBtnEliminarActionPerformed

 private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
  this.dispose();
 }//GEN-LAST:event_jBtnSalirActionPerformed

 private void jtxtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtbuscarActionPerformed
  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtbuscarActionPerformed

 private void jtxtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbuscarKeyTyped
  jtxtbuscar.addKeyListener(new KeyAdapter() {
   public void keyReleased(final KeyEvent e) {
    String cadena = (jtxtbuscar.getText());
    jtxtbuscar.setText(cadena);
    repaint();
    buscarzona();
   }
  });
  trsFiltro = new TableRowSorter(jtbproducto.getModel());
  jtbproducto.setRowSorter(trsFiltro);
 }//GEN-LAST:event_jtxtbuscarKeyTyped

 private void jtxtcodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcodKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   this.jtxtproducto.requestFocus();

  }  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtcodKeyPressed

 private void jtxtproductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtproductoKeyPressed
  String sql,dni;
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   dni=this.jtxtproducto.getText();
   sql="SELECT * FROM PRODUCTO WHERE nombre='"+ dni +"'";
   try{
    cnx.rs=cnx.stm.executeQuery(sql);
    if(cnx.rs.next()){
     JOptionPane.showMessageDialog(null,"PRODUCTO YA  REGISTRADO","Aviso",1);
     Limpiar();
    }
    else{

     this.jtxtprecio.requestFocus();

    }
   }catch(Exception e){
    System.out.println(e.getMessage());
   }
  }
  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtproductoKeyPressed

 private void jtxtproductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtproductoKeyTyped
 
 }//GEN-LAST:event_jtxtproductoKeyTyped

 private void jtxtstockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtstockKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   this.jcbomarca.requestFocus();

  }  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtstockKeyPressed

 private void jtxtstockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtstockKeyReleased
  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtstockKeyReleased

 private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
icono();
cnx.conectar();
LlenarTabla();
CargaComboCategoria();
CargaCombomarca();
Mostrar();
jtbproducto.changeSelection(0, 0,false,true);
Botones(true);
Cajas(false);
this.jdcfechav.setDate(now);

 }//GEN-LAST:event_formWindowOpened

 private void jtbproductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbproductoMouseClicked
Mostrar();
 }//GEN-LAST:event_jtbproductoMouseClicked

 private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
  LlenarTabla();
  CargaComboCategoria();
  CargaCombomarca();
  
 }//GEN-LAST:event_formWindowActivated

 private void jtxtproductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtproductoKeyReleased
convertiraMayusculas(jtxtproducto);  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtproductoKeyReleased

 private void jtxtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbuscarKeyReleased
convertiraMayusculas(jtxtbuscar);  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtbuscarKeyReleased

 private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
FRM_MANTENIMIENTO_CATEGORIA cat=new  FRM_MANTENIMIENTO_CATEGORIA();
cat.show();// TODO add your handling code here:
 }//GEN-LAST:event_jButton1ActionPerformed

 private void jtxtstockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtstockKeyTyped
 String Caracteres = jtxtstock.getText(); 
        if(Caracteres.length()==3 ){ 
            evt.consume();    
        }  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtstockKeyTyped

 private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
FRM_MANTENIMIENTO_MARCA M=new  FRM_MANTENIMIENTO_MARCA();
M.show();
 }//GEN-LAST:event_jButton2ActionPerformed

 private void jtxtprecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtprecioKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   this.jtxtstock.requestFocus();

  }  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtprecioKeyPressed

 private void jcbomarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbomarcaKeyPressed
  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   this.jcbocategoria.requestFocus();

  }  // TODO add your handling code here:
 }//GEN-LAST:event_jcbomarcaKeyPressed

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
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_PRODUCTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_PRODUCTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_PRODUCTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
   java.util.logging.Logger.getLogger(FRM_MANTENIMIENTO_PRODUCTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }
        //</editor-fold>

  /* Create and display the form */
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new FRM_MANTENIMIENTO_PRODUCTO().setVisible(true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbocategoria;
    private javax.swing.JComboBox jcbomarca;
    private com.toedter.calendar.JDateChooser jdcfechav;
    private javax.swing.JTable jtbproducto;
    private javax.swing.JTextField jtxtbuscar;
    public static javax.swing.JTextField jtxtcod;
    private javax.swing.JTextField jtxtcosto;
    private javax.swing.JTextField jtxtprecio;
    public static javax.swing.JTextField jtxtproducto;
    public static javax.swing.JTextField jtxtstock;
    // End of variables declaration//GEN-END:variables
}
