package bd2.tp_final.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import bd2.tp_final.dto.Apuesta;
import bd2.tp_final.dto.Usuario;

@Transactional
public interface ApuestaDAO extends CrudRepository<Apuesta,Integer>{

	public Iterable<Apuesta> findByUsuario(Usuario usuario);
	
}
