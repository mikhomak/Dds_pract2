package amazing;

public class Envio {

	private String direccionDestino, codigoPostalDestino, direccionOrigen, codigoPostalOrigen;
	private int idEnvio, pesoEnGramos;
	private double costeEnvio;
	private static int idEnvioGlobal;
	private ITransport transport;
	private envioTipo tipoDeEnvio;
	
	public Envio() {}
	
	public Envio(String direccionDestino, String codigoPostalDestino, String direccionOrigen, String codigoPostalOrigen, int pesoEnGramos, ITransport transport) {
		idEnvioGlobal++;
		this.idEnvio = idEnvioGlobal;
		this.direccionDestino = direccionDestino;
		this.codigoPostalDestino = codigoPostalDestino;
		this.direccionOrigen = direccionOrigen;
		this.codigoPostalOrigen = codigoPostalOrigen;
		this.pesoEnGramos = pesoEnGramos;
		this.transport = transport;
		this.costeEnvio = calcularCosteEnvio(transport);
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
	
	public double calcularCosteEnvio(ITransport transport) {
		double coste = 0.0;
		
		
		switch(tipoDeEnvio) {
		case carta:
			coste = pesoEnGramos * 0.01; //Carta
			break;
		case paquete:
			coste = pesoEnGramos * 0.02; //Paquete
			break;
		case granVolumen:
			coste = pesoEnGramos * 0.025; //Gran Volumen
			break;
		}
		
		
		return coste;
	}
	
	
	public void setType(envioTipo tipo) {
		tipoDeEnvio = tipo;
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
	
	
	public enum envioTipo{
		carta,
		paquete,
		granVolumen;
	}
}
