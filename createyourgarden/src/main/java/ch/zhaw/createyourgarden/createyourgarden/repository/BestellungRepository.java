package ch.zhaw.createyourgarden.createyourgarden.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.createyourgarden.createyourgarden.model.Bestellung;

public interface BestellungRepository extends 
MongoRepository<Bestellung, String> {
    
}
