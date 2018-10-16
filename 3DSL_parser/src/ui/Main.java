package ui;

import ast.PROGRAM;
import libs.Tokenizer;
import libs.Vector;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;


public class Main {
    public static Map<String,Object> symbolTable = new HashMap<>();
    public static final String NEWLINE = "%newLine%";
    public static final String TAB = "%tab%";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
//        Tokenizer.makeTokenizer("reedTest.3dsl");
         Tokenizer.makeTokenizer("mattTest.3dsl");
        // Tokenizer.makeTokenizer("markForTest.3dsl");
//         Tokenizer.makeTokenizer("rhodaTest.3dsl");



        PROGRAM p = new PROGRAM();
        p.parse();
        p.evaluate();
        System.out.println("completed successfully");
        System.out.println(symbolTable);
    }

    public static String getValue(String str) {
        // Recursively check
        if (Main.symbolTable.containsKey(str)) {
            return getValue((String) Main.symbolTable.get(str));
        } else{
            return str;
        }
    }

    public static Vector getVector(Vector vector) {
        if (vector.variable == null) {
            return vector;
        } else {
            return Main.getVector(Vector.fromString((String) Main.symbolTable.get(vector.variable)));
        }


//        return vector.variable == null ? vector : Vector.fromString((String) Main.symbolTable.get(vector.variable));
    }

}
