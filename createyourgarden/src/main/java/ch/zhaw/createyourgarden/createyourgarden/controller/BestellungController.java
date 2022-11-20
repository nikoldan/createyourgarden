package ch.zhaw.createyourgarden.createyourgarden.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.createyourgarden.createyourgarden.model.Bestellung;
import ch.zhaw.createyourgarden.createyourgarden.repository.BestellungRepository;

@RestController
@RequestMapping("/api/bestellung")
public class BestellungController {
    
    @Autowired
    BestellungRepository bestellungRepository;

    @PostMapping("")
    public ResponseEntity<Bestellung> createBestellung(
        @RequestBody BestellungCreateDTO jDTO) {
            Bestellung jDAO = new Bestellung(jDTO.getDatum(), jDTO.getArtikels(), jDTO.getBestellungState());
            Bestellung j = bestellungRepository.save(jDAO);
            return new ResponseEntity<>(j, HttpStatus.CREATED);
        }


}
