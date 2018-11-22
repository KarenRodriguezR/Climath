package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the registro database table.
 * 
 */
@Entity
@NamedQuery(name="Registro.findAll", query="SELECT r FROM Registro r")
public class Registro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idregistro;

	private Boolean estado;

	private String fecha;

	private String hora;

	private Double humedad;

	private Double temperatura;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name="fk_registro_ciudad")
	private Ciudad ciudad;

	public Registro() {
		}
	
	public Registro(int idr, boolean es, String fe, String ho, double hum, double tem) {
		this.idregistro = idr;
		this.estado = es;
		this.fecha = fe;
		this.hora = ho;
		this.humedad = hum;
		this.temperatura = tem;
	}
	
	public Integer getIdregistro() {
		return this.idregistro;
	}

	public void setIdregistro(Integer idregistro) {
		this.idregistro = idregistro;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Double getHumedad() {
		return this.humedad;
	}

	public void setHumedad(Double humedad) {
		this.humedad = humedad;
	}

	public Double getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

}