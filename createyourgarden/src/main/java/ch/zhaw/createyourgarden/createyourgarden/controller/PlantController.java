package ch.zhaw.createyourgarden.createyourgarden.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.createyourgarden.createyourgarden.repository.PlantRepository;

@RestController
@RequestMapping("https://open.plantbook.io/api/v1/plant/detail/acer buergerianum/")
public class PlantController {
    
    @Autowired
    PlantRepository plantRepository;

    
    
}
