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

import Programa.Empresa;

public class VentanaAgregarSede extends JFrame implements ActionListener {


	private JPanel todoPanel;
	private Color miVerde;
	private JComboBox<String> comboBox;
	private ButtonGroup grupoAccion;
	private JTextField nombreAgregarTxtF;
    private JTextField ubicacionAgregarTxtF;
    private JTextField loginAgregarTxtF;
    private JTextField contrasenaAgregarTxtF;
    private JTextField adminNomAgregarTxtF;
    private Empresa empresa;
	
	public VentanaAgregarSede(){
		
		
		
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
		JLabel instruccioneseEtiqueta = new JLabel("Escribe los datos de la sede a agregar");
		JLabel nombreAgregarEtiqueta = new JLabel("Nombre de la sede ");
		nombreAgregarTxtF = new JTextField();
		JLabel ubicacionAgregarEtiqueta = new JLabel("Ubicación");
		ubicacionAgregarTxtF = new JTextField();
		JLabel loginAgregarEtiqueta = new JLabel("Nuevo login del admin local de la sede ");
		loginAgregarTxtF = new JTextField();
		JLabel contrasenaAgregarEtiqueta = new JLabel("Contraseña del nuevo admin local ");
		contrasenaAgregarTxtF = new JTextField();
		JLabel adminNomAgregarEtiqueta = new JLabel("Nombre del admin local de la sede ");
		adminNomAgregarTxtF = new JTextField();
		
	
		//Decorar fuentes
		instruccioneseEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		nombreAgregarEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		ubicacionAgregarEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		loginAgregarEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		contrasenaAgregarEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		adminNomAgregarEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		
		
		panelMitad.setSize(500, 600);
		panelMitad.setLayout(null);
		
		
		// Establecer las posiciones y tamaños de las etiquetas y campos de texto
		instruccioneseEtiqueta.setBounds(10, 20, 470, 40); // x, y, width, height
		nombreAgregarEtiqueta.setBounds(10,50,250,50);
		nombreAgregarTxtF .setBounds(160,60,140,25);
		ubicacionAgregarEtiqueta.setBounds(10,85,250,50);
		ubicacionAgregarTxtF.setBounds(160,100,140,25);
		loginAgregarEtiqueta.setBounds(320,52,400,45);
		contrasenaAgregarEtiqueta.setBounds(320,90,400,45);
		loginAgregarTxtF.setBounds(610,60,140,25);
		contrasenaAgregarTxtF.setBounds(610,100,140,25);
		adminNomAgregarEtiqueta.setBounds(10,150,300,25);
		adminNomAgregarTxtF.setBounds(300,150,140,25);
		
		
	
		panelMitad.add(adminNomAgregarEtiqueta);
		panelMitad.add(adminNomAgregarTxtF);
		panelMitad.add(contrasenaAgregarTxtF);
		panelMitad.add(loginAgregarTxtF);
		panelMitad.add(contrasenaAgregarEtiqueta);
        panelMitad.add(loginAgregarEtiqueta);
		panelMitad.add(ubicacionAgregarEtiqueta);
		panelMitad.add(nombreAgregarEtiqueta);
        panelMitad.add(instruccioneseEtiqueta);
		panelMitad.add(nombreAgregarTxtF);
        panelMitad.add(ubicacionAgregarTxtF);
		
		
		
		//Ahora añado el formulario al panel mitad
		todoPanel.add(panelArriba, BorderLayout.NORTH);
		todoPanel.add(panelMitad, BorderLayout.CENTER);
		todoPanel.add(panelAbajo, BorderLayout.SOUTH);
		
		
		//ActionListenerEnviar
		botonEnviar.setActionCommand("Enviar");
		botonEnviar.addActionListener(this);

		
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
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();

		
		if(grito.equals("Enviar")) {
			String nombre = nombreAgregarTxtF.getText();
            String ubicacion = ubicacionAgregarTxtF.getText();
            String login = loginAgregarTxtF.getText();
            String contrasena = contrasenaAgregarTxtF.getText();
            String nombreAdmin = adminNomAgregarTxtF.getText();
	      
	     try {
			this.empresa = new Empresa();
			this.empresa.getInventario().agregarSede(nombreAdmin, login, contrasena, nombre, ubicacion);
			JOptionPane.showMessageDialog(null, "Sede agregada, ¡kuchau!");
			this.dispose();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     
	      
	     this.dispose();
	        
		}
		
	}
	
}
