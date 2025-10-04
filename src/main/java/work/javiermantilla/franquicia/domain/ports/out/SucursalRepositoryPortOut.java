package work.javiermantilla.franquicia.domain.ports.out;


import java.util.List;
import java.util.Optional;



import work.javiermantilla.franquicia.domain.model.Sucursal;

public interface SucursalRepositoryPortOut {
	Sucursal getSucursalById(Integer id);
	Sucursal save(Sucursal sucursal);
	List<Sucursal> getSucursales();
	Optional<Sucursal> findById(Integer id);	
	List<Sucursal> findByIdFranquicia(int id);
}