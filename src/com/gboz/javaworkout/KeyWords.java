package com.gboz.javaworkout;

/**
 * Created by Grzegorz on 02.10.2016.
 */
public class KeyWords {
    public String keyWords[] = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while", "true", "false", "null"};

    public void KeyWordsOutput(String[] keyWords) {
        this.keyWords = keyWords;
        for (String x : keyWords) {
            System.out.print(x + ", ");
        }
    }
}
