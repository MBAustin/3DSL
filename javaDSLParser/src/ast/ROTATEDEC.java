package ast;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;


public class ROTATEDEC extends STATEMENT {
    String objName;
    String value;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("rotate");
        objName = tokenizer.getNext().trim(); //TODO: remove need for trim
        tokenizer.getAndCheckNext("by");
        value = tokenizer.getNext().trim(); //TODO: remove need for trim;
    }

    @Override
    public void evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        String[] xyz = value.split(",");
        writer.println("cmds.rotate('" + xyz[0].trim() + "deg','" + xyz[1].trim() + "deg','" + xyz[2].trim()
                + "deg', '" + objName + "')");
    }
}
