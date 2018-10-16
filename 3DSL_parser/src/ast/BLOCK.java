package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class BLOCK extends STATEMENT {
    List<STATEMENT> statements;
    DEC param;
    String retval;
    Boolean function = false;
    Boolean foreach = false;

    @Override
    public void parse() {
        if (function) {
            tokenizer.getAndCheckNext("takes");
            // TODO parse params for function dec
            param = new DEC();
            param.parse();
        }


        statements = new ArrayList<>();
        while (!isEndOfBlock()){
            STATEMENT s = STATEMENT.getSubStatement();
            statements.add(s);
            s.parse();
        }
//        tokenizer.getAndCheckNext("return");
//        retval = tokenizer.getNext();
//        tokenizer.getAndCheckNext("end");
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        String output = "";
        for (STATEMENT s : statements) {
            String temp = s.evaluate();
            output = output + temp + "\n";
        }
        return output;
    }

    public String evaluateForLoop() throws FileNotFoundException, UnsupportedEncodingException {
        String output = "";
        for (STATEMENT s : statements) {
            // Add tab for each newline
            String temp = s.evaluate();
             temp = temp.replace("\n", "\n\t");
        }
        return output;
    }

    private Boolean isEndOfBlock() {
        if (tokenizer.checkToken(Main.NEWLINE)) {
            tokenizer.getNext();
            if (tokenizer.checkToken(Main.TAB)) {
                tokenizer.getNext();
            } else {
                return true;
            }
        }
        return false;
    }

}
