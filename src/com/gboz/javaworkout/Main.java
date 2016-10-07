package com.gboz.javaworkout;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Use method from class KeyWords");
//        KeyWords var = new KeyWords();
//        var.KeyWordsOutput(var.keyWords);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Random random = new Random();
        int randomNumber = 0;
        System.out.println(randomNumber);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                randomNumber = random.nextInt(2);
                System.out.print(randomNumber + " ");
            }
            System.out.println(randomNumber);
        }

    }
}
