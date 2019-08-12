package bd2.tp_final.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bd2.tp_final.dto.Apuesta;
import bd2.tp_final.dto.Equipo;



@Service
public class EquipoService extends ProdeService{
	
	/* CONSULTA */
	public Iterable<Equipo> obtenerEquipos(){
		return equipoDAO.findAll();
	}
	
	/* CONSULTA */
	public Optional<Equipo> obtenerEquipo(Integer equipoId){
		return equipoDAO.findById(equipoId);
	}
	
	/* ALTA */
	public Equipo nuevoEquipo(String nombre) {
		Equipo equipo = new Equipo(nombre);
		return equipoDAO.save(equipo);
	}
		
	/* MODIFICACIÓN */
	public Equipo editarEquipo(Equipo equipo, String nombre) throws NoSuchElementException{
		if(nombre != null && !nombre.isEmpty()) {
			equipo.setNombre(nombre);
		}
		return equipoDAO.save(equipo);
	}
	
	/* BAJA */
	public void eliminarEquipo(Equipo equipo) {
		equipoDAO.delete(equipo);
	}
}
