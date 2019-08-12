package bd2.tp_final.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bd2.tp_final.dao.UsuarioDAO;
import bd2.tp_final.dto.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	/* CONSULTA */
	public Iterable<Usuario> obtenerUsuarios(){
		return usuarioDAO.findAll();
	}
	
	/* CONSULTA */
	public Optional<Usuario> obtenerUsuario(Integer usuarioId){
		return usuarioDAO.findById(usuarioId);
	}	
	
	/* ALTA */
	public Usuario nuevoUsuario(String username, String nombre, String apellido) throws Exception {
		Optional<Usuario> usuarioExistente = usuarioDAO.findByUsername(username);
		if(usuarioExistente.isPresent()) {
			throw new Exception("El username elegido ya existe, por favor elija otro");
		}
		Usuario u = new Usuario(username, nombre, apellido);
		
		return usuarioDAO.save(u);
	}
	
	/* MODIFICACIÓN */
	public Usuario editarUsuario(Usuario usuario, String username, String nombre, String apellido){
		usuario.setUsername(username);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);		
		return usuarioDAO.save(usuario);
	}
	

}
