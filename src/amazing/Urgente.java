package amazing;

public class Urgente extends decorador {

	static final double costeAddicional = 2;
	protected String nombreDelServicio = "Urgente";
	
	public Urgente(Envio objectoADecorar) {
		super(objectoADecorar);
		// TODO Auto-generated constructor stub
	}
	
	public double calcularCoste(ITransport transport) {
		return super.calcularCosteEnvio(transport)+ costeAddicional;
		
	}
}
