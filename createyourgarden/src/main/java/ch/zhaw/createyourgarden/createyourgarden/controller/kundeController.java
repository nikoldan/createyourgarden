package ch.zhaw.createyourgarden.createyourgarden.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.createyourgarden.createyourgarden.model.Kunde;
import ch.zhaw.createyourgarden.createyourgarden.model.KundeCreateDTO;
import ch.zhaw.createyourgarden.createyourgarden.repository.KundeRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class KundeController {

    @Autowired
    KundeRepository kundeRepository;

    @PostMapping("/api/kunde")
    public ResponseEntity<Kunde> createKunde(@RequestBody KundeCreateDTO xDTO) {
        Kunde xDAO = new Kunde(xDTO.getName(), xDTO.getEmail());
        Kunde x = kundeRepository.save(xDAO);
        return new ResponseEntity<>(x, HttpStatus.CREATED);
    }
    
    @GetMapping("/api/kunde")
    public ResponseEntity<List<Kunde>> getAllKunde() {
        List<Kunde> allKunde = kundeRepository.findAll();
        return new ResponseEntity<>(allKunde, HttpStatus.OK);
    }

    @GetMapping("/api/kunde/{id}")
    public ResponseEntity<Kunde> getKundeById(@PathVariable String id) {
        Optional<Kunde> optKunde = kundeRepository.findById(id);
        if (optKunde.isPresent()) {
            return new ResponseEntity<>(optKunde.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
