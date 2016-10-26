package com.gboz.javaworkout;

/**
 * Created by Grzegorz on 24.10.2016.
 */


public class Main2 {

    public static String generateBinary(int len) {
        String binary = "";
        for (int i = 0; i < len; i++) {
            binary += 0 + (int) (Math.random() * ((1 - 0) + 1));
        }
        return binary;
    }

    public static int binaryToDecimal(String binary) {
        char[] numbers = binary.toCharArray();
        int val = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] == '1') {
                val += Math.pow(2, (numbers.length - i - 1));
            }
        }
        return val;
    }

    public static double rastriginFunction(double x, double A, double w) {
        return A + Math.pow(x, 2) - A * Math.cos(w * x);
    }

    public static double translate(int num, double a, double b, int m) {
        return a + (b - a) * num / (Math.pow(2, m) - 1);
    }


    public static void main(String[] args) {

    }
}
