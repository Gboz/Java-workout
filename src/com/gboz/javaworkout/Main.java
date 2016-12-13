package com.gboz.javaworkout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    private static void bubbleSort(double A, double w) {
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
        int index;
        String[] binaryTymcz = new String[k];
        double[] doubleTymcz = new double[k];
        for (int i = 0; i < doubleSeq.length; i++) {
            index = ((int) (Math.random() * (((doubleSeq.length - 1)) + 1)));
            index = ((int) (Math.random() * (((index)) + 1)));
            doubleTymcz[i] = doubleSeq[index];
            binaryTymcz[i] = binarySeq[index];
//            doubleSeq[i] = doubleSeq[index];
//            binarySeq[i] = binarySeq[index];
        }

        for (int i = 0; i < doubleSeq.length; i++) {
            doubleSeq[i] = doubleTymcz[i];
            binarySeq[i] = binaryTymcz[i];
        }
    }

    private static void builderSelection() {
        System.out.println("\n##########Selekcja metodą rankingową BEGIN##########\n");
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

    //mutacja zajęcia 3
    static String replace(String binary_seq, int index, char replace) {
        char[] chars = binary_seq.toCharArray();
        chars[index] = replace;
        return String.valueOf(chars);
    }

    public static void mutation(double pm, double A, double w, double a, double b, int m) {
        for (int i = 0; i < binarySeq.length; i++) {
            for (int k = 0; k < binarySeq[i].length(); k++) {
                double r = 0 + (1) * Math.random();
                if (r < pm) {
                    System.out.println("Zmutowano chromosom "+i+", miejsce "+k);
                    binarySeq[i] = replace(binarySeq[i], k, (binarySeq[i].charAt(k) == '0') ? '1' : '0');
                }
            }
            doubleSeq[i] = translate(binaryToDecimal(binarySeq[i]), a, b, m);
        }
    }

    private static void builderMutation() {
        System.out.println("\n##########Mutacja BEGIN##########\n");
        mutation(0.1, A, w, a, b, m);
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
        System.out.println("\n##########Mutacja END##########\n");
    }

    //krzyżowanie i sukcesja
    private static void crossover(double pc, double A, double w, double a, double b, int m) {
        List indexList = new ArrayList();
        for (int i = 0; i < binarySeq.length; i++) {
            double r = 0 + (1 - 0) * Math.random();
            if (r < pc) {
                indexList.add(i);
            }
        }
        Collections.shuffle(indexList);
        if (indexList.size() % 2 != 0) {
            indexList.remove(0 + (int)(Math.random() * ((indexList.size() - 1) + 1)));
        }
        System.out.println("Krzyżowanie pary: " + indexList);
        String pattern = generateBinary(m);
        System.out.println("Wzór krzyżowania: " + pattern);
        char[] patternArray = pattern.toCharArray();
        String[] tmpBinarySeq = new String[binarySeq.length];
        for (int i = 0; i < indexList.size(); i += 2) {
            tmpBinarySeq[(int) indexList.get(i)] = "";
            tmpBinarySeq[(int) indexList.get(i + 1)] = "";
            for (int j = 0; j < patternArray.length; j++) {
                if (patternArray[j] == '0') {
                    tmpBinarySeq[(int) indexList.get(i)] += binarySeq[(int) indexList.get(i)].charAt(j);
                    tmpBinarySeq[(int) indexList.get(i + 1)] += binarySeq[(int) indexList.get(i + 1)].charAt(j);
                } else {
                    tmpBinarySeq[(int) indexList.get(i)] += binarySeq[(int) indexList.get(i + 1)].charAt(j);
                    tmpBinarySeq[(int) indexList.get(i + 1)] += binarySeq[(int) indexList.get(i)].charAt(j);
                }
            }
            binarySeq[(int) indexList.get(i)] = tmpBinarySeq[(int) indexList.get(i)];
            binarySeq[(int) indexList.get(i + 1)] = tmpBinarySeq[(int) indexList.get(i + 1)];
        }
        for (int i = 0; i < binarySeq.length; i++) {
            doubleSeq[i] = translate(binaryToDecimal(binarySeq[i]), a, b, m);
        }
    }

    private static void builderCrossover() {
        System.out.println("\n##########krzyżowanie i sukcesja BEGIN##########\n");
        //epoki => 150
        for (int generation = 0; generation < 150; generation++) {

            System.out.println("###\n Po zastosowaniu selekcji metodą rankingową\n###");
            bubbleSort(A, w);
            System.out.println("###\nPunkty zakodowane binarnie\n###");
            for (int i = 0; i < k; i++) {
                System.out.println(binarySeq[i]);
            }
            System.out.println("###\nPunkty w formie rzeczywistej\n###");
            for (int i = 0; i < k; i++) {
                System.out.println(doubleSeq[i]);
            }
            System.out.println("###\nWartości funkcji dla odpowiednich punktów\n###");
            for (int i = 0; i < k; i++) {
                System.out.println("f(x" + i + ") = " + rastriginFunction(doubleSeq[i], A, w));
            }

            System.out.println("###\n Po zastosowaniu mutacji\n###");
            mutation(0.2, A, w, a, b, m);
            System.out.println("###\nPunkty zakodowane binarnie\n###");
            for (int i = 0; i < k; i++) {
                System.out.println(binarySeq[i]);
            }
            System.out.println("###\nPunkty w formie rzeczywistej\n###");
            for (int i = 0; i < k; i++) {
                System.out.println(doubleSeq[i]);
            }
            System.out.println("###\nWartości funkcji dla odpowiednich punktów\n###");
            for (int i = 0; i < k; i++) {
                System.out.println("f(x" + i + ") = " + rastriginFunction(doubleSeq[i], A, w));
            }
            System.out.println("###\n Po zastosowaniu krzyżowania\n###");
            crossover(0.5, A, w, a, b, m);
            System.out.println("###\nPunkty zakodowane binarnie\n###");
            for (int i = 0; i < k; i++) {
                System.out.println(binarySeq[i]);
            }
            System.out.println("###\nPunkty w formie rzeczywistej\n###");
            for (int i = 0; i < k; i++) {
                System.out.println(doubleSeq[i]);
            }
            System.out.println("###\nWartości funkcji dla odpowiednich punktów\n###");
            for (int i = 0; i < k; i++) {
                System.out.println("f(x" + i + ") = " + rastriginFunction(doubleSeq[i], A, w));
            }
        }
        //znalezienie maksimum ze wszystkich punktów populacji
        int max=0;
        for (int i = 0; i < k; i++) {
            if (rastriginFunction(doubleSeq[i], A, w) > rastriginFunction(doubleSeq[max], A, w)) {
                max = i;
            }
        }
        System.out.println("Maksimum globalne w punkcie " + doubleSeq[max]+", wynosi "+rastriginFunction(doubleSeq[max], A, w));
        System.out.println("\n##########krzyżowanie i sukcesja END##########\n");
    }

    public static void main(String[] args) {
        builderPopulation();
        builderSelection();
        builderMutation();
        builderCrossover();
    }
}
