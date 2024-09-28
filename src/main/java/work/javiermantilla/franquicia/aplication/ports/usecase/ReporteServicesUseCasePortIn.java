package work.javiermantilla.franquicia.aplication.ports.usecase;

import work.javiermantilla.franquicia.infrastructure.rest.dto.ProductoReporteStock;

public interface ReporteServicesUseCasePortIn {
	ProductoReporteStock getReporte(Integer idFranquicia);
}
