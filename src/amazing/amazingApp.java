package amazing;

import java.util.ArrayList;
import java.util.Scanner;

public class amazingApp {
	
	
	private static int clienteActualIndex = -1;
	private static ArrayList<Cliente> clientes = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menuPrincipal();
	}
	
	public static void menuPrincipal() {
		int opcionMenu = 0;
		String menu = "";
		Scanner scanner = new Scanner(System.in);
		do {
			// clienteactual == null
			if(clienteActivo()) {
				menu = "4- Crear Env�o\n"
						+ "5- Ver Env�os\n";
			}
			
			
		    System.out.println("\t\tMain Menu\t\t\n"
		    		+ "1- Crear Cliente\n"
		    		+ "2- Listar Clientes\n"
		    		+ "3- Elegir/Cambiar Cliente\n"
		    		+ menu
		    		+ "9- Salir");
	
		    opcionMenu = scanner.nextInt();
		    
		    if(!clienteActivo() && opcionMenu > 3 && opcionMenu < 9) {
		    	System.out.println("Vuelve a seleccionar");
		    }else {
		    	switch(opcionMenu) {
			    case 1:
			    	crearCliente();
			    	break;
			    case 2:
			    	listarClientes();
			    	break;
			    case 3:
			    	elegirCliente();
			    	break;
			    case 4:
			    	if(crearEnvio())
			    		serviciosAddicionales();
			    	break;
			    case 5:
			    	listarEnvios();
			    	break;
			    	
			    }
		    }
		}while(opcionMenu < 9);
		scanner.close();
		System.out.println("Ha salido de la aplicaci�n.");
	}
	
	public static boolean clienteActivo() {
		return (!clientes.isEmpty() && clientes.size() >= clienteActualIndex && clienteActualIndex >= 0) ;
	}

	public static void crearCliente() {
		Scanner scanner = new Scanner(System.in);
		String nombre, direccion, codigoPostal, telefono;
		
		
	    System.out.println("\t\tCreación Cliente\t\t\n"
	    		+ "Nombre: ");
	    nombre = scanner.nextLine();
	    
	    System.out.println("Direcci�n: ");
	    direccion = scanner.nextLine();
	    
	    System.out.println("C�digo Postal: ");
	    codigoPostal = scanner.nextLine();
	    
	    System.out.println("Tel�fono: ");
	    telefono = scanner.nextLine();
	    
	    clientes.add(new Cliente(nombre, direccion, codigoPostal, telefono));
	    
	    System.out.println("Cliente " +nombre +" creado correctamente.");

	}
	
	
	public static boolean listarClientes() {
		if(clientes.size() > 0) {
			System.out.println("\t\tClientes Registrados\t\t\n");
			for(int i=0; i<clientes.size(); i++) {
				System.out.println((i+1) +": " +clientes.get(i).toString());
			}
			return true;
		}else {
			System.out.println("No hay clientes registrados.");
			return false;
		}
	}
	
	
	
	public static void elegirCliente() {
		
		if(listarClientes() == false) {
			return ;
		}
		
		Scanner scanner = new Scanner(System.in);
		int clienteSeleccionado;
		
		
	    System.out.println("Elija el cliente (con el numero)\n");
	    clienteSeleccionado = scanner.nextInt();
	    clienteActualIndex = clienteSeleccionado-1;
	    System.out.println("Has elegido - " + clientes.get(clienteActualIndex).getNombre());
	}
	
	
	// Devuelve true - si queremos anadir un servicio 
	// Devuelve false - si no queremos anadir un servicio
	public static boolean crearEnvio() {
		Scanner scanner = new Scanner(System.in);
		String direccionDestino, codigoPostalDestino; 
		int pesoEnGramos;
		String respuesta = null;
	    System.out.println("\t\tCreaci�n Env�o\t\t\n"
	    		+ "Direcci�n Destino: ");
	    direccionDestino = scanner.nextLine();
	    
	    System.out.println("C�digo Postal Destino: ");
	    codigoPostalDestino = scanner.nextLine();
	    
	    System.out.println("Peso (gramos): ");
	    pesoEnGramos = scanner.nextInt();
	   	    
	    ITransport transport = fabricaTransport.transport(clientes.get(clienteActualIndex).getCodigoPostal());
	    
	    
	    String envio = clientes.get(clienteActualIndex).crearEnvio(direccionDestino, codigoPostalDestino, pesoEnGramos,transport);
	    
	    System.out.println("Env�o Creado: \n" +envio);
	    
	    System.out.println("Quieres servicios adicionales?(Y/N)");
	     respuesta = scanner.next();
	    if(respuesta.equals("Y") || respuesta.equals("y"))
	    	return true;

	    return false;


	}
	
	private static void serviciosAddicionales() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Eliga el servicio que quieres a�adir: ");
	    System.out.println("1) Fragil (3 euros)");
	    System.out.println("2) Con acuses de recibo (2 euros)");
	    System.out.println("3) Urgente (2 euros)");
	    int res = scanner.nextInt();
	    clientes.get(clienteActualIndex).a��dirServicioAlEnvio(res);
	    System.out.println("Servicio a�adido!");
	}
	
	private static void listarEnvios() {
		System.out.println("Envios del cliente " + clientes.get(clienteActualIndex).getNombre() + ": ");
		System.out.println(clientes.get(clienteActualIndex).mostrarTodosEnvios());
	}
	
}
