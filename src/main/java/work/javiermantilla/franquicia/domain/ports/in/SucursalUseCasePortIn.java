package work.javiermantilla.franquicia.domain.ports.in;

import java.util.List;

import work.javiermantilla.franquicia.domain.model.Sucursal;

public interface SucursalUseCasePortIn {
	Sucursal crearSucursal(Sucursal sucursalDTO);
	List<Sucursal> getSucursales();
	Sucursal updateSucursal(Integer id,Sucursal dto);
	Sucursal getSucursalById(Integer id);
	List<Sucursal> getSucursalesByIdFranquicia(Integer idFranquicia);
}
