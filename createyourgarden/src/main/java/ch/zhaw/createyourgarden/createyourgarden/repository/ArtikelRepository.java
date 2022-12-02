package ch.zhaw.createyourgarden.createyourgarden.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.createyourgarden.createyourgarden.model.Artikel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArtikelRepository extends 
MongoRepository<Artikel,String> {
    
    List<Artikel> findByStandort(String standort);

    Page<Artikel> findByStandort(String standort, Pageable pageable);

}
