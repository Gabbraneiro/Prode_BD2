package bd2.tp_final.controller;


import org.springframework.beans.factory.annotation.Autowired;
import bd2.tp_final.service.ApuestaService;
import bd2.tp_final.service.EquipoService;
import bd2.tp_final.service.PartidoService;
import bd2.tp_final.service.TorneoService;
import bd2.tp_final.service.UsuarioService;


public class ProdeController {
	
	@Autowired
	protected UsuarioService usuarioService;
	
	@Autowired
	protected EquipoService equipoService;
	
	@Autowired
	protected TorneoService torneoService;
	
	@Autowired
	protected PartidoService partidoService;
	
	@Autowired
	protected ApuestaService apuestaService;
	

}
