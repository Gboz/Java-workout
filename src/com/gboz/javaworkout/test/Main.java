package com.gboz.javaworkout.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Grzegorz on 02.12.2016.
 */
public class Main {

    public static void main(String[] args) {
        Kot kot = new Kot("Tapsio", null, 3.5, "Zbyszek");
        System.out.println(kot.przedstawSie());

        Pattern pattern = Pattern.compile("a*b?cde");
        Matcher matcher = pattern.matcher("jakis ciag znakow");
        System.out.println(matcher.matches());

    }
}
