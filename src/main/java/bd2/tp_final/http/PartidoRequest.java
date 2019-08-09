package bd2.tp_final.http;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;


public class PartidoRequest implements ProdeRequest{

	private Integer local;

	private Integer visitante;

	private Integer torneo;

	private String fecha;	
	
	public Integer getLocal() {
		return local;
	}

	public Integer getVisitante() {
		return visitante;
	}

	public Integer getTorneo() {
		return torneo;
	}

	public String getFecha() {
		return fecha;
	}


	public Map<String, Object> validarRequest() {
		Map<String,Object> retorno = new HashMap<String,Object>();
		retorno.put("requestValido", true);
		if(local == null) {
			retorno.put("local", "El campo local no puede ser nulo");
			retorno.put("requestValido", false);
		}
		if(local != null && local < 1) {
			retorno.put("local", "El campo local es inválido");
			retorno.put("requestValido", false);
		}
		if(visitante == null) {
			retorno.put("visitante", "El campo visitante no puede ser nulo");
			retorno.put("requestValido", false);
		}
		if(visitante != null && visitante < 1) {
			retorno.put("visitante", "El campo visitante es inválido");
			retorno.put("requestValido", false);
		}
		if(torneo == null) {
			retorno.put("torneo", "El campo torneo no puede ser nulo");
			retorno.put("requestValido", false);
		}
		if(torneo != null && torneo < 1) {
			retorno.put("torneo", "El campo torneo es inválido");
			retorno.put("requestValido", false);
		}	
		if(fecha == null) {
			retorno.put("fecha", "El campo fecha no puede ser nulo");
			retorno.put("requestValido", false);
		}
		else {
			try {
				LocalDateTime.parse(fecha);
			}
			catch(DateTimeParseException e) {
				retorno.put("fecha", "El campo fecha es invalido. Formato esperado: '1970-11-22T10:11:22' ");
				retorno.put("requestValido", false);
			}
		}
		if(fecha != null && fecha.isEmpty()) {
			retorno.put("torneo", "El campo fecha no puede estar vacio");
			retorno.put("requestValido", false);
		}

		return retorno;
	}

}
