package work.javiermantilla.franquicia.infrastructure.database.adapter;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

import work.javiermantilla.franquicia.aplication.ports.FranquiciaRepositoryPortOut;
import work.javiermantilla.franquicia.common.annotation.AdapterComponent;
import work.javiermantilla.franquicia.common.util.GenericMapper;
import work.javiermantilla.franquicia.domain.model.Franquicia;
import work.javiermantilla.franquicia.infrastructure.database.entity.FranquiciaEntity;
import work.javiermantilla.franquicia.infrastructure.database.repository.FranquiciaRepository;


@AdapterComponent("jpa")
@RequiredArgsConstructor
public class FranquiciaRepositoryAdapter implements FranquiciaRepositoryPortOut{

	private final FranquiciaRepository franquiciaRepository;
	
	@Override
	public List<Franquicia> findAll() {		
		List<FranquiciaEntity> list= this.franquiciaRepository.findAll();		
		return GenericMapper.mapList(list, Franquicia.class);
	}

	@Override
	public Franquicia save(Franquicia franquicia) {
		FranquiciaEntity franquiciaEntity= this.franquiciaRepository
				.save(GenericMapper.map(franquicia,FranquiciaEntity.class));
		return GenericMapper.map(franquiciaEntity, Franquicia.class);
	}

	@Override
	public Optional<Franquicia> findById(Integer id) {		
		Optional<FranquiciaEntity> oFranquicia = this.franquiciaRepository.findById(id);		
		return oFranquicia.isEmpty() ? 
				Optional.empty() : 
					Optional.of(GenericMapper.map(oFranquicia.get(), Franquicia.class)) ;
	}

	@Override
	public Franquicia getNombreRepetido(Integer id, String nombre) {
		FranquiciaEntity franquiciaEntity = this.franquiciaRepository.getNombreRepetido(id, nombre);
		return franquiciaEntity!=null ? GenericMapper.map(franquiciaEntity, Franquicia.class) : null ;
	}

	
}
