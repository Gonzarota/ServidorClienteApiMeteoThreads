package com.server.domain;

import com.server.domain.elementsInfo.*;
import com.server.utils.Utils;

import java.util.List;

public class InfoServiceReponse {

    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private String name;



    public String getInfoToString(){
        StringBuilder sb=new StringBuilder();
        sb.append("Location: ");
        sb.append(this.getName()).append("\nMain weather: ").append((this.getWeather().get(0).getMain()));
        sb.append(", ").append(this.getWeather().get(0).getDescription());
        sb.append("\nTemperature: ").append(Utils.tempConverse(this.getMain().getTemp()));
        sb.append("\nHumidity: ").append(this.getMain().getHumidity());
        sb.append("\nWind speed: ").append(this.getWind().getSpeed());
        return sb.toString();
    }

    //mpsolanas@effor.es



    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMedidas(Main medidas) {
        this.main = medidas;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
