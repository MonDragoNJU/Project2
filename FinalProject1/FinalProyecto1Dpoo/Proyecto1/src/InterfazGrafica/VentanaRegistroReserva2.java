package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.toedter.calendar.JDateChooser;

import Programa.Categoria;
import Programa.Empresa;
import Programa.LicenciaConduccion;
import Programa.Reserva;
import Programa.Sede;
import Usuarios.Empleado;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



public class VentanaRegistroReserva2 extends JFrame implements ActionListener {

	 private JPanel todoPanel;
	 private Color miVerde;
	 private JComboBox<String> comboBoxHorasRec, comboBoxHorasDev;
	 private ButtonGroup grupoAccion;
	 private JLabel etiquetaRapidos, fechaRecogidaEtiqueta, horaRecogidaEtiqueta, fechaDevolucionEtiqueta, HoraDevolucionEtiqueta, sedeRecogidaEtiqueta, sedeDevolucionEtiqueta;
	 private JTextField fechaRecogidaTxtField,  fechaDevolucionTxtField;
	 private JButton botonEnviar;
	 private JDateChooser dateChooserRecogida, dateChooserDevolucion;
	 private LocalDate fechaNacimientoF;
	 private LocalDate fechaVencimientoTarjetaF;
	 private LocalDate fechaVencimientoLicenciaF;
	 private LocalDate fechaRecogidaF;
	 private LocalDate fechaDevolucionF;
	 private JDateChooser dateChooserIntentoD;
	 
	 
	// Variables generales de la clase
	private Empresa empresa;
	private String categoriaVehiculo;
    private String nombre;
    private String telefono;
    private String correo;
    private String fechaNacimiento;
    private long numLicencia;
    private String paisLicencia;
    private String urlLicencia;
    private String fechaVencimientoLicencia;
    private long numeroTarjeta;
    private String tipoTarjeta;
    private String fechaVencimientoTarjeta;
    private LocalTime horaRecogidaF;
    private LocalTime horaDevolucionF;
    
    private String fechaRecogida;
    private String horaRecogida;
    private String fechaDevolucion;
    private String horaDevolucion;
    private String sedeRecogida;
    private String sedeDevolucion;
    
    private ArrayList<Categoria> categorias;
    private ArrayList<Sede> sedes;
    
    private ArrayList<String> miArrayCategoria = new ArrayList<String> ();
    private ArrayList<String> miArraySedes = new ArrayList<String> ();
    
    private String[] categoriasEnArreglo;
    private String[] sedesEnArreglo;
    
	private JComboBox<String> comboBoxCategorias;
	private JComboBox<String> comboBoxSedeReco;
	private JComboBox<String> comboBoxSedeDev;
	
	private int indiceSedeRecogida;
	private int indiceSedeDevolucion;
	private String usuario;
	
	
	public VentanaRegistroReserva2(String usuario, String nombre, String telefono, String correo, String fechaNacimiento, long numLicencia, String paisLicencia, String urlLicencia, String fechaVencimientoLicencia, long numeroTarjeta, String tipoTarjeta, String fechaVencimientoTarjeta) throws IOException{
		this.usuario = usuario;
		//AQUI VAMOS A PONERLA:
		//SEDES Y CATEGORIA DE MI CARRO
		this.empresa = new Empresa();
		this.categorias = empresa.getInventario().getCategorias();
		this.sedes = empresa.getInventario().getSedes();
		
		
		for(Categoria categorita: categorias){
			System.out.println(categorita.getNombre());
			miArrayCategoria.add(categorita.getNombre());
			
		}
		
		for(Sede sedecita: sedes){
			miArraySedes.add(sedecita.getNombre());
		}
				
		//Ahora casting de ArrayList a arreglo
		categoriasEnArreglo = miArrayCategoria.toArray(new String[0]);
		sedesEnArreglo = miArraySedes.toArray(new String[0]);
		

				
		//COMBOBOXX!
		comboBoxCategorias = new JComboBox<>(categoriasEnArreglo);
		comboBoxSedeReco = new JComboBox<>(sedesEnArreglo);
		comboBoxSedeDev = new JComboBox<>(sedesEnArreglo);
		
		
		
		
		////////////////////////////
		 this.nombre = nombre;
	     this.telefono = telefono;
	     this.correo = correo;
	     this.fechaNacimiento = fechaNacimiento;
	     this.numLicencia = numLicencia;
	     this.paisLicencia = paisLicencia;
	     this.urlLicencia = urlLicencia;
	     this.fechaVencimientoLicencia = fechaVencimientoLicencia;
	     this.numeroTarjeta = numeroTarjeta;
	     this.tipoTarjeta = tipoTarjeta;
	     this.fechaVencimientoTarjeta = fechaVencimientoTarjeta;
		
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
		JLabel fechaRecogidaEtiqueta = new JLabel("Fecha de recogida del vehículo (DD/MM/AAAA)");
		fechaRecogidaTxtField = new JTextField(20);
		
		
		
		
		
		JLabel horaRecogidaEtiqueta = new JLabel("Hora de recogida");
		
		comboBoxHorasRec = new JComboBox<>();
		

        for (int hora = 6; hora <= 21; hora++) {
            comboBoxHorasRec.addItem(String.format("%02d:00", hora));
            if (hora != 21) { // No agregar 21:30
                comboBoxHorasRec.addItem(String.format("%02d:30", hora));
            }
        }
        
        JLabel fechaDevolucionEtiqueta = new JLabel("Fecha de devolución del vehículo (DD/MM/AAAA)");
		fechaDevolucionTxtField = new JTextField(20);
		
		
		
		
		JLabel HoraDevolucionEtiqueta = new JLabel("Hora de devolución");
		//ComboBoxHorasDevolucion jiji
		comboBoxHorasDev = new JComboBox<>();

        for (int hora = 6; hora <= 21; hora++) {
        	comboBoxHorasDev.addItem(String.format("%02d:00", hora));
            if (hora != 21) { // No agregar 21:30
            	comboBoxHorasDev.addItem(String.format("%02d:30", hora));
            }
        }
		
		
        //VAMOS CON COMBOBOXES
        
        JLabel sedeRecogidaEtiqueta = new JLabel("Sede de recogida");
        
        JLabel sedeDevolucionEtiqueta = new JLabel("Sede de devolución");
        
        JLabel categoriaEtiqueta = new JLabel("Categoria del vehículo");
        
        
        //dchooser
        dateChooserIntentoD = new JDateChooser();
        dateChooserIntentoD.setBounds(405,274,165,20);
        
		//Decorar fuentes
		fechaRecogidaEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		horaRecogidaEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		comboBoxHorasRec.setFont(new Font("Georgia", Font.PLAIN, 14));
		fechaDevolucionEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		comboBoxHorasDev.setFont(new Font("Georgia", Font.PLAIN, 14));
		HoraDevolucionEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		sedeRecogidaEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		sedeDevolucionEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		categoriaEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		dateChooserIntentoD.setFont(new Font("Georgia", Font.PLAIN, 17));
		
		//Le creamos un borde bonito al comboBox
		Border border = BorderFactory.createLineBorder(miVerde, 2); // Color azul y grosor de 2
        comboBoxHorasRec.setBorder(border);
        comboBoxHorasDev.setBorder(border);
		
	
		panelMitad.setSize(500, 600);
		panelMitad.setLayout(null);
		
		
	    //Creo mis calendarios
        dateChooserRecogida = new JDateChooser();
        dateChooserRecogida.setBounds(385, 30, 165, 20);
        
 
		
        //Personalizamos calendarios
        dateChooserRecogida.setBorder(BorderFactory.createLineBorder(miVerde, 2));
        dateChooserIntentoD.setBorder(BorderFactory.createLineBorder(miVerde, 2));
        
        //Agregamos calendarios
        panelMitad.add(dateChooserRecogida);
        panelMitad.add(dateChooserIntentoD);
		
		// Establecer las posiciones y tamaños de las etiquetas y campos de texto
		fechaRecogidaEtiqueta.setBounds(10, 20, 370, 40); // x, y, width, height
		fechaRecogidaTxtField.setBounds(355, 30, 165, 20);
		horaRecogidaEtiqueta.setBounds(10,55,200,40);
		comboBoxHorasRec.setBounds(170, 60, 120, 30);
		fechaDevolucionEtiqueta.setBounds(10,265,470,40);
		fechaDevolucionTxtField.setBounds(375,274,165,20);
		comboBoxHorasDev.setBounds(185,305,120,30);
		HoraDevolucionEtiqueta.setBounds(10,300,200,40);
		sedeRecogidaEtiqueta.setBounds(10,60,160,100);
		categoriaEtiqueta.setBounds(10,140,300,100);
		sedeDevolucionEtiqueta.setBounds(10,305,160,100);
		
		//comboBoxCategorias.setBounds(50,60,160,100);
		comboBoxSedeReco.setBounds(180,100,160,30);
		comboBoxSedeDev.setBounds(195,350,160,30);
		comboBoxCategorias.setBounds(180,168,160,30);

		
		
		
		
		panelMitad.add(categoriaEtiqueta);
        panelMitad.add(comboBoxCategorias);
        panelMitad.add(comboBoxSedeReco);
        panelMitad.add(comboBoxSedeDev);
        panelMitad.add(sedeDevolucionEtiqueta);
		panelMitad.add(sedeRecogidaEtiqueta);
		panelMitad.add(fechaRecogidaEtiqueta);
		panelMitad.add(fechaRecogidaTxtField);
		panelMitad.add(horaRecogidaEtiqueta);
		panelMitad.add(comboBoxHorasRec);
		panelMitad.add(fechaDevolucionEtiqueta);
		panelMitad.add(fechaDevolucionTxtField);
		panelMitad.add(comboBoxHorasDev);
		panelMitad.add(HoraDevolucionEtiqueta);
	
		
		
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
		setSize(750, 600);
		setResizable(false);
				
		//Define el título de la ventana
		setTitle("Cliente");
	
		//Muestra la ventana
		setVisible(true);
		
		
		}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String grito = e.getActionCommand();
		
		
		if(grito.equals("Enviar")) {
			
				horaRecogida = (String) comboBoxHorasRec.getSelectedItem();
				
		        horaDevolucion = (String) comboBoxHorasDev.getSelectedItem();
		        
		        fechaDevolucion = convertirFechaAString(dateChooserIntentoD);
		        
		        fechaRecogida = convertirFechaAString(dateChooserRecogida).trim();


		        
		        
		     
		        
		      // Capturamos los valores seleccionados de los JComboBox
		        sedeRecogida = (String) comboBoxSedeReco.getSelectedItem();
		        sedeDevolucion = (String) comboBoxSedeDev.getSelectedItem();
		        categoriaVehiculo = (String) comboBoxCategorias.getSelectedItem();
		      //Hasta aqui tenemos todo en Strings :)
		        // Actualizar índice de la sede de recogida
		        indiceSedeRecogida = encontrarIndiceSede(sedeRecogida);

		        // Actualizar índice de la sede de devolución
		        indiceSedeDevolucion = encontrarIndiceSede(sedeDevolucion);
		        
		     
		     // Formateadores
		        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Año con dos dígitos
		        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

		        
		        fechaNacimientoF = LocalDate.parse(fechaNacimiento, dateFormatter);
		        fechaRecogidaF = LocalDate.parse(fechaRecogida, dateFormatter);
		        fechaDevolucionF = LocalDate.parse(fechaDevolucion, dateFormatter);
		        fechaVencimientoTarjetaF = LocalDate.parse(fechaVencimientoTarjeta, dateFormatter);
		        fechaVencimientoLicenciaF = LocalDate.parse(fechaVencimientoLicencia, dateFormatter);
		        
		        
		        horaRecogidaF = LocalTime.parse(horaRecogida, timeFormatter);
		        horaDevolucionF = LocalTime.parse(horaDevolucion, timeFormatter);

		        //imprimirDatos(); 
		        
		        
		        LicenciaConduccion nuevaLicencia = empresa.crearNuevaLicencia(numLicencia, paisLicencia, fechaVencimientoLicenciaF, urlLicencia);
		        Reserva nuevaReserva  = empresa.nuevaReserva(categoriaVehiculo, indiceSedeRecogida, indiceSedeDevolucion, usuario, fechaRecogida, fechaDevolucion, horaRecogidaF, horaDevolucionF, fechaRecogidaF, fechaDevolucionF, nuevaLicencia, 0);
		        
		        JOptionPane.showMessageDialog(null, "¡Reserva exitosa! Kuchauuu");
		        this.dispose();
		       

		}
		
		
    }
	
	
	
	private int encontrarIndiceSede(String nombreSede) {
	    int indexSede = 0;
	    boolean encontrado = false;

	    while (indexSede < sedes.size() && !encontrado) {
	        if (sedes.get(indexSede).getNombre().equals(nombreSede)) {
	            encontrado = true;
	        } else {
	            indexSede++;
	        }
	    }

	    if (encontrado) {
	        return indexSede;
	    } else {
	        return -1; // Retorna -1 si no se encuentra la sede
	    }
	    
	    
	    
	}

	
	private void imprimirDatos() {
		System.out.println("Nombre: " + nombre + " (Type: " + nombre.getClass().getName() + ")");
	    System.out.println("Teléfono: " + telefono + " (Type: " + telefono.getClass().getName() + ")");
	    System.out.println("Correo: " + correo + " (Type: " + correo.getClass().getName() + ")");
	    System.out.println("Fecha de Nacimiento: " + fechaNacimientoF  + " (Type: " + fechaNacimientoF.getClass().getName() + ")");
	    System.out.println("Número de Licencia: " + numLicencia + " (Type: " + ((Object)numLicencia).getClass().getName() + ")");
	    System.out.println("País de Licencia: " + paisLicencia + " (Type: " + paisLicencia.getClass().getName() + ")");
	    System.out.println("URL Licencia: " + urlLicencia + " (Type: " + urlLicencia.getClass().getName() + ")");
	    System.out.println("Fecha Vencimiento Licencia: " + fechaVencimientoLicenciaF + " (Type: " + fechaVencimientoLicenciaF.getClass().getName() + ")");
	    System.out.println("Número de Tarjeta: " + numeroTarjeta + " (Type: " + ((Object)numeroTarjeta).getClass().getName() + ")");
	    System.out.println("Tipo de Tarjeta: " + tipoTarjeta + " (Type: " + tipoTarjeta.getClass().getName() + ")");
	    System.out.println("Fecha Vencimiento Tarjeta: " + fechaVencimientoTarjetaF + " (Type: " + fechaVencimientoTarjetaF.getClass().getName() + ")");
	    System.out.println("Fecha de Recogida: " + fechaRecogidaF + " (Type: " + fechaRecogidaF.getClass().getName() + ")");
	    System.out.println("Hora de Recogida: " + horaRecogidaF + " (Type: " + horaRecogidaF.getClass().getName() + ")");
	    System.out.println("Fecha de Devolución: " + fechaDevolucionF + " (Type: " + fechaDevolucionF.getClass().getName() + ")");
	    System.out.println("Hora de Devolución: " + horaDevolucionF + " (Type: " + horaDevolucionF.getClass().getName() + ")");
	    System.out.println("Sede de Recogida: " + sedeRecogida + " (Type: " + sedeRecogida.getClass().getName() + ")");
	    System.out.println("Sede de Devolución: " + sedeDevolucion + " (Type: " + sedeDevolucion.getClass().getName() + ")");
	    System.out.println("Categoría del Vehículo: " + categoriaVehiculo + " (Type: " + categoriaVehiculo.getClass().getName() + ")");

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
	
	

}
