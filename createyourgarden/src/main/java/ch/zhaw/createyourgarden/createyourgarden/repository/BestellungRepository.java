package ch.zhaw.createyourgarden.createyourgarden.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BestellungRepository extends 
MongoRepository<Bestellung, String> {
    
}
