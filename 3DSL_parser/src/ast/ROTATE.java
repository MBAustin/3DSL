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

        String realObject = Main.getValue(object);
        Vector realVector = Main.getVector(vector);

        return "cmds.xform(\'"+realObject+"\', relative=True, ro="+ realVector + ")";


    }
}
