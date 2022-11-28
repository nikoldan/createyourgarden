package ch.zhaw.createyourgarden.createyourgarden.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.createyourgarden.createyourgarden.model.Artikel;
import ch.zhaw.createyourgarden.createyourgarden.repository.ArtikelRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


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
    
    @GetMapping("/{id}")
    public ResponseEntity<Artikel> getArtikelById(@PathVariable String id) {
        Optional<Artikel> optArtikel = artikelRepository.findById(id);
        if (optArtikel.isPresent()) {
            return new ResponseEntity<>(optArtikel.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
