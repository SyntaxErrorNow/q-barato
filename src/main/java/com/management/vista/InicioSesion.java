package com.management.vista;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.management.controlador.UsuarioController;
import com.management.modelo.schema.Usuario;

import java.awt.FlowLayout;

public class InicioSesion extends JFrame implements ActionListener {
    private UsuarioController usuarioController;

    public InicioSesion() {
        usuarioController = new UsuarioController();
        initComponents();
    }
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        ContrasenaLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CiLabel1 = new javax.swing.JLabel();
        iniciarSesionButton = new javax.swing.JButton();
        CarnetField = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new FlowLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ContrasenaLabel.setBackground(new java.awt.Color(255, 255, 255));
        ContrasenaLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        ContrasenaLabel.setForeground(new java.awt.Color(0, 0, 0));
        ContrasenaLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ContrasenaLabel.setText("Contraseña");

        jLabel1.setIcon(new javax.swing.ImageIcon("imagenes/image1.png")); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Iniciar Sesión");

        CiLabel1.setBackground(new java.awt.Color(255, 255, 255));
        CiLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        CiLabel1.setForeground(new java.awt.Color(0, 0, 0));
        CiLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CiLabel1.setText("Carnet de identidad");

        iniciarSesionButton.setText("Iniciar Sesión");
        iniciarSesionButton.setBackground(new java.awt.Color(255, 255, 255));
        iniciarSesionButton.setFont(new java.awt.Font("Roboto", 0, 12));
        iniciarSesionButton.setForeground(new java.awt.Color(0, 0, 0));
        iniciarSesionButton.addActionListener(this);



        CarnetField.setBackground(new java.awt.Color(255, 255, 255));
        CarnetField.setToolTipText("");
        jPasswordField1.setBackground(new java.awt.Color(255, 255, 255));


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CiLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ContrasenaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CarnetField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(59, Short.MAX_VALUE))

                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(100, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(85, 85, 85)))

                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(100, Short.MAX_VALUE)
                    .addComponent(iniciarSesionButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(85, 85, 85)))
                    );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)


            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(95, 95, 95)
                    .addComponent(CiLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(CarnetField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(ContrasenaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iniciarSesionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addContainerGap(180, Short.MAX_VALUE)
            )

            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(215, 215, 215)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(357, Short.MAX_VALUE)))



        );

        bg.add(jPanel1, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));

        Fondo.setIcon(new javax.swing.ImageIcon("imagenes/qbarato.jpeg")); // NOI18N
        bg.add(Fondo, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        new Insets(0, 0, 0, 0), 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();

        setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CarnetField;
    private javax.swing.JLabel CiLabel1;
    private javax.swing.JLabel ContrasenaLabel;
    private javax.swing.JLabel Fondo;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JButton iniciarSesionButton;

    // End of variables declaration//GEN-END:variables
    @Override
    public void actionPerformed(ActionEvent e) {
        String ciField = CarnetField.getText() ;
        String contrasenaField = String.valueOf(jPasswordField1.getPassword());

        Usuario usuario = usuarioController.getUsuarioByCI(Integer.parseInt(ciField));
        if(usuario == null || ciField.equals("") || contrasenaField.equals("")){
            JOptionPane.showMessageDialog(null, "Los datos son requeridos");
        }
        else if(Integer.parseInt(ciField) == usuario.getCi() && contrasenaField.equals(usuario.getContrasena())){
            this.setVisible(false);
            JOptionPane.showMessageDialog(null, "Bienvenido a q-barato");
        }else{
            JOptionPane.showMessageDialog(null, "Los datos con incorrectos");
        }
    }
}
