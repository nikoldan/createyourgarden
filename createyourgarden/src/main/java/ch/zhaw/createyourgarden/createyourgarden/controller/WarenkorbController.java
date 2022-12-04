package ch.zhaw.createyourgarden.createyourgarden.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.createyourgarden.createyourgarden.repository.WarenkorbRepository;



@RestController
@RequestMapping("/api/warenkorb")
public class WarenkorbController {
    @Autowired
    WarenkorbRepository warenkorbRepository;

    

}
