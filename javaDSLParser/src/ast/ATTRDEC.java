package ast;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;


public class ATTRDEC extends STATEMENT {
    String attr;
    String objName;
    String value;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("set");
        attr = tokenizer.getNext().trim(); //TODO: remove need for trim
        tokenizer.getAndCheckNext("on");
        objName = tokenizer.getNext().trim(); //TODO: remove need for trim
        tokenizer.getAndCheckNext("to");
        value = tokenizer.getNext().trim(); //TODO: remove need for trim;
    }

    @Override
    public void evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        String attrString = "cmds.setAttr('" + objName + "." + attr + "',";
        String[] valStrings = value.split(" ");
        for(String subAttr : valStrings) {
            attrString += " " + subAttr;
        }
        attrString += ")";
        writer.println(attrString);
    }
}
