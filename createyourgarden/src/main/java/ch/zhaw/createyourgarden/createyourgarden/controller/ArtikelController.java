package ch.zhaw.createyourgarden.createyourgarden.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.createyourgarden.createyourgarden.model.Artikel;
import ch.zhaw.createyourgarden.createyourgarden.repository.ArtikelRepository;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/artikel")
public class ArtikelController {
    
    @Autowired
    ArtikelRepository artikelRepository;

    @GetMapping("")
    public ResponseEntity<List<Artikel>> getAllArtikel() {
        List<Artikel> allArtikel = artikelRepository.findAll();
        return new ResponseEntity<>(allArtikel, HttpStatus.OK);
    }
    
    




}
