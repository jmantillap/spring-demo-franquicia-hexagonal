package work.javiermantilla.franquicia.aplication.ports.usecase;

import java.util.List;

import work.javiermantilla.franquicia.domain.model.Franquicia;
import work.javiermantilla.franquicia.infrastructure.rest.dto.franquicia.FranquiciaRequestDTO;
import work.javiermantilla.franquicia.infrastructure.rest.dto.franquicia.FranquiciaUpdateRequestDTO;

public interface FranquiciaUseCasePortIn {
	Franquicia crearFranquicia(FranquiciaRequestDTO franquiciaDTO);
	List<Franquicia> getFranquicias();
	Franquicia updateFranquicia(Integer id,FranquiciaUpdateRequestDTO dto);
	Franquicia getFranquiciaById(Integer id);
}
