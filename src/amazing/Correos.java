package amazing;

public class Correos implements ITransport {

	@Override
	public double getCosteCarta(double peso) {
		// TODO Auto-generated method stub
		return peso * 0.015;
	}

	@Override
	public double getCostePaquete(double peso) {
		// TODO Auto-generated method stub
		return peso * 0.03;
	}

	@Override
	public double getCosteGranVolumen(double peso) {
		// TODO Auto-generated method stub
		return peso * 0.035;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Correos";
	}

	
}
