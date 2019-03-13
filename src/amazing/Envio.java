package amazing;

public class Envio {

	private String direccionDestino, codigoPostalDestino, direccionOrigen, codigoPostalOrigen;
	private int idEnvio, pesoEnGramos;
	private double costeEnvio;
	private static int idEnvioGlobal;
	
	
	public Envio() {}
	
	public Envio(String direccionDestino, String codigoPostalDestino, String direccionOrigen, String codigoPostalOrigen, int pesoEnGramos) {
		idEnvioGlobal++;
		this.idEnvio = idEnvioGlobal;
		this.direccionDestino = direccionDestino;
		this.codigoPostalDestino = codigoPostalDestino;
		this.direccionOrigen = direccionOrigen;
		this.codigoPostalOrigen = codigoPostalOrigen;
		this.pesoEnGramos = pesoEnGramos;
		this.costeEnvio = calcularCosteEnvio();
	}
	
	public int getID() { return this.idEnvio;}
	
	
	public String getDireccionDestino() {
		return direccionDestino;
	}
	
	public void setDireccionDestino(String direccionDestino) {
		this.direccionDestino = direccionDestino;
	}
	
	public String getCodigoPostalDestino() {
		return codigoPostalDestino;
	}
	
	public void setCodigoPostalDestino(String codigoPostalDestino) {
		this.codigoPostalDestino = codigoPostalDestino;
	}
	
	public int getPeso() {
		return pesoEnGramos;
	}
	
	public void setPeso(int peso) {
		this.pesoEnGramos = peso;
	}
	
	private double calcularCosteEnvio() {
		double coste = 0.0;
		
		if(pesoEnGramos > 0 && pesoEnGramos <= 100) {
			coste = pesoEnGramos * 0.01; //Carta			
		}else if(pesoEnGramos > 100 && pesoEnGramos <= 2000) {
			coste = pesoEnGramos * 0.02; //Paquete
		}else if(pesoEnGramos > 2000) {
			coste = pesoEnGramos * 0.025; //Gran Volumen
		}
		
		return coste;
	}
	
	public String toString() {
		return "ID: " + this.idEnvio 
				+"\nOrigen: " +this.direccionOrigen +" " +this.codigoPostalOrigen 
				+"\nDestino: " +this.direccionDestino +" " +this.codigoPostalDestino
				+"\nCoste: " +this.costeEnvio;
	}
	
	public String toStringSimplificado() {
		return "ID: " + this.idEnvio
		+"\nDestino: " +this.direccionDestino +" " +this.codigoPostalDestino;
	}
}
