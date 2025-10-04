package work.javiermantilla.franquicia.infrastructure.out.persistence.mongo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import work.javiermantilla.franquicia.infrastructure.out.persistence.mongo.document.MongoDocument;

@Repository
public interface MongoRepositoryJPA /*extends JPANnosdql */ {
	List<MongoDocument> getAllMongo();
}
