package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class ATTACH extends STATEMENT {
    private String object1;
    private String object2;
//    attach {OBJECT} to {OBJECT}

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("attach");
        object1 = tokenizer.getNext();
        tokenizer.getAndCheckNext("to");
        object2 = tokenizer.getNext();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
//        TODO Matt, can you do the maya python for this, attach object1 to object2. object2 is the parent
        return "python: attach " + object1 + " to " + object2 + "\n" + "Python overhead code blah blah";
    }


}
