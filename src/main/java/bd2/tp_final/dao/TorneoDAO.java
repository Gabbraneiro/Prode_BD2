package bd2.tp_final.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import bd2.tp_final.dto.Torneo;

@Transactional
public interface TorneoDAO extends CrudRepository<Torneo,Integer>{

}
