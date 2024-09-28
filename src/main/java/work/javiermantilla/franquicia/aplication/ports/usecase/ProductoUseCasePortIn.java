package work.javiermantilla.franquicia.aplication.ports.usecase;

import java.util.List;

import work.javiermantilla.franquicia.domain.model.Producto;
import work.javiermantilla.franquicia.infrastructure.rest.dto.ProductoRequestDTO;
import work.javiermantilla.franquicia.infrastructure.rest.dto.ProductoStockRequestDTO;
import work.javiermantilla.franquicia.infrastructure.rest.dto.ProductoUpdateRequestDTO;


public interface ProductoUseCasePortIn {
	Producto crearProducto(ProductoRequestDTO productoDTO);
	List<Producto> getProductos();
	ProductoRequestDTO updateProducto(Integer id,ProductoUpdateRequestDTO dto);
	Boolean eliminarProducto(Integer id);
	ProductoRequestDTO updateStock(Integer id,ProductoStockRequestDTO dto);	
}
