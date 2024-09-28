package work.javiermantilla.franquicia.aplication.usecase;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import work.javiermantilla.franquicia.aplication.ports.db.SucursalRepositoryPortOut;
import work.javiermantilla.franquicia.aplication.ports.usecase.FranquiciaUseCasePortIn;
import work.javiermantilla.franquicia.aplication.ports.usecase.SucursalUseCasePortIn;
import work.javiermantilla.franquicia.common.annotation.UseCase;
import work.javiermantilla.franquicia.common.util.GenericMapper;
import work.javiermantilla.franquicia.domain.model.Franquicia;
import work.javiermantilla.franquicia.domain.model.Sucursal;
import work.javiermantilla.franquicia.infrastructure.rest.dto.SucursalRequestDTO;
import work.javiermantilla.franquicia.infrastructure.rest.dto.SucursalUpdateRequestDTO;

@UseCase
@RequiredArgsConstructor
@Log4j2
public class SucursalServicesUsesCase implements SucursalUseCasePortIn {

	private final SucursalRepositoryPortOut sucursalRepositoryPortOut;
	private final FranquiciaUseCasePortIn franquiciaUseCasePortIn;
	
	@Override
	public Sucursal crearSucursal(SucursalRequestDTO sucursalDTO) {
	
		Franquicia franquicia = this.franquiciaUseCasePortIn
				.getFranquiciaById(sucursalDTO.getIdFranquicia());
		
		Sucursal sucursal= GenericMapper.map(sucursalDTO,Sucursal.class);
		sucursal.setFranquicia(franquicia);
		sucursal = this.sucursalRepositoryPortOut.save(sucursal);
		sucursal.setFranquicia(franquicia);
		return sucursal;
	}

	@Override
	public List<Sucursal> getSucursales() {
		
		return null;
	}

	@Override
	public Sucursal updateSucursal(Integer id, SucursalUpdateRequestDTO dto) {
		
		return null;
	}

	@Override
	public Sucursal getSucursalById(Integer id) {
		return this.sucursalRepositoryPortOut.getSucursalById(id);
	}

	@Override
	public List<Sucursal> getSucursalesByIdFranquicia(Integer idFranquicia) {
		
		return null;
	}

}
