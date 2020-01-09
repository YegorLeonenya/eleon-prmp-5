package bsuir.prmp.l5weatherapi.api;

import bsuir.prmp.l5weatherapi.pojo.weather.CurrentWeather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherMapApi {

    String BASE_URL = "https://api.openweathermap.org";
    String API_KEY = "7493747f0b733ef33e2b147f3aa5d78d";

    @GET("/data/2.5/weather")
    Call<CurrentWeather> getCurrentWeatherByCityId(@Query("q") String cityName,
                                                   @Query("APPID") String apiKey,
                                                   @Query("units") String units);

}
