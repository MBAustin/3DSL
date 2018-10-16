package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class CLONE extends STATEMENT {
    private String object;
    private String name;
    private int iterations;
    private String step;
//    clone {OBJECT} as <name>
//            Or
//    clone {OBJECT} as <name> with:
//          iterations 8
//          step ConeStep

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("clone");
        object = tokenizer.getNext();
        tokenizer.getAndCheckNext("as");
        name = tokenizer.getNext();

        String with = tokenizer.getNext();
        if(with.equals("with:")) {
            tokenizer.getAndCheckNext(Main.NEWLINE);
            tokenizer.getAndCheckNext(Main.TAB);
            tokenizer.getAndCheckNext("iterations");
            iterations = Integer.parseInt(tokenizer.getNext());
            tokenizer.getAndCheckNext(Main.NEWLINE);
            tokenizer.getAndCheckNext(Main.TAB);
            tokenizer.getAndCheckNext("step");
            step = tokenizer.getNext();


        }
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        String retVal = "";
        Main.symbolTable.put("object", object);
        for(int i=1; i <= iterations; i++) {
            if(i==1) {
                retVal += "\ncmds.duplicate(\'" + object + "\')";
            }
            else {
                retVal += "\ncmds.duplicate(\'" + object+(i-1) + "\')";
            }
            Main.symbolTable.put("object", object+i);
            BLOCK codeblock = (BLOCK) Main.symbolTable.get(step);
            retVal += "\n" + codeblock.evaluate();
        }
        return retVal;
    }

    public String getName(){return name;}
}