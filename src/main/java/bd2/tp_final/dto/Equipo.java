package bd2.tp_final.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="equipo")
public class Equipo extends DTO {
	
	@Column(nullable = false)
	String nombre;	
	
	public Equipo() {
		
	}
	
	public Equipo(String nombre) {
		super();
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
