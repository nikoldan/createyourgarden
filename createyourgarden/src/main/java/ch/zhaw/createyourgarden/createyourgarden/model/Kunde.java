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
@Document("kunde")
public class Kunde {
    @Id
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    
    private String plzOrt;  
    
     

}
