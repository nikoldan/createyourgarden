package ch.zhaw.createyourgarden.createyourgarden.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
public class BestellungCreateDTO {
    private LocalDateTime datum;
    private List<Artikel> artikels;
    private String kundenId;


}
