package ast;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;


public class MOVEDEC extends STATEMENT {
    String objName;
    String value;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("move");
        objName = tokenizer.getNext().trim(); //TODO: remove need for trim
        tokenizer.getAndCheckNext("by");
        value = tokenizer.getNext().trim(); //TODO: remove need for trim;
    }

    @Override
    public void evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        writer.println("cmds.move(" + value + ", '" + objName + "')");
    }
}
