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
        String realObject1 = Main.getValue(object1);
        String realObject2 = Main.getValue(object2);
        String cutRename = realObject2 + "cut" + this.toString().split("@")[1];
        String retVal =  "cmds.rename(\'"+realObject2+"\', \'"+cutRename+"\')\n" +
                "cmds.polyCBoolOp(\'"+cutRename+"\', \'"+realObject1+"\', op=2, n=\'"+realObject2+"\')";
        return retVal;
    }

}
