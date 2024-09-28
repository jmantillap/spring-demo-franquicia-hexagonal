package work.javiermantilla.franquicia.aplication.usecase;

import java.util.List;


import lombok.RequiredArgsConstructor;
import work.javiermantilla.franquicia.aplication.ports.db.ProductoRepositoryPortOut;
import work.javiermantilla.franquicia.aplication.ports.db.SucursalRepositoryPortOut;
import work.javiermantilla.franquicia.aplication.ports.usecase.ProductoUseCasePortIn;
import work.javiermantilla.franquicia.common.annotation.UseCase;
import work.javiermantilla.franquicia.common.util.GenericMapper;
import work.javiermantilla.franquicia.domain.model.Producto;
import work.javiermantilla.franquicia.domain.model.Sucursal;
import work.javiermantilla.franquicia.infrastructure.rest.dto.ProductoRequestDTO;
import work.javiermantilla.franquicia.infrastructure.rest.dto.ProductoStockRequestDTO;
import work.javiermantilla.franquicia.infrastructure.rest.dto.ProductoUpdateRequestDTO;

@RequiredArgsConstructor
@UseCase
public class ProductoServicesUseCase implements ProductoUseCasePortIn {
		
	private final ProductoRepositoryPortOut productoRepositoryPortOut;
	private final SucursalRepositoryPortOut sucursalRepositoryPortOut;

	
	@Override
	public Producto crearProducto(ProductoRequestDTO productoDTO) {		
		Sucursal  sucursal = this.sucursalRepositoryPortOut
							.getSucursalById(productoDTO.getIdSucursal());
		
		Producto  producto = GenericMapper.map(productoDTO, Producto.class);		
		producto.setSucursal(sucursal);
		producto = this.productoRepositoryPortOut.save(producto);		
		producto.setSucursal(sucursal);		
		return producto;
	}

	@Override
	public List<Producto> getProductos() {		
		return this.productoRepositoryPortOut.findAll();
	}

	@Override
	public ProductoRequestDTO updateProducto(Integer id, ProductoUpdateRequestDTO dto) {
		
		return null;
	}

	@Override
	public Boolean eliminarProducto(Integer id) {
		
		return true;
	}

	@Override
	public ProductoRequestDTO updateStock(Integer id, ProductoStockRequestDTO dto) {
		
		return null;
	}

}
