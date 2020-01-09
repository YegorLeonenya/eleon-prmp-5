package bsuir.prmp.l5weatherapi.pojo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Weather {

    private static final String[] WIND_SECTORS = {
            "северный",
            "северо-восточный",
            "восточный",
            "юго-восточный",
            "южный",
            "юго-западный",
            "западный",
            "северо-западный"
    };

    private Date date;
    private long cityId;
    private String countryCode;
    private String cityName;
    private int temperature;
    private int humidity;
    private int pressure;
    private int cloudiness;
    private double windSpeed;
    private int windDirection;
    private int weatherConditionId;
    private String weatherMain;
    private String weatherDescription;
    private String weatherIconId;
    private long sunrise;
    private long sunset;

    public Weather(long cityId,
                   String countryCode,
                   String cityName,
                   int temperature,
                   int humidity,
                   int pressure,
                   int cloudiness,
                   double windSpeed,
                   int windDirection,
                   int weatherConditionId,
                   String weatherMain,
                   String weatherDescription,
                   String weatherIconId,
                   long sunrise,
                   long sunset) {
        this.date = new Date();
        this.cityId = cityId;
        this.countryCode = countryCode;
        this.cityName = cityName;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.cloudiness = cloudiness;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.weatherConditionId = weatherConditionId;
        this.weatherMain = weatherMain;
        this.weatherDescription = weatherDescription;
        this.weatherIconId = weatherIconId;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy-HH:mm:ss", Locale.ENGLISH);
        return dateFormat.format(this.date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(int cloudiness) {
        this.cloudiness = cloudiness;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        int index = (int) Math.floor(((windDirection + 22.5) % 360) / 45);
        return WIND_SECTORS[index];
    }

    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }

    public int getWeatherConditionId() {
        return weatherConditionId;
    }

    public void setWeatherConditionId(int weatherConditionId) {
        this.weatherConditionId = weatherConditionId;
    }

    public String getWeatherMain() {
        return weatherMain;
    }

    public void setWeatherMain(String weatherMain) {
        this.weatherMain = weatherMain;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getWeatherIconId() {
        return weatherIconId;
    }

    public void setWeatherIconId(String weatherIconId) {
        this.weatherIconId = weatherIconId;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

}
