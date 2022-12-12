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
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/api/artikel")
public class ArtikelController {
    
    @Autowired
    ArtikelRepository artikelRepository;

    @GetMapping("")
    public ResponseEntity<Page<Artikel>> getAllArtikel( 
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) Integer pageSize,
        @RequestParam(required = false) String wo) {
    if (page == null) {
        page = 1;
    }
    if (pageSize == null) {
        pageSize = 10;
    }
    Page<Artikel> allArtikels;
    if (wo != null){
        allArtikels = artikelRepository.findByStandort(wo, PageRequest.of(page - 1, pageSize));
        return new ResponseEntity<>(allArtikels, HttpStatus.OK);
    } else {
        allArtikels = artikelRepository.findAll(PageRequest.of(page - 1, pageSize));
        return new ResponseEntity<>(allArtikels, HttpStatus.OK);
    }
        
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

    @GetMapping("/standortwahl")
    public ResponseEntity<List<Artikel>> getArtikelByStandort(@RequestParam String wo) {
        return new ResponseEntity<>(artikelRepository.findByStandort(wo), HttpStatus.OK);
    }

}
