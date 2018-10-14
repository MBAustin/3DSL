package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class CUT extends STATEMENT {
//    cut {OBJECT} out of {OBJECT}
    private String object1;
    private String object2;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("cut");
        object1 = tokenizer.getNext();
        tokenizer.getAndCheckNext("out");
        tokenizer.getAndCheckNext("of");
        object2 = tokenizer.getNext();

    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        // TODO MATT can you do the python here. Cut object1 out of object2.
        // I think you mentioned it would make a 3rd invisible object and attach it to object2?
        System.out.println("Cut " + object1 + " out of " + object2);
        return null;
    }

}
