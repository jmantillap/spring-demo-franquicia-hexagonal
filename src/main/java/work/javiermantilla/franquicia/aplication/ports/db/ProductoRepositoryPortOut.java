package work.javiermantilla.franquicia.aplication.ports.db;

import java.util.List;

import work.javiermantilla.franquicia.domain.model.Producto;

public interface ProductoRepositoryPortOut {
	List<Producto> findAll();
	Producto save(Producto producto);
}
