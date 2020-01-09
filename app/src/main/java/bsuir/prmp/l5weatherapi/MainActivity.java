package bsuir.prmp.l5weatherapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import bsuir.prmp.l5weatherapi.pojo.Weather;
import bsuir.prmp.l5weatherapi.api.CityService;
import bsuir.prmp.l5weatherapi.api.WeatherService;
import bsuir.prmp.l5weatherapi.api.OpenWeatherMapApi;
import bsuir.prmp.l5weatherapi.pojo.city.CityInfoResponse;
import bsuir.prmp.l5weatherapi.pojo.weather.CurrentWeather;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity
        extends AppCompatActivity
        implements SearchView.OnQueryTextListener, SearchView.OnSuggestionListener {

    private static ArrayAdapter<String> adapter;
    private static String[] itemList = new String[] {};
    private static String currentCity = "Moscow,RU";

    private WeatherViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = ViewModelProviders.of(MainActivity.this).get(WeatherViewModel.class);
        refreshCurrentWeather(currentCity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        initializeSearching(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item_refresh) {
            refreshCurrentWeather(currentCity);
        }
        return true;
    }

    private void refreshCurrentWeather(String cityName) {
        WeatherService.getInstance()
                .getOpenWeatherMapApi()
                .getCurrentWeatherByCityId(
                        cityName,
                        OpenWeatherMapApi.API_KEY,
                        "metric")
                .enqueue(new Callback<CurrentWeather>() {
                    @Override
                    public void onResponse(Call<CurrentWeather> call,
                                           Response<CurrentWeather> response) {
                        try {
                            CurrentWeather currentWeather = response.body();
                            model.setWeatherData(new Weather(
                                    currentWeather.getCityId(),
                                    currentWeather.getSystemInfo().getCountryCode(),
                                    currentWeather.getCityName(),
                                    currentWeather.getMain().getTemperature(),
                                    currentWeather.getMain().getHumidity(),
                                    currentWeather.getMain().getPressure(),
                                    currentWeather.getClouds().getCloudiness(),
                                    currentWeather.getWind().getSpeed(),
                                    currentWeather.getWind().getDirection(),
                                    currentWeather.getWeather().get(0).getConditionId(),
                                    currentWeather.getWeather().get(0).getMain(),
                                    currentWeather.getWeather().get(0).getDescription(),
                                    currentWeather.getWeather().get(0).getIconId(),
                                    currentWeather.getSystemInfo().getSunrise(),
                                    currentWeather.getSystemInfo().getSunset()
                            ));
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(),
                                    "Error",
                                    Toast.LENGTH_SHORT
                            ).show();
                            currentCity = model.getWeatherData().getValue().getCityName()
                                    + ","
                                    + model.getWeatherData().getValue().getCountryCode();
                        }
                    }

                    @Override
                    public void onFailure(Call<CurrentWeather> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT)
                                .show();
                    }
                });
        Toast.makeText(this, R.string.refreshed, Toast.LENGTH_SHORT).show();
    }

    private void findCityByName(String cityName) {
        CityService.getInstance()
                .getCityGeoLocationApi()
                .getCitiesByLocation(cityName)
                .enqueue(new Callback<CityInfoResponse>() {
                    @Override
                    public void onResponse(Call<CityInfoResponse> call, Response<CityInfoResponse> response) {
                        adapter.clear();
                        adapter.addAll(
                                response.body()
                                        .getCityInfoDataList()
                                        .stream()
                                        .map(cityInfoData -> cityInfoData.getName()
                                                + ","
                                                + cityInfoData.getCountry()
                                        )
                                        .toArray(String[]::new)
                        );
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<CityInfoResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT)
                                .show();
                    }
                });
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.replaceAll(" ", "\\+");
        findCityByName(newText);
        return true;
    }

    @Override
    public boolean onSuggestionSelect(int position) {
        return true;
    }

    @Override
    public boolean onSuggestionClick(int position) {
        currentCity = adapter.getItem(position);
        refreshCurrentWeather(currentCity);
        return true;
    }

    private void initializeSearching(Menu menu) {
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.item_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        SearchView.SearchAutoComplete searchAutoComplete = searchView
                .findViewById(androidx.appcompat.R.id.search_src_text);
        searchAutoComplete.setTextColor(Color.WHITE);
        searchAutoComplete
                .setDropDownBackgroundDrawable(ContextCompat
                        .getDrawable(
                                getApplicationContext(),
                                R.drawable.abc_popup_background_mtrl_mult
                        )
                );

        adapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_dropdown_item_1line,
                itemList
        );
        searchAutoComplete.setAdapter(adapter);

        searchView.setOnQueryTextListener(this);
        searchView.setOnSuggestionListener(this);
    }

}
