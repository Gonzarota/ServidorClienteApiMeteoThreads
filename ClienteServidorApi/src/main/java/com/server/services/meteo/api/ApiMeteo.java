package com.server.services.meteo.api;

import com.google.gson.Gson;
import com.server.domain.InfoServiceReponse;
import com.server.domain.elementsInfo.Coordenadas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ApiMeteo {

    public final String url="http://api.openweathermap.org/data/2.5/weather?lat=35.3&lon=139&appid=3e2d658a45d141292b9ac778c8b2dc32";


    public InfoServiceReponse getCurrentWeather(Coordenadas coordenadas) throws IOException {

        String urlAPi="http://api.openweathermap.org/data/2.5/weather?lat="+coordenadas.getLat()+
                "&lon="+coordenadas.getLon()+"&appid=3e2d658a45d141292b9ac778c8b2dc32";

        URL url= new URL(urlAPi);
        HttpURLConnection con=(HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while((inputLine = bufferedReader.readLine())!=null){
            content.append(inputLine);
        }
        bufferedReader.close();

        Gson gson=new Gson();
        InfoServiceReponse infogson=gson.fromJson(content.toString(), InfoServiceReponse.class);

        con.disconnect();

        return infogson;

    }
}
