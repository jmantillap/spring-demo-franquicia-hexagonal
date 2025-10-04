package work.javiermantilla.franquicia.infrastructure.in.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import work.javiermantilla.franquicia.domain.model.Franquicia;
import work.javiermantilla.franquicia.infrastructure.in.rest.dto.FranquiciaRequestDTO;
import work.javiermantilla.franquicia.infrastructure.in.rest.dto.FranquiciaUpdateRequestDTO;

@Mapper(componentModel = "spring", 
unmappedTargetPolicy = ReportingPolicy.IGNORE, 
unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface FranquiciaDtoMapper {

	Franquicia toFranquicia(FranquiciaRequestDTO franquiciaDTO);
	
	Franquicia toFranquiciaUpdate(FranquiciaUpdateRequestDTO franquiciaDTO);
		
	FranquiciaRequestDTO toFranquiciaRequestDto(Franquicia franquicia);
	
}
