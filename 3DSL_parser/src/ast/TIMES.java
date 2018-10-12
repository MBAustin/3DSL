package ast;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class TIMES extends STATEMENT {
    private int num;
    private STATEMENT substatement;


    @Override
    public void parse() {
        tokenizer.getAndCheckNext("times");
        num = Integer.parseInt(tokenizer.getNext());
        tokenizer.getAndCheckNext("do");
        substatement = STATEMENT.getSubStatement();
        substatement.parse();
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("Going to do this "+num+" times!");
        for (int i=0; i<num; i++){
            substatement.evaluate();
        }
        return null;
    }
}
