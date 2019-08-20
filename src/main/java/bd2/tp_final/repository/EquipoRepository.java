package bd2.tp_final.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import bd2.tp_final.dto.Equipo;

@Transactional
public interface EquipoRepository extends CrudRepository<Equipo,Integer>{

}
