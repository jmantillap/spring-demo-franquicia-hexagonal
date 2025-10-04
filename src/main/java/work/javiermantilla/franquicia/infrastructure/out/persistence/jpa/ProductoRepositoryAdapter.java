package work.javiermantilla.franquicia.infrastructure.out.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;

import lombok.RequiredArgsConstructor;
import work.javiermantilla.franquicia.aplication.annotation.AdapterComponent;
import work.javiermantilla.franquicia.aplication.util.GenericMapper;
import work.javiermantilla.franquicia.domain.model.Producto;
import work.javiermantilla.franquicia.domain.ports.out.ProductoRepositoryPortOut;
import work.javiermantilla.franquicia.infrastructure.out.persistence.jpa.entity.ProductoEntity;
import work.javiermantilla.franquicia.infrastructure.out.persistence.jpa.repository.ProductoRepository;

@RequiredArgsConstructor
@AdapterComponent
@Primary
public class ProductoRepositoryAdapter implements ProductoRepositoryPortOut {

	private final ProductoRepository productoRepository;

	@Override
	public List<Producto> findAll() {
		List<ProductoEntity> list = this.productoRepository.findAll();
		return GenericMapper.mapList(list, Producto.class);
	}

	@Override
	public Producto save(Producto producto) {

		ProductoEntity productoSave = this.productoRepository
				.save(GenericMapper.map(producto, ProductoEntity.class));
		return GenericMapper.map(productoSave, Producto.class);
	}

	@Override
	public Optional<Producto> findById(Integer id) {		
		Optional<ProductoEntity> oProducto = this.productoRepository.findById(id);				
		return oProducto.isEmpty() ? Optional.empty()
				: Optional.of(GenericMapper.map(oProducto.get(), Producto.class));
	}

	@Override
	public Boolean delete(Producto producto) {
		this.productoRepository.delete(GenericMapper.map(producto,ProductoEntity.class));
		return true;
	}

	@Override
	public List<Object[]> getProductosMaxStockSucursal(Integer idSucursal) {
		return this.productoRepository.getProductosMaxStockSucursal(idSucursal);
	}

}
