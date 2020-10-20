package ee.icd0004.week7;

import ee.icd0004.week7.api.WeatherApi;
import ee.icd0004.week7.domain.CurrentWeatherData;
import ee.icd0004.week7.domain.MainDetails;
import ee.icd0004.week7.domain.WeatherReport;

public class WeatherTime {

    public WeatherReport getWeatherReportForCity(String city) {
        WeatherReport weatherReport = new WeatherReport();
        WeatherApi weatherApi = new WeatherApi();

        CurrentWeatherData currentWeatherData = weatherApi.getCurrentWeatherData(city);

        MainDetails mainDetails = new MainDetails();
        mainDetails.setCity(currentWeatherData.getName());

        weatherReport.setMainDetails(mainDetails);
        return weatherReport;
    }
}
