package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class HANDLENEWLINEANDTABS extends STATEMENT {

    @Override
    public void parse() {
        if (tokenizer.checkToken(Main.NEWLINE)) {
            tokenizer.getAndCheckNext(Main.NEWLINE);
        }
        if (tokenizer.checkToken(Main.TAB)) {
            tokenizer.getAndCheckNext(Main.TAB);
        }
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        return null;
    }
}
