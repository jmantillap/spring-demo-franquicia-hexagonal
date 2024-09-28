package work.javiermantilla.franquicia.aplication.ports.db;


import work.javiermantilla.franquicia.domain.model.Sucursal;

public interface SucursalRepositoryPortOut {
	Sucursal getSucursalById(Integer id);
	Sucursal save(Sucursal sucursal);
}
