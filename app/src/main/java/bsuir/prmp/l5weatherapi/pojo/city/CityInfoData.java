package bsuir.prmp.l5weatherapi.pojo.city;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityInfoData {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("c")
    @Expose
    private String country;

    public String getName() {
        return name.split(", ")[0];
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
