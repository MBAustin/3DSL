package ui;

import ast.PROGRAM;
import libs.Tokenizer;
import libs.Vector;
import java.util.*;
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
        }
//        else if (str.equals("random")){
//            Vector myVector = new Vector((float) (Math.random() * 255.0),
//                    (float) (Math.random() * 255.0), (float) (Math.random() * 255.0));
//            System.out.println("VECTOR: " + myVector.toString());
//            return myVector.toString();
//        }
        else{
            return str;
        }
    }

    public static Vector getVector(Vector vector) {
        if (vector.variable == null) {
            return vector;
        } else {

            Vector retVal = Main.getVector(Vector.fromString((String) Main.symbolTable.get(vector.variable)));
            System.out.println("GOT VECTOR: " + retVal);
            return retVal;
        }


//        return vector.variable == null ? vector : Vector.fromString((String) Main.symbolTable.get(vector.variable));
    }

}
