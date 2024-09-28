package work.javiermantilla.franquicia.aplication.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import work.javiermantilla.franquicia.aplication.ports.in.FranquiciaUseCasePortIn;
import work.javiermantilla.franquicia.aplication.ports.in.SucursalUseCasePortIn;
import work.javiermantilla.franquicia.aplication.ports.out.SucursalRepositoryPortOut;
import work.javiermantilla.franquicia.common.annotation.UseCase;
import work.javiermantilla.franquicia.common.util.GenericMapper;
import work.javiermantilla.franquicia.domain.model.Franquicia;
import work.javiermantilla.franquicia.domain.model.Sucursal;
import work.javiermantilla.franquicia.infrastructure.adapter.in.rest.dto.sucursal.SucursalRequestDTO;
import work.javiermantilla.franquicia.infrastructure.adapter.in.rest.dto.sucursal.SucursalUpdateRequestDTO;

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
		return sucursalRepositoryPortOut.getSucursales();
	}

	@Override
	public Sucursal getSucursalById(Integer id) {
		return this.sucursalRepositoryPortOut.getSucursalById(id);
	}
	
	@Override
	public Sucursal updateSucursal(Integer id, SucursalUpdateRequestDTO dto) {
		
		Optional<Sucursal> oSucursal = this.sucursalRepositoryPortOut.findById(id);
		if(!oSucursal.isPresent()) {
			log.error("La sucursal con id: {}, no existe.",id);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"La Sucursal no existe");
		}		
		oSucursal.get().setNombre(dto.getNombre());		
		return this.sucursalRepositoryPortOut.save(oSucursal.get());
	}

	

	@Override
	public List<Sucursal> getSucursalesByIdFranquicia(Integer idFranquicia) {		
	    return this.sucursalRepositoryPortOut.findByIdFranquicia(idFranquicia);
		
	}

}
