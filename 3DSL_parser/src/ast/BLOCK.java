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

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("with");
        param = new DEC();
        param.parse();
        tokenizer.getAndCheckNext("start");
        statements = new ArrayList<>();
        while (!tokenizer.checkToken("return")){
            STATEMENT s = STATEMENT.getSubStatement();
            statements.add(s);
            s.parse();
        }
        tokenizer.getAndCheckNext("return");
        retval = tokenizer.getNext();
        tokenizer.getAndCheckNext("end");
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("You should never have reached this!");
        return null;
    }

    public String evaluate(String arg) throws FileNotFoundException, UnsupportedEncodingException {
        param.evaluate();
        Main.symbolTable.put(param.getName(), arg);
        for (STATEMENT s : statements){
            s.evaluate();
        }
        return retval;
    }

}
