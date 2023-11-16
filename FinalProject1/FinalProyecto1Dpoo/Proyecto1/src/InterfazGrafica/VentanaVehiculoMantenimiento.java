package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.toedter.calendar.JDateChooser;

import Programa.Empresa;
import Programa.Vehiculo;
import Programa.VehiculoNoAlquilado;

public class VentanaVehiculoMantenimiento extends JFrame implements ActionListener {

	
	private JPanel todoPanel;
	private Color miVerde;
	private JComboBox<String> comboBoxPlacas;
	private ButtonGroup grupoAccion;
	private JDateChooser dateChooserRegreso;
	
	private Empresa empresa;
	private ArrayList<Vehiculo> misVehiculos;
	private ArrayList<String> misPlacas = new ArrayList<String>();
	private String[] placasEnArreglo;
	private String carroSeleccionado;
	private String fechaRegreso;
	private LocalDate fechaRegresoF;
	
	private JRadioButton mantenimientoBtn;
	private String usuario;
	
	public VentanaVehiculoMantenimiento(String usuario) throws IOException {
		
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
		
		//ActionListenerEnviar
		botonEnviar.setActionCommand("Enviar");
		botonEnviar.addActionListener(this);
		
		
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
		JLabel etiquetaInstruccion = new JLabel("Elije el vehículo y su estado", JLabel.CENTER);
		etiquetaInstruccion.setFont(new Font("Georgia", Font.PLAIN, 20));
		
		//Opciones en un JPanel en Grid
				
		JPanel panelMenu = new JPanel(new GridLayout(3, 2));
		
		//Solo una opcion -> creo grupo
		grupoAccion = new ButtonGroup();
		
		//Grupo de botones
		mantenimientoBtn = new JRadioButton("Mantenimiento");
	
		
		
	
		
		mantenimientoBtn.setFont(new Font("Georgia", Font.PLAIN, 20));
		
		
		//Solo un boton seleccionado en mi grupo
		grupoAccion.add(mantenimientoBtn);
		
		
		//ComboBox de placas de carros
		empresa = new Empresa();
		misVehiculos = this.empresa.getInventario().getVehiculosEspera();
				
		for(Vehiculo vehiculito: misVehiculos) {
			misPlacas.add(vehiculito.getPlaca());
					
		}
				
		//Casteo mi lista 
		placasEnArreglo = misPlacas.toArray(new String[0]);
				
		//COMBOBOXX!
		comboBoxPlacas = new JComboBox<>(placasEnArreglo);
		
		
		//Aquí se mostrarían los carros
		JLabel mostrarCarrosEtiqueta = new JLabel("Vehículos en espera");
		mostrarCarrosEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 20));
		comboBoxPlacas.setFont(new Font("Georgia", Font.PLAIN, 14));
		
		comboBoxPlacas.setBorder(BorderFactory.createLineBorder(miVerde, 2));
		
		
		//DateChooser
		dateChooserRegreso = new JDateChooser();
		dateChooserRegreso.setBorder(BorderFactory.createLineBorder(miVerde, 2));
		
		//Añadimos todo
		panelMensaje.setBackground(Color.white);
		panelMensaje.add(etiquetaInstruccion, BorderLayout.NORTH);
		
		
		//Etiqueta
		JLabel etiquetaFecha = new JLabel("Fecha de regreso del vehículo");
		etiquetaFecha.setFont(new Font("Georgia", Font.PLAIN, 17));
		mantenimientoBtn.setBackground(Color.WHITE);
		etiquetaFecha.setBackground(Color.WHITE);
		mostrarCarrosEtiqueta.setBackground(Color.WHITE);
		
		panelMenu.add(etiquetaFecha);
		panelMenu.add(dateChooserRegreso);
		panelMenu.add(mostrarCarrosEtiqueta);
		panelMenu.add(comboBoxPlacas);
		panelMenu.add(mantenimientoBtn);
		
		
		
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
		setTitle("Cliente");

		//Muestra la ventana
		setVisible(true);
		
	}
	
	// Método para convertir la fecha de JDateChooser a String
    private String convertirFechaAString(JDateChooser dateChooser) {
        if (dateChooser.getDate() != null) {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            return formatoFecha.format(dateChooser.getDate());
        } else {
            return ""; // O manejar de otra manera si la fecha es nula
        }
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {

		String grito = e.getActionCommand();
		
		if (grito.equals("Enviar")){
			
			 if (mantenimientoBtn.isSelected()) { 
				 
				 carroSeleccionado = (String) comboBoxPlacas.getSelectedItem();
				 //System.out.println(empleadoSeleccionado);
				 
				 //Indice carro
				 int indice = 0;
				 boolean checker = false;
				 Vehiculo carroObjeto = null;
				 int indiceCarro = 0;
				 
				 while (indice < misPlacas.size() && checker == false) {
			         if (misVehiculos.get(indice).getPlaca().equalsIgnoreCase(carroSeleccionado)) {
			        	 indiceCarro = indice;
			        	 checker = true;
			         }
					 indice++;
			        }
				 
				 //Fecha carro
				 // Convertir fechas de JDateChooser a String y asignar a variables globales
			      fechaRegreso = convertirFechaAString(dateChooserRegreso);
			      System.out.println(fechaRegreso);
			      
			     //LocalDate
			      DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Año con dos dígitos
			      fechaRegresoF = LocalDate.parse(fechaRegreso, dateFormatter);

			    empresa.mandarRevisarVehiculo(indiceCarro, "MANTENIMIENTO", fechaRegresoF, usuario, fechaRegreso);
			    
			    JOptionPane.showMessageDialog(null, "Brum brum, carro en mantenimiento");
			    this.dispose();
		       
		        
			 }
		         
		}
		
	}
	
	
	
	
}
