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
        return "cmds.rotate("+vector.a+","+vector.b+","+vector.c+",'"+object+"')";
    }
}
