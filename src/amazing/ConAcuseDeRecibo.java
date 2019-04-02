package amazing;

public class ConAcuseDeRecibo extends decorador {

	static final double costeAddicional = 2.5;
	protected String nombreDelServicio = "Con acuses de recibio";
	
	public ConAcuseDeRecibo(Envio objectoADecorar) {
		super(objectoADecorar);
		// TODO Auto-generated constructor stub
	}
	
	public double calcularCoste(ITransport transport) {
		return super.calcularCosteEnvio(transport)+ costeAddicional;
		
	}
}
