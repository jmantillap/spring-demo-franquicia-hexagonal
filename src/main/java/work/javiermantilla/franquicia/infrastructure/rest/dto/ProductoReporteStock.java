package work.javiermantilla.franquicia.infrastructure.rest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductoReporteStock {
	
	private FranquiciaRequestDTO franquicia;
	private List<SucursalProducto> sucursales;
	
	@Data
	@AllArgsConstructor
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class SucursalProducto{
		private SucursalRequestDTO sucursal;
		private List<ProductoRequestDTO> productoXSucursal;
	}

}
