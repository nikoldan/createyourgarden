package ch.zhaw.createyourgarden.createyourgarden.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Document("bestellung")
public class Bestellung {
    @Id
    private String id;
    @NonNull
    private String datum;
    
    private BestellungState bestellungState = BestellungState.NEU;
    private String kundenId;
    private List<Artikel> artikels;

}
