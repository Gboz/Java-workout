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


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\Grzegorz\\IdeaProjects\\Java workout\\src\\com\\gboz\\javaworkout\\test.txt"));
        String patern = scanner.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(patern, " =,;");
        ArrayList<Integer> integers = new ArrayList<>();
        Integer x;
        while (stringTokenizer.hasMoreTokens()) {
            x = Integer.parseInt(stringTokenizer.nextToken());
            integers.add(x);
            System.out.println(integers);
            System.out.println("Array integers size: " +integers.size());
        }

        for (Integer i: integers) {

            System.out.println(integers.indexOf(i));
        }

    }

}
