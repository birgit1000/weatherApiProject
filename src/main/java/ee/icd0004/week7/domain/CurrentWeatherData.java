package ee.icd0004.week7.domain;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown =  true)
public class CurrentWeatherData {
    private String name;
    private Coordinates coord;
}
