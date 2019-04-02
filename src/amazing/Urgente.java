package amazing;

public class Urgente extends decorador {

	static final double costeAddicional = 2;
	protected String nombreDelServicio = "Urgente";
	
	public Urgente(Envio objectoADecorar) {
		super(objectoADecorar);
		// TODO Auto-generated constructor stub
	}

	
	protected String getName() {
		return nombreDelServicio;
	}

	@Override
	protected double getCoste() {
		// TODO Auto-generated method stub
		return costeAddicional;
	}
}
