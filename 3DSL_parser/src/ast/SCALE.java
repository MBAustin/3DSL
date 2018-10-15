package ast;

import libs.Vector;
import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class SCALE extends STATEMENT {
    private String object;
    private Vector vector;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("scale");
        object = tokenizer.getNext();
        tokenizer.getAndCheckNext("by");
        vector = tokenizer.getVector();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        return "cmds.scale("+vector.a+","+vector.b+","+vector.c+",'"+object+"')";
    }
}
