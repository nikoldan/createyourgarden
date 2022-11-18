package ch.zhaw.createyourgarden.createyourgarden.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.createyourgarden.createyourgarden.model.Kunde;

public interface kundeRepository extends MongoRepository<Kunde, String>{
    
}
