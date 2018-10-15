package ast;

import libs.Node;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class PROGRAM extends Node{
    private List<STATEMENT> statements = new ArrayList<>();
    private PrintWriter writer;

    @Override
    public void parse() {
        while (tokenizer.moreTokens()) {
            STATEMENT s = STATEMENT.getSubStatement();
            s.parse();
            statements.add(s);
        }

    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        writer = new PrintWriter("output.py", "UTF-8");
        for (STATEMENT s : statements){
            String output = s.evaluate();
            if (output != null) {
                writer.println(output);
            }
        }
        writer.close();
        return null;
    }
}
