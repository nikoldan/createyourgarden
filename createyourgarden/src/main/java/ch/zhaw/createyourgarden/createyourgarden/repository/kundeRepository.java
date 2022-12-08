package ch.zhaw.createyourgarden.createyourgarden.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import ch.zhaw.createyourgarden.createyourgarden.model.Kunde;

public interface KundeRepository extends MongoRepository<Kunde, String>{
    List<Kunde> findByEmail(String email);
    
}
