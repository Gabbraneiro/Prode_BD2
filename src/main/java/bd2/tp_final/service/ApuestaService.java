package bd2.tp_final.service;


import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import bd2.tp_final.dto.Apuesta;
import bd2.tp_final.dto.Partido;
import bd2.tp_final.dto.Usuario;

@Service
public class ApuestaService extends ProdeService{
	static final Integer PLENO = 3;
	static final Integer ACIERTO = 1;
	
	
	/* CONSULTA */
	public Iterable<Apuesta> obtenerApuestas(){
		return apuestaDAO.findAll();
	}
	
	/* CONSULTA */
	public Iterable<Apuesta> obtenerApuestas(Usuario usuario) {
		return apuestaDAO.findByUsuario(usuario);
	}
	
	/* ALTA */
	public Apuesta nuevaApuesta(Partido partido, Usuario usuario, Integer golesLocal, Integer golesVisitante, Integer penalesLocal, Integer penalesVisitante) throws NoSuchElementException{
		Apuesta apuesta = new Apuesta(golesLocal, golesVisitante, penalesLocal, penalesVisitante, partido, usuario);
		return apuestaDAO.save(apuesta);
		
	}
	
	/* MODIFICACIÓN */
	public Apuesta editarApuesta(Apuesta apuesta, Integer idUsuario, Integer golesLocal, Integer golesVisitante, Integer penalesLocal, Integer penalesVisitante) throws Exception, NoSuchElementException{
		
		Partido partido = partidoDAO.findById(apuesta.getPartido().getId()).get();
		if(partido.getFecha().isBefore(LocalDateTime.now())) {
			throw new Exception("No se puede editar la apuesta la fecha actual es mayor a la fecha del partido");
		}
		if(idUsuario != null) {
			Usuario usuario = usuarioDAO.findById(idUsuario).get();
			apuesta.setUsuario(usuario);
		}
		if(golesLocal != null) {
			apuesta.setGolesLocal(golesLocal);
		}
		if(penalesLocal !=null) {
			apuesta.setPenalesLocal(penalesLocal);
		}
		if(golesVisitante !=null) {
			apuesta.setGolesVisitante(golesVisitante);
		}
		if(penalesVisitante != null) {
			apuesta.setPenalesVisitante(penalesVisitante);
		}
		
		return apuestaDAO.save(apuesta);
		
	}
	
	public Iterable<Apuesta> contabilizarApuestas(){
		Iterable<Apuesta> apuestas = apuestaDAO.findAll();
		for (Apuesta apuesta : apuestas) {
			Partido partido = partidoDAO.findById(apuesta.getPartido().getId()).get();
			if(partido.getFecha().isBefore(LocalDateTime.now())) { //Si ya paso la fecha del partido
				if(partido.getGolesLocal() != null && partido.getGolesVisitante() !=null) { //Si estan registrados los goles de ambos equipos
					this.calcularPuntajeGoles(apuesta);
					if(partido.getGolesLocal() == partido.getGolesVisitante()) { //Si empataron
						if(partido.getPenalesLocal() != null && partido.getPenalesVisitante() != null) { //Si estan registrados los penales de ambos equipos
							this.calcularPuntajePenales(apuesta);
						}
					}
				}
			}
		}
		return apuestaDAO.findAll();
	}
	public void calcularPuntajeGoles(Apuesta apuesta) {
		Boolean aciertoPleno = apuesta.getGolesLocal() == apuesta.getPartido().getGolesLocal() && apuesta.getGolesVisitante() == apuesta.getPartido().getGolesVisitante();
		Boolean aciertoVictoriaLocal = (apuesta.getGolesLocal()  > apuesta.getGolesVisitante()) && (apuesta.getPartido().getGolesLocal() >  apuesta.getPartido().getGolesVisitante());
		Boolean aciertoVictoriaVisitante = (apuesta.getGolesLocal()  < apuesta.getGolesVisitante()) && (apuesta.getPartido().getGolesLocal() <  apuesta.getPartido().getGolesVisitante());
		Boolean aciertoEmpate = (apuesta.getGolesLocal()  == apuesta.getGolesVisitante()) && (apuesta.getPartido().getGolesLocal() ==  apuesta.getPartido().getGolesVisitante());
		Integer puntaje = 0;
		if(aciertoPleno) {
			puntaje+= PLENO; 
		}
		else if(aciertoVictoriaLocal || aciertoVictoriaVisitante || aciertoEmpate) {
			puntaje+= ACIERTO;
		}
		apuesta.setPuntosGanados(puntaje);
		apuestaDAO.save(apuesta);
	}
	
	public void calcularPuntajePenales(Apuesta apuesta) {
		Boolean aciertoPleno = apuesta.getPenalesLocal() == apuesta.getPartido().getPenalesLocal() && apuesta.getPenalesVisitante() == apuesta.getPartido().getPenalesVisitante();
		Boolean aciertoVictoriaLocal = (apuesta.getPenalesLocal()  > apuesta.getPenalesVisitante()) && (apuesta.getPartido().getPenalesLocal() >  apuesta.getPartido().getPenalesVisitante());
		Boolean aciertoVictoriaVisitante = (apuesta.getPenalesLocal()  < apuesta.getPenalesVisitante()) && (apuesta.getPartido().getPenalesLocal() <  apuesta.getPartido().getPenalesVisitante());
		Boolean aciertoEmpate = (apuesta.getPenalesLocal()  == apuesta.getPenalesVisitante()) && (apuesta.getPartido().getPenalesLocal() ==  apuesta.getPartido().getPenalesVisitante());
		Integer puntaje = 0;
		if(aciertoPleno) {
			puntaje+= PLENO; 
		}
		else if(aciertoVictoriaLocal || aciertoVictoriaVisitante || aciertoEmpate) {
			puntaje+= ACIERTO;
		}
		apuesta.setPuntosGanados(apuesta.getPuntosGanados() + puntaje);
		apuestaDAO.save(apuesta);
	}
}
