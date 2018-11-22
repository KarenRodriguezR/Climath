package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ciudad database table.
 * 
 */
@Entity
@NamedQuery(name="Ciudad.findAll", query="SELECT c FROM Ciudad c")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idciudad;

	private Boolean estado;

	private String nombre;

	//bi-directional many-to-one association to Registro
	@OneToMany(mappedBy="ciudad")
	private List<Registro> registros;
	
	public Ciudad() {
	}

	public Ciudad(Integer idc, boolean y, String name) {
		this.idciudad = idc;
		this.estado = y;
		this.nombre = name;
	}

	public Integer getIdciudad() {
		return this.idciudad;
	}

	public void setIdciudad(Integer a) {
		this.idciudad = a;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Registro> getRegistros() {
		return this.registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	public Registro addRegistro(Registro registro) {
		getRegistros().add(registro);
		registro.setCiudad(this);

		return registro;
	}

	public Registro removeRegistro(Registro registro) {
		getRegistros().remove(registro);
		registro.setCiudad(null);

		return registro;
	}

}