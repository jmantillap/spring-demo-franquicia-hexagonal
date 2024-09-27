package work.javiermantilla.franquicia.infrastructure.database.adapter;

import java.util.List;


import org.springframework.context.annotation.Primary;

import lombok.RequiredArgsConstructor;
import work.javiermantilla.franquicia.aplication.ports.ProductoRepositoryPortOut;
import work.javiermantilla.franquicia.common.annotation.AdapterComponent;
import work.javiermantilla.franquicia.common.util.GenericMapper;
import work.javiermantilla.franquicia.domain.model.Producto;
import work.javiermantilla.franquicia.infrastructure.database.entity.ProductoEntity;
import work.javiermantilla.franquicia.infrastructure.database.repository.ProductoRepository;

@RequiredArgsConstructor
@AdapterComponent
@Primary
public class ProductoRepositoryAdapter implements ProductoRepositoryPortOut {
	
	private final ProductoRepository productoRepository;
	
	@Override
	public List<Producto> findAll() {		
		List<ProductoEntity> list= this.productoRepository.findAll();		
		return GenericMapper.mapList(list,Producto.class);
	}

}
