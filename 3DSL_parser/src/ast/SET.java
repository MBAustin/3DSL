package ast;

import libs.Vector;
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
//        if(tokenizer.checkToken(Main.NEWLINE)) {
//            tokenizer.getAndCheckNext(Main.NEWLINE);
//        }
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        String realObject = Main.getValue(object);
        String realProperty = Main.getValue(property);
        // Check  if value is a vector
        if (Vector.isVector(value)) {
            Vector realValue = Vector.fromString(value);
            // TODO evaluate a vector property
            return null;
        } else {
            String realValue = Main.getValue(value);
            // TODO evaluate a different property
            return null;
        }


    }
}
