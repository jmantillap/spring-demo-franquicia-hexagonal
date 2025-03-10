package work.javiermantilla.franquicia.aplication.ports.in;

import java.util.List;

import work.javiermantilla.franquicia.domain.model.Producto;
import work.javiermantilla.franquicia.infrastructure.adapter.in.rest.dto.producto.ProductoRequestDTO;
import work.javiermantilla.franquicia.infrastructure.adapter.in.rest.dto.producto.ProductoStockRequestDTO;
import work.javiermantilla.franquicia.infrastructure.adapter.in.rest.dto.producto.ProductoUpdateRequestDTO;


public interface ProductoUseCasePortIn {
	Producto crearProducto(ProductoRequestDTO productoDTO);
	List<Producto> getProductos();
	Producto updateProducto(Integer id,ProductoUpdateRequestDTO dto);
	Boolean eliminarProducto(Integer id);
	Producto updateStock(Integer id,ProductoStockRequestDTO dto);	
}
