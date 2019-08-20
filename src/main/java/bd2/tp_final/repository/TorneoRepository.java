package bd2.tp_final.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import bd2.tp_final.dto.Torneo;

@Transactional
public interface TorneoRepository extends CrudRepository<Torneo,Integer>{

}
