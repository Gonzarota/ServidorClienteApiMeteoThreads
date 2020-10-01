package com.server;

import com.server.domain.elementsInfo.Coordenadas;

public class Checker {

    public static boolean checkFormato(String consulta){
        String[] check=consulta.split(",");
        if(check.length==2){
            try{
                Float.parseFloat(check[0]);
                Float.parseFloat(check[1]);
                return true;
            }catch (NumberFormatException ex){
                return false;
            }
        }
        return false;
    }

    public static boolean checkRange(Coordenadas coordenadas){
        return coordenadas.getLat()>= -90&& coordenadas.getLat()<=90
                && coordenadas.getLon()>=-180&& coordenadas.getLon()<=180;
    }
}
