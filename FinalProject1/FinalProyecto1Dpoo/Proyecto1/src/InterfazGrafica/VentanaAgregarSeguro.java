package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Programa.Empresa;

public class VentanaAgregarSeguro extends JFrame implements ActionListener {

	private JPanel todoPanel;
	private Color miVerde;
	private JComboBox<String> comboBox;
	private ButtonGroup grupoAccion;
	private JTextField nombreAgregarTxtF;
	private JButton botonEnviar;
	private JTextField precioAgregarTxtF;
	private Empresa empresa;
	
	public VentanaAgregarSeguro(){
		
		//Quiero crear un color
		miVerde = new Color(202,222,185);
				
		//Quiero un panel grande con MINIpaneles
		todoPanel = new JPanel(new BorderLayout());
		todoPanel.setBackground(Color.white);
				
		//Minipanel de arriba que es un BorderLayout
		JPanel panelArriba = new JPanel(new BorderLayout());
		panelArriba.setBackground(miVerde);
		panelArriba.setPreferredSize(new Dimension(800, 90));
				
		//Etiqueta del titulo centrada en un panel de BorderLayout
		JLabel etiquetaRapidos = new JLabel("Rápidos y Aletosos", JLabel.CENTER);
		etiquetaRapidos.setFont(new Font("Georgia", Font.BOLD, 40));
		panelArriba.add(etiquetaRapidos, BorderLayout.CENTER);
				
		//Minipanel de abajo que es un Border Layout
		JPanel panelAbajo = new JPanel(new BorderLayout());
				
		//Configuracion del boton de enviar
		JButton botonEnviar = new JButton("Enviar");
		botonEnviar.setFont(new Font("Georgia", Font.PLAIN, 16));
		botonEnviar.setForeground(Color.BLACK);
		botonEnviar.setBackground(miVerde);
		botonEnviar.setPreferredSize(new Dimension(40, 50));
		panelAbajo.add(botonEnviar, BorderLayout.CENTER);
		
		
		//Minipanel de la mitad que es un 
		JPanel panelMitad = new JPanel();
		JLabel instruccioneseEtiqueta = new JLabel("Escribe los datos del seguro a agregar");
		JLabel nombreAgregarEtiqueta = new JLabel("Nombre");
		nombreAgregarTxtF = new JTextField();
		JLabel precioAgregarEtiqueta = new JLabel("Precio");
		precioAgregarTxtF = new JTextField();

		
	
		//Decorar fuentes
		instruccioneseEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		nombreAgregarEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		precioAgregarEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		
		
		
		
		panelMitad.setSize(500, 600);
		panelMitad.setLayout(null);
		
		
		// Establecer las posiciones y tamaños de las etiquetas y campos de texto
		instruccioneseEtiqueta.setBounds(10, 20, 470, 40); // x, y, width, height
		nombreAgregarEtiqueta.setBounds(10,50,250,50);
		nombreAgregarTxtF .setBounds(80,60,170,25);
		precioAgregarEtiqueta.setBounds(10,85,250,50);
		precioAgregarTxtF.setBounds(80,100,170,25);
	
        
		panelMitad.add(precioAgregarEtiqueta);
		panelMitad.add(nombreAgregarEtiqueta);
        panelMitad.add(instruccioneseEtiqueta);
		panelMitad.add(nombreAgregarTxtF);
        panelMitad.add(precioAgregarTxtF);
		
		
		
		//Ahora añado el formulario al panel mitad
		todoPanel.add(panelArriba, BorderLayout.NORTH);
		todoPanel.add(panelMitad, BorderLayout.CENTER);
		todoPanel.add(panelAbajo, BorderLayout.SOUTH);

		
		//Agrega el panel con todos los minipaneles que acabo de crear a la ventana
		setContentPane(todoPanel);
			
		//Detiene la aplicación al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		//Define el tamaño inicial de la ventana
		setSize(800, 350);
		setResizable(false);
				
		//Define el título de la ventana
		setTitle("AdministradorGeneral");
	
		//Muestra la ventana
		setVisible(true);
		
		//ActionListenerEnviar
				botonEnviar.setActionCommand("Enviar");
				botonEnviar.addActionListener((ActionListener) this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		
		if(grito.equals("Enviar")) {
			String nombre = nombreAgregarTxtF.getText();
            String precioString = precioAgregarTxtF.getText();
            double precio = 0.0;

            try {
                precio = Double.parseDouble(precioString);
            } catch (NumberFormatException ex) {
                System.out.println("Error al convertir el precio: " + ex.getMessage());
                // Manejo del error si el precio no es un número válido
            }
            try {
				empresa = new Empresa();
				empresa.getInventario().agregarSegurito(nombre, precio);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            JOptionPane.showMessageDialog(null, "Seguro agregado, ¡kuchau!");
            
            this.dispose();
            
		}
	}
		
	
	//Método inicial de la aplicación
	//public static void main(String[] args) {

		//VentanaAgregarSeguro ventanaAgregarSeguro = new VentanaAgregarSeguro();

	//}
	
}
