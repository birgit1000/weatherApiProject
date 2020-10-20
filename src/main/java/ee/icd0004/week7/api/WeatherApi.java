package ee.icd0004.week7.api;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import ee.icd0004.week7.domain.CurrentWeatherData;
import ee.icd0004.week7.domain.Unit;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

import static com.sun.jersey.api.client.Client.create;
import static com.sun.jersey.api.json.JSONConfiguration.FEATURE_POJO_MAPPING;

public class WeatherApi {
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5";
    private static final String API_KEY = "838a8c10b8a6f02a94b2b7dd1eaa0769";


    public CurrentWeatherData getCurrentWeatherData(String city) {
        Client client = getConfiguredClient();
        String resourceUrl = BASE_URL + "/weather";

        ClientResponse response = client.resource(resourceUrl)
                .queryParam("q", city)
                .queryParam("appid", API_KEY)
                .queryParam("units", Unit.METRIC.toString())
                .get(ClientResponse.class);

        return response.getEntity(CurrentWeatherData.class);
    }

    private static Client getConfiguredClient(){
        ClientConfig config = new DefaultClientConfig();
        config.getClasses().add(JacksonJaxbJsonProvider.class);
        config.getFeatures().put(FEATURE_POJO_MAPPING, true);
        return create(config);
    }
}
