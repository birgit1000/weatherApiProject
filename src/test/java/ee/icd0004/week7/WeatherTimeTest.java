package ee.icd0004.week7;


import ee.icd0004.week7.api.WeatherApi;
import ee.icd0004.week7.domain.WeatherReport;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class WeatherTimeTest {

    @Test
    public void shouldHaveMainDetailsBlockInWeatherReport(){
        WeatherApi weatherApi = new WeatherApi();
        WeatherTime weatherTime = new WeatherTime(weatherApi);
        String city = "Tallinn";

        WeatherReport weatherReport = weatherTime.getWeatherReportForCity(city);

        assertThat(weatherReport.getMainDetails().getCity()).isNotNull();
    }

    @Test
    public void shouldHaveCityNameInWeatherReport(){
        WeatherApi weatherApi = new WeatherApi();
        WeatherTime weatherTime = new WeatherTime(weatherApi);
        String city = "Tallinn";

         WeatherReport weatherReport = weatherTime.getWeatherReportForCity(city);

        assertThat(weatherReport.getMainDetails().getCity()).isEqualTo(city);
    }

}
