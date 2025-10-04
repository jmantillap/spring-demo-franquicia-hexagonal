package work.javiermantilla.franquicia.domain.ports.out;

import java.util.List;
import java.util.Optional;



import work.javiermantilla.franquicia.domain.model.Producto;

public interface ProductoRepositoryPortOut {
	List<Producto> findAll();
	Producto save(Producto producto);	
	Optional<Producto> findById(Integer id);
	Boolean delete(Producto producto);	
	List<Object[]> getProductosMaxStockSucursal(Integer idSucursal);
}
