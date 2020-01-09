package bsuir.prmp.l5weatherapi.pojo.city;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CityInfoResponse {

    @SerializedName("Results")
    @Expose
    private ArrayList<CityInfoData> cityInfoDataList;

    public ArrayList<CityInfoData> getCityInfoDataList() {
        return cityInfoDataList;
    }

    public void setCityInfoDataList(ArrayList<CityInfoData> cityInfoDataList) {
        this.cityInfoDataList = cityInfoDataList;
    }

}
