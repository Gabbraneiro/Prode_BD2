package bd2.tp_final.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario extends DTO {
	
	@Column(nullable = false, unique = true)
	String username;
	
	@Column(nullable = false)
	String nombre;
	
	@Column(nullable = false)
	String apellido;
		
//	@OneToMany(mappedBy = "usuario")
//	List<Apuesta> apuestas;
	
	public Usuario() {
		
	}
	
	public Usuario(String username, String nombre, String apellido) {
		super();
		this.username = username;
		this.nombre = nombre;
		this.apellido = apellido;
//		this.apuestas = new ArrayList<Apuesta>();
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


}
