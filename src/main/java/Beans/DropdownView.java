package Beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import controlador.CiudadControlador;
import modelo.Ciudad;
import servicios.RESTEasyClientGet;

@ManagedBean(name="lista")
public class DropdownView implements Serializable {
	
    private List<Ciudad> ciudades;
    private String ms;
    private String res;
    
    public String getRes() {
    	return res;
    }
    public void getRes(String res) {
    	this.res=res;
    }
    
    
    
   
	public String getMs() {
		return ms;122	3421
	}
	public void setMs(String ms) {
		this.ms = ms;
	}

	
 
    public DropdownView () {
    	CiudadControlador ns = new CiudadControlador();
    	ciudades=ns.listarCiudades();
    	
    	
    }
   public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
	
	public void mensaje() throws Exception {
		RESTEasyClientGet nu = new RESTEasyClientGet();
    	res=nu.cliente(ms);
	}
}