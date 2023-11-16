package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class VentanaMenuEmpleado extends JFrame implements ActionListener {
	private JPanel todoPanel;
	private Color miVerde;
	private JComboBox<String> comboBox;
	private ButtonGroup grupoAccion;
	private JRadioButton limpiezaCarroBtn;
	private JRadioButton mantenimientoCarroBtn;
	private String usuario;
	
	public VentanaMenuEmpleado(String usuario) {
		
		this.usuario = usuario;
		
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
		
		
		//Minipanel de la mitad que es un Border Layout
		JPanel panelMitad = new JPanel(new BorderLayout());
		panelMitad.setBackground(Color.white);
		
		
		//Lema de la empresa que va al norte en la mitad
		JLabel etiquetaLema = new JLabel("La carretera te llama, nosotros te equipamos", JLabel.CENTER);
		etiquetaLema.setFont(new Font("Georgia", Font.PLAIN, 30));
		panelMitad.add(etiquetaLema, BorderLayout.NORTH);
		
		
		//JPanel para ubicar con el menu y las cosas
		JPanel panelMensaje= new JPanel(new BorderLayout());
		
		//Instruccion
		JLabel etiquetaInstruccion = new JLabel("Elije la acción a realizar", JLabel.CENTER);
		etiquetaInstruccion.setFont(new Font("Georgia", Font.PLAIN, 20));
		
		//Opciones en un JPanel en Grid
				
		JPanel panelMenu = new JPanel(new GridLayout(2, 1));
		
		//Solo una opcion -> creo grupo
		grupoAccion = new ButtonGroup();
		
		//Grupo de botones
		limpiezaCarroBtn = new JRadioButton("Mandar vehículo a limpieza");
		mantenimientoCarroBtn = new JRadioButton("Mandar vehículo a mantenimiento");
		
		limpiezaCarroBtn.setBackground(Color.WHITE);
		mantenimientoCarroBtn.setBackground(Color.WHITE);
	
		
		
		limpiezaCarroBtn.setFont(new Font("Georgia", Font.PLAIN, 20));
		mantenimientoCarroBtn.setFont(new Font("Georgia", Font.PLAIN, 20));

		
		//Solo un boton seleccionado en mi grupo
		grupoAccion.add(limpiezaCarroBtn);
		grupoAccion.add(mantenimientoCarroBtn);
	
		
		
		//ActionListenerEnviar
		botonEnviar.setActionCommand("Enviar");
		botonEnviar.addActionListener(this);
		
		//Añadimos todo
		panelMensaje.setBackground(Color.white);
		panelMensaje.add(etiquetaInstruccion, BorderLayout.NORTH);
		panelMenu.add(limpiezaCarroBtn);
		panelMenu.add(mantenimientoCarroBtn);

		
		panelMitad.add(panelMensaje, BorderLayout.CENTER);
		panelMitad.add(panelMenu, BorderLayout.SOUTH);
		
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
		setTitle("Empleado");

		//Muestra la ventana
		setVisible(true);
		
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		
		if (grito.equals("Enviar")){
			
		 if (limpiezaCarroBtn.isSelected()) { 
	        this.dispose();
	        try {
	        	VentanaVehiculoLimpieza ventanaVehiculoLimpieza = new VentanaVehiculoLimpieza(usuario);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
		 }
		 else if (mantenimientoCarroBtn.isSelected()) {
			 this.dispose();
			 try {
				VentanaVehiculoMantenimiento ventanaVehiculoMantenimiento = new VentanaVehiculoMantenimiento(usuario);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		 }
	         
		}
		
	}
	


}
