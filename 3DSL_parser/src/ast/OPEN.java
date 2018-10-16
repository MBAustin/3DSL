package ast;

import libs.Vector;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class OPEN extends STATEMENT {
    private String fileName;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("open");
        if(tokenizer.checkToken("new")) {
            tokenizer.getNext();
            tokenizer.getAndCheckNext("scene");
        }
        else {
            fileName = tokenizer.getNext();
        }

    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        if(fileName == null) {
            return "cmds.file(f=True, new=True)";
        }
        else {
            return "cmds.file(\'" + fileName + "\' o=True)";
        }

    }
}
