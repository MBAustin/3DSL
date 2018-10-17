package ast;

import libs.Vector;
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
                if (tokenizer.checkToken("%tab%")) {
                    tokenizer.getAndCheckNext(Main.TAB);
                    String property = tokenizer.getNext();
                    String value = tokenizer.getNext();
                    propertyMap.put(property, value);
                } else {
                    break;
                }
            }
        }
        System.out.println(propertyMap);
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        String retVal = "cmds.poly" + object + "(n=\'"+name+"\')\n";
        for(Map.Entry<String, String> entry : propertyMap.entrySet()) {
            String attrName = entry.getKey();
            String attrValue = entry.getValue();

            if (!Vector.isVector(attrValue)) {
                // Check if value is in symbol table
                attrValue = Main.getValue(attrValue);
            }

            // Check if the value is a vector
            if (Vector.isVector(attrValue)){
                System.out.println("MAKE found vector with value: " + attrValue);
                Vector aV = Vector.fromString(attrValue);
                if(attrName.equals("color")) {
                    retVal += "setColor(\'" + name + "\', " + aV.a+ "/255.0, " + aV.b+"/255.0, " + aV.c + "/255.0)\n";
                }
                else {
                    retVal += "cmds.setAttr(\'" + name + "." + attrName + "\', " + aV.a + ", " +
                            aV.b + ", " + aV.c + ", type=\"double3\")\n";
                }
            }
            else {
                try {
                    double attrDouble = Double.parseDouble(attrValue);
                    retVal += "cmds.setAttr(\'" + name + "." + attrName + "\', " + attrDouble + ")\n";
                }
                catch (NumberFormatException e) {
                    retVal += "cmds.setAttr(\'" + name + "." + attrName + "\'" + attrValue + ")\n";
                }
            }
        }
        System.out.println(retVal);
        return retVal;
    }

    public String getName(){return name;}
}
