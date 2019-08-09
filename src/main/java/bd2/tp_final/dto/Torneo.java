package bd2.tp_final.dto;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="torneo")
public class Torneo extends DTO {
	
	@Column(nullable = false)
	String nombre;
	
//	@OneToMany(mappedBy = "torneo")
//	List<Partido> partidos;
	
	public Torneo() {
		
	}
	
	public Torneo(String nombre) {
		super();
		this.nombre = nombre;
//		this.partidos = new ArrayList<Partido>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
//	public List<Partido> getPartidos() {
//		return partidos;
//	}
//	public void setPartidos(List<Partido> partidos) {
//		this.partidos = partidos;
//	}
}
