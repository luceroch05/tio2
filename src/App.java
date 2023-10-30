//import java.awt.*;
//import java.sql.Date;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class App {
    App app;
    JFrame frame;
    JLabel lbl;
    JTextField txtnombre,txtdni,txttelefono,txtdireccion,txtnacimiento;
    JPanel panelprincipal,panelTabla;
    JButton btnProcesar,btnAtras;
    String nombres,direccion,telefono,dni, nacimiento;
    tabla tab;
    JTable table;
    DefaultTableModel modelo;
    
    
    public App() {
       

        frame= new JFrame();
        frame.setSize(400,600);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        // Cierra la aplicación cuando se cierra la ventana        

        panelprincipal=new JPanel();
        panelprincipal.setBounds(0,0,400,600);
        panelprincipal.setLayout(null);
        frame.add(panelprincipal);

        lbl=new JLabel("Ingrese nombre:");
        lbl.setBounds(50,60,200,30);
        panelprincipal.add(lbl);

        txtnombre=new JTextField();
        txtnombre.setBounds(50,90,200,30);
        panelprincipal.add(txtnombre);

        lbl=new JLabel("Direccion:");
        lbl.setBounds(50,130,150,30);
        panelprincipal.add(lbl);

        txtdireccion= new JTextField();
        txtdireccion.setBounds(50,160,200,30);
        panelprincipal.add(txtdireccion);

        lbl=new JLabel("Teléfono:");
        lbl.setBounds(50,200,150,30);
        panelprincipal.add(lbl);

        txttelefono= new JTextField();
        txttelefono.setBounds(50,230,200,30);
        panelprincipal.add(txttelefono);

        lbl=new JLabel("DNI:");
        lbl.setBounds(50,270,200,30);
        panelprincipal.add(lbl);

        txtdni= new JTextField();
        txtdni.setBounds(50,300,200,30);
        panelprincipal.add(txtdni);

        lbl=new JLabel("Fecha de nacimiento:");
        lbl.setBounds(50,340,150,30);
        panelprincipal.add(lbl);

        txtnacimiento= new JTextField();
        txtnacimiento.setBounds(50,370,200,30);
        panelprincipal.add(txtnacimiento);


        btnProcesar=new JButton("Registrar");
        btnProcesar.setBounds(50,410,200,30);
        
        btnProcesar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent i) {
                obtenerdatos();
                tab = new tabla(modelo);
                tab.agregandofilas(nombres, direccion, telefono, dni, nacimiento);
                
            }                
               
            
        });        
        panelprincipal.add(btnProcesar);


        panelTabla= new JPanel();
        panelTabla.setSize(400,600);
        panelTabla.setLayout(null);
        panelTabla.setVisible(false);
        frame.add(panelTabla);
        modelo = new DefaultTableModel();
        modelo.addColumn("Nombres");
        modelo.addColumn("Dirección");
        modelo.addColumn("Teléfono");
        modelo.addColumn("DNI");
        modelo.addColumn("Fecha de nacimiento");
        modelo.addColumn("Dias pasados");


        
        table = new JTable(modelo);
        JScrollPane scroll=new JScrollPane(table);
        scroll.setBounds(50, 100, 300, 200);
        panelTabla.add(scroll);
        
        


        btnAtras= new JButton("Atrás");
        btnAtras.setBounds(50,470,200,30);
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                panelTabla.setVisible(false);
                panelprincipal.setVisible(true);
            }
        });
        panelTabla.add(btnAtras);
        
        frame.repaint();

    }
    public void obtenerdatos(){
                panelTabla.setVisible(true);
                panelprincipal.setVisible(false);

                nombres=txtnombre.getText();
                direccion=txtdireccion.getText();
                telefono=txttelefono.getText();
                dni=txtdni.getText();
                nacimiento=txtnacimiento.getText();
                System.out.println("Nombres: " + nombres);
                System.out.println("Dirección: " + direccion);
                System.out.println("Teléfono: " + telefono);
                System.out.println("DNI: " + dni);
                System.out.println("Fecha de nacimiento: " + nacimiento);

    }

    public static void main(String[] args){
         new App();
    }
}
