package work.javiermantilla.franquicia.aplication.usecase;

import java.util.List;

import lombok.RequiredArgsConstructor;
import work.javiermantilla.franquicia.aplication.ports.ProductoRepositoryPortOut;
import work.javiermantilla.franquicia.aplication.ports.ProductoUseCasePortIn;
import work.javiermantilla.franquicia.common.annotation.UseCase;
import work.javiermantilla.franquicia.domain.model.Producto;
import work.javiermantilla.franquicia.infrastructure.rest.dto.ProductoRequestDTO;
import work.javiermantilla.franquicia.infrastructure.rest.dto.ProductoStockRequestDTO;
import work.javiermantilla.franquicia.infrastructure.rest.dto.ProductoUpdateRequestDTO;

@RequiredArgsConstructor
@UseCase
public class ProductoServicesUseCase implements ProductoUseCasePortIn {

	private final ProductoRepositoryPortOut productoRepositoryPortOut;
	
	@Override
	public Producto crearProducto(ProductoRequestDTO productoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getProductos() {		
		return this.productoRepositoryPortOut.findAll();
	}

	@Override
	public ProductoRequestDTO updateProducto(Integer id, ProductoUpdateRequestDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoRequestDTO updateStock(Integer id, ProductoStockRequestDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
