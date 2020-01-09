package bsuir.prmp.l5weatherapi.api;

import bsuir.prmp.l5weatherapi.pojo.city.CityInfoResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface CityGeoLocationApi {

    String BASE_URL = "https://devru-latitude-longitude-find-v1.p.rapidapi.com";

    @Headers("x-rapidapi-key: 2f3a28e734msha9f300b58a2741ap1ae1ebjsnb0df4a968f64")
    @GET("/latlon.php")
    Call<CityInfoResponse> getCitiesByLocation(@Query("location") String location);

}
