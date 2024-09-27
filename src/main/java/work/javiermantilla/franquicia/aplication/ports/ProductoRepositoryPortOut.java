package work.javiermantilla.franquicia.aplication.ports;

import java.util.List;

import work.javiermantilla.franquicia.domain.model.Producto;

public interface ProductoRepositoryPortOut {
	List<Producto> findAll();
}
