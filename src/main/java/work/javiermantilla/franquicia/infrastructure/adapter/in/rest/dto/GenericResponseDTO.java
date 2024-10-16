package work.javiermantilla.franquicia.infrastructure.adapter.in.rest.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import work.javiermantilla.franquicia.common.util.FranquiciaConstants;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponseDTO {

	private Object data;
	private boolean success;
	private String message;
	private HttpStatus status;
	private String title = "";

	public GenericResponseDTO(Object data, boolean success, String message, HttpStatus status) {
		this.data = data;
		this.success = success;
		this.message = message;
		this.status = status;
		this.title = success ? "" : "¡Oops! Ocurrió un error";
	}

	public GenericResponseDTO(Object data, HttpStatus status) {
		this.data = data;
		this.success = true;
		this.message = FranquiciaConstants.RESPONSE_FIND;
		this.status = status;
		this.title = FranquiciaConstants.TITTLE_FIND;
	}
}
