package de.neuefische.corona_rest_temp.model;

import java.util.Objects;

public class CoronaFrontEnd {

    private String countryCode;
    private Integer average;

    public CoronaFrontEnd(String countryCode, Integer average){
        this.countryCode= countryCode;
        this.average = average;
    }

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
        CoronaFrontEnd that = (CoronaFrontEnd) o;
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
