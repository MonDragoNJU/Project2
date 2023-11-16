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

import Programa.Empresa;
import Programa.Sede;
import Programa.Seguro;

public class VentanaEliminarSeguro extends JFrame implements ActionListener {

	private JPanel todoPanel;
	private Color miVerde;
	private JComboBox<String> comboBoxSeguros;
	private ButtonGroup grupoAccion;
	
	private ArrayList<Seguro> misSeguros;
	private ArrayList<String> misNombresSeguros = new ArrayList<String>();
	private String[] nombresSeguroEnArreglo;
	private Empresa empresa;
	private String seguroSeleccionado;
	
	public VentanaEliminarSeguro() throws IOException{
		
		empresa = new Empresa();
		
		misSeguros = this.empresa.getInventario().getSegurosDisponibles();
		
		for(Seguro segurito: misSeguros) {
			misNombresSeguros.add(segurito.getNombre());
		}
		
		//Casteo mi lista 
		
		nombresSeguroEnArreglo = misNombresSeguros.toArray(new String[0]);
				
		//COMBOBOXX!
		comboBoxSeguros = new JComboBox<>(nombresSeguroEnArreglo);
		
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
		JLabel instruccioneseEtiqueta = new JLabel("Elije el nombre del seguro a eliminar ");
		
	
		
		
		
		//Decorar fuentes
		instruccioneseEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		comboBoxSeguros.setFont(new Font("Georgia", Font.PLAIN, 14));
		comboBoxSeguros.setBorder(BorderFactory.createLineBorder(miVerde, 2));
		
		
		panelMitad.setSize(500, 600);
		panelMitad.setLayout(null);
		
		
		// Establecer las posiciones y tamaños de las etiquetas y campos de texto
		instruccioneseEtiqueta.setBounds(10, 20, 470, 40); // x, y, width, height
		comboBoxSeguros.setBounds(300,70,90,30);
		
		
		panelMitad.add(instruccioneseEtiqueta);
		panelMitad.add(comboBoxSeguros);
	
		
		
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
			
			seguroSeleccionado = (String) comboBoxSeguros.getSelectedItem();
			
			 
			 empresa.getInventario().eliminarSeguroArchivo(seguroSeleccionado);
			 
			 JOptionPane.showMessageDialog(null, "Seguro eliminado, ¡kuchau!");
			 this.dispose();
			}
	
	
	}
}
