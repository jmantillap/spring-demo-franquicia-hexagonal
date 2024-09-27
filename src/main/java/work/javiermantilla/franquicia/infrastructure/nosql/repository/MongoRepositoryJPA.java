package work.javiermantilla.franquicia.infrastructure.nosql.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import work.javiermantilla.franquicia.infrastructure.nosql.entity.MongoEntity;

@Repository
public interface MongoRepositoryJPA /*extends JPANnosdql */ {
	List<MongoEntity> getAllMongo();
}
