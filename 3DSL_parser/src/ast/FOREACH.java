package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class FOREACH extends STATEMENT {
    private String name;
    private String group;
    private BLOCK codeblock;
//    for each <name> in {GROUP}:
//	    <operation>
//	    …


    @Override
    public void parse() {
        tokenizer.getAndCheckNext("for");
        tokenizer.getAndCheckNext("each");
        name = tokenizer.getNext();
        tokenizer.getAndCheckNext("in");
        group = tokenizer.getNext().replace(":", "");

        // need make a codeblock to repeat
        codeblock = new BLOCK();
        codeblock.foreach = true;
        codeblock.parse();

    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        String realGroup = Main.getValue(group);
        // TODO get children from maya using realGroup
        // TODO make for loop using name and realGroup
        return "for " + name +" in " + realGroup + ":\n" + codeblock.evaluateForLoop();
    }


}
