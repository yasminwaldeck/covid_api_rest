package de.neuefische.corona_rest_temp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
public class CoronaIn {
    private String countryCode;
    private Integer confirmed;

    public CoronaIn() {
    }

    public CoronaIn(String countryCode, Integer confirmed) {
        this.countryCode = countryCode;
        this.confirmed = confirmed;
    }

    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("CountryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    @JsonProperty("Confirmed")
    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoronaIn that = (CoronaIn) o;
        return Objects.equals(countryCode, that.countryCode) && Objects.equals(confirmed, that.confirmed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, confirmed);
    }

    @Override
    public String toString() {
        return "CoronaBackEnd{" +
                "countryCode='" + countryCode + '\'' +
                ", confirmed=" + confirmed +
                '}';
    }

    //Bitte Hände waschen

    // ABSTAND!!!

    // Maske tragen

//    {
//        "ID": "f623434e-af35-4bfc-8acf-5707e56df3a8",
//            "Country": "Germany",
//            "CountryCode": "DE",
//            "Province": "",
//            "City": "",
//            "CityCode": "",
//            "Lat": "51.17",
//            "Lon": "10.45",
//            "Confirmed": 3484755,
//            "Deaths": 84141,
//            "Recovered": 3118660,
//            "Active": 281954,
//            "Date": "2021-05-05T00:00:00Z"
//    }


}
