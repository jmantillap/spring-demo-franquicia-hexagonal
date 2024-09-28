package work.javiermantilla.franquicia.domain.report;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import work.javiermantilla.franquicia.domain.model.Franquicia;
import work.javiermantilla.franquicia.domain.model.Producto;
import work.javiermantilla.franquicia.domain.model.Sucursal;

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
