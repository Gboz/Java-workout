package com.gboz.javaworkout;

import java.util.Random;

/**
 * Created by Grzegorz on 07.10.2016.
 */
public class FRastragina {
    double A = 10;
    double w = 20 * Math.PI;
    int k = 20;
    double a = -1.0;
    double b = 1.0;
    double d = 6.0;
    int m = 0;
    String binary = "";

    double rastriginFunction(double x, double A, double w) {
        return A + Math.pow(x, 2) - A * Math.cos(w * x);
    }

    String generateBinary(int len) {
        for (int i = 0; i < len; i++) {
            binary += 0 + (int) (Math.random() * ((1 - 0) + 1));
        }
        return binary;
    }

    public int binaryToDecimal(String binary) {
        char[] numbers = binary.toCharArray();
        int val = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] == '1') {
                val += Math.pow(2, (numbers.length - i - 1));
            }
        }
        return val;
    }

    double translate(int num, double a, double b, int m) {
        return a + (b - a) * num / (Math.pow(2, m) - 1);
    }
}
