package com.cliente;

import java.io.IOException;

public class MainC {
    public static void main(String[] args) throws IOException {

        ClienteThread c1=new ClienteThread("34","45");
        ClienteThread c2=new ClienteThread("74","85");
        ClienteThread c3=new ClienteThread("44","25");

        c1.start();
        c2.start();
        c3.start();



    }
}
