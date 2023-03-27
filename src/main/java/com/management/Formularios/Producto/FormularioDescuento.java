package com.management.Formularios.Producto;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import com.management.Producto;
import com.management.Archivos.ArchivoProducto;
import com.management.data.DataProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.FlowLayout;




public class FormularioDescuento extends JFrame implements ActionListener{
    JComboBox<String> mes;
    JButton botonEnvio;
    JLabel texto;
    String mesField;
    String [] meses = DataProducto.obtenerTemporadas();

        public FormularioDescuento(){
            super("Descuentos");
            setLayout(new FlowLayout());


            texto = new JLabel("Elije el mes: ");
            mes = new JComboBox<String>(meses);

            botonEnvio = new JButton();
            botonEnvio.setText("Enviar");
            botonEnvio.addActionListener(this);


            add(texto);
            add(mes);
            add(botonEnvio);


            this.setSize(250,250);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.getContentPane().setBackground(Color.WHITE);
            this.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            mesField = (String)mes.getItemAt(mes.getSelectedIndex());
            if(mesField.equals("")){
                JOptionPane.showMessageDialog(null, "Los datos son requeridos");
            }else{
                String descuento = DataProducto.obtenerDescuento(mesField);
                ArrayList<Producto> productos = ArchivoProducto.getProductoTemporales();
                ArrayList<Producto> productosDescuentos = new ArrayList<Producto>();
                mesField = mesField.substring(0, 1);
                String numMes = Integer.parseInt(mesField) < 10 ? ("0" + mesField) : (mesField + "");
                for(Producto producto : productos){
                    String productoId = producto.getId().substring(1, 3);
                    if(productoId.equals(numMes)){
                        producto.setPrecio(precioDescuento(producto.getPrecio(), descuento));
                        productosDescuentos.add(producto);
                    }

                }
                System.out.println(productosDescuentos);
                setVisible(false);
            }

        }

        private double precioDescuento(double precio, String descuento){
            return (precio * Integer.parseInt(descuento)) / 100;
        }

}