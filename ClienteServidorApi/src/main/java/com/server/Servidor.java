package com.server;

import com.server.domain.InfoServiceReponse;
import com.server.services.meteo.api.ApiMeteo;
import com.server.domain.elementsInfo.Coordenadas;
import com.server.utils.Utils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {

    ServerSocket ss;
    Socket s;
    DataInputStream din;
    DataOutputStream dout;

    public Servidor(Socket socket) throws IOException {
        this.s=socket;
        this.din = new DataInputStream(s.getInputStream());
        this.dout = new DataOutputStream(s.getOutputStream());
    }

    @Override
    public void run(){
        String consulta = null;
        try {
            this.join(3000);
            consulta = getClientCoordenates();
            Coordenadas coor = createCoor(consulta);
            doReponsetoClient(coor);
            close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getClientCoordenates() throws IOException {
        System.out.println("Consulta aceptada");
        String lat = din.readUTF();
        String lon = din.readUTF();
        String consulta = lat + "," + lon;

        System.out.println("El cliente hace la consulta de-> Latitud: " + lat + " Longitud: " + lon);
        if (Checker.checkFormato(consulta) == true) {
            dout.writeUTF("Datos correctos");
            return "{\"lon\":" + lon + ",\"lat\":" + lat + "}";
        } else {
            dout.writeUTF("Datos incorrectos");
            return null;
        }
    }

    public Coordenadas createCoor(String consulta) throws IOException {

        if(consulta!=null){
            Coordenadas coordenadas = Utils.parseCoordenadas(consulta);
            if (Checker.checkRange(coordenadas)) {
                return coordenadas;
            } else {
                dout.writeUTF("Las coordenadas no se encuentran en los rangos correctos");
                return null;
            }
        }else{
            return null;
        }
    }

    public void doReponsetoClient(Coordenadas coor) throws IOException {
        if(coor!=null){
            ApiMeteo oc = new ApiMeteo();

            /*try{
                this.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            InfoServiceReponse openInfo = oc.getCurrentWeather(coor);
            dout.writeUTF(openInfo.getInfoToString());
        }else{
            dout.writeUTF("Vuelve a empezar, por favor");
        }
    }

    public void close() throws IOException {
        din.close();
        dout.close();
        s.close();
    }
}


        /*ServerSocket ss=new ServerSocket(3333);
        System.out.println("Escuchando peticiones de consulta");

        while(true){
            Socket s=ss.accept();
            System.out.println("Consulta escuchada");

            DataInputStream din=new DataInputStream(s.getInputStream());
            String lat=din.readUTF();
            String lon=din.readUTF();

            System.out.println("El cliente hace la consulta de-> Latitud: "+lat+ " Longitud: "+lon);
            String consulta=lat+","+lon;
            boolean consultaCorrect= Checker.checkFormato(consulta);
            String coor="{\"lon\":"+lon+",\"lat\":"+lat+"}";

            DataOutputStream dout=new DataOutputStream(s.getOutputStream());

            if(consultaCorrect==true){
                dout.writeUTF("Datos correctos");
                Coordenadas coordenadas= Utils.parseCoordenadas(coor);

                if (Checker.checkRange(coordenadas)) {
                    ApiMeteo oc=new ApiMeteo();
                    InfoServiceReponse openInfo=oc.getCurrentWeather(coordenadas);
                    dout.writeUTF(openInfo.getInfoToString());
                }else{
                    dout.writeUTF("Las coordenadas no se encuentran en los rangos correctos");
                }
            }
            if(consultaCorrect==false){
                dout.writeUTF("Lo siento, datos incorrectos");
            }

            din.close();
            dout.close();
            s.close();
        }

    }
}*/
