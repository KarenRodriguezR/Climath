package Beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import controlador.CiudadControlador;
import modelo.Ciudad;
import modelo.Registro;
import servicios.RESTEasyClientGet;

@ManagedBean(name="temp")

public class DropdownView {
	private Registro registro;
	private List<Ciudad> ciudades;
	private String ms;
	
	public DropdownView(){
		CiudadControlador ns = new CiudadControlador();
		ciudades=ns.listarCiudades();
		
	}

	public Registro getRegistro() {
		return registro;
	}
	public void setRegistro(Registro registro) {
		this.registro = registro;
	}
	public List<Ciudad> getCiudades() {
		return ciudades;
	}
	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
	public String getMs() {
		return ms;
	}
	public void setMs(String ms) {
		this.ms = ms;
	}
	public void consultaApi() throws Exception {
		System.out.println(ms);
		RESTEasyClientGet nuevo = new RESTEasyClientGet();
		this.setRegistro(nuevo.llamado(ms));
		System.out.println("SALE");
		
		
	}
}