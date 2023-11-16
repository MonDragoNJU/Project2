package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

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
import Programa.VehiculoNoAlquilado;

public class VentanaEliminarCarro extends JFrame implements ActionListener {
	
	private JPanel todoPanel;
	private Color miVerde;
	private JComboBox<String> comboBoxPlacas;
	private ButtonGroup grupoAccion;
	private Empresa empresa;
	private ArrayList<VehiculoNoAlquilado> misVehiculos;
	private ArrayList<String> misPlacas = new ArrayList<String>();
	private String[] placasEnArreglo;
	private String carroSeleccionado;
	
	
	public VentanaEliminarCarro() throws IOException{
		
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
		JLabel instruccioneseEtiqueta = new JLabel("Elije la placa del vehículo a eliminar ");
		
		
		//ComboBox de placas de carros
		empresa = new Empresa();
		misVehiculos = this.empresa.getInventario().getVehiculosNoAlquilados();
		
		for(VehiculoNoAlquilado vehiculito: misVehiculos) {
			misPlacas.add(vehiculito.getPlaca());
			
		}
		
		//Casteo mi lista 
		
		placasEnArreglo = misPlacas.toArray(new String[0]);
		
		//COMBOBOXX!
		comboBoxPlacas = new JComboBox<>(placasEnArreglo);
		
		//Decorar fuentes
		instruccioneseEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		comboBoxPlacas.setFont(new Font("Georgia", Font.PLAIN, 14));
		
		comboBoxPlacas.setBorder(BorderFactory.createLineBorder(miVerde, 2));
		
		panelMitad.setSize(500, 600);
		panelMitad.setLayout(null);
		
		
		// Establecer las posiciones y tamaños de las etiquetas y campos de texto
		instruccioneseEtiqueta.setBounds(10, 20, 470, 40); // x, y, width, height
		comboBoxPlacas.setBounds(300,70,90,30);
		
		panelMitad.add(instruccioneseEtiqueta);
		panelMitad.add(comboBoxPlacas);
		
		
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
			
			 carroSeleccionado = (String) comboBoxPlacas.getSelectedItem();
			 //System.out.println(empleadoSeleccionado);
			 
			 empresa.getInventario().eliminarVehiculoArchivo(carroSeleccionado);
			 
			 JOptionPane.showMessageDialog(null, "Carro eliminado, ¡kuchau!");
			 
			 this.dispose();
			}
		
	}
	
	

}
