package amazing;

public class Fragil extends decorador {

	static final double costeAddicional = 3;
	protected String nombreDelServicio = "Fragil";
	
	public Fragil(Envio objectoADecorar) {
		super(objectoADecorar);
		// TODO Auto-generated constructor stub
	}
	


	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return nombreDelServicio;
	}

	@Override
	protected double getCoste() {
		// TODO Auto-generated method stub
		return costeAddicional;
	}
	
	
	
}
