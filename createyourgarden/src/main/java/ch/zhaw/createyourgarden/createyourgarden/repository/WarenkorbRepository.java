package ch.zhaw.createyourgarden.createyourgarden.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.createyourgarden.createyourgarden.model.Warenkorb;

public interface WarenkorbRepository extends MongoRepository<Warenkorb,String>{
    
}
