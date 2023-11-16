package InterfazGrafica;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Aplicacion.Aplicacion;




public class VentanaRegistroReserva extends JFrame implements ActionListener {

	
	private JPanel todoPanel;
	private Color miVerde;
	private JComboBox<String> comboBox;
	private ButtonGroup grupoAccion;
	private String nombre;
    private String telefono;
    private String correo;
    private String nacimiento;
    private long numLicencia;
    private String paisLicencia;
    private String urlLicencia;
    private String vencimientoLicencia;
    private long numeroTarjeta;
    private String tipoTarjeta;
    private String vencimientoTarjeta;
    private JTextField nombreTxtField;
    private JTextField numLicenciaTxtField;
    private JTextField paisLicenciaTxtField;
    private JTextField urlLicenciaTxtField;
    private JTextField vencimientoLicenciaTxtField;
    private JTextField numeroTarjetaTxtField;
    private JTextField tipoTarjetaTxtField;
    private JTextField vencimientoTarjetaTxtField;
    private JDateChooser dateChooserNacimiento;
    private JDateChooser dateChooserLicencia;
    private JDateChooser dateChooserTarjeta;
    private String usuario;

    
	
    private VentanaRegistroReserva2 ventanaRegistroReserva2;
    private String fechaNacimiento;
    private String fechaVencimientoLicencia;
    private String fechaVencimientoTarjeta;
    private JTextField telefonoTxtField;
    private JTextField nacimientoTxtField;
    private JTextField correoTxtField;


	
	public VentanaRegistroReserva(String usuario){
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
		
		
		
		
		//Minipanel de la mitad que es un 
		JPanel panelMitad = new JPanel();
		JLabel nombreEtiqueta = new JLabel("Nombre del cliente");
		nombreTxtField = new JTextField(20);
		JLabel telefonoEtiqueta = new JLabel("Teléfono");
		telefonoTxtField = new JTextField(20);
		JLabel correoEtiqueta = new JLabel("Correo");
		correoTxtField = new JTextField(20);
		JLabel nacimientoEtiqueta = new JLabel("Fecha de nacimiento (DD/MM/AAAA)");
		nacimientoTxtField = new JTextField(20);
		
		//Toda la info de licencia de conduccion
		JLabel anuncioLicencia = new JLabel("Licencia de conducción del cliente");
		anuncioLicencia.setFont(new Font("Georgia", Font.BOLD, 20));
		
		
		
		
		JLabel numLicenciaEtiqueta = new JLabel("Número de licencia");
		numLicenciaTxtField = new JTextField(20);
		JLabel paisLicenciaEtiqueta = new JLabel("Pais de expedición de la licencia");
		paisLicenciaTxtField = new JTextField(20);
		JLabel urlLicenciaEtiqueta = new JLabel("URL de la imagen de su licencia");
		urlLicenciaTxtField = new JTextField(20);
		JLabel vencimientoLicenciaEtiqueta = new JLabel("Fecha de vencimiento de la licencia (DD/MM/AAAA)");
		vencimientoLicenciaTxtField = new JTextField(20);
		
		
		//Toda la info de licencia de conduccion
		JLabel anuncioTarjeta = new JLabel("Tarjeta de crédito del cliente");
		anuncioTarjeta.setFont(new Font("Georgia", Font.BOLD, 20));
		
	
		JLabel numeroTarjetaEtiqueta = new JLabel("Número de tarjeta");
		numeroTarjetaTxtField = new JTextField(20);
		JLabel tipoTarjetaEtiqueta = new JLabel("Tipo de tarjeta");
		tipoTarjetaTxtField = new JTextField(20);
		JLabel vencimientoTarjetaEtiqueta = new JLabel("Fecha de vencimiento de tarjeta (DD/MM/AAAA)");
		vencimientoTarjetaTxtField = new JTextField(20);
		
		
		JLabel recogidaEtiqueta = new JLabel("SWDKANASLD");
		JTextField recogidaTxtField = new JTextField(20);
		
		//Decorar fuentes
		nombreEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		telefonoEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		correoEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		nacimientoEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		numLicenciaEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		paisLicenciaEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		urlLicenciaEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		vencimientoLicenciaEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		numeroTarjetaEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		numeroTarjetaEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		tipoTarjetaEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		vencimientoTarjetaEtiqueta.setFont(new Font("Georgia", Font.PLAIN, 17));
		
		panelMitad.setSize(500, 600);
		panelMitad.setLayout(null);
		
		
		// Establecer las posiciones y tamaños de las etiquetas y campos de texto
        nombreEtiqueta.setBounds(10, 20, 170, 40); // x, y, width, height
        nombreTxtField.setBounds(165, 30, 165, 20);

        telefonoEtiqueta.setBounds(460, 30, 140, 20);
        telefonoTxtField.setBounds(530, 30, 165, 20);

        correoEtiqueta.setBounds(465, 62, 140, 20);
        correoTxtField.setBounds(527, 65, 165, 20);
        
        nacimientoEtiqueta.setBounds(10, 60, 400, 20);
        nacimientoTxtField.setBounds(290, 63, 165, 20);
        
        anuncioLicencia.setBounds(10,100,600,30);
        
        numLicenciaEtiqueta.setBounds(10,130,165,20);
        numLicenciaTxtField.setBounds(160,132,165,20);

        paisLicenciaEtiqueta.setBounds(10,155,305,20);
        paisLicenciaTxtField.setBounds(255,157,165,20);
        
        urlLicenciaEtiqueta.setBounds(10,182,305,20);
        urlLicenciaTxtField.setBounds(255,182,305,20);
        
        vencimientoLicenciaEtiqueta.setBounds(10,210,450,20);
        vencimientoLicenciaTxtField.setBounds(390,212,165,20);
        
        anuncioTarjeta.setBounds(10,245,450,20);
        
        numeroTarjetaEtiqueta.setBounds(10,270,450,20);
        numeroTarjetaTxtField.setBounds(160,272,165,20);
        
        tipoTarjetaEtiqueta.setBounds(10,293,450,20);
        tipoTarjetaTxtField.setBounds(160,295,165,20);
        
        vencimientoTarjetaEtiqueta.setBounds(10,318,400,20);
        vencimientoTarjetaTxtField.setBounds(365,320,165, 20);
        
        //Creo mis calendarios
        dateChooserNacimiento = new JDateChooser();
        dateChooserNacimiento.setBounds(303, 63, 165, 20);
        
        
        dateChooserLicencia = new JDateChooser();
        dateChooserLicencia.setBounds(413,212,165,20);
        
        dateChooserTarjeta = new JDateChooser();
        dateChooserTarjeta.setBounds(383,320,305,20);
        
        //Decoramos calendariooos
        dateChooserTarjeta.setBorder(BorderFactory.createLineBorder(miVerde, 2));
        dateChooserNacimiento.setBorder(BorderFactory.createLineBorder(miVerde, 2));
        dateChooserLicencia.setBorder(BorderFactory.createLineBorder(miVerde, 2));
        
       
        
        
        //Añado calendarios primero
        panelMitad.add(dateChooserTarjeta);
        panelMitad.add(dateChooserNacimiento);
        panelMitad.add(dateChooserLicencia);
        
        
        //ActionListenerEnviar
      	botonEnviar.setActionCommand("Enviar");
      	botonEnviar.addActionListener(this);

        

		panelMitad.add(nombreEtiqueta);
		panelMitad.add(nombreTxtField);
		panelMitad.add(telefonoEtiqueta);
		panelMitad.add(telefonoTxtField);
		panelMitad.add(correoEtiqueta);
		panelMitad.add(correoTxtField);
		panelMitad.add(nacimientoEtiqueta);
		panelMitad.add(nacimientoTxtField);
		panelMitad.add(anuncioLicencia);
		panelMitad.add(numLicenciaEtiqueta);
		panelMitad.add(numLicenciaTxtField);
		panelMitad.add(paisLicenciaEtiqueta);
		panelMitad.add(paisLicenciaTxtField);
		panelMitad.add(urlLicenciaEtiqueta);
		panelMitad.add(urlLicenciaTxtField);
		panelMitad.add(vencimientoLicenciaEtiqueta);
		panelMitad.add(vencimientoLicenciaTxtField);
		panelMitad.add(anuncioTarjeta);
		panelMitad.add(numeroTarjetaEtiqueta);
		panelMitad.add(tipoTarjetaEtiqueta);	
		panelMitad.add(vencimientoTarjetaEtiqueta);
		panelMitad.add(numeroTarjetaTxtField);
		panelMitad.add(tipoTarjetaTxtField);
		panelMitad.add(vencimientoTarjetaTxtField);
		
		

		
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
		
		
		if(grito.equals("Enviar")) {
			
	        // Asignación de valores a las variables globales
	        nombre = nombreTxtField.getText();
	        telefono = telefonoTxtField.getText();
	        correo = correoTxtField.getText();
	        nacimiento = nacimientoTxtField.getText();
	        numLicencia = Long.parseLong(numLicenciaTxtField.getText());
	        paisLicencia = paisLicenciaTxtField.getText();
	        urlLicencia = urlLicenciaTxtField.getText();
	        vencimientoLicencia = vencimientoLicenciaTxtField.getText();
	        numeroTarjeta = Long.parseLong(numeroTarjetaTxtField.getText());
	        tipoTarjeta = tipoTarjetaTxtField.getText();
	        vencimientoTarjeta = vencimientoTarjetaTxtField.getText();

	        // Convertir fechas de JDateChooser a String y asignar a variables globales
	        fechaNacimiento = convertirFechaAString(dateChooserNacimiento);
	        fechaVencimientoLicencia = convertirFechaAString(dateChooserLicencia);
	        fechaVencimientoTarjeta = convertirFechaAString(dateChooserTarjeta);
	      
	        try {
				ventanaRegistroReserva2 = new VentanaRegistroReserva2(usuario, nombre, telefono, correo, fechaNacimiento, numLicencia, paisLicencia, urlLicencia, fechaVencimientoLicencia, numeroTarjeta,  tipoTarjeta, fechaVencimientoTarjeta);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	
		}
    }
    
    

}
