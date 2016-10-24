package com.gboz.javaworkout;

public class Main {

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
        double A = 10, w = 20 * Math.PI, a = -1.0, b = 1.0, d = 6.0;
        int k = 3, m = 0;

        double value = (b - a) * Math.pow(10, d);
        while (value >= Math.pow(2, m)) {
            m++;
        }

        System.out.println("m: " + m);
        String binarySeq[] = new String[k];
        double doubleSeq[] = new double[k];
        System.out.println("ciągi binarne: ");
        for (int i = 0; i < k; i++) {
            binarySeq[i] = generateBinary(m);
            doubleSeq[i] = translate(binaryToDecimal(binarySeq[i]), a, b, m);
            System.out.println(binarySeq[i]);
        }
        System.out.println("punkty po przekształceniu");
        for (int i = 0; i < k; i++) {
            System.out.println(doubleSeq[i]);
        }
        System.out.println("wartości funkcji Rastrigina");
        for (int i = 0; i < k; i++) {
            System.out.println("x" + i + " = " + rastriginFunction(doubleSeq[i], A, w));
        }
    }
}
