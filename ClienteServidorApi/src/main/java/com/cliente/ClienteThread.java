package com.cliente;

import com.server.domain.elementsInfo.Coordenadas;

import java.io.IOException;

public class ClienteThread extends Thread {

    String lat;
    String lon;

    public ClienteThread(String lat, String lon){
        this.lat=lat;
        this.lon=lon;
    }

    @Override
    public void run() {
        Cliente cliente = new Cliente();
        try {
            this.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            cliente.sendToServer(this.lat,this.lon);
            cliente.getServerReponse();
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
