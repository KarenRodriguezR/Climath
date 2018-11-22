package vista;


public class RegistroVista {
	public void imprimirDatosRegistro(int idreg,boolean est, String fec, String hor, double hum, double temp) {
		
		
		
		
		System.out.println("**** REGISTRO ****");
		System.out.println("Id: "+idreg);
		System.out.println("Estado: "+est);
		System.out.println("Fecha: "+fec);
		System.out.println("Hora: "+hor);
		System.out.println("Humedad: "+hum);
		System.out.println("Temperatura: "+temp);
		}
}