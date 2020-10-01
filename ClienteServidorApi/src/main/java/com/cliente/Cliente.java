package com.cliente;

import com.server.domain.elementsInfo.Coordenadas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    Scanner sc=new Scanner(System.in);
    DataOutputStream dout;
    DataInputStream din;
    Socket s;

    public Cliente(){
        try {
            this.s=new Socket("localhost",3333);
            this.dout = new DataOutputStream(s.getOutputStream());
            this.din=new DataInputStream(s.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String doConsultLat() throws IOException {
        System.out.println("Dime las coordenadas que quieres consultar");
        System.out.println("Dime la latitud");
        String lat = sc.nextLine();
        return lat;
    }

    public String doConsultLon() throws IOException{
        System.out.println("Dime la longitud");
        String lon = sc.nextLine();
        System.out.println("");
        return lon;
    }

    public void sendToServer(String lat,String lon) throws IOException {
        dout.writeUTF(lat);
        dout.writeUTF(lon);
    }

    public void getServerReponse() throws IOException {
        //get  if checkformat is ok
        String str=din.readUTF();
        System.out.println("Servidor responde:" + str);

        //get reponse
        System.out.println("");
        System.out.println(din.readUTF());
        System.out.println("");
    }

    public void close() throws IOException {
        dout.close();
        din.close();
        s.close();
    }

}
