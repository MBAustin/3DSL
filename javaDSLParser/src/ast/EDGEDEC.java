package ast;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;


public class EDGEDEC extends STATEMENT {
    String shape1;
    String shape2;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("parent");
        shape1 = tokenizer.getNext().trim(); //TODO: remove need for trim
        tokenizer.getAndCheckNext("to");
        shape2 = tokenizer.getNext().trim(); //TODO: remove need for trim;
    }

    @Override
    public void evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        writer.println("cmds.parent('" + shape1 + "','" + shape2 + "')");
    }
}
