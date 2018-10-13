package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class DEC extends STATEMENT {
    private String name;
    private Object value;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("store");
        value = tokenizer.getNext();
        tokenizer.getAndCheckNext("as");
        name = tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("Putting "+this.value+" into symbol table as "+this.name);
        Main.symbolTable.put(name,value);
        return null;
    }

    public String getName(){return name;}
}
