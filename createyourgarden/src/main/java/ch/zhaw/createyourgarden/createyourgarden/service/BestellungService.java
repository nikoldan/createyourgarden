package ch.zhaw.createyourgarden.createyourgarden.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zhaw.createyourgarden.createyourgarden.model.Bestellung;
import ch.zhaw.createyourgarden.createyourgarden.model.BestellungState;
import ch.zhaw.createyourgarden.createyourgarden.repository.BestellungRepository;

@Service
public class BestellungService {
    @Autowired
    BestellungRepository bestellungRepository;

    public Optional<Bestellung> bestellungBestaetigen(String bestellungId) {
        if (bestellungRepository.findById(bestellungId).isPresent()) {
            Optional<Bestellung> bestellBestaetigen = bestellungRepository.findById(bestellungId);
            if (bestellBestaetigen.isPresent()) {
                Bestellung bestellung = bestellBestaetigen.get();
                if (bestellung.getBestellungState() == BestellungState.NEU) {
                    bestellung.setBestellungState(BestellungState.BESTAETIGT);
                    bestellungRepository.save(bestellung);
                }

            }
        }
        return Optional.empty();
    }

}
