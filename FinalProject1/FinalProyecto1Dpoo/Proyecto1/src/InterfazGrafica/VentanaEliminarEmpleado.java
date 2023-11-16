package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Aplicacion.Aplicacion;
import Programa.Empresa;
import Usuarios.Empleado;

public class VentanaEliminarEmpleado extends JFrame implements ActionListener {
	private Empresa empresa;
	private JPanel todoPanel;
	private Color miVerde;
	private JComboBox<String> comboBoxNombres;
	private ButtonGroup grupoAccion;
	private HashMap<String, ArrayList<Empleado>> empleados;
	private String nombreSede;
	private String empleadoSeleccionado;
	
	
	
	private String[] nombresEnArreglo;
	private ArrayList<String> nombresDeMisEmpleados = new ArrayList<String>();
	
	public VentanaEliminarEmpleado(String user) throws IOException{
		
		//Vamos a recorrer mi gente para obtener los nombres yuju
		this.empresa = new Empresa();
		this.empleados = empresa.getInventario().getEmpleados();
		this.nombreSede = empresa.buscarSedeAdminLocal(user);
		
		
		
		for(Empleado empleadito: empleados.get(nombreSede) ) {
			nombresDeMisEmpleados.add(empleadito.getLogin());
		}
		

		
		//Ahora casting de ArrayList a arreglo
		
		nombresEnArreglo = nombresDeMisEmpleados.toArray(new String[0]);
		
		
		//COMBOBOXX!
		comboBoxNombres = new JComboBox<>(nombresEnArreglo);
		
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
		JLabel instruccioneseEtiqueta = new JLabel("Elije el login del empleado a eliminar ");
	
		
		//Decorar comboBox
		comboBoxNombres.setBorder(BorderFactory.createLineBorder(miVerde, 2));
		
		
		//Decorar fuentes
		instruccioneseEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		comboBoxNombres.setFont(new Font("Georgia", Font.PLAIN, 14));
		
		
		panelMitad.setSize(500, 600);
		panelMitad.setLayout(null);
		
		
		// Establecer las posiciones y tamaños de las etiquetas y campos de texto
		instruccioneseEtiqueta.setBounds(10, 20, 470, 40); // x, y, width, height
		comboBoxNombres.setBounds(290,110,200,30);
		
		panelMitad.add(instruccioneseEtiqueta);
		panelMitad.add(comboBoxNombres);
	
		
		
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
		
		if(grito.equals("Enviar")) {
			
			 empleadoSeleccionado = (String) comboBoxNombres.getSelectedItem();
			 //System.out.println(empleadoSeleccionado);
			 
			 empresa.getInventario().eliminarEmpleadoArchivo(empleadoSeleccionado);
			 
			 JOptionPane.showMessageDialog(null, "Empleado despedido (uy), ¡kuchau!");
			 
			 this.dispose();
			}
		}
	
	//Método inicial de la aplicación
	//public static void main(String[] args) {

		//VentanaEliminarEmpleado ventanaEliminarEmpleado = new VentanaEliminarEmpleado();

	//}
		

	

}
