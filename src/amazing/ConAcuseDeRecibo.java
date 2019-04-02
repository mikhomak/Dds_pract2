package amazing;

public class ConAcuseDeRecibo extends decorador {

	static final double costeAddicional = 2.5;
	protected String nombreDelServicio = "Con acuses de recibio";
	
	public ConAcuseDeRecibo(Envio objectoADecorar) {
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
