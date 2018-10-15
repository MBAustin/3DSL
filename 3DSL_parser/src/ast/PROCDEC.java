package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;

public class PROCDEC extends STATEMENT {
    private String nameOfProc;
    private BLOCK codeblock;
    private STATEMENT retstmt;
    private ArrayList<String> parameterList = new ArrayList<String>();
//    function <name> takes <parameter>, …:
//	<operation>
//	...

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("function");
        nameOfProc = tokenizer.getNext();
        tokenizer.getAndCheckNext("takes");
        String next = tokenizer.getNext();
        while (!next.contains(":")) {
            next = next.substring(0, next.length() - 1);
            parameterList.add(next);
            next = tokenizer.getNext();
        }

        next = next.substring(0, next.length() - 1);
        parameterList.add(next);

        System.out.println(parameterList);

        codeblock = new BLOCK();
        codeblock.parse();
        Main.symbolTable.put(nameOfProc, codeblock);
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        return null;
    }
}
