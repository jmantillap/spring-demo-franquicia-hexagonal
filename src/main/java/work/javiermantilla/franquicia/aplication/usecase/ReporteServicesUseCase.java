package work.javiermantilla.franquicia.aplication.usecase;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import work.javiermantilla.franquicia.aplication.ports.in.FranquiciaUseCasePortIn;
import work.javiermantilla.franquicia.aplication.ports.in.ReporteServicesUseCasePortIn;
import work.javiermantilla.franquicia.aplication.ports.in.SucursalUseCasePortIn;
import work.javiermantilla.franquicia.aplication.ports.out.ProductoRepositoryPortOut;
import work.javiermantilla.franquicia.common.annotation.UseCase;
import work.javiermantilla.franquicia.common.util.GenericMapper;
import work.javiermantilla.franquicia.domain.model.Franquicia;
import work.javiermantilla.franquicia.domain.model.Producto;
import work.javiermantilla.franquicia.domain.model.Sucursal;
import work.javiermantilla.franquicia.domain.report.ProductoReporteStock;
import work.javiermantilla.franquicia.domain.report.ProductoReporteStock.SucursalProducto;

@UseCase
@RequiredArgsConstructor
public class ReporteServicesUseCase implements ReporteServicesUseCasePortIn {
	
	
	private final FranquiciaUseCasePortIn franquiciaUseCasePortIn;
	private final SucursalUseCasePortIn  sucursalUseCasePortIn;
	private final ProductoRepositoryPortOut productoRepositoryPortOut;
	
	@Override
	public ProductoReporteStock getReporte(Integer idFranquicia) {
	
		Franquicia  franquicia = this.franquiciaUseCasePortIn.getFranquiciaById(idFranquicia);
		
		ProductoReporteStock productoStock= new ProductoReporteStock(
				GenericMapper.map(franquicia, Franquicia.class),
				new ArrayList<>());
				
		
		List<Sucursal> lista= this.sucursalUseCasePortIn.getSucursalesByIdFranquicia(franquicia.getId());		
		lista.stream().forEach(s->{
			List<Object[]> listProductoMax= this.productoRepositoryPortOut.getProductosMaxStockSucursal(s.getId());
			if(!listProductoMax.isEmpty()) {				
				List<Producto> listProductoDTO =
						listProductoMax.stream()
						.map(o-> new Producto(o[3].toString(),Integer.parseInt(o[4].toString()) )
						).toList();
						
				SucursalProducto sucursalProducto = new SucursalProducto(
						new Sucursal(s.getId(),s.getNombre()),listProductoDTO);				
				productoStock.getSucursales().add(sucursalProducto);
			}
		});
		
		return productoStock;
		
	}

}
