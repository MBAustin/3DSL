package ast;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class PRINT extends STATEMENT {
    STATEMENT stmt;
    String simpleVal;
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("print");
        if (tokenizer.checkToken("get")) {
            stmt = new USE();
            stmt.parse();
        }
        else if (tokenizer.checkToken("call")){
            stmt = new PROCCALL();
            stmt.parse();
        }
        else {
            simpleVal = tokenizer.getNext();
        }
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        if (stmt !=null) {
            System.out.println("PRINTING: " + stmt.evaluate());
        }
        else System.out.println("SIMPLE VAL PRINTING: "+simpleVal);
        return null;
    }
}
