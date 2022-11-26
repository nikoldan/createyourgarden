package ch.zhaw.createyourgarden.createyourgarden.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.createyourgarden.createyourgarden.model.Artikel;

public interface ArtikelRepository extends 
MongoRepository<Artikel,String> {
    
}
