package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class PROCDEC extends STATEMENT {
    private String name;
    private BLOCK codeblock;
    private STATEMENT retstmt;


    @Override
    public void parse() {
        tokenizer.getAndCheckNext("def");
        name = tokenizer.getNext();
        tokenizer.checkToken(("with"));
        codeblock = new BLOCK();
        codeblock.parse();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        Main.symbolTable.put(name,codeblock);
        return null;
    }
}
