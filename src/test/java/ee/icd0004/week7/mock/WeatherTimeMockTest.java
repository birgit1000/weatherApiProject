package ee.icd0004.week7.mock;

import ee.icd0004.week7.WeatherTime;
import ee.icd0004.week7.api.WeatherApi;
import ee.icd0004.week7.domain.CurrentWeatherData;
import ee.icd0004.week7.domain.WeatherReport;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeatherTimeMockTest {

    @InjectMocks
    static WeatherTime weatherTime;
    @Mock
    static WeatherApi weatherApiMock;

    @BeforeClass
    public static void setUp(){
        weatherTime = new WeatherTime(weatherApiMock);
    }

    @Test
    public void shouldHaveCityNameInWeatherReport(){
        String city = "Tallinn";
        CurrentWeatherData currentWeatherData = new CurrentWeatherData();
        currentWeatherData.setName(city);
        when(weatherApiMock.getCurrentWeatherData(anyString())).thenReturn(currentWeatherData);

        WeatherReport weatherReport = weatherTime.getWeatherReportForCity(city);

        assertThat(weatherReport.getMainDetails().getCity()).isEqualTo(city);
    }
}
