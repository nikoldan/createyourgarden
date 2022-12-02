package ch.zhaw.createyourgarden.createyourgarden.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zhaw.createyourgarden.createyourgarden.repository.BestellungRepository;

@Service
public class BestellungService {
    @Autowired
    BestellungRepository bestellungRepository;

    

}
