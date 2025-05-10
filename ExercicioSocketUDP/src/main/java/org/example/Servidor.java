package org.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Servidor implements Runnable{

    private DatagramSocket socket;

    private final int PORT = 9090;


    @Override
    public void run() {
        try {
            socket = new DatagramSocket(PORT);
            while(true) {
                DatagramPacket recebido = new DatagramPacket(new byte[1024], 1024);
                socket.receive(recebido);

                Thread thread = new Thread(new MinhaThread(recebido, socket));
                thread.start();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if (socket != null && !socket.isClosed()) {
                socket.close(); // Fecha o socket corretamente
                System.out.println("[Servidor] Socket fechado");
            }
        }


    }
}

class MinhaThread implements Runnable{
    private LocalDateTime time;

    private DatagramSocket socket;
    private DatagramPacket packet;

    public MinhaThread(DatagramPacket packet, DatagramSocket socket) {
        this.packet = packet;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
            String data = LocalDateTime.now().format(formatter);
            DatagramPacket pacote = new DatagramPacket(data.getBytes(), data.getBytes().length, packet.getAddress(), packet.getPort());
            socket.send(pacote);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
