package work.javiermantilla.franquicia.aplication.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import work.javiermantilla.franquicia.aplication.ports.in.FranquiciaUseCasePortIn;
import work.javiermantilla.franquicia.aplication.ports.out.FranquiciaRepositoryPortOut;
import work.javiermantilla.franquicia.common.annotation.UseCase;
import work.javiermantilla.franquicia.common.util.GenericMapper;
import work.javiermantilla.franquicia.domain.model.Franquicia;
import work.javiermantilla.franquicia.infrastructure.adapter.in.rest.dto.franquicia.FranquiciaRequestDTO;
import work.javiermantilla.franquicia.infrastructure.adapter.in.rest.dto.franquicia.FranquiciaUpdateRequestDTO;


@Log4j2
@RequiredArgsConstructor
@UseCase
public class FranquiciaServicesUsesCase implements FranquiciaUseCasePortIn {
	
	@Qualifier("jpa")
	private final FranquiciaRepositoryPortOut franquiciaRepositoryPortOut;

	@Override
	public Franquicia crearFranquicia(FranquiciaRequestDTO franquiciaDTO) {
		franquiciaDTO.setId(null);
		franquiciaDTO.setEstado(true);		
		Franquicia franquicia= GenericMapper.map(franquiciaDTO, Franquicia.class);		
		return this.franquiciaRepositoryPortOut.saveFranchise(franquicia);
	}

	@Override
	public List<Franquicia> getFranquicias() {		
		return this.franquiciaRepositoryPortOut.franchiseFindAll();
	}

	@Override
	public Franquicia updateFranquicia(Integer id, FranquiciaUpdateRequestDTO dto) {
		Optional<Franquicia> oFranquicia = this.franquiciaRepositoryPortOut.findByIdFranchise(id);
		if(!oFranquicia.isPresent()) {
			log.error("La franquicia con id: {}, no existe.",id);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"La Franquicia no existe");
		}
		if(this.franquiciaRepositoryPortOut.getNameRepeated(id, dto.getNombre())!=null) {
			log.error("El nombre: {} ,ya  existe.",dto.getNombre());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"El nombre de la franquicia ya existe");
		}
		oFranquicia.get().setNombre(dto.getNombre());
		Franquicia franquicia= this.franquiciaRepositoryPortOut.saveFranchise(oFranquicia.get());
		log.info("Se actualizo la franquicia");
		return franquicia;
	}

	@Override
	public Franquicia getFranquiciaById(Integer id) {
		Optional<Franquicia> oFranquicia = this.franquiciaRepositoryPortOut.findByIdFranchise(id);
		if(!oFranquicia.isPresent()) {
			log.error("La franquicia con id: {}, no existe.",id);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"La Franquicia no existe");
		}
		return oFranquicia.get();
	}

}
