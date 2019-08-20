package bd2.tp_final.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import bd2.tp_final.dto.Torneo;


@Service
public class TorneoService extends ProdeService {

	/* CONSULTA */
	public Iterable<Torneo> obtenerTorneos(){
		return torneoRepository.findAll();
	}
	
	/* CONSULTA */
	public Optional<Torneo> obtenerTorneo(Integer torneoId){
		return torneoRepository.findById(torneoId);
	}
	
	/* ALTA */
	public Torneo nuevoTorneo(String nombre) {
		Torneo torneo = new Torneo(nombre);
		return torneoRepository.save(torneo);
	}
	
	/* MODIFICACIÓN */
	public Torneo editarTorneo(Torneo torneo, String nombre){
		torneo.setNombre(nombre);
		return torneoRepository.save(torneo);
	}
	
	/* BAJA */
	public void eliminarTorneo(Torneo torneo) {
		torneoRepository.delete(torneo);
	}
}
