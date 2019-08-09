package bd2.tp_final.service;


import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import bd2.tp_final.dto.Apuesta;
import bd2.tp_final.dto.Partido;
import bd2.tp_final.dto.Usuario;

@Service
public class ApuestaService extends ProdeService{
	
	/* CONSULTA */
	public Iterable<Apuesta> obtenerApuestas(){
		return apuestaDAO.findAll();
	}
	
	/* CONSULTA */
	public Iterable<Apuesta> obtenerApuestas(Integer usuarioId) {
		return apuestaDAO.findByUsuario(usuarioId);
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
}
