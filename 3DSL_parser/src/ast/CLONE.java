package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class CLONE extends STATEMENT {
    private String object;
    private String name;
    private Number iterations;
    private String step;


    @Override
    public void parse() {
        tokenizer.getAndCheckNext("clone");
        object = tokenizer.getNext();
        tokenizer.getAndCheckNext("as");
        name = tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        //System.out.println("cmds.duplicate('"+object+"', name='"+name+"')");
        return "cmds.duplicate('"+object+"', name='"+name+"')";
    }

    public String getName(){return name;}
}