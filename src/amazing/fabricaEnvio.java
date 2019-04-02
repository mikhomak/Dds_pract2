package amazing;

import amazing.Envio.envioTipo;

public class fabricaEnvio {

	public static Envio crearEnvio(String direccionDestino, String codigoPostalDestino, String direccionOrigen, String codigoPostalOrigen, int pesoEnGramos , ITransport transport) {
		
		
		
		
		Envio envio = new Envio(direccionDestino, codigoPostalDestino, direccionOrigen, codigoPostalOrigen, pesoEnGramos, transport);
		
		if(pesoEnGramos > 0 && pesoEnGramos <= 100) {
			envio.setType(envioTipo.carta);
		}else if(pesoEnGramos > 100 && pesoEnGramos <= 2000) {
			envio.setType(envioTipo.paquete);
		}else if(pesoEnGramos > 2000) {
			envio.setType(envioTipo.granVolumen);
		}
		return envio;
	}
	
	
}
