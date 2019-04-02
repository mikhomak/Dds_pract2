package amazing;

public class Seur implements ITransport {

	@Override
	public double getCosteCarta(double peso) {
		// TODO Auto-generated method stub
		return peso * 0.01;
	}

	@Override
	public double getCostePaquete(double peso) {
		// TODO Auto-generated method stub
		return peso * 0.02;
	}

	@Override
	public double getCosteGranVolumen(double peso) {
		// TODO Auto-generated method stub
		return peso *0.035;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Seur";
	}

}
