package bd2.tp_final.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import bd2.tp_final.dto.Partido;

@Transactional
public interface PartidoRepository extends CrudRepository<Partido,Integer>{
	
	public Iterable<Partido> findByTorneo(Integer torneoId);
}
