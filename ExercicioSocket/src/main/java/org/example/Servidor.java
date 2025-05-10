package org.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor implements Runnable {
    private DatagramSocket socket;
    private byte[] buffer;

    private final int PORTA = 5050;

    @Override
    public void run() {
        try {
            socket = new DatagramSocket(PORTA);

            while (true) {
                DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
                socket.receive(packet);

                Thread thread = new Thread(new MinhaThread(new DatagramPacket(packet.getData(), packet.getData().length, packet.getAddress(), packet.getPort()),
                        socket));
                thread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class MinhaThread implements Runnable{
    private DatagramPacket packet;
    private DatagramSocket socket;

    public MinhaThread(DatagramPacket packet, DatagramSocket socket) {
        this.packet = packet;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            String message = new StringBuilder(new String(packet.getData())).reverse().toString();
            packet.setData(message.getBytes());
            socket.send(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
