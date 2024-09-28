package work.javiermantilla.franquicia.infrastructure.rest.dto.franquicia;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FranquiciaUpdateRequestDTO implements Serializable {

	private static final long serialVersionUID = 6198043062145430662L;
	
	@Size(min = 2, max = 45)
	private String nombre;
	
}
