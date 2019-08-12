package bd2.tp_final.dto;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="puntaje")
public class Puntaje extends DTO{
	
	
	private Integer puntos;
	
    @ManyToOne()
    @JoinColumn(name="usuario", nullable=false)
    private Usuario usuario;
    
    @ManyToOne()
    @JoinColumn(name="torneo", nullable=false)
    private Torneo torneo;

    
    
	public Puntaje(Integer puntos, Usuario usuario, Torneo torneo) {
		super();
		this.puntos = puntos;
		this.usuario = usuario;
		this.torneo = torneo;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}
    
    
    
}
