package ch.zhaw.createyourgarden.createyourgarden.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.createyourgarden.createyourgarden.model.Kunde;
import ch.zhaw.createyourgarden.createyourgarden.model.KundeCreateDTO;
import ch.zhaw.createyourgarden.createyourgarden.repository.KundeRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class kundeController {

    @Autowired
    KundeRepository kundeRepository;

    @PostMapping("/kunde")
    public ResponseEntity<Kunde> createKunde(@RequestBody KundeCreateDTO xDTO) {
        Kunde xDAO = new Kunde(xDTO.getName(), xDTO.getEmail());
        Kunde x = kundeRepository.save(xDAO);
        return new ResponseEntity<>(x, HttpStatus.CREATED);
    }
    

}
