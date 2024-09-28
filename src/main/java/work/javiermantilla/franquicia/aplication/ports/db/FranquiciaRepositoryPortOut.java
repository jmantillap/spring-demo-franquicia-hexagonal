package work.javiermantilla.franquicia.aplication.ports.db;

import java.util.List;
import java.util.Optional;


import work.javiermantilla.franquicia.domain.model.Franquicia;


public interface FranquiciaRepositoryPortOut {
	List<Franquicia> findAll();
	Franquicia save(Franquicia franquicia);
	Optional<Franquicia> findById(Integer id);
	Franquicia getNombreRepetido(Integer id,String nombre);
	
}
