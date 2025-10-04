package work.javiermantilla.franquicia.domain.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import work.javiermantilla.franquicia.aplication.annotation.UseCase;
import work.javiermantilla.franquicia.domain.model.Producto;
import work.javiermantilla.franquicia.domain.model.Sucursal;
import work.javiermantilla.franquicia.domain.ports.in.ProductoUseCasePortIn;
import work.javiermantilla.franquicia.domain.ports.out.ProductoRepositoryPortOut;
import work.javiermantilla.franquicia.domain.ports.out.SucursalRepositoryPortOut;

@RequiredArgsConstructor
@UseCase
@Log4j2
public class ProductoServicesUseCase implements ProductoUseCasePortIn {

	private final ProductoRepositoryPortOut productoRepositoryPortOut;
	private final SucursalRepositoryPortOut sucursalRepositoryPortOut;

	@Override
	public Producto crearProducto(Producto producto) {
		Sucursal sucursal = this.sucursalRepositoryPortOut.getSucursalById(producto.getSucursal().getId());		
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
	public Producto updateProducto(Integer id, Producto dto) {
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
	public Producto updateStock(Integer id, Integer stock) {
		Producto producto= this.getProductoById(id);
		producto.setStock(stock);
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
