package work.javiermantilla.franquicia.aplication.ports;

import java.util.List;

import work.javiermantilla.franquicia.domain.model.Franquicia;
import work.javiermantilla.franquicia.infrastructure.rest.dto.FranquiciaRequestDTO;
import work.javiermantilla.franquicia.infrastructure.rest.dto.FranquiciaUpdateRequestDTO;

public interface FranquiciaUseCasePortIn {
	Franquicia crearFranquicia(FranquiciaRequestDTO franquiciaDTO);
	List<Franquicia> getFranquicias();
	Franquicia updateFranquicia(Integer id,FranquiciaUpdateRequestDTO dto);
	Franquicia getFranquiciaById(Integer id);
}
