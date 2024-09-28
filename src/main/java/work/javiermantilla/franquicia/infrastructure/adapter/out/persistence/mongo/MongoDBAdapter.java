package work.javiermantilla.franquicia.infrastructure.adapter.out.persistence.mongo;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import work.javiermantilla.franquicia.aplication.ports.out.ProductoRepositoryPortOut;
import work.javiermantilla.franquicia.common.annotation.AdapterComponent;
import work.javiermantilla.franquicia.common.util.GenericMapper;

import work.javiermantilla.franquicia.domain.model.Producto;
import work.javiermantilla.franquicia.infrastructure.adapter.out.persistence.mongo.repository.MongoRepositoryJPA;



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

	@Override
	public Optional<Producto> findById(Integer id) {		
		return Optional.empty();
	}

	@Override
	public Boolean delete(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> getProductosMaxStockSucursal(Integer idSucursal) {
		// TODO Auto-generated method stub
		return null;
	}


}
