package com.gboz.javaworkout;

public class Main {

    static private double A = 10;
    static private double w = 20 * Math.PI;
    static private double a = -1.0;
    static private double b = 1.0;
    static private int k = 10;
    static private int m = 0;
    static private String binarySeq[];
    static private double doubleSeq[];

    private static String generateBinary(int len) {
        String binary = "";
        for (int i = 0; i < len; i++) {
            binary += (int)(Math.random() * 2);
        }
        return binary;
    }

    private static int binaryToDecimal(String binary) {
        char[] numbers = binary.toCharArray();
        int val = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] == '1') {
                val += Math.pow(2, (numbers.length - i - 1));
            }
        }
        return val;
    }

    private static double rastriginFunction(double x, double A, double w) {
        return A + Math.pow(x, 2) - A * Math.cos(w * x);
    }

    private static double translate(int num, double a, double b, int m) {
        return a + (b - a) * num / (Math.pow(2, m) - 1);
    }

    private static int binaryLength() {
        double d = 6.0;
        double value = (b - a) * Math.pow(10, d);
        while (value >= Math.pow(2, m)) {
            m++;
        }
        System.out.println("długość łańcucha: " + m);
        return m;
    }

    private static void getBinarySeq() {
        System.out.println("ciągi binarne: ");
        binarySeq = new String[k];
        doubleSeq = new double[k];
        for (int i = 0; i < k; i++) {
            binarySeq[i] = generateBinary(m);
            doubleSeq[i] = translate(binaryToDecimal(binarySeq[i]), a, b, m);
            System.out.println(binarySeq[i]);
        }
    }

    private static void getPointsAfterTranslate() {
        System.out.println("punkty po przekształceniu: ");
        for (int i = 0; i < k; i++) {
            System.out.println(doubleSeq[i]);
        }
    }

    private static void getRastriginResults() {
        System.out.println("wartości funkcji Rastrigina: ");
        for (int i = 0; i < k; i++) {
            System.out.println("x" + i + " = " + rastriginFunction(doubleSeq[i], A, w));
        }
    }

    private static void builderPopulation() {
        System.out.println("\n##########Tworzenie populacji BEGIN##########\n");
        binaryLength();
        getBinarySeq();
        getPointsAfterTranslate();
        getRastriginResults();
        System.out.println("\n##########Tworzenie populacji END##########\n");
    }

    //selekcja zajęcia 2
    public static void bubbleSort(double A, double w) {
        int lastIndex = doubleSeq.length - 1;
        int oneBeforeLastIndex = lastIndex - 1;
        double doubleVar;
        String binaryVar;
        while (oneBeforeLastIndex >= 0) {
            if (rastriginFunction(doubleSeq[oneBeforeLastIndex], A, w) < rastriginFunction(doubleSeq[lastIndex], A, w)) {
                doubleVar = doubleSeq[oneBeforeLastIndex];
                binaryVar = binarySeq[oneBeforeLastIndex];
                doubleSeq[oneBeforeLastIndex] = doubleSeq[lastIndex];
                binarySeq[oneBeforeLastIndex] = binarySeq[lastIndex];
                doubleSeq[lastIndex] = doubleVar;
                binarySeq[lastIndex] = binaryVar;
                lastIndex = doubleSeq.length - 1;
                oneBeforeLastIndex = lastIndex - 1;
            } else {
                lastIndex--;
                oneBeforeLastIndex--;
            }
        }
    }

    public static void ranking() {
        bubbleSort(A, w);
        int index;
        String binaryVarTab[] = new String[k];
        double doubleVarTab[] = new double[k];
        for (int i = 0; i < doubleSeq.length; i++) {
            index = ((int) (Math.random() * (((doubleSeq.length - 1)) + 1)));
            index = ((int) (Math.random() * (((index)) + 1)));
            doubleVarTab[i] = doubleSeq[index];
            binaryVarTab[i] = binarySeq[index];
        }
    }

    public static void builderSelection() {
        System.out.println("\n##########Selekcja metodą rankingową BEGIN##########\n");
        ranking();
        System.out.println("ciągi binarne: ");
        for (int i = 0; i < k; i++) {
            System.out.println(binarySeq[i]);
        }
        System.out.println("punkty: ");
        for (int i = 0; i < k; i++) {
            System.out.println(doubleSeq[i]);
        }
        System.out.println("wartości funkcji");
        for (int i = 0; i < k; i++) {
            System.out.println("x" + i + " = " + rastriginFunction(doubleSeq[i], A, w));
        }
        System.out.println("\n##########Selekcja metodą rankingową END##########\n");
    }

    public static void main(String[] args) {
        builderPopulation();
        builderSelection();
    }
}
