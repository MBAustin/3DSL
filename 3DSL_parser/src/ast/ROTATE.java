package ast;

import libs.Vector;
import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class ROTATE extends STATEMENT {
    private String object;
    private Vector vector;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("rotate");
        object = tokenizer.getNext();
        tokenizer.getAndCheckNext("by");
        vector = tokenizer.getVector();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        String realObject = Main.symbolTable.containsKey(object) ? (String) Main.symbolTable.get(object) : object;
        Vector realVector = vector.variable == null ? vector : Vector.fromString((String) Main.symbolTable.get(vector.variable));
        return "cmds.rotate("+realVector.a+","+realVector.b+","+realVector.c+",'"+realObject+"')";
    }
}
