package work.javiermantilla.franquicia.infrastructure.rest.dto.producto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import work.javiermantilla.franquicia.infrastructure.rest.dto.sucursal.SucursalRequestDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductoRequestDTO implements Serializable {
	
	private static final long serialVersionUID = -4666772745629603369L;
	@Null
	private Integer id;
	@NotNull
	@NotEmpty
	private String nombre;
	@NotNull
	@Positive
	private Integer idSucursal;
	@Null
	private SucursalRequestDTO sucursal;	
	@NotNull
	@Positive
	private Integer stock;
	public ProductoRequestDTO(String nombre, Integer stock) {
		super();
		this.nombre = nombre;
		this.stock = stock;
	}
	
	
}
