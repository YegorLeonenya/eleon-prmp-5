package bsuir.prmp.l5weatherapi.pojo.weather.properties;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SystemInfo {

    @SerializedName("country")
    @Expose
    private String countryCode;

    @SerializedName("sunrise")
    @Expose
    private long sunrise;

    @SerializedName("sunset")
    @Expose
    private long sunset;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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
