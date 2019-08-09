package bd2.tp_final.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="apuesta")
public class Apuesta extends DTO{
	
	@Column(nullable = false)
	Integer golesLocal;
	
	@Column(nullable = false)
	Integer golesVisitante;
	
	Integer penalesLocal;
	
	Integer penalesVisitante;
	
	Integer puntosGanados;
	
    @ManyToOne()
    @JoinColumn(name="partido", nullable=false)
	Partido partido;
    
    @ManyToOne()
    @JoinColumn(name="usuario", nullable=false)
	Usuario usuario;
	
    
	public Apuesta() {
		
	}
	
	public Apuesta(Integer golesLocal, Integer golesVisitante, Integer penalesLocal, Integer penalesVisitante, Partido partido, Usuario usuario) {
		super();
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
		this.penalesLocal = penalesLocal;
		this.penalesVisitante = penalesVisitante;
		this.partido = partido;
		this.usuario = usuario;
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
	public Integer getPuntosGanados() {
		return puntosGanados;
	}
	public void setPuntosGanados(Integer puntosGanados) {
		this.puntosGanados = puntosGanados;
	}
	public Partido getPartido() {
		return partido;
	}
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
