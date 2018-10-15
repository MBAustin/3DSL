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
        String retval =  "cmds.parent(\'"+object1+"\', \'"+object2+"\')";
        System.out.println(retval);
        return retval;
    }


}
