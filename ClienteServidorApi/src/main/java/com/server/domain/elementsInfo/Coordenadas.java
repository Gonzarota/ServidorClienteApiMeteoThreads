package com.server.domain.elementsInfo;

public class Coordenadas {

    private float lat;
    private float lon;

    public Coordenadas(float lon,float lat){
        this.lat=lat;
        this.lon=lon;
    }

    @Override
    public boolean equals(Object object){
        if(object.getClass().equals(Coordenadas.class)){
            Coordenadas c = (Coordenadas)object;
            if(this.lat == c.lat && this.lon == c.lon)
                return true;
        }
        return false;
    }


    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }


}
