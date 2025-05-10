package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Thread servidor = new Thread(new Servidor());
        servidor.start();


        Thread cliente = new Thread(new Cliente("127.0.0.1", 9090));
        cliente.start();
    }
}