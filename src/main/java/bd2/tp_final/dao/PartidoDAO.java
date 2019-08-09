package bd2.tp_final.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import bd2.tp_final.dto.Partido;

@Transactional
public interface PartidoDAO extends CrudRepository<Partido,Integer>{
	
	public Iterable<Partido> findByTorneo(Integer torneoId);
}
