package ch.zhaw.createyourgarden.createyourgarden.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document("artikel")
public class Artikel {
    @Id
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String dName;
    @NonNull
    private String beschreibung;
   

    private String standort;
    private int bluetemonat;
    private int hoehe;
    
    
    
}
