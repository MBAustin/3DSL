package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class SET extends STATEMENT {
    String name;
    String value;
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("set");
        name = tokenizer.getNext();
        value = tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("Setting "+name+" to "+value);
        Main.symbolTable.put(name,value);
        return null;
    }
}
