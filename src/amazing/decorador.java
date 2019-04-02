package amazing;

public abstract class decorador extends Envio {

	protected Envio objetoEnvio;
	protected String nombreDelServicio;
	protected double costeServicio;
	
	protected abstract String getName();
	protected abstract double getCoste();
	
	public decorador(Envio objectoADecorar) {
		super();
		objetoEnvio = objectoADecorar;
	}
	
	
	public double calcularCosteEnvio(ITransport transport) {
		double res = objetoEnvio.calcularCosteEnvio(transport) + this.getCoste();
		objetoEnvio.anadirCosteServicio(this.getCoste());
		return res;
	}
	
	public String toString() {
		return objetoEnvio.toString() + "Servicio adicional: " + nombreDelServicio + "\n" ;
	}
	
	public String getCodigoPostalDestino() {
		calcularCosteEnvio(objetoEnvio.transport);
		return objetoEnvio.codigoPostalDestino;
	}
	
	public String toStringSimplificado() {
		calcularCosteEnvio(objetoEnvio.transport);
		return objetoEnvio.toStringSimplificado() +  "Servicio adicional: " + this.getName() ;
	}
}
