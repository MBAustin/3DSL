package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Hashtable;

public class PROCCALL extends STATEMENT {
    private String name;
    private Map<String, String> args;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("call");
        name = tokenizer.getNext();
        tokenizer.getAndCheckNext("with:");

        args = new Hashtable<>();
        while (!isEndOfBlock()){
            Main.symbolTable.put(tokenizer.getNext(), tokenizer.getNext());
        }
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        BLOCK codeblock = (BLOCK) Main.symbolTable.get(name);
        return codeblock.evaluate();
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
