package ui;

import ast.PROGRAM;
import libs.Tokenizer;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        List<String> literals = Arrays.asList("Hello!","Thanks!","make me a", "called", "parent","to", "assign", "set",
                "on", "by", "move", "rotate");
        Tokenizer.makeTokenizer("3Dinput.tdot",literals);
        PROGRAM p = new PROGRAM();
        p.parse();
        p.evaluate();
        System.out.println("Completed Successfully!");
    }

}
