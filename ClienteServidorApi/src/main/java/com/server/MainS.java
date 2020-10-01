package com.server;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainS {
    public static void main(String[] args) throws IOException {

        ServerSocket ss=new ServerSocket(3333);
        System.out.println("Escuchando");
        while(true){
            Socket s=ss.accept();
            Servidor server=new Servidor(s);
            server.start();
        }
    }
}
