package work.javiermantilla.franquicia.infrastructure.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import work.javiermantilla.franquicia.infrastructure.database.entity.FranquiciaEntity;

@Repository
public interface FranquiciaRepository extends JpaRepository<FranquiciaEntity, Integer> {

	 @Query("SELECT f FROM FranquiciaEntity f WHERE f.id <> :id AND f.nombre  = :nombre")
	 FranquiciaEntity getNombreRepetido(@Param("id") Integer id,@Param("nombre") String nombre);
}
