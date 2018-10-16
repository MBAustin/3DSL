package ast;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class SAVE extends STATEMENT {
    private String fileName;

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("save");
        tokenizer.getAndCheckNext("scene");
        tokenizer.getAndCheckNext("as");
        fileName = tokenizer.getNext();

    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        String retVal = "cmds.file( rename=\'"+fileName+"\' )\n" +
        "cmds.file( save=True, type='mayaAscii' )";
        return retVal;
    }
}
