package bd2.tp_final.http;

public class PuntajeResponse {

	private String username;
	private Integer puntaje;
		
	public PuntajeResponse(String username, Integer puntaje) {
		super();
		this.username = username;
		this.puntaje = puntaje;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}
	
	
	
}
