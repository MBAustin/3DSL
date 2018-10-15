package ast;

import ui.Main;

import java.util.LinkedHashMap;
import java.util.Map;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class MAKE extends STATEMENT {
    private String object;
    private String name;
    private Map<String, String> propertyMap = new LinkedHashMap<String, String>();

    @Override
    public void parse() {
        tokenizer.getAndCheckNext("make");
        String aOrAn = tokenizer.getNext();
        if(aOrAn.equals("a") || aOrAn.equals("an")) {
            object = tokenizer.getNext();
            tokenizer.getAndCheckNext("called");
            name = tokenizer.getNext();
        }
        String with = tokenizer.getNext();
        if(with.equals("with:")) {
            while (tokenizer.checkToken(Main.NEWLINE)){
                tokenizer.getAndCheckNext(Main.NEWLINE);
                String property = tokenizer.getNext();
                String value = tokenizer.getNext();
                if (value.charAt(0) == '(') {
                    // todo: convert to vector
                }
                propertyMap.put(property, value);
            }
        }
        System.out.println(propertyMap);
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
//        System.out.println("Putting "+this.name+" into symbol table");
//        Main.symbolTable.put(name,"");
        return null;
    }

}
