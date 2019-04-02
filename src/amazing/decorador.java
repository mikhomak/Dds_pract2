package amazing;

public class decorador extends Envio {

	protected Envio objetoEnvio;
	protected String nombreDelServicio;
	
	
	public decorador(Envio objectoADecorar) {
		super();
		objetoEnvio = objectoADecorar;
	}
	
	
	public double calcularCosteEnvio(ITransport transport) {
		return objetoEnvio.calcularCosteEnvio(transport);
	}
	
	public String toString() {
		return objetoEnvio.toString() + "Servicio adicional: " + nombreDelServicio + "\n" ;
	}
}
