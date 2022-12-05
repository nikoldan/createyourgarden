package ch.zhaw.createyourgarden.createyourgarden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.createyourgarden.createyourgarden.model.Warenkorb;
import ch.zhaw.createyourgarden.createyourgarden.model.WarenkorbDTO;
import ch.zhaw.createyourgarden.createyourgarden.repository.WarenkorbRepository;

@RestController
@RequestMapping("/api/warenkorb")
public class WarenkorbController {

    @Autowired
    WarenkorbRepository warenkorbRepository;

    @PostMapping("")
    public ResponseEntity<Warenkorb> createWarenkorb(
            @RequestBody WarenkorbDTO aDTO) {
        // Warenkorb aDAO = new Warenkorb(aDTO.getKorb(), aDTO.getKundenId(),
        // aDTO.getGesamtPreis(), aDTO.getAnzahlArtikel());
        Warenkorb aDAO = new Warenkorb(aDTO.getKundenId());
        Warenkorb a = warenkorbRepository.save(aDAO);
        return new ResponseEntity<>(a, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Warenkorb>> getAllWarenkorb() {
        List<Warenkorb> allWarenkorb = warenkorbRepository.findAll();
        return new ResponseEntity<>(allWarenkorb, HttpStatus.OK);
    }

}
