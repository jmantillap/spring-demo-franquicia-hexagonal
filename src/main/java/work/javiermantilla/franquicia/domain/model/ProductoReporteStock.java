package work.javiermantilla.franquicia.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductoReporteStock {
	
	private Franquicia franquicia;
	private List<SucursalProducto> sucursales;
	
	@Data
	@AllArgsConstructor
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class SucursalProducto{
		private Sucursal sucursal;
		private List<Producto> productoXSucursal;
	}

}
