package work.javiermantilla.franquicia.infrastructure.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import work.javiermantilla.franquicia.aplication.ports.usecase.SucursalUseCasePortIn;
import work.javiermantilla.franquicia.common.util.FranquiciaConstants;
import work.javiermantilla.franquicia.infrastructure.rest.dto.GenericResponseDTO;
import work.javiermantilla.franquicia.infrastructure.rest.dto.sucursal.SucursalRequestDTO;
import work.javiermantilla.franquicia.infrastructure.rest.dto.sucursal.SucursalUpdateRequestDTO;

@RestController
@RequestMapping("/api/v1/sucursal")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@Log4j2
public class SucursalControllerAdapter {

	private final SucursalUseCasePortIn sucursalUseCasePortIn;
	private GenericResponseDTO genericResponse;
	
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> crearSucursal(@Valid @RequestBody SucursalRequestDTO sucursalDTO) {

		log.info("Inicio la sucursal a crear : {}", sucursalDTO);
		genericResponse = new GenericResponseDTO(
				this.sucursalUseCasePortIn.crearSucursal(sucursalDTO),
				true,
				FranquiciaConstants.RESPONSE_CREATED, 
				HttpStatus.OK,
				FranquiciaConstants.TITTLE_CREATED);
		return new ResponseEntity<>(genericResponse, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "")
	public ResponseEntity<Object> getSucursales() {

		log.info("Consulta de lista de sucursales ");
		genericResponse = new GenericResponseDTO(
				this.sucursalUseCasePortIn.getSucursales(), 
				true,
				FranquiciaConstants.RESPONSE_FIND, 
				HttpStatus.OK, 
				FranquiciaConstants.TITTLE_FIND);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);
	}
	
	@PatchMapping(value="/{id}")
	public ResponseEntity<Object> actualizarNombre(@Valid @PathVariable Integer id
			,@Valid @RequestBody  SucursalUpdateRequestDTO sucursalUpdateDTO) {
		
		log.info("Se actualiza el nombre de la sucursal");
		genericResponse = new GenericResponseDTO(
				this.sucursalUseCasePortIn.updateSucursal(id,sucursalUpdateDTO), 
				true,
				FranquiciaConstants.RESPONSE_UPDATE, 
				HttpStatus.OK, 
				FranquiciaConstants.TITTLE_UPDATE);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);
	}
}
