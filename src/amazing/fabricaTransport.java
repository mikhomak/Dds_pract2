package amazing;

public class fabricaTransport {

	
	public static ITransport transport(String codigoPostal) {
		ITransport transportista;
		if (codigoPostal.startsWith("15") || codigoPostal.startsWith("36") || codigoPostal.startsWith("32") || codigoPostal.startsWith("27") ||
				codigoPostal.startsWith("33") || codigoPostal.startsWith("39") || codigoPostal.startsWith("48") || codigoPostal.startsWith("20")) {
		   transportista  = new Correos();
		}
		
		else if (codigoPostal.startsWith("25") || codigoPostal.startsWith("08") || codigoPostal.startsWith("17") || codigoPostal.startsWith("43") ||
			       codigoPostal.startsWith("12") || codigoPostal.startsWith("46") || codigoPostal.startsWith("03") || codigoPostal.startsWith("30"))
		   	    transportista  = new DHL();
		     else transportista = new Seur();
		
		return transportista;
	}
}
	

