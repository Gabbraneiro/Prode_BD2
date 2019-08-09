package bd2.tp_final.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import bd2.tp_final.dto.Torneo;


@Service
public class TorneoService extends ProdeService {

	/* CONSULTA */
	public Iterable<Torneo> obtenerTorneos(){
		return torneoDAO.findAll();
	}
	
	/* CONSULTA */
	public Optional<Torneo> obtenerTorneo(Integer torneoId){
		return torneoDAO.findById(torneoId);
	}
	
	/* ALTA */
	public Torneo nuevoTorneo(String nombre) {
		Torneo torneo = new Torneo(nombre);
		return torneoDAO.save(torneo);
	}
	
	/* MODIFICACIÓN */
	public Torneo editarTorneo(Torneo torneo, String nombre){
		torneo.setNombre(nombre);
		return torneoDAO.save(torneo);
	}
}
