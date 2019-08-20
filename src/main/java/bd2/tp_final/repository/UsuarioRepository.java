package bd2.tp_final.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import bd2.tp_final.dto.Usuario;

@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario,Integer>{

	Optional<Usuario> findByUsername(String username);
	
}
