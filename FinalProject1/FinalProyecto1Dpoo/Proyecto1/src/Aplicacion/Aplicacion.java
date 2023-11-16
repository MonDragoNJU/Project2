package Aplicacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import Interfaces.InterfazAdminGeneral;
import Interfaces.InterfazAdminLocal;
import Interfaces.InterfazCliente;
import Interfaces.InterfazEmpleado;
import InterfazGrafica.VentanaMenuAdminGeneral;
import InterfazGrafica.VentanaMenuAdminLocal;
import InterfazGrafica.VentanaMenuCliente;
import InterfazGrafica.VentanaMenuEmpleado;
import InterfazGrafica.VentanaPrincipal;
import Usuarios.ManejadorSesiones;

public class Aplicacion {
	
	//Interfaces//
	private InterfazAdminGeneral interfazAdminGeneral;
	private InterfazAdminLocal interfazAdminLocal;
	private InterfazCliente interfazCliente;
	private InterfazEmpleado interfazEmpleado;

	private String usuario;
	private String password;
	
	//Metodos//
	
	
	
	public void ejecutarAplicacion(String usuario) throws IOException {
		
		System.out.print("Bienvenido a RapidosYAletosos\n");
		System.out.print("Adjunte su usuario para ingresar a la aplicacion \n");
		
		ManejadorSesiones manejador = new ManejadorSesiones();
		String rol = manejador.revisarUsuario(usuario, password);
		
		
		if (rol.equalsIgnoreCase("cliente")) {
//			
//			InterfazCliente interfazUsada = new InterfazCliente();
//			interfazUsada.mostrarOpciones(usuario);
			VentanaMenuCliente ventanitaCliente = new VentanaMenuCliente(usuario);
			
		}
		else if (rol.equalsIgnoreCase("adminLocal")) {
			//InterfazAdminLocal interfazUsada = new InterfazAdminLocal();
			//interfazUsada.mostrarOpciones(usuario, password);
			VentanaMenuAdminLocal ventanaMenuAdminLocal = new VentanaMenuAdminLocal(usuario);
			
		}
		else if (rol.equalsIgnoreCase("adminGeneral")) {
//			InterfazAdminGeneral interfazUsada = new InterfazAdminGeneral();
//			interfazUsada.mostrarOpciones();
			
			VentanaMenuAdminGeneral ventanita = new VentanaMenuAdminGeneral(usuario);
		}
		else if (rol.equalsIgnoreCase("empleado")){
			//InterfazEmpleado interfazUsada = new InterfazEmpleado();
			//interfazUsada.mostrarOpciones(usuario);
			
			VentanaMenuEmpleado ventanita = new VentanaMenuEmpleado(usuario);
			
		}
		else {
			System.out.print("pailangas");
			 JOptionPane.showMessageDialog(null, "Usuario no encontrado, pailangas");
		}
		
	}
	
	public Aplicacion(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
		
	}

	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	

}
