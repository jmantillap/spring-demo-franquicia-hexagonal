package work.javiermantilla.franquicia.domain.ports.out;

import java.util.List;
import java.util.Optional;


import work.javiermantilla.franquicia.domain.model.Franquicia;


public interface FranquiciaRepositoryPortOut {
	List<Franquicia> franchiseFindAll();
	Franquicia saveFranchise(Franquicia franquicia);
	Optional<Franquicia> findByIdFranchise(Integer id);
	Franquicia getNameRepeated(Integer id,String nombre);
	
}
