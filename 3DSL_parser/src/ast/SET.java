package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class SET extends STATEMENT {
    String property;
    String object;
    String value;
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("set");
        property = tokenizer.getNext();
        tokenizer.getAndCheckNext("of");
        object = tokenizer.getNext();
        tokenizer.getAndCheckNext("to");
        value = tokenizer.getNext();
        if(tokenizer.checkToken(Main.NEWLINE)) {
            tokenizer.getAndCheckNext(Main.NEWLINE);
        }
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
//        System.out.println("Setting "+name+" to "+value);
//        Main.symbolTable.put(name,value);
        return null;
    }
}
