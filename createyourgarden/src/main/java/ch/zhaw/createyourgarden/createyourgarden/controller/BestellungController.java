package ch.zhaw.createyourgarden.createyourgarden.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.createyourgarden.createyourgarden.model.Bestellung;
import ch.zhaw.createyourgarden.createyourgarden.model.BestellungCreateDTO;
import ch.zhaw.createyourgarden.createyourgarden.repository.BestellungRepository;

@RestController
@RequestMapping("/api/bestellung")
public class BestellungController {
    
    @Autowired
    BestellungRepository bestellungRepository;

   @PostMapping("")
    public ResponseEntity<Bestellung> createBestellung(
        @RequestBody BestellungCreateDTO jDTO) {
            Bestellung jDAO = new Bestellung(jDTO.getDatum(), jDTO.getArtikels(), jDTO.getKundenId());
            Bestellung j = bestellungRepository.save(jDAO);
            return new ResponseEntity<>(j, HttpStatus.CREATED);
        }

    @GetMapping("/{id")
    public ResponseEntity<Bestellung> getBestellungById(@PathVariable String id) {
        Optional<Bestellung> optBestellung = bestellungRepository.findById(id);
        if (optBestellung.isPresent()) {
            return new ResponseEntity<>(optBestellung.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
