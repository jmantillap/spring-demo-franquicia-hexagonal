package work.javiermantilla.franquicia.aplication.ports.db;

import java.util.List;
import java.util.Optional;

import work.javiermantilla.franquicia.domain.model.Producto;

public interface ProductoRepositoryPortOut {
	List<Producto> findAll();
	Producto save(Producto producto);	
	Optional<Producto> findById(Integer id);
	Boolean delete(Producto producto);
}
