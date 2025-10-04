package work.javiermantilla.franquicia.domain.ports.in;

import work.javiermantilla.franquicia.domain.model.ProductoReporteStock;

public interface ReporteServicesUseCasePortIn {
	ProductoReporteStock getReporte(Integer idFranquicia);
}
