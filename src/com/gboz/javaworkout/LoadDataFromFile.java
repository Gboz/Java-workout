package com.gboz.javaworkout;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Grzegorz on 26.10.2016.
 */
public class LoadDataFromFile {

    public static void loadFromFile() throws FileNotFoundException {
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
                    if (i == 0) continue;
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
            System.out.println(e);
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        loadFromFile();
    }

}
