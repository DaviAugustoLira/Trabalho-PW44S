package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Digite um número ou 0 para sair");
            int numero = sc.nextInt();
            if(numero % 2 == 0) System.out.println("par");
            if(numero % 2 != 0) System.out.println("impar");
            if(numero > 0) System.out.println("positivo");
            if(numero < 0) System.out.println("negativo");
            if(numero == 0) break;
        }
    }
}