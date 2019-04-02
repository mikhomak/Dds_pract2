package amazing;

public interface ITransport {

	public abstract double getCosteCarta(double peso);
	
	public abstract double getCostePaquete(double peso) ;
	
	public abstract double getCosteGranVolumen(double peso) ;
	
	public abstract String getName();
}
