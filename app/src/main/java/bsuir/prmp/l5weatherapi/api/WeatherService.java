package bsuir.prmp.l5weatherapi.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherService {

    private static WeatherService mInstance;
    private Retrofit mRetrofit;

    private WeatherService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(OpenWeatherMapApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static WeatherService getInstance() {
        if (mInstance == null) {
            mInstance = new WeatherService();
        }
        return mInstance;
    }

    public OpenWeatherMapApi getOpenWeatherMapApi() {
        return mRetrofit.create(OpenWeatherMapApi.class);
    }

}
