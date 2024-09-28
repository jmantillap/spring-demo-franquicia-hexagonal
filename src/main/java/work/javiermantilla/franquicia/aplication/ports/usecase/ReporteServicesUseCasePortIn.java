package work.javiermantilla.franquicia.aplication.ports.usecase;

import work.javiermantilla.franquicia.infrastructure.rest.dto.producto.ProductoReporteStock;

public interface ReporteServicesUseCasePortIn {
	ProductoReporteStock getReporte(Integer idFranquicia);
}
