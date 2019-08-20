package bd2.tp_final.service;

import org.springframework.beans.factory.annotation.Autowired;

import bd2.tp_final.repository.EquipoRepository;
import bd2.tp_final.repository.PartidoRepository;
import bd2.tp_final.repository.ApuestaRepository;
import bd2.tp_final.repository.TorneoRepository;
import bd2.tp_final.repository.UsuarioRepository;

public abstract class ProdeService {
	
	@Autowired
	protected ApuestaRepository apuestaRepository;
	
	@Autowired
	protected EquipoRepository equipoRepository;
	
	@Autowired
	protected PartidoRepository partidoRepository;
	
	@Autowired
	protected TorneoRepository torneoRepository;
	
	@Autowired
	protected UsuarioRepository usuarioRepository;

	
}
