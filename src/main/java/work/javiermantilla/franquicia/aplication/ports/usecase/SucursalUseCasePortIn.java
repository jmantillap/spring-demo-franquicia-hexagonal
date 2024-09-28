package work.javiermantilla.franquicia.aplication.ports.usecase;

import java.util.List;

import work.javiermantilla.franquicia.domain.model.Sucursal;
import work.javiermantilla.franquicia.infrastructure.rest.dto.SucursalRequestDTO;
import work.javiermantilla.franquicia.infrastructure.rest.dto.SucursalUpdateRequestDTO;


public interface SucursalUseCasePortIn {
	Sucursal crearSucursal(SucursalRequestDTO sucursalDTO);
	List<Sucursal> getSucursales();
	Sucursal updateSucursal(Integer id,SucursalUpdateRequestDTO dto);
	Sucursal getSucursalById(Integer id);
	List<Sucursal> getSucursalesByIdFranquicia(Integer idFranquicia);
}
