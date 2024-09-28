package work.javiermantilla.franquicia.aplication.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import work.javiermantilla.franquicia.aplication.ports.db.ProductoRepositoryPortOut;
import work.javiermantilla.franquicia.aplication.ports.db.SucursalRepositoryPortOut;
import work.javiermantilla.franquicia.aplication.ports.usecase.ProductoUseCasePortIn;
import work.javiermantilla.franquicia.common.annotation.UseCase;
import work.javiermantilla.franquicia.common.util.GenericMapper;
import work.javiermantilla.franquicia.domain.model.Producto;
import work.javiermantilla.franquicia.domain.model.Sucursal;
import work.javiermantilla.franquicia.infrastructure.rest.dto.ProductoRequestDTO;
import work.javiermantilla.franquicia.infrastructure.rest.dto.ProductoStockRequestDTO;
import work.javiermantilla.franquicia.infrastructure.rest.dto.ProductoUpdateRequestDTO;

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

		return true;
	}

	@Override
	public Producto updateStock(Integer id, ProductoStockRequestDTO dto) {

		return null;
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
