package InterfazGrafica;



import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Aplicacion.Aplicacion;



public class VentanaPrincipal extends JFrame implements ActionListener{

	private JPanel todoPanel;
	private Color miVerde;
	private JTextField usuarioField;
	private JTextField contrasenaField;
	private JButton botonEnviar;
	private String usuario;
	private String contrasena;
	private Aplicacion app;

	public VentanaPrincipal() {
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
		JLabel etiquetaRapidos = new JLabel("Bienvenido a Rápidos y Aletosos", JLabel.CENTER);
		etiquetaRapidos.setFont(new Font("Georgia", Font.BOLD, 40));
		panelArriba.add(etiquetaRapidos, BorderLayout.CENTER);
		
		//Minipanel de abajo que es un Border Layout
		JPanel panelAbajo = new JPanel(new BorderLayout());
		
		//Configuracion del boton de enviar
		JButton botonEnviar = new JButton("Enviar");
	
		//ActionListenerEnviar
		botonEnviar.setActionCommand("Enviar");
		botonEnviar.addActionListener(this);
		
		botonEnviar.setFont(new Font("Georgia", Font.PLAIN, 16));
		botonEnviar.setForeground(Color.BLACK);
		botonEnviar.setBackground(miVerde);
		botonEnviar.setPreferredSize(new Dimension(40, 50));
		panelAbajo.add(botonEnviar, BorderLayout.CENTER);
		
		
		//Minipanel de la mitad que es un Border Layout
		JPanel panelMitad = new JPanel(new BorderLayout());
		panelMitad.setBackground(Color.white);
		
		
		
		//Lema de la empresa que va al norte en la mitad
		JLabel etiquetaLema = new JLabel("La carretera te llama, nosotros te equipamos", JLabel.CENTER);
		etiquetaLema.setFont(new Font("Georgia", Font.PLAIN, 30));
		panelMitad.add(etiquetaLema, BorderLayout.NORTH);
		
		
		//Ajustar tamaño del carro
		ImageIcon imageIcon = new ImageIcon("data/mcqueen.jpg");
		Image originalImage = imageIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(490, 300, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		JLabel etiquetaCarro = new JLabel(resizedIcon);
		etiquetaCarro.setBounds(100, 50, 100, 30); 
		
		panelMitad.add(etiquetaCarro, BorderLayout.CENTER);
		
		//Ahora un panel para el formulario
		JPanel panelFormulario = new JPanel();
		
		//Formulario para mandar :)
		JLabel usuarioLabel = new JLabel("Usuario");
		usuarioField = new JTextField(20);
		usuarioField.setMaximumSize(new Dimension(300, 70));
		JLabel contrasenaLabel = new JLabel("Contraseña");
		contrasenaField = new JTextField(20);
		contrasenaField.setMaximumSize(new Dimension(300, 70));
		

		//Fuentes
	
		usuarioLabel.setFont(new Font("Georgia", Font.BOLD, 20));

		contrasenaLabel.setFont(new Font("Georgia", Font.BOLD, 20));
		
		panelFormulario.add(usuarioLabel);
		panelFormulario.add(usuarioField);
		panelFormulario.add(contrasenaLabel);
		panelFormulario.add(contrasenaField);
		panelFormulario.setBackground(Color.white);


		//Ahora añado el formulario al panel mitad
		panelMitad.add(panelFormulario, BorderLayout.SOUTH);
		
		todoPanel.add(panelArriba, BorderLayout.NORTH);
		todoPanel.add(panelMitad, BorderLayout.CENTER);
		todoPanel.add(panelAbajo, BorderLayout.SOUTH);

		
		//Agrega el panel con todos los minipaneles que acabo de crear a la ventana
		setContentPane(todoPanel);
		
		//Detiene la aplicación al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Define el tamaño inicial de la ventana
		setSize(750, 600);
		setResizable(false);
		
		//Define el título de la ventana
		setTitle("RapidosYAletosos");

		//Muestra la ventana
		setVisible(true);
		

		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String grito = e.getActionCommand();
		usuario = usuarioField.getText();
		contrasena = contrasenaField.getText();
		
		if(grito.equals("Enviar")) {
			System.out.println(usuario);
			System.out.println(contrasena);
			
			this.app = new Aplicacion(usuario, contrasena);
			this.dispose();
			
			try {
				app.ejecutarAplicacion(usuario);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}
	

	
	//Método inicial de la aplicación
		public static void main(String[] args) {

			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
			

		}

}