package bd2.tp_final.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import bd2.tp_final.dto.Equipo;

@Transactional
public interface EquipoDAO extends CrudRepository<Equipo,Integer>{

}
