package ui;

import ast.PROGRAM;
import libs.Tokenizer;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<String,Object> symbolTable = new HashMap<>();
    public static final String NEWLINE = "%newLine%";
    public static final String TAB = "%tab%";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Tokenizer.makeTokenizer("reedTest.3dsl");
        // Tokenizer.makeTokenizer("mattTest.3dsl");
        // Tokenizer.makeTokenizer("markForTest.3dsl");
        // Tokenizer.makeTokenizer("rhodaTest.3dsl");



        PROGRAM p = new PROGRAM();
        p.parse();
        p.evaluate();
        System.out.println("completed successfully");
        System.out.println(symbolTable);
    }

}
