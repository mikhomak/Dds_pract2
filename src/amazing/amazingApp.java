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
			// clienteactual = null
			if(clienteActivo()) {
				menu = "4- Crear Env韔\n5- Ver Env韔s\n";
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
			    	crearEnvio();
			    	break;
			    	
			    }
		    }
		}while(opcionMenu < 9);
		scanner.close();
		System.out.println("Ha salido de la aplicaci髇.");
	}
	
	public static boolean clienteActivo() {
		return (!clientes.isEmpty() && clientes.size() > clienteActualIndex && clienteActualIndex >= 0) ;
	}

	public static void crearCliente() {
		Scanner scanner = new Scanner(System.in);
		String nombre, direccion, codigoPostal, telefono;
		
		
	    System.out.println("\t\tCreaci贸n Cliente\t\t\n"
	    		+ "Nombre: ");
	    nombre = scanner.nextLine();
	    
	    System.out.println("Direcci贸n: ");
	    direccion = scanner.nextLine();
	    
	    System.out.println("C贸digo Postal: ");
	    codigoPostal = scanner.nextLine();
	    
	    System.out.println("Tel茅fono: ");
	    telefono = scanner.nextLine();
	    
	    clientes.add(new Cliente(nombre, direccion, codigoPostal, telefono));
	    
	    System.out.println("Cliente " +nombre +" creado correctamente.");
	    scanner.close();
	}
	
	
	public static void listarClientes() {
		if(clientes.size() > 0) {
			System.out.println("\t\tClientes Registrados\t\t\n");
			for(int i=0; i<clientes.size(); i++) {
				System.out.println((i+1) +": " +clientes.get(i).toString());
			}
		}else {
			System.out.println("No hay clientes registrados.");
		}
	}
	
	public static void elegirCliente() {
		listarClientes();
		
		Scanner scanner = new Scanner(System.in);
		int clienteSeleccionado;
		
		
	    System.out.println("Elija el cliente (con el numero)\n");
	    clienteSeleccionado = scanner.nextInt();
	    clienteActualIndex = clienteSeleccionado-1;
	    System.out.println("Has elegido - " + clientes.get(clienteActualIndex).getNombre() + "\n");
	    scanner.close();
	}
	
	public static void crearEnvio() {
		Scanner scanner = new Scanner(System.in);
		String direccionDestino, codigoPostalDestino; 
		int pesoEnGramos;
		
	    System.out.println("\t\tCreaci髇 Env韔\t\t\n"
	    		+ "Direcci贸n Destino: ");
	    direccionDestino = scanner.nextLine();
	    
	    System.out.println("C骴igo Postal Destino: ");
	    codigoPostalDestino = scanner.nextLine();
	    
	    System.out.println("Peso (gramos): ");
	    pesoEnGramos = scanner.nextInt();
	   	    
	    String envio = clientes.get(clienteActualIndex).crearEnvio(direccionDestino, codigoPostalDestino, pesoEnGramos);
	    
	    System.out.println("Env韔 Creado: \n" +envio);
	    scanner.close();
	}
	
}
