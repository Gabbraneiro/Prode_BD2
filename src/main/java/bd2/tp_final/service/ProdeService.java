package bd2.tp_final.service;

import org.springframework.beans.factory.annotation.Autowired;

import bd2.tp_final.dao.ApuestaDAO;
import bd2.tp_final.dao.EquipoDAO;
import bd2.tp_final.dao.PartidoDAO;
import bd2.tp_final.dao.TorneoDAO;
import bd2.tp_final.dao.UsuarioDAO;

public abstract class ProdeService {
	
	@Autowired
	protected ApuestaDAO apuestaDAO;
	
	@Autowired
	protected EquipoDAO equipoDAO;
	
	@Autowired
	protected PartidoDAO partidoDAO;
	
	@Autowired
	protected TorneoDAO torneoDAO;
	
	@Autowired
	protected UsuarioDAO usuarioDAO;
}
