package work.javiermantilla.franquicia.infrastructure.nosql.adapter;

import java.util.List;

import lombok.RequiredArgsConstructor;
import work.javiermantilla.franquicia.aplication.ports.db.ProductoRepositoryPortOut;
import work.javiermantilla.franquicia.common.annotation.AdapterComponent;
import work.javiermantilla.franquicia.common.util.GenericMapper;

import work.javiermantilla.franquicia.domain.model.Producto;
import work.javiermantilla.franquicia.infrastructure.nosql.repository.MongoRepositoryJPA;



@RequiredArgsConstructor
@AdapterComponent
public class MongoDBAdapter implements ProductoRepositoryPortOut {
	
	private MongoRepositoryJPA mongo;

	@Override
	public List<Producto> findAll() {				
		return GenericMapper.mapList(mongo.getAllMongo(), Producto.class);
	}

	@Override
	public Producto save(Producto producto) {
		
		return null;
	}


}
