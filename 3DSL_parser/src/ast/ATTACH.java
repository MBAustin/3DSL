package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class ATTACH extends STATEMENT {
    private String name;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("new");
        name = tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("Putting "+this.name+" into symbol table");
        Main.symbolTable.put(name,"");
        return null;
    }

    public String getName(){return name;}
}
