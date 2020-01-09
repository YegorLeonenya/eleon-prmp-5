package bsuir.prmp.l5weatherapi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import bsuir.prmp.l5weatherapi.R;

public class WeatherFragment extends Fragment {

    private TextView tvLocation;
    private TextView tvCurrentTemperature;
    private TextView tvCurrentHumidity;
    private TextView tvCurrentCloudiness;
    private TextView tvCurrentPressure;
    private TextView tvCurrentWindSpeed;
        private ImageView ivWeatherIcon;

    private WeatherViewModel model;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.fragment_weather,
                container,
                false);
        initialViews(rootView);

        model = ViewModelProviders.of(getActivity()).get(WeatherViewModel.class);
        subscribeToModel();
        return rootView;
    }

    private void initialViews(View rootView) {
        tvLocation = rootView.findViewById(R.id.tv_location);
        tvCurrentTemperature = rootView.findViewById(R.id.tv_current_temperature);
        tvCurrentHumidity = rootView.findViewById(R.id.tv_current_humidity);
        tvCurrentCloudiness = rootView.findViewById(R.id.tv_current_cloudiness);
        tvCurrentPressure = rootView.findViewById(R.id.tv_current_pressure);
        tvCurrentWindSpeed = rootView.findViewById(R.id.tv_current_wind_speed);
        ivWeatherIcon = rootView.findViewById(R.id.iv_weather_icon);
    }

    private void subscribeToModel() {
        model.getWeatherData().observe(this, currentWeatherDto ->  {
            tvLocation.setText(currentWeatherDto.getCityName() + ", " + currentWeatherDto.getCountryCode());
            ivWeatherIcon.setImageResource(getDrawableIdByName(currentWeatherDto.getWeatherIconId()));
            tvCurrentTemperature.setText(currentWeatherDto.getTemperature() + "°C");
            tvCurrentHumidity.setText(currentWeatherDto.getHumidity() + " %");
            tvCurrentCloudiness.setText(currentWeatherDto.getCloudiness() + " %");
            tvCurrentPressure.setText(currentWeatherDto.getPressure() + " GPa");
            tvCurrentWindSpeed.setText(currentWeatherDto.getWindSpeed() + " m/s");
        });
    }

    private int getDrawableIdByName(String name) {
        switch (name) {
            case "01d":
                return R.drawable.weather_icon_01d;
            case "01n":
                return R.drawable.weather_icon_01n;
            case "02d":
                return R.drawable.weather_icon_02d;
            case "02n":
                return R.drawable.weather_icon_02n;
            case "03d":
                return R.drawable.weather_icon_03d;
            case "03n":
                return R.drawable.weather_icon_03n;
            case "04d":
                return R.drawable.weather_icon_04d;
            case "04n":
                return R.drawable.weather_icon_04n;
            case "09d":
                return R.drawable.weather_icon_09d;
            case "09n":
                return R.drawable.weather_icon_09n;
            case "10d":
                return R.drawable.weather_icon_10d;
            case "10n":
                return R.drawable.weather_icon_10n;
            case "11d":
                return R.drawable.weather_icon_11d;
            case "11n":
                return R.drawable.weather_icon_11n;
            case "13d":
                return R.drawable.weather_icon_13d;
            case "13n":
                return R.drawable.weather_icon_13n;
            case "50d":
                return R.drawable.weather_icon_50d;
            case "50n":
                return R.drawable.weather_icon_50n;
        }
        return R.drawable.ic_launcher_background;
    }

}
