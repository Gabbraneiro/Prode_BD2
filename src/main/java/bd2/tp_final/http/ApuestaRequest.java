package bd2.tp_final.http;

import java.util.HashMap;
import java.util.Map;

public class ApuestaRequest implements ProdeRequest{

	private Integer golesLocal;	

	private Integer golesVisitante;
	
	private Integer penalesLocal;
	
	private Integer penalesVisitante;
	
	private Integer partido;
    
	private Integer usuario;

	public Integer getGolesLocal() {
		return golesLocal;
	}

	public Integer getGolesVisitante() {
		return golesVisitante;
	}

	public Integer getPenalesLocal() {
		return penalesLocal;
	}

	public Integer getPenalesVisitante() {
		return penalesVisitante;
	}

	public Integer getPartido() {
		return partido;
	}

	public Integer getUsuario() {
		return usuario;
	}

	@Override
	public Map<String, Object> validarRequest() {
		Map<String,Object> retorno = new HashMap<String,Object>();
		retorno.put("requestValido", true);
		if(golesLocal == null) {
			retorno.put("golesLocal", "El campo golesLocal no puede ser nulo");
			retorno.put("requestValido", false);
		}
		if(golesLocal != null && golesLocal < 0) {
			retorno.put("golesLocal", "El campo golesLocal es inválido");
			retorno.put("requestValido", false);
		}
		if(golesVisitante == null) {
			retorno.put("golesVisitante", "El campo golesVisitante no puede ser nulo");
			retorno.put("requestValido", false);
		}
		if(golesVisitante != null && golesVisitante < 0) {
			retorno.put("golesVisitante", "El campo golesVisitante es inválido");
			retorno.put("requestValido", false);
		}
		if(golesVisitante == null) {
			retorno.put("golesVisitante", "El campo golesVisitante no puede ser nulo");
			retorno.put("requestValido", false);
		}
		if(golesVisitante != null && golesVisitante < 0) {
			retorno.put("golesVisitante", "El campo golesVisitante es inválido");
			retorno.put("requestValido", false);
		}
		if(partido == null) {
			retorno.put("partido", "El campo partido no puede ser nulo");
			retorno.put("requestValido", false);
		}
		if(partido != null && partido < 1) {
			retorno.put("partido", "El campo partido es inválido");
			retorno.put("requestValido", false);
		}
		if(usuario == null) {
			retorno.put("usuario", "El campo usuario no puede ser nulo");
			retorno.put("requestValido", false);
		}
		if(usuario != null && usuario < 1) {
			retorno.put("usuario", "El campo usuario es inválido");
			retorno.put("requestValido", false);
		}
		if(penalesLocal != null || penalesVisitante != null) {
			if(golesLocal != golesVisitante) {
				retorno.put("penales", "Los campo penalesLocal y penalesVisitante deben mandarse solo si es empate");
				retorno.put("requestValido", false);
			}
		}
		if(penalesLocal != null && penalesVisitante == null) {
			retorno.put("penalesVisitante", "El campo penalesVisitante es requerido si se setea el campo penalesLocal");
			retorno.put("requestValido", false);
		}
		if(penalesVisitante != null && penalesLocal == null) {
			retorno.put("penalesLocal", "El campo penalesLocal es requerido si se setea el campo penalesVisitante");
			retorno.put("requestValido", false);
		}
		if(penalesLocal != null && penalesLocal < 0) {
			retorno.put("penalesLocal", "El campo penalesLocal es inválido");
			retorno.put("requestValido", false);
		}
		if(penalesVisitante != null && penalesVisitante < 0) {
			retorno.put("penalesVisitante", "El campo penalesVisitante es inválido");
			retorno.put("requestValido", false);
		}
		return retorno;
	}
	
	
}
