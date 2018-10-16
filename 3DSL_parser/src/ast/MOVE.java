package ast;

import libs.Vector;
import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class MOVE extends STATEMENT {
    private String object;
    private Vector vector;
    private String destObject = "";

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("move");
        object = tokenizer.getNext();
        if (tokenizer.checkToken("by")) {
            tokenizer.getAndCheckNext("by");
            vector = tokenizer.getVector();
        } else {
            tokenizer.getAndCheckNext("to");
            destObject = tokenizer.getNext();
        }
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        String realObject = Main.getValue(object);
        if (destObject.length() > 0) {
            String realDestObject = Main.getValue(destObject);
        } else {
            Vector realVector = Main.getVector(vector);
        }
//        TODO evaluate move
        return null;
    }
}
