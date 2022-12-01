package ch.zhaw.createyourgarden.createyourgarden.model;

import java.time.LocalDateTime;
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
    private LocalDateTime datum;
    @NonNull
    private List<Artikel> artikels;
    @NonNull
    private String kundenId;
    
    private String kommentare;
    private BestellungState bestellungState = BestellungState.NEU;

}
