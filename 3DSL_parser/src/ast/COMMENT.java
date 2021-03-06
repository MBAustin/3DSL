package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class COMMENT extends STATEMENT {

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("#");
        while(!tokenizer.checkToken(Main.NEWLINE)) {
            tokenizer.getNext();
        }

        System.out.println("Comment ended");

    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        return null;
    }
}
