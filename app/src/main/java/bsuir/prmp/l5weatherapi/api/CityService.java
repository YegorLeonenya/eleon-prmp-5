package bsuir.prmp.l5weatherapi.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CityService {

    private static CityService mInstance;
    private Retrofit mRetrofit;

    private CityService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(CityGeoLocationApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static CityService getInstance() {
        if (mInstance == null) {
            mInstance = new CityService();
        }
        return mInstance;
    }

    public CityGeoLocationApi getCityGeoLocationApi() {
        return mRetrofit.create(CityGeoLocationApi.class);
    }

}
