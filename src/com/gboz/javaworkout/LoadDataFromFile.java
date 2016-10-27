package com.gboz.javaworkout;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class LoadDataFromFile {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\Grzegorz\\IdeaProjects\\Java workout\\src\\com\\gboz\\javaworkout\\dane3.txt"));
        StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine(), " ");
        ArrayList<Integer> integers = new ArrayList<>();
        Integer x;
        int count = 0;
        while (scanner.hasNextLine()) {
            count++;
            scanner.nextLine();
        }
        System.out.println(count);
        scanner = new Scanner(new File("C:\\Users\\Grzegorz\\IdeaProjects\\Java workout\\src\\com\\gboz\\javaworkout\\dane3.txt"));
        try {
            for (int i = 0; i <= count + 1; i++){
                for (int j = 1; j <= 3; j++) {
                    if (i == 0 || i == 1) continue;
                    while (stringTokenizer.hasMoreTokens()) {
                        x = Integer.parseInt(stringTokenizer.nextToken());
                        integers.add(x);
                        System.out.println(integers);
                        System.out.println("Array integers size: " + integers.size());
                    }
                }
                stringTokenizer = new StringTokenizer(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Koniec elementów: " + e);
        }

        System.out.println(integers);
        System.out.println(integers.get(0));
        System.out.println(integers.get(1));
        System.out.println(integers.get(2));
        System.out.println(integers.get(4));

    }

}
