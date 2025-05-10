package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Runnable serRun = new Servidor();
        Thread servThread = new Thread(serRun);
        servThread.start();

        Thread clThread = new Thread(new Cliente("127.0.0.1", 5050, "Davi"));
        clThread.start();

        Thread clThread2 = new Thread(new Cliente("127.0.0.1", 5050, "Maria"));
        clThread2.start();

        Thread clThread3 = new Thread(new Cliente("127.0.0.1", 5050, "Joao"));
        clThread3.start();
    }
}