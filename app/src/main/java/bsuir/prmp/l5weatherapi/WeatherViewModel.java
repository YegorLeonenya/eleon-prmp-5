package bsuir.prmp.l5weatherapi;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import bsuir.prmp.l5weatherapi.pojo.Weather;

public class WeatherViewModel extends ViewModel {

    private MutableLiveData<Weather> weatherData = new MutableLiveData<>();

    public MutableLiveData<Weather> getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(Weather weatherDto) {
        this.weatherData.setValue(weatherDto);
    }

}
