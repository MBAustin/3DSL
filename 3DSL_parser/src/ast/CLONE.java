package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class CLONE extends STATEMENT {
    private String object;
    private String name;
    private Number iterations;
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
        //System.out.println("cmds.duplicate('"+object+"', name='"+name+"')");
        return "cmds.duplicate('"+object+"', name='"+name+"')";
    }

    public String getName(){return name;}
}