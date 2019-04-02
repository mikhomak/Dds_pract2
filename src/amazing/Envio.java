package amazing;

public class Envio {

	protected String direccionDestino;
	protected String codigoPostalDestino;
	protected String direccionOrigen;
	protected String codigoPostalOrigen;
	protected int idEnvio, pesoEnGramos;
	protected double costeEnvio;
	protected static int idEnvioGlobal;
	protected ITransport transport;
	protected envioTipo tipoDeEnvio;
	
	public Envio() {}
	
	public Envio(String direccionDestino, String codigoPostalDestino, String direccionOrigen, String codigoPostalOrigen, int pesoEnGramos, ITransport transport, envioTipo tipoEnvio) {
		idEnvioGlobal++;
		this.idEnvio = idEnvioGlobal;
		this.direccionDestino = direccionDestino;
		this.codigoPostalDestino = codigoPostalDestino;
		this.direccionOrigen = direccionOrigen;
		this.codigoPostalOrigen = codigoPostalOrigen;
		this.pesoEnGramos = pesoEnGramos;
		this.transport = transport;
		this.tipoDeEnvio = tipoEnvio;
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
			coste = transport.getCosteCarta(pesoEnGramos); //Carta
			break;
		case paquete:
			coste = transport.getCostePaquete(pesoEnGramos); //Paquete
			break;
		case granVolumen:
			coste = transport.getCosteGranVolumen(pesoEnGramos); //Gran Volumen
			break;
		}
		
		
		return coste;
	}
	
	public void anadirCosteServicio(double coste) {
		costeEnvio +=coste;
	}
	
	
	
	public void setType(envioTipo tipo) {
		tipoDeEnvio = tipo;
	}
	
	
	public String toString() {
		return "ID: " + this.idEnvio 
				+"\nOrigen: " +this.direccionOrigen +" " +this.codigoPostalOrigen 
				+"\nDestino: " +this.direccionDestino +" " +this.codigoPostalDestino
				+"\nTransport: " + this.transport.getName()
				+"\nCoste: " +this.costeEnvio;
	}
	
	public String toStringSimplificado() {
		return "ID: " + this.idEnvio
		+"\nDestino: " +this.direccionDestino +" " +this.codigoPostalDestino
		+"\nCoste: " + this.costeEnvio + "\n";
	}
	
	
	public enum envioTipo{
		carta,
		paquete,
		granVolumen;
	}
}
