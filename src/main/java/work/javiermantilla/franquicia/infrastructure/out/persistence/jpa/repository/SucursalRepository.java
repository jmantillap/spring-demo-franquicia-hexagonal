package work.javiermantilla.franquicia.infrastructure.out.persistence.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import work.javiermantilla.franquicia.infrastructure.out.persistence.jpa.entity.SucursalEntity;


@Repository
public interface SucursalRepository extends JpaRepository<SucursalEntity, Integer> {
	
	@Query("SELECT s FROM SucursalEntity s inner join fetch s.franquicia f where f.id = :id")
	List<SucursalEntity> findByIdFranquicia(@Param("id") int id);
}
