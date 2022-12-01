package ch.zhaw.createyourgarden.createyourgarden.repository;
import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;


import ch.zhaw.createyourgarden.createyourgarden.model.Artikel;


public interface ArtikelRepository extends 
MongoRepository<Artikel,String> {
    
    List<Artikel> findByStandort(String standort);


}
