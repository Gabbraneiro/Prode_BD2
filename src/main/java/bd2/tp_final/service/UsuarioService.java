package bd2.tp_final.service;

import java.util.Optional;


import org.springframework.stereotype.Service;
import bd2.tp_final.dto.Usuario;


@Service
public class UsuarioService extends ProdeService{

	/* CONSULTA */
	public Iterable<Usuario> obtenerUsuarios(){
		return usuarioRepository.findAll();
	}
	
	/* CONSULTA */
	public Optional<Usuario> obtenerUsuario(Integer usuarioId){
		return usuarioRepository.findById(usuarioId);
	}	
	
	/* ALTA */
	public Usuario nuevoUsuario(String username, String nombre, String apellido) throws Exception {
		Optional<Usuario> usuarioExistente = usuarioRepository.findByUsername(username);
		if(usuarioExistente.isPresent()) {
			throw new Exception("El username elegido ya existe, por favor elija otro");
		}
		Usuario u = new Usuario(username, nombre, apellido);
		
		return usuarioRepository.save(u);
	}
	
	/* MODIFICACIÓN */
	public Usuario editarUsuario(Usuario usuario, String username, String nombre, String apellido){
		usuario.setUsername(username);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);		
		return usuarioRepository.save(usuario);
	}
	
	/* BAJA */
	public void eliminarUsuario(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
	
}
