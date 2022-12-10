package ch.zhaw.createyourgarden.createyourgarden.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import ch.zhaw.createyourgarden.createyourgarden.model.BestellStateAggregationDTO;
import ch.zhaw.createyourgarden.createyourgarden.model.Bestellung;

public interface BestellungRepository extends
        MongoRepository<Bestellung, String> {

    // Aggregierte Daten für den Status:
    @Aggregation("{$group: {_id: '$bestellungState',bestellIds: {$push: '$_id'},count: {$count: {}}}}")
    List<BestellStateAggregationDTO> getBestellStateAggregation();

}
