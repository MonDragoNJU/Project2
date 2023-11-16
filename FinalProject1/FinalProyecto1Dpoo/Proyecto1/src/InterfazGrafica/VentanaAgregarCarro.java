package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.Action;
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

import Programa.Categoria;
import Programa.Empresa;
import Programa.Sede;
import Programa.Vehiculo;
import Programa.VehiculoNoAlquilado.Estado;

public class VentanaAgregarCarro extends JFrame implements ActionListener{
	private JPanel todoPanel;
	private Color miVerde;
	private JComboBox<String> comboBoxCategorias;
	private ButtonGroup grupoAccion;
	private String usuario;
	private JTextField placaAgregarTxtF;
	private JTextField modeloAgregarTxtF;
	private JTextField marcaAgregarTxtF;
	private JTextField categoriaAgregarTxtF;
	private JComboBox<String> comboBoxcolores;
	private JComboBox<String> comboBoxestados;
	private JComboBox<String> comboBoxtransmision;
	private JComboBox<Integer>  comboBoxCapacidad;
	private Empresa empresa;
	private ArrayList<String> categorias = new ArrayList<String>();
	private String[] categoriasEnArreglo;
	private Categoria categoriaselecc;
	private JLabel etiquetaFecha;
	private JTextField fechaTxtField;
	private String fecha;
	private ArrayList<String> sedes = new ArrayList<String>();
	private String[] sedesEnArreglo;
	private JComboBox<String> comboBoxSedes;
	private JLabel sedeEtiqueta;
	private Sede sedere;
	private Estado estadoselecc;

	
	
	
	public VentanaAgregarCarro(String usuario) throws IOException{
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
		JButton botonEnviar = new JButton("Siguiente");
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
		JLabel instruccioneseEtiqueta = new JLabel("Escribe los datos del vehículo a agregar");
		JLabel placaAgregarEtiqueta = new JLabel("Placa");
	    placaAgregarTxtF = new JTextField();
		JLabel modeloAgregarEtiqueta = new JLabel("Modelo");
		modeloAgregarTxtF = new JTextField();
		JLabel capacidadAgregarEtiqueta = new JLabel("Capacidad personas");
		JLabel colorAgregarEtiqueta = new JLabel("Color");
		JLabel estadoAgregarEtiqueta = new JLabel("Estado");
		
		
		JLabel marcaAgregarEtiqueta = new JLabel("Marca");
		marcaAgregarTxtF = new JTextField();
		JLabel categoriaAgregarEtiqueta = new JLabel("Categoría");
		categoriaAgregarTxtF = new JTextField();
		JLabel transmisionAgregarEtiqueta = new JLabel("Tipo de transmisión");
		
		//ComboBoxCapacidad
		comboBoxCapacidad = new JComboBox<>();
        for (int i = 1; i <= 10; i++) {
            comboBoxCapacidad.addItem(i);
        }
        
        

        //ComboBoxColores
        String[] colorNames = {"Rojo", "Azul", "Gris", "Verde", "Negro", "Blanco"};
        comboBoxcolores = new JComboBox<>(colorNames);
        
        //ComboBoxEstados
        String[] estadoNames = {"Limpieza", "Mantenimiento"};
        comboBoxestados = new JComboBox<>(estadoNames);
        
        //ComboBoxTransmision
        String[] transmisionNames = {"Automatico", "Manual"};
        comboBoxtransmision = new JComboBox<>(transmisionNames);
		
        //ComboBoxCategorias
        this.empresa = new Empresa();
		
		for(Categoria categoria : empresa.getInventario().getCategorias()) {
			categorias.add(categoria.getNombre());
		}
		
		categoriasEnArreglo = categorias.toArray(new String[0]);
		
		
		comboBoxCategorias = new JComboBox<>(categoriasEnArreglo);
		
		//ComboBoxSedes
		
		 for(Sede sede: empresa.getInventario().getSedes()) {
	    	  sedes.add(sede.getNombre());
	      }
		 
		 sedesEnArreglo = sedes.toArray(new String[0]);
		 
		 comboBoxSedes = new JComboBox<>(sedesEnArreglo);
		
		 
		 
		
		//Etiqueta fecha de disponibilidad del carro
		etiquetaFecha = new JLabel("Ingrese la fecha en la cual el carro estará disponible DD/MM/AAAA");
		fechaTxtField = new JTextField(20);
		
		
		//Etiqueta sede de devolucion
		sedeEtiqueta = new JLabel("Sede de devolución del carro");
		
		
		//Decorar fuentes
		instruccioneseEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		placaAgregarEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		modeloAgregarEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		capacidadAgregarEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		colorAgregarEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		estadoAgregarEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		comboBoxCapacidad.setFont(new Font("Georgia", Font.PLAIN, 14));
		colorAgregarEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		estadoAgregarEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		comboBoxcolores.setFont(new Font("Georgia", Font.PLAIN, 14));
		comboBoxestados.setFont(new Font("Georgia", Font.PLAIN, 14));
		marcaAgregarEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		categoriaAgregarEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		transmisionAgregarEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		comboBoxtransmision.setFont(new Font("Georgia", Font.PLAIN, 14));
		comboBoxCategorias.setFont(new Font("Georgia", Font.PLAIN, 14));
		etiquetaFecha.setFont(new Font("Georgia", Font.PLAIN, 17));
		comboBoxSedes.setFont(new Font("Georgia", Font.PLAIN, 14));
		sedeEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		
		
		// Crear un borde pal ComboBox
        Border border = BorderFactory.createLineBorder(miVerde, 2); // Color azul y grosor de 2
        comboBoxCapacidad.setBorder(border);
        comboBoxcolores.setBorder(border);
        comboBoxestados.setBorder(border);
        comboBoxtransmision.setBorder(border);
        comboBoxCategorias.setBorder(border);
        comboBoxSedes.setBorder(border);
		
		panelMitad.setSize(500, 600);
		panelMitad.setLayout(null);
		
		
		// Establecer las posiciones y tamaños de las etiquetas y campos de texto
		instruccioneseEtiqueta.setBounds(10, 20, 470, 40); // x, y, width, height
		placaAgregarEtiqueta.setBounds(10,50,250,50);
		placaAgregarTxtF.setBounds(80,60,120,25);
		modeloAgregarEtiqueta.setBounds(10,85,250,50);
		modeloAgregarTxtF.setBounds(80,100,120,25);
		capacidadAgregarEtiqueta.setBounds(240,50,2500,50);
		comboBoxCapacidad.setBounds(400,60, 50, 30);
		colorAgregarEtiqueta.setBounds(240,85,250,50);
		comboBoxcolores.setBounds(295,95,80, 27);
		estadoAgregarEtiqueta.setBounds(10,125,250,50);
		comboBoxestados.setBounds(80,137,100, 30);
		marcaAgregarEtiqueta.setBounds(10,180,100, 30);
		marcaAgregarTxtF.setBounds(80,180,100, 27);
		categoriaAgregarEtiqueta.setBounds(240,180,100,30);
		comboBoxCategorias.setBounds(320,180,100,30);
		transmisionAgregarEtiqueta.setBounds(240,125,250,50);
		comboBoxtransmision.setBounds(400,135,130, 30);
		etiquetaFecha.setBounds(10, 210, 2500, 50);
		fechaTxtField.setBounds(530,220,80,30);
		comboBoxSedes.setBounds(250,280,130,40);
		sedeEtiqueta.setBounds(10,280,290,40);
		
		panelMitad.add(sedeEtiqueta);
		panelMitad.add(comboBoxSedes);
        panelMitad.add(fechaTxtField );
		panelMitad.add(etiquetaFecha);
		panelMitad.add(comboBoxtransmision);
		panelMitad.add(transmisionAgregarEtiqueta);
        panelMitad.add(comboBoxCategorias);
		panelMitad.add(categoriaAgregarEtiqueta);
        panelMitad.add(marcaAgregarTxtF);
		panelMitad.add(marcaAgregarEtiqueta);
		panelMitad.add(instruccioneseEtiqueta);
		panelMitad.add(placaAgregarEtiqueta);
		panelMitad.add(placaAgregarTxtF);
		panelMitad.add(modeloAgregarEtiqueta);
		panelMitad.add(modeloAgregarTxtF);
		panelMitad.add(capacidadAgregarEtiqueta);
		panelMitad.add(comboBoxCapacidad);
		panelMitad.add(colorAgregarEtiqueta);
		panelMitad.add(estadoAgregarEtiqueta);
		panelMitad.add(comboBoxcolores);
		panelMitad.add(comboBoxestados);
		
		
		
		//Ahora añado el formulario al panel mitad
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
		setTitle("AdministradorGeneral");
	
		//Muestra la ventana
		setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		
		if(grito.equals("Enviar")) {
			
			String placa = placaAgregarTxtF.getText();
	        String modelo = modeloAgregarTxtF.getText();
	        String marca = marcaAgregarTxtF.getText();
	        String categoria = (String) comboBoxCategorias.getSelectedItem();
	        Integer capacidad = (Integer) comboBoxCapacidad.getSelectedItem();
	        String color = (String) comboBoxcolores.getSelectedItem();
	        String estado = (String) comboBoxestados.getSelectedItem();
	        String transmision = (String) comboBoxtransmision.getSelectedItem();
	        String fecha = fechaTxtField.getText();
	        
	        String sedeRecogida = (String) comboBoxSedes.getSelectedItem();
	        
	        //Castear fecha a LocalDate
	        
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        
	        LocalDate fechaF = LocalDate.parse(fecha, formatter);
	        
	        for(Categoria categori : empresa.getInventario().getCategorias()) {
	        	if(categori.getNombre().equals(categoria)) {
	        		categoriaselecc = categori;
	        	}
	        }
	        for(Sede sedecita: empresa.getInventario().getSedes()) {
	        	if(sedecita.getNombre().equals(sedeRecogida)) {
	        		sedere = sedecita;
	        	}
	        }
	        
	        Vehiculo vehiculo = new Vehiculo (categoriaselecc,  placa, marca,  modelo,  color,
	    			 transmision,  capacidad,false);
	        
	        Estado estado1 = Estado.DISPONIBLE;
	        Estado estado2 = Estado.LIMPIEZA;
	        Estado estado3 = Estado.MANTENIMIENTO;
	        
	        if(estado.equals("Mantenimiento")) {
	        	estadoselecc = estado3;
	        }else if(estado.equals("Limpieza")) {
	        	estadoselecc = estado2;
	        }
	        
	        
	     
	      
	       empresa.getInventario().agregarVehiculo(categoriaselecc,placa, marca,  modelo,color, transmision,capacidad, fechaF, estadoselecc, sedere, estado, fecha);
			
	       JOptionPane.showMessageDialog(null, "Carro agregado, ¡kuchau!");
	       this.dispose();
			
			
			
			
			
		}
		
	}
		
		

}
