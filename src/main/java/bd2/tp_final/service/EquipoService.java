package bd2.tp_final.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import bd2.tp_final.dto.Equipo;



@Service
public class EquipoService extends ProdeService{
	
	/* CONSULTA */
	public Iterable<Equipo> obtenerEquipos(){
		return equipoRepository.findAll();
	}
	
	/* CONSULTA */
	public Optional<Equipo> obtenerEquipo(Integer equipoId){
		return equipoRepository.findById(equipoId);
	}
	
	/* ALTA */
	public Equipo nuevoEquipo(String nombre) {
		Equipo equipo = new Equipo(nombre);
		return equipoRepository.save(equipo);
	}
		
	/* MODIFICACIÓN */
	public Equipo editarEquipo(Equipo equipo, String nombre) throws NoSuchElementException{
		if(nombre != null && !nombre.isEmpty()) {
			equipo.setNombre(nombre);
		}
		return equipoRepository.save(equipo);
	}
	
	/* BAJA */
	public void eliminarEquipo(Equipo equipo) {
		equipoRepository.delete(equipo);
	}
}
