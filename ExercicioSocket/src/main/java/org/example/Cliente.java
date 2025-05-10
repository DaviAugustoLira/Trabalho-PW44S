package org.example;

import javax.xml.crypto.Data;
import java.net.*;

public class Cliente implements Runnable{

    private DatagramSocket socket;

    private int port;
    private String host;
    private String dado;

    public Cliente(String host, int port, String dado) {
        this.host = host;
        this.port = port;
        this.dado = dado;
    }

    @Override
    public void run() {
        try {
            socket = new DatagramSocket();

            byte[] b = dado.getBytes();
            InetAddress address = InetAddress.getByName(host);

            DatagramPacket packet = new DatagramPacket(b, b.length, address, port);

            socket.send(packet);

            DatagramPacket retorno = new DatagramPacket(new byte[1024], 1024);
            socket.receive(retorno);

            System.out.println(new String(retorno.getData()).trim());

            socket.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
