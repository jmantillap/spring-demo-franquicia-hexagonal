package work.javiermantilla.franquicia.infrastructure.database.adapter;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import work.javiermantilla.franquicia.aplication.ports.db.SucursalRepositoryPortOut;
import work.javiermantilla.franquicia.common.annotation.AdapterComponent;
import work.javiermantilla.franquicia.common.util.GenericMapper;
import work.javiermantilla.franquicia.domain.model.Sucursal;
import work.javiermantilla.franquicia.infrastructure.database.entity.SucursalEntity;
import work.javiermantilla.franquicia.infrastructure.database.repository.SucursalRepository;


@RequiredArgsConstructor
@AdapterComponent
@Log4j2
public class SucursalRepositoryAdapter implements SucursalRepositoryPortOut {
	
	private final SucursalRepository sucursalRepository;
	
	
	@Override
	public Sucursal getSucursalById(Integer id) {		
		Optional<SucursalEntity> oSucursal = this.sucursalRepository.findById(id);
		if(!oSucursal.isPresent()) {
			log.error("La sucursal con id: {}, no existe.",id);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"La Sucursal no existe");
		}
		return GenericMapper.map(oSucursal.get(), Sucursal.class)   ;
		
	}


	@Override
	public Sucursal save(Sucursal sucursal) {		
		SucursalEntity sucursalSave= this.sucursalRepository.save(GenericMapper.map(sucursal,SucursalEntity.class));		
		return GenericMapper.map(sucursalSave, Sucursal.class);
	}

}
