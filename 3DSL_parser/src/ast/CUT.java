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
        String realObject1 = Main.getValue(object1);
        String realObject2 = Main.getValue(object2);
        System.out.println("Cut " + realObject1 + " out of " + realObject2);
        String cutRename = realObject2 + "cut";
        String retVal =  "cmds.rename(\'"+realObject2+"\', \'"+cutRename+"\')\n" +
                "cmds.polyCBoolOp(\'"+realObject1+"\', \'"+cutRename+"\', op=2, n=\'"+realObject2+"\')";
        System.out.println(retVal);
        return retVal;
    }

}
