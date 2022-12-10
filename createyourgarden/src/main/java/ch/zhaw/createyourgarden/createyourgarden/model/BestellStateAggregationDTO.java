package ch.zhaw.createyourgarden.createyourgarden.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BestellStateAggregationDTO {
    private String id;
    private List<String> bestellIds;
    private String count;
}
