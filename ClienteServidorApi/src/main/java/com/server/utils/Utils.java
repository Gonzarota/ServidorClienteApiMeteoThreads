package com.server.utils;

import com.google.gson.Gson;
import com.server.domain.elementsInfo.Coordenadas;

public class Utils {

    public static Coordenadas parseCoordenadas(String coor){
        Gson gson=new Gson();
        Coordenadas coorgson=gson.fromJson(coor, Coordenadas.class);
        return coorgson;
    }

    public static String tempConverse(Float kelvin){
        float celsius=Math.round(kelvin-273.15f);
        return String.valueOf(celsius);
    }

}
