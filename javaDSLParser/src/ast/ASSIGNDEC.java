package ast;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;


public class ASSIGNDEC extends STATEMENT {
    String shader;
    String objectName;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("assign");
        shader = tokenizer.getNext().trim(); //TODO: remove need for trim
        tokenizer.getAndCheckNext("to");
        objectName = tokenizer.getNext().trim(); //TODO: remove need for trim;
    }

    @Override
    public void evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        writer.println("cmds.select('" + objectName + "')");
        writer.println("cmds.hyperShade(assign='" + shader + "')");
    }
}
