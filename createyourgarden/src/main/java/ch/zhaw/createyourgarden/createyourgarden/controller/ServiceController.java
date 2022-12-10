package ch.zhaw.createyourgarden.createyourgarden.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonCreator;

import ch.zhaw.createyourgarden.createyourgarden.model.Bestellung;
import ch.zhaw.createyourgarden.createyourgarden.model.BestellungBereitDTO;
import ch.zhaw.createyourgarden.createyourgarden.model.bestellungBestaetigenDTO;
import ch.zhaw.createyourgarden.createyourgarden.service.BestellungService;

@RestController
@RequestMapping("/api/service")
public class ServiceController {
    @Autowired
    BestellungService bestellungService;

   // @JsonCreator
    @PostMapping("/bBestaetigung")
    public ResponseEntity<Bestellung> bestellungBestaetigen(@RequestBody bestellungBestaetigenDTO bestellDTO) {
        Optional<Bestellung> bestaetigeBestaetigung = bestellungService.bestellungBestaetigen(bestellDTO.getBestellungId());
        if (bestaetigeBestaetigung.isPresent())
            return new ResponseEntity<Bestellung>(bestaetigeBestaetigung.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/bBereitgestellt")
    public ResponseEntity<Bestellung> bestellungBereit(@RequestBody BestellungBereitDTO bereitDTO) {
        Optional<Bestellung> bdraussen = bestellungService.bestellungBereit(bereitDTO.getBestellungId());
        if (bdraussen.isPresent())
            return new ResponseEntity<Bestellung>(bdraussen.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
