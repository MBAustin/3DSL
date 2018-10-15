package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Dictionary;
import java.util.Hashtable;

public class PROCCALL extends STATEMENT {
    private String name;
    private Dictionary<String, String> args;


    @Override
    public void parse() {
        tokenizer.getAndCheckNext("call");
        name = tokenizer.getNext();
        tokenizer.getAndCheckNext("with:");

        args = new Hashtable<>();
        while (!isEndOfBlock()){
            args.put(tokenizer.getNext(), tokenizer.getNext());
        }
        System.out.println(args);
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        return null;
    }

    private Boolean isEndOfBlock() {
        if (tokenizer.checkToken(Main.NEWLINE)) {
            tokenizer.getNext();
            if (tokenizer.checkToken(Main.TAB)) {
                tokenizer.getNext();
            } else {
                return true;
            }
        }
        return false;
    }
}
