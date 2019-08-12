package bd2.tp_final.dao;

import org.springframework.data.repository.CrudRepository;

import bd2.tp_final.dto.Puntaje;
import bd2.tp_final.dto.Torneo;
import bd2.tp_final.dto.Usuario;

public interface PuntajeDAO extends CrudRepository<Puntaje,Integer>{

	public Iterable<Puntaje> findByTorneo(Torneo torneo);
	
	public Iterable<Usuario> findByUsuario(Usuario torneo);
	
}
