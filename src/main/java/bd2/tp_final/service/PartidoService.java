package bd2.tp_final.service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bd2.tp_final.dto.Equipo;
import bd2.tp_final.dto.Partido;
import bd2.tp_final.dto.Torneo;

@Service
public class PartidoService extends ProdeService{
	
	/* CONSULTA */
	public Iterable<Partido> obtenerPartidos(){
		return partidoDAO.findAll();
	}
	
	/* CONSULTA */
	public Iterable<Partido> obtenerPartidos(Integer torneoId){
		return partidoDAO.findByTorneo(torneoId);
	}
	
	/* CONSULTA */
	public Optional<Partido> obtenerPartido(Integer partidoId){
		return partidoDAO.findById(partidoId);
	}	
	
	/* ALTA */
	public Partido nuevoPartido(Equipo equipoLocal, Equipo equipoVisitante, Torneo torneo, String fechaStr){
		LocalDateTime fecha = LocalDateTime.parse(fechaStr);
//		Equipo equipoLocal = equipoDAO.findById(equipo).get();
//		Equipo equipoVisitante = equipoDAO.findById(equipo2).get();
//		Torneo torneo = torneoDAO.findById(torneo2).get();
		Partido partido = new Partido(equipoLocal, equipoVisitante, torneo, fecha);
		return partidoDAO.save(partido);
	}
	
	/* MODIFICACIÓN */
	public Partido editarPartido(Partido partido, Integer idEquipoLocal, Integer idEquipoVisitante, Integer idTorneo, String fechaStr) throws NoSuchElementException{
		LocalDateTime fecha = LocalDateTime.parse(fechaStr);
		partido.setFecha(fecha);	
		Equipo equipoLocal = equipoDAO.findById(idEquipoLocal).get();
		partido.setLocal(equipoLocal);
		Equipo equipoVisitante = equipoDAO.findById(idEquipoVisitante).get();
		partido.setVisitante(equipoVisitante);
		Torneo torneo = torneoDAO.findById(idTorneo).get();
		partido.setTorneo(torneo);		
		return partidoDAO.save(partido);
		
	}
	
	/* ACTUALIZACIÓN */
	public Partido actualizarResultadosPartido(Partido partido, Integer golesLocal, Integer golesVisitante, Integer penalesLocal, Integer penalesVisitante){
		partido.setGolesLocal(golesLocal);
		partido.setGolesVisitante(golesVisitante);
		partido.setPenalesLocal(penalesLocal);
		partido.setPenalesVisitante(penalesVisitante);
		return partidoDAO.save(partido);
		
	}
	
	/* BAJA */
	public void eliminarPartido(Partido partido) {
		partidoDAO.delete(partido);
	}

}


