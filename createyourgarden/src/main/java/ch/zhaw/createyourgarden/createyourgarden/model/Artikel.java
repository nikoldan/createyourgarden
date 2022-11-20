package ch.zhaw.createyourgarden.createyourgarden.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Document("artikel")
public class Artikel {
    @Id
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String deutscherName;
    @NonNull
    private String beschreibung;
    
    private double preis;
    @NonNull

    private String standort;
    private int bluetemonat;
    private int hoehe;
    
    
    
}
