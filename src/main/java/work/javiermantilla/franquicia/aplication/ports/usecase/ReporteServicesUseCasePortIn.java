package work.javiermantilla.franquicia.aplication.ports.usecase;

import work.javiermantilla.franquicia.domain.report.ProductoReporteStock;

public interface ReporteServicesUseCasePortIn {
	ProductoReporteStock getReporte(Integer idFranquicia);
}
