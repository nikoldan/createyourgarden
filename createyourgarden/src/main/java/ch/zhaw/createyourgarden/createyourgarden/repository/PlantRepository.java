package ch.zhaw.createyourgarden.createyourgarden.repository;
import ch.zhaw.createyourgarden.createyourgarden.model.Plant;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface PlantRepository extends 
MongoRepository<Plant, String> {
    
}
