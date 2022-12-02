package ch.zhaw.createyourgarden.createyourgarden.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.createyourgarden.createyourgarden.model.Bestellung;
import ch.zhaw.createyourgarden.createyourgarden.model.bestellungBestaetigenDTO;
import ch.zhaw.createyourgarden.createyourgarden.service.BestellungService;

@RestController
@RequestMapping("/api/service")
public class ServiceController {
    @Autowired
    BestellungService bestellungService;

    @PostMapping("/bBestaetigung")
    public ResponseEntity<Bestellung> bestellungBestaetigen(@RequestBody bestellungBestaetigenDTO bestellDTO) {
        Optional<Bestellung> bestaetigeBestaetigung = bestellungService.bestellungBestaetigen(bestellDTO.getBestellungId());
        if (bestaetigeBestaetigung.isPresent())
            return new ResponseEntity<Bestellung>(bestaetigeBestaetigung.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
