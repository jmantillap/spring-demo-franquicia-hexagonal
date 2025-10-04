package work.javiermantilla.franquicia.domain.ports.in;

import java.util.List;

import work.javiermantilla.franquicia.domain.model.Franquicia;

public interface FranquiciaUseCasePortIn {
	Franquicia crearFranquicia(Franquicia franquicia);
	List<Franquicia> getFranquicias();
	Franquicia updateFranquicia(Integer id,Franquicia dto);
	Franquicia getFranquiciaById(Integer id);
}
