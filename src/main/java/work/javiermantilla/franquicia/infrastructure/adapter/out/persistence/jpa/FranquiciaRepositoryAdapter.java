package work.javiermantilla.franquicia.infrastructure.adapter.out.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;

import lombok.RequiredArgsConstructor;
import work.javiermantilla.franquicia.aplication.ports.out.FranquiciaRepositoryPortOut;
import work.javiermantilla.franquicia.common.annotation.AdapterComponent;
import work.javiermantilla.franquicia.common.util.GenericMapper;
import work.javiermantilla.franquicia.domain.model.Franquicia;
import work.javiermantilla.franquicia.infrastructure.adapter.out.persistence.jpa.entity.FranquiciaEntity;
import work.javiermantilla.franquicia.infrastructure.adapter.out.persistence.jpa.repository.FranquiciaRepository;


@AdapterComponent
@RequiredArgsConstructor
@Qualifier("jpa")
public class FranquiciaRepositoryAdapter implements FranquiciaRepositoryPortOut{

	private final FranquiciaRepository franquiciaRepository;
	
	@Override
	public List<Franquicia> franchiseFindAll() {		
		List<FranquiciaEntity> list= this.franquiciaRepository.findAll();		
		return GenericMapper.mapList(list, Franquicia.class);
	}

	@Override
	public Franquicia saveFranchise(Franquicia franquicia) {
		FranquiciaEntity franquiciaEntity= this.franquiciaRepository
				.save(GenericMapper.map(franquicia,FranquiciaEntity.class));
		return GenericMapper.map(franquiciaEntity, Franquicia.class);
	}

	@Override
	public Optional<Franquicia> findByIdFranchise(Integer id) {		
		Optional<FranquiciaEntity> oFranquicia = this.franquiciaRepository.findById(id);		
		return oFranquicia.isEmpty() ? 
				Optional.empty() : 
					Optional.of(GenericMapper.map(oFranquicia.get(), Franquicia.class)) ;
	}

	@Override
	public Franquicia getNameRepeated(Integer id, String nombre) {
		FranquiciaEntity franquiciaEntity = this.franquiciaRepository.getNombreRepetido(id, nombre);
		return franquiciaEntity!=null ? GenericMapper.map(franquiciaEntity, Franquicia.class) : null ;
	}

	
}
