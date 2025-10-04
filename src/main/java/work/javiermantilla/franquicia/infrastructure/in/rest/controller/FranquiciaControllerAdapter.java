package work.javiermantilla.franquicia.infrastructure.in.rest.controller;

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
import work.javiermantilla.franquicia.aplication.util.FranquiciaConstants;
import work.javiermantilla.franquicia.domain.model.Franquicia;
import work.javiermantilla.franquicia.domain.ports.in.FranquiciaUseCasePortIn;
import work.javiermantilla.franquicia.infrastructure.in.rest.dto.FranquiciaRequestDTO;
import work.javiermantilla.franquicia.infrastructure.in.rest.dto.FranquiciaUpdateRequestDTO;
import work.javiermantilla.franquicia.infrastructure.in.rest.dto.GenericResponseDTO;
import work.javiermantilla.franquicia.infrastructure.in.rest.mapper.FranquiciaDtoMapper;

@RestController
@RequestMapping("/api/v1/franquicia")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@Log4j2
public class FranquiciaControllerAdapter {

	private final FranquiciaUseCasePortIn franquiciaUseCasePortIn;
	private GenericResponseDTO genericResponse;
	private final FranquiciaDtoMapper franquiciaDtoMapper;

	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> crearFranquicia(@Valid @RequestBody FranquiciaRequestDTO franquiciaDTO) {

		log.info("Inicio la franquicia a crear : {}", franquiciaDTO);
		Franquicia franquicia= franquiciaDtoMapper.toFranquicia(franquiciaDTO);
		genericResponse = new GenericResponseDTO(
				this.franquiciaUseCasePortIn.crearFranquicia(franquicia), 
				true,
				FranquiciaConstants.RESPONSE_CREATED, 
				HttpStatus.OK, 
				FranquiciaConstants.TITTLE_CREATED);
		return new ResponseEntity<>(genericResponse, HttpStatus.CREATED);
	}

	@GetMapping(value = "")
	public ResponseEntity<Object> listaFranquicia() {

		log.info("Consulta de lista de franquicias ");
		genericResponse = new GenericResponseDTO(
				this.franquiciaUseCasePortIn.getFranquicias(), 
				true,
				FranquiciaConstants.RESPONSE_FIND, 
				HttpStatus.OK, 
				FranquiciaConstants.TITTLE_FIND);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);
	}

	@PatchMapping(value="/{id}")
	public ResponseEntity<Object> actualizarNombre(@Valid @PathVariable Integer id
			,@Valid @RequestBody  FranquiciaUpdateRequestDTO franquiciaUpdateDTO) {
		
		log.info("Se actualiza el nombre de la franquicia");
		Franquicia franquicia= franquiciaDtoMapper.toFranquiciaUpdate(franquiciaUpdateDTO);
		
		genericResponse = new GenericResponseDTO(
				this.franquiciaUseCasePortIn.updateFranquicia(id,franquicia), 
				true,
				FranquiciaConstants.RESPONSE_UPDATE, 
				HttpStatus.OK, 
				FranquiciaConstants.TITTLE_UPDATE);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);
	}

}
