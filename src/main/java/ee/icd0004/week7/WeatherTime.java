package ee.icd0004.week7;

import ee.icd0004.week7.api.WeatherApi;
import ee.icd0004.week7.domain.CurrentWeatherData;
import ee.icd0004.week7.domain.MainDetails;
import ee.icd0004.week7.domain.WeatherReport;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WeatherTime {
    private WeatherApi weatherApi;

    public WeatherReport getWeatherReportForCity(String city) {
        WeatherApi weatherApi = new WeatherApi();
        WeatherReport weatherReport = new WeatherReport();
        CurrentWeatherData currentWeatherData = weatherApi.getCurrentWeatherData(city);

        MainDetails mainDetails = new MainDetails();
        mainDetails.setCity(currentWeatherData.getName());

        weatherReport.setMainDetails(mainDetails);
        return weatherReport;
    }
}
