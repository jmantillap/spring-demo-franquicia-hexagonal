package work.javiermantilla.franquicia.infrastructure.rest.dto.sucursal;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import work.javiermantilla.franquicia.infrastructure.rest.dto.franquicia.FranquiciaRequestDTO;


@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class SucursalRequestDTO implements Serializable {
	
	private static final long serialVersionUID = -8553637982181400849L;
	@Null
	private Integer id;
	@NotNull
	@Positive
	private Integer idFranquicia;
	@Size(min = 2, max = 45)
	private String nombre;
	@Null
	private FranquiciaRequestDTO franquicia;
	public SucursalRequestDTO(@Null Integer id, @Size(min = 2, max = 45) String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	
}
