package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Aplicacion.Aplicacion;
import Programa.Empresa;

public class VentanaAgregarEmpleado extends JFrame implements ActionListener {
	
	private JPanel todoPanel;
	private Color miVerde;
	private JTextField nombreAgregarTxtF;
	private JTextField loginAgregarTxtF;
	private JTextField contrasenaAgregarTxtF;
	private String contrasena;
	private String login;
	private String nombre;
	private Empresa empresa;
	private String usuario;
	
	public VentanaAgregarEmpleado(String usuario) throws IOException{
		this.usuario = usuario;
		this.empresa = new Empresa();
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
		
		
		//ActionListenerEnviar
		botonEnviar.setActionCommand("Enviar");
		botonEnviar.addActionListener(this);
				
		
		
		//Minipanel de la mitad que es un 
		JPanel panelMitad = new JPanel();
		JLabel instruccioneseEtiqueta = new JLabel("Escribe los datos de la sede a agregar");
		JLabel nombreAgregarEtiqueta = new JLabel("Nombre del empleado ");
		nombreAgregarTxtF = new JTextField();
		JLabel loginAgregarEtiqueta = new JLabel("Nuevo login del empleado");
		loginAgregarTxtF = new JTextField();
		JLabel contrasenaAgregarEtiqueta = new JLabel("Contraseña del nuevo empleado ");
		contrasenaAgregarTxtF = new JTextField();
		
	
		//Decorar fuentes
		instruccioneseEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		nombreAgregarEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		loginAgregarEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		contrasenaAgregarEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		
		
		panelMitad.setSize(500, 600);
		panelMitad.setLayout(null);
		
		
		// Establecer las posiciones y tamaños de las etiquetas y campos de texto
		instruccioneseEtiqueta.setBounds(10, 20, 470, 40); // x, y, width, height
		nombreAgregarEtiqueta.setBounds(10,50,250,50);
		nombreAgregarTxtF .setBounds(190,60,140,25);
		
		loginAgregarEtiqueta.setBounds(10,85,250,50);
		loginAgregarTxtF.setBounds(210,100,140,25);
		
		contrasenaAgregarEtiqueta.setBounds(370,52,400,45);
		contrasenaAgregarTxtF.setBounds(615,60,140,25);
		
	
		
		panelMitad.add(contrasenaAgregarTxtF);
        panelMitad.add(instruccioneseEtiqueta);
        panelMitad.add(nombreAgregarEtiqueta);
        panelMitad.add(nombreAgregarTxtF);
        panelMitad.add(loginAgregarEtiqueta);
        panelMitad.add(loginAgregarTxtF);
        panelMitad.add(contrasenaAgregarEtiqueta);
 
		
		
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
		setTitle("AdministradorLocal");
	
		//Muestra la ventana
		setVisible(true);
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String grito = e.getActionCommand();
		nombre = nombreAgregarTxtF.getText();
		contrasena = contrasenaAgregarTxtF.getText();
		login = loginAgregarTxtF.getText();
		String nombreSede = empresa.buscarSedeAdminLocal(usuario);
		
		if(grito.equals("Enviar")) {
			System.out.println(nombre);
			System.out.println(contrasena);
			System.out.println(login);
			empresa.getInventario().agregarEmpleadoTodo(nombre, nombreSede, login, contrasena);
			JOptionPane.showMessageDialog(null, "Empleado agregado, ¡kuchau!");
			this.dispose();
		}
		
	}
	
//	//Método inicial de la aplicación
//	public static void main(String[] args) {
//
//		VentanaAgregarEmpleado ventanaAgregarEmpleado = new VentanaAgregarEmpleado(usuario);
//
//	}
	

}
