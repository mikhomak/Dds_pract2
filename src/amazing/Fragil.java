package amazing;

public class Fragil extends decorador {

	static final double costeAddicional = 3;
	protected String nombreDelServicio = "Fragil";
	
	public Fragil(Envio objectoADecorar) {
		super(objectoADecorar);
		// TODO Auto-generated constructor stub
	}
	
	public double calcularCoste(ITransport transport) {
		return super.calcularCosteEnvio(transport)+ costeAddicional;
		
	}
	
	
}
