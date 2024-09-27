package work.javiermantilla.franquicia.infrastructure.nosql.adapter;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import work.javiermantilla.franquicia.aplication.ports.FranquiciaRepositoryPortOut;
import work.javiermantilla.franquicia.common.util.GenericMapper;
import work.javiermantilla.franquicia.domain.model.Franquicia;
import work.javiermantilla.franquicia.infrastructure.nosql.repository.MongoRepositoryJPA;


@RequiredArgsConstructor
public class MongoDBAdapter implements FranquiciaRepositoryPortOut {
	
	private final MongoRepositoryJPA mongo;

	@Override
	public List<Franquicia> findAll() {				
		return GenericMapper.mapList(mongo.getAllMongo(), Franquicia.class);
	}

	@Override
	public Franquicia save(Franquicia franquicia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Franquicia> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Franquicia getNombreRepetido(Integer id, String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
