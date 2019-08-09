package bd2.tp_final.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;

public class ProdeResponse {
	
	protected HttpStatus statusCode;
	protected Object data;
	
	public ProdeResponse(Object data, HttpStatus statusCode) {
		this.data = data;
		this.statusCode = statusCode;
	}
	
	public ResponseEntity<String> render(){
		Gson gson = new Gson();
		String json = gson.toJson(this.data);
		return ResponseEntity.status(this.statusCode).body(json);
	}
}
