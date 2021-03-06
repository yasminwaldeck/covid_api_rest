package de.neuefische.corona_rest_temp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class CoronaOut {

    @JsonProperty("CountryCode")
    private String countryCode;

    @JsonProperty("Average")
    private Integer average;



    public CoronaOut(String countryCode, Integer average){
        this.countryCode= countryCode;
        this.average = average;
    }

    public CoronaOut(){}

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Integer getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoronaOut that = (CoronaOut) o;
        return Objects.equals(countryCode, that.countryCode) && Objects.equals(average, that.average);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, average);
    }

    @Override
    public String toString() {
        return "CoronaFrontEnd{" +
                "countryCode='" + countryCode + '\'' +
                ", average=" + average +
                '}';
    }
}
