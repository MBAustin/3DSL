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
        tokenizer.getAndCheckNext(Main.NEWLINE);
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        writer.println("cmds.rotate("+vector.a+","+vector.b+","+vector.c+",'"+object+"')");
        return null;
    }
}
