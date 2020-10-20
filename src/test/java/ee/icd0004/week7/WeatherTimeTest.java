package ee.icd0004.week7;


import ee.icd0004.week7.domain.WeatherReport;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class WeatherTimeTest {

    @Test
    public void shouldHaveMainDetailsBlockInWeatherReport(){
        WeatherTime weatherTime = new WeatherTime();
        String city = "Tallinn";

        WeatherReport weatherReport = weatherTime.getWeatherReportForCity(city);

        assertThat(weatherReport.getMainDetails().getCity()).isBlank();
    }

    @Test
    public void shouldHaveCityNameInWeatherReport(){
        WeatherTime weatherTime = new WeatherTime();
        String city = "Tallinn";

        WeatherReport weatherReport = weatherTime.getWeatherReportForCity(city);

        assertThat(weatherReport.getMainDetails().getCity()).isEqualTo(city);
    }

}
