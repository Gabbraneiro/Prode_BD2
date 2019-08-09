package bd2.tp_final.http;

import java.util.HashMap;
import java.util.Map;

public class ActualizacionPartidoRequest implements ProdeRequest{

	private Integer golesLocal;
	
	private Integer golesVisitante;
	
	private Integer penalesLocal;
	
	private Integer penalesVisitante;	
	
	
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
