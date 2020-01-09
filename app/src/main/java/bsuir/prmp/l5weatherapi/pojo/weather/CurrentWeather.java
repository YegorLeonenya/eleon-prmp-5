package bsuir.prmp.l5weatherapi.pojo.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import bsuir.prmp.l5weatherapi.pojo.weather.properties.Clouds;
import bsuir.prmp.l5weatherapi.pojo.weather.properties.Main;
import bsuir.prmp.l5weatherapi.pojo.weather.properties.SystemInfo;
import bsuir.prmp.l5weatherapi.pojo.weather.properties.Weather;
import bsuir.prmp.l5weatherapi.pojo.weather.properties.Wind;

public class CurrentWeather {

    @SerializedName("id")
    @Expose
    private long cityId;

    @SerializedName("name")
    @Expose
    private String cityName;

    @SerializedName("weather")
    @Expose
    private ArrayList<Weather> weather;

    @SerializedName("main")
    @Expose
    private Main main;

    @SerializedName("wind")
    @Expose
    private Wind wind;

    @SerializedName("clouds")
    @Expose
    private Clouds clouds;

    @SerializedName("sys")
    @Expose
    private SystemInfo system;

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public SystemInfo getSystemInfo() {
        return system;
    }

    public void setSystemInfo(SystemInfo system) {
        this.system = system;
    }

}
