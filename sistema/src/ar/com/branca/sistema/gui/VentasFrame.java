package ar.com.branca.sistema.gui;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import ar.com.branca.sistema.datos.BaseDatos;
import ar.com.branca.sistema.pojos.DetalleVenta;
import ar.com.branca.sistema.pojos.Producto;
import ar.com.branca.sistema.pojos.Venta;

/**
 *
 * @author Martín
 */
public class VentasFrame extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTablaProductos = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
 
    DefaultListModel<Producto> modeloListaProductos = new DefaultListModel<Producto>();
    BaseDatos base = new BaseDatos();

    
    public VentasFrame() {
        initComponents();
        cargarColumnasTabla();
        cargarListenerModeloTabla();
    }
    
    private void cargarListenerModeloTabla(){
        modeloTablaProductos.addTableModelListener(new TableModelListener(){
            @Override
            public void tableChanged(TableModelEvent e) {
                int numFilas = modeloTablaProductos.getRowCount();
                
                //variable que va a servir para guardar la sumatoria de la venta.
                double sumatoria = 0;
                
                for (int i = 0; i < numFilas; i++) {
                    String importe = (String) modeloTablaProductos.getValueAt(i, 4);
                    sumatoria += Double.parseDouble(importe);
                }
                lblSumatoria.setText(String.valueOf(sumatoria));
                
            }
        });
    }
    
    
    private void cargarColumnasTabla(){
        modeloTablaProductos.addColumn("Clave");
        modeloTablaProductos.addColumn("Nombre");
        modeloTablaProductos.addColumn("Precio Venta");
        modeloTablaProductos.addColumn("Cantidad");
        modeloTablaProductos.addColumn("Importe");
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        campoBuscarProd = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblSumatoria = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnRealizarVenta = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        campoPagaCon = new javax.swing.JTextField();
        btnCancelarVenta = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblImagenProd = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaBusquedas = new javax.swing.JList<>();
        btnCorteDia = new javax.swing.JButton();
        btnQuitarProd = new javax.swing.JButton();

        setTitle("Ventas");

        tablaVentas.setModel(modeloTablaProductos);

        tablaVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaVentasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaVentas);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Buscar producto:");

        campoBuscarProd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        campoBuscarProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarProdKeyReleased(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblSumatoria.setFont(new java.awt.Font("Tahoma", 0, 78)); // NOI18N
        lblSumatoria.setForeground(new java.awt.Color(255, 102, 102));
        lblSumatoria.setText("0.00");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Venta Total:");

        btnRealizarVenta.setBackground(new java.awt.Color(255, 51, 51));
        btnRealizarVenta.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnRealizarVenta.setText("Realizar Venta");
        btnRealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarVentaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Pago con:");

        campoPagaCon.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSumatoria)
                    .addComponent(btnRealizarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(campoPagaCon, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lblSumatoria, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(campoPagaCon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRealizarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnCancelarVenta.setPreferredSize(new java.awt.Dimension(88, 88));
        btnCancelarVenta.setIcon(new ImageIcon(new ImageIcon("images/eliminar.png").getImage().getScaledInstance((int)(btnCancelarVenta.getPreferredSize().getWidth()*0.7), (int)(btnCancelarVenta.getPreferredSize().getHeight()*0.7), java.awt.Image.SCALE_DEFAULT)));
        btnCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVentaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagenProd, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblImagenProd, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        listaBusquedas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        listaBusquedas.setModel(modeloListaProductos);
        listaBusquedas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listaBusquedasMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(listaBusquedas);

        btnCorteDia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCorteDia.setText("Corte del día");

        btnQuitarProd.setPreferredSize(new java.awt.Dimension(88, 88));
        btnQuitarProd.setIcon(new ImageIcon(new ImageIcon("images/Quitar.png").getImage().getScaledInstance((int)(btnQuitarProd.getPreferredSize().getWidth()*0.7), (int)(btnQuitarProd.getPreferredSize().getHeight()*0.7), java.awt.Image.SCALE_DEFAULT)));
        btnQuitarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnQuitarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnCancelarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(campoBuscarProd)
                    .addComponent(btnCorteDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCorteDia, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoBuscarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnQuitarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(103, 103, 103))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoBuscarProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarProdKeyReleased
        limpiarListaProductos();
        String cadenaBusqueda = campoBuscarProd.getText();
        if(cadenaBusqueda.isEmpty()){
            limpiarListaProductos();
        }
        else{
            ArrayList<Producto> listaProductos = base.obtenerProductosPorCriterio(cadenaBusqueda);
        
            for(Producto prod:listaProductos){
                modeloListaProductos.addElement(prod);
            }
        }
    }//GEN-LAST:event_campoBuscarProdKeyReleased

    
    
    private void listaBusquedasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaBusquedasMousePressed
        JList list = (JList)evt.getSource();
        if(evt.getClickCount() == 2){
            int index = list.locationToIndex(evt.getPoint());
            Producto prod = (Producto)list.getSelectedValue();
            anadirProductoAVenta(prod);
            
            desplegarFoto(prod);
        }
    }//GEN-LAST:event_listaBusquedasMousePressed

    private void desplegarFoto(Producto prod){
        ImageIcon imagenProducto = null;
        try {
                /*obtener imagen*/
                InputStream is = base.buscarFoto(prod);
                BufferedImage bi = ImageIO.read(is);
                imagenProducto = new ImageIcon(bi);
                
                //Redimensión de imagen para ajustarla al tamaño del JLabel.
                Image imgProd = imagenProducto.getImage();
                int anchoEtiqueta = lblImagenProd.getWidth(); //Obtiene ancho de la imagen
                int altoEtiqueta = lblImagenProd.getHeight(); //Obtiene alto de la imagen
                
                //Se crea un nuevo objeto Image con la imagen redimensionada.
                Image imgRedimensionada = imgProd.getScaledInstance(anchoEtiqueta, altoEtiqueta, Image.SCALE_DEFAULT);
               
                //Se crea un nuevo objeto ImageIcon a partir de la imagen redimensionada.
                ImageIcon iconRedimensionado = new ImageIcon(imgRedimensionada);
                
                //Establecemos la imagen redimensionada, como icono de la etiqueta de imagen.
                lblImagenProd.setIcon(iconRedimensionado);
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        
    }
    
    private void tablaVentasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaVentasKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_F2){
            int filaSeleccionada = tablaVentas.getSelectedRow();
            String cantidad = JOptionPane.showInputDialog("Modificar cantidad:");
            String precioVenta = (String) modeloTablaProductos.getValueAt(filaSeleccionada, 2);
            double importe = Double.parseDouble(cantidad) * Double.parseDouble(precioVenta);
            String importeString = String.valueOf(importe);
            modeloTablaProductos.setValueAt(cantidad, filaSeleccionada, 3);
            modeloTablaProductos.setValueAt(importeString, filaSeleccionada, 4);
        }
    }//GEN-LAST:event_tablaVentasKeyReleased

    private void btnQuitarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarProdActionPerformed
        int filaSeleccionada = tablaVentas.getSelectedRow();
        int cantidadFilas = modeloTablaProductos.getRowCount();
        if(cantidadFilas > 0){
            int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de borrar el producto?");
            if(opcion == 0){
                modeloTablaProductos.removeRow(filaSeleccionada);
            }
        }
    }//GEN-LAST:event_btnQuitarProdActionPerformed

    private void btnCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVentaActionPerformed
        int cantidadFilas = modeloTablaProductos.getRowCount();
        if(cantidadFilas > 0) {
            int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de cancelar la venta?");
            if(opcion == 0){
                for (int i = cantidadFilas-1; i >= 0; i--) {
                    modeloTablaProductos.removeRow(i);
                }
            }
        }
    }//GEN-LAST:event_btnCancelarVentaActionPerformed

    private void btnRealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarVentaActionPerformed

        ArrayList<DetalleVenta> detalles = new ArrayList<DetalleVenta>();

        //Obtenemos la sumatoria de la venta
        String sumatoriaStr = lblSumatoria.getText();
        double montoVenta = Double.parseDouble(sumatoriaStr);
        
        String pagoConStr = campoPagaCon.getText();
        
        double cambio = 0;
        
        if(!pagoConStr.isEmpty()){
            double montoPago = Double.parseDouble(pagoConStr);
            cambio = montoPago - montoVenta;
        }
       
        
        //Obtenemos la fecha actual y creamos un objeto Date Sql
        Calendar calendarioLocal = Calendar.getInstance();
        java.util.Date fechaActual = calendarioLocal.getTime();
        long fechaMilisegundos = fechaActual.getTime();
        java.sql.Date fecha = new Date(fechaMilisegundos);
        
        Venta venta = new Venta(montoVenta, fecha);
        Long idVenta = base.insertarVenta(venta);
        
        int numRows = modeloTablaProductos.getRowCount();
        
        for (int i = 0; i < numRows; i++) {
            String idProducto = (String) modeloTablaProductos.getValueAt(i, 0);
            String cantidadStr = (String) modeloTablaProductos.getValueAt(i, 3);
            double cantidad = Double.parseDouble(cantidadStr);
            DetalleVenta detalle = new DetalleVenta(idVenta, idProducto, cantidad);
            base.insertarDetalleVenta(detalle);
            
            detalles.add(detalle);
        }
        
        for (int i = numRows-1; i >= 0; i--) {
            modeloTablaProductos.removeRow(i);
        }
        
        lblSumatoria.setText("0.0");
        
        if(!pagoConStr.isEmpty()){
            JOptionPane.showMessageDialog(this, "<html><h1 style='font-size:200 px; color:blue'>"+cambio+"</h1></html>", "Usted debe dar este cambio:", 1);
            campoPagaCon.setText("");
        }
    }//GEN-LAST:event_btnRealizarVentaActionPerformed

    private void anadirProductoAVenta(Producto prod){
        String claveProd = prod.getIdProducto();
        String nombreProd = prod.getNomProducto();
        String precioVenta = String.valueOf(prod.getPrecioVentaProducto());
        String importe = String.valueOf(prod.getPrecioVentaProducto());
        
        String [] datosProducto = {claveProd, nombreProd, precioVenta, "1", importe};
        modeloTablaProductos.addRow(datosProducto);
    }
    
    private void limpiarListaProductos(){
        modeloListaProductos.clear();
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarVenta;
    private javax.swing.JButton btnCorteDia;
    private javax.swing.JButton btnQuitarProd;
    private javax.swing.JButton btnRealizarVenta;
    private javax.swing.JTextField campoBuscarProd;
    private javax.swing.JTextField campoPagaCon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImagenProd;
    private javax.swing.JLabel lblSumatoria;
    private javax.swing.JList<Producto> listaBusquedas;
    private javax.swing.JTable tablaVentas;
    // End of variables declaration//GEN-END:variables
}
