package bd2.tp_final.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="partido")
public class Partido extends DTO {
	
	@ManyToOne()
    @JoinColumn(name="local", nullable=false)
	Equipo local;

    @ManyToOne()
    @JoinColumn(name="visitante", nullable=false)
	Equipo visitante;
	
    @ManyToOne()
    @JoinColumn(name="torneo", nullable=false)
	Torneo torneo;
    
    @Column(nullable = false)
	LocalDateTime fecha;
	
	Integer golesLocal;
	
	Integer golesVisitante;
	
	Integer penalesLocal;
	
	Integer penalesVisitante;	

	public Partido() {
		
	}
	
	public Partido(Equipo local, Equipo visitante, Torneo torneo, LocalDateTime fecha) {
		super();
		this.local = local;
		this.visitante = visitante;
		this.torneo = torneo;
		this.fecha = fecha;
	}
	public Equipo getLocal() {
		return local;
	}
	public void setLocal(Equipo local) {
		this.local = local;
	}
	public Equipo getVisitante() {
		return visitante;
	}
	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public Integer getGolesLocal() {
		return golesLocal;
	}
	public void setGolesLocal(Integer golesLocal) {
		this.golesLocal = golesLocal;
	}
	public Integer getGolesVisitante() {
		return golesVisitante;
	}
	public void setGolesVisitante(Integer golesVisitante) {
		this.golesVisitante = golesVisitante;
	}
	public Integer getPenalesLocal() {
		return penalesLocal;
	}
	public void setPenalesLocal(Integer penalesLocal) {
		this.penalesLocal = penalesLocal;
	}
	public Integer getPenalesVisitante() {
		return penalesVisitante;
	}
	public void setPenalesVisitante(Integer penalesVisitante) {
		this.penalesVisitante = penalesVisitante;
	}
	public Torneo getTorneo() {
		return torneo;
	}
	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}
	
	
}
