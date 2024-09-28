package work.javiermantilla.franquicia.aplication.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import work.javiermantilla.franquicia.aplication.ports.in.ProductoUseCasePortIn;
import work.javiermantilla.franquicia.aplication.ports.out.ProductoRepositoryPortOut;
import work.javiermantilla.franquicia.aplication.ports.out.SucursalRepositoryPortOut;
import work.javiermantilla.franquicia.common.annotation.UseCase;
import work.javiermantilla.franquicia.common.util.GenericMapper;
import work.javiermantilla.franquicia.domain.model.Producto;
import work.javiermantilla.franquicia.domain.model.Sucursal;
import work.javiermantilla.franquicia.infrastructure.adapter.in.rest.dto.producto.ProductoRequestDTO;
import work.javiermantilla.franquicia.infrastructure.adapter.in.rest.dto.producto.ProductoStockRequestDTO;
import work.javiermantilla.franquicia.infrastructure.adapter.in.rest.dto.producto.ProductoUpdateRequestDTO;

@RequiredArgsConstructor
@UseCase
@Log4j2
public class ProductoServicesUseCase implements ProductoUseCasePortIn {

	private final ProductoRepositoryPortOut productoRepositoryPortOut;
	private final SucursalRepositoryPortOut sucursalRepositoryPortOut;

	@Override
	public Producto crearProducto(ProductoRequestDTO productoDTO) {
		Sucursal sucursal = this.sucursalRepositoryPortOut.getSucursalById(productoDTO.getIdSucursal());
		Producto producto = GenericMapper.map(productoDTO, Producto.class);
		producto.setSucursal(sucursal);
		producto = this.productoRepositoryPortOut.save(producto);
		producto.setSucursal(sucursal);
		return producto;
	}

	@Override
	public List<Producto> getProductos() {
		return this.productoRepositoryPortOut.findAll();
	}

	@Override
	public Producto updateProducto(Integer id, ProductoUpdateRequestDTO dto) {
		Producto producto= this.getProductoById(id);		
		producto.setNombre(dto.getNombre());			
		return this.productoRepositoryPortOut.save(producto);
	}

	@Override
	public Boolean eliminarProducto(Integer id) {
		Producto producto= this.getProductoById(id);
		this.productoRepositoryPortOut.delete(producto);
		return true;
	}

	@Override
	public Producto updateStock(Integer id, ProductoStockRequestDTO dto) {
		Producto producto= this.getProductoById(id);
		producto.setStock(dto.getStock());
		producto= this.productoRepositoryPortOut.save(producto);
		return producto;
	}
	
	private Producto getProductoById(Integer idProducto){
		Optional<Producto> oProducto = this.productoRepositoryPortOut.findById(idProducto);
		if(!oProducto.isPresent()) {
			log.error("El producto con id: {}, no existe.",idProducto);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"El producto no existe");
		}
		return oProducto.get();
	}

}
