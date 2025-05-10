package org.example;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Cliente implements Runnable{
    private String host;
    private int port;
    private DatagramSocket socket;

    public Cliente(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void run() {
        try {

            InetAddress endereco = InetAddress.getByName(host);

            socket = new DatagramSocket();

            socket.send(new DatagramPacket(new byte[1024], 1024, endereco, port));

            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

            socket.receive(packet);

            System.out.println(new String(packet.getData()).trim());

            Thread.sleep(1000);
            socket.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
