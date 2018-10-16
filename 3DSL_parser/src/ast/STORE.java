package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class STORE extends STATEMENT {
    private String value;
    private String name;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("store");
        value = tokenizer.getNext();
        tokenizer.getAndCheckNext("as");
        name = tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("Putting "+this.name+" into symbol table");
        Main.symbolTable.put(name,value);
        return null;
    }

    public String getName(){return name;}
}
