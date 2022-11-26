package ch.zhaw.createyourgarden.createyourgarden.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BestellungCreateDTO {
    private String datum;
    private List<Artikel> artikels;
    private String kundenId;


}
