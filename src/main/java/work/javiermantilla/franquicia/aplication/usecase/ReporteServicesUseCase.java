package work.javiermantilla.franquicia.aplication.usecase;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import work.javiermantilla.franquicia.aplication.ports.db.ProductoRepositoryPortOut;
import work.javiermantilla.franquicia.aplication.ports.usecase.FranquiciaUseCasePortIn;
import work.javiermantilla.franquicia.aplication.ports.usecase.ReporteServicesUseCasePortIn;
import work.javiermantilla.franquicia.aplication.ports.usecase.SucursalUseCasePortIn;
import work.javiermantilla.franquicia.common.annotation.UseCase;
import work.javiermantilla.franquicia.common.util.GenericMapper;
import work.javiermantilla.franquicia.domain.model.Franquicia;
import work.javiermantilla.franquicia.domain.model.Sucursal;
import work.javiermantilla.franquicia.infrastructure.rest.dto.franquicia.FranquiciaRequestDTO;
import work.javiermantilla.franquicia.infrastructure.rest.dto.producto.ProductoReporteStock;
import work.javiermantilla.franquicia.infrastructure.rest.dto.producto.ProductoRequestDTO;
import work.javiermantilla.franquicia.infrastructure.rest.dto.producto.ProductoReporteStock.SucursalProducto;
import work.javiermantilla.franquicia.infrastructure.rest.dto.sucursal.SucursalRequestDTO;

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
				GenericMapper.map(franquicia, FranquiciaRequestDTO.class),
				new ArrayList<>());
				
		
		List<Sucursal> lista= this.sucursalUseCasePortIn.getSucursalesByIdFranquicia(franquicia.getId());		
		lista.stream().forEach(s->{
			List<Object[]> listProductoMax= this.productoRepositoryPortOut.getProductosMaxStockSucursal(s.getId());
			if(!listProductoMax.isEmpty()) {				
				List<ProductoRequestDTO> listProductoDTO =
						listProductoMax.stream()
						.map(o-> new ProductoRequestDTO(o[3].toString(),Integer.parseInt(o[4].toString()) )
						).toList();
						
				SucursalProducto sucursalProducto = new SucursalProducto(
						new SucursalRequestDTO(s.getId(),s.getNombre()),listProductoDTO);				
				productoStock.getSucursales().add(sucursalProducto);
			}
		});
		
		return productoStock;
		
	}

}
