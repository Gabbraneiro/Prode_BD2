package bd2.tp_final.repository;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import bd2.tp_final.dto.Apuesta;
import bd2.tp_final.dto.Usuario;

@Transactional
public interface ApuestaRepository extends CrudRepository<Apuesta,Integer>{

	public Iterable<Apuesta> findByUsuario(Usuario usuario);
	
}
