package work.javiermantilla.franquicia.infrastructure.rest.dto.producto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import work.javiermantilla.franquicia.infrastructure.rest.dto.franquicia.FranquiciaRequestDTO;
import work.javiermantilla.franquicia.infrastructure.rest.dto.sucursal.SucursalRequestDTO;

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
