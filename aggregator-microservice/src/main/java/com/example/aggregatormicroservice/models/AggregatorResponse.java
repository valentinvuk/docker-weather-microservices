package com.example.aggregatormicroservice.models;

public class AggregatorResponse {
    private String tempUnit, humUnit;
    private Integer temp, hum;

    public AggregatorResponse() {
    }

    public AggregatorResponse(String tempUnit, String humUnit, Integer temp, Integer hum) {
        this.tempUnit = tempUnit;
        this.humUnit = humUnit;
        this.temp = temp;
        this.hum = hum;
    }

    public String getTempUnit() {
        return tempUnit;
    }

    public void setTempUnit(String tempUnit) {
        this.tempUnit = tempUnit;
    }

    public String getHumUnit() {
        return humUnit;
    }

    public void setHumUnit(String humUnit) {
        this.humUnit = humUnit;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public Integer getHum() {
        return hum;
    }

    public void setHum(Integer hum) {
        this.hum = hum;
    }

    @Override
    public String toString() {
        return "AggregatorResponse{" +
                "tempUnit='" + tempUnit + '\'' +
                ", humUnit='" + humUnit + '\'' +
                ", temp=" + temp +
                ", hum=" + hum +
                '}';
    }
}
