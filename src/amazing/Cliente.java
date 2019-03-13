package amazing;
import java.util.ArrayList;

import amazing.Envio;

public class Cliente {
	
	private String nombre, direccion, codigoPostal, telefono;
	private ArrayList<Envio> envios = new ArrayList<>();
	
	
	public Cliente() {}
	
	public Cliente(String nombre, String direccion, String codigoPostal, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.telefono = telefono;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getCodigoPostal() {
		return codigoPostal;
	}
	
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String crearEnvio(String direccionDestino, String codigoPostalDestino, int pesoEnGramos) {
		Envio envio = new Envio(direccionDestino, codigoPostalDestino, this.direccion, this.codigoPostal, pesoEnGramos);
		envios.add(envio);
		return envio.toString();
	}
	
	public String mostrarTodosEnvios() {
		String todosEnvios = "";
		for(int i=0; i<this.envios.size(); i++) {
			todosEnvios += i +": " +envios.get(i).toStringSimplificado() +"\n"; 
		}
		return todosEnvios;
	}
	
	public String solicitarEnvio(int index) {
		return envios.get(index).toString();
	}
	
	public String solicitarEnvioPorID(int idEnvio) {
		String result = "No encotre el envio";
		for(int i=0; i<this.envios.size(); i++) {
			if(this.envios.get(i).getID() == idEnvio) result = envios.get(i).toString();
		}
		return result;
	}
	
	public Envio getUltimoEnvio() {
		return envios.get(envios.size()-1);
	}
	
	public String toString() {
		return "Nombre: " +nombre +" Dirección: " +direccion +" Código Postal: " +codigoPostal +" Teléfono: " +telefono;
	}
}
