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
        String cutRename = object2 + "cut";
        String retVal =  "cmds.rename(\'"+object2+"\', \'"+cutRename+"\')\n" +
                "cmds.polyCBoolOp(\'"+object1+"\', \'"+cutRename+"\', op=2, n=\'"+object2+"\')";
        System.out.println(retVal);
        return retVal;
    }

}
