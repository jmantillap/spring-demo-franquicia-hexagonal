package work.javiermantilla.franquicia.infrastructure.adapter.out.persistence.mongo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import work.javiermantilla.franquicia.infrastructure.adapter.out.persistence.mongo.entity.MongoEntity;

@Repository
public interface MongoRepositoryJPA /*extends JPANnosdql */ {
	List<MongoEntity> getAllMongo();
}
