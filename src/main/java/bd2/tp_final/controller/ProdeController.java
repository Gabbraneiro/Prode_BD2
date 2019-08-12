package bd2.tp_final.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bd2.tp_final.dto.Usuario;
import bd2.tp_final.http.ProdeResponse;
import bd2.tp_final.http.PuntajeResponse;
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
