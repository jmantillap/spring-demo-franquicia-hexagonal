package work.javiermantilla.franquicia.domain.ports.in;

import java.util.List;

import work.javiermantilla.franquicia.domain.model.Producto;


public interface ProductoUseCasePortIn {
	Producto crearProducto(Producto productoDTO);
	List<Producto> getProductos();
	Producto updateProducto(Integer id,Producto dto);
	Boolean eliminarProducto(Integer id);
	Producto updateStock(Integer id,Integer stock);	
}
