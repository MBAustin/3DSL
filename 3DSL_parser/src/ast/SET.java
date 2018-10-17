package ast;

import libs.Vector;
import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class SET extends STATEMENT {
    String property;
    String object;
    String value;
    @Override
    public void parse() {
        tokenizer.getAndCheckNext("set");
        property = tokenizer.getNext();
        tokenizer.getAndCheckNext("of");
        object = tokenizer.getNext();
        tokenizer.getAndCheckNext("to");
        value = tokenizer.getNext();
//        if(tokenizer.checkToken(Main.NEWLINE)) {
//            tokenizer.getAndCheckNext(Main.NEWLINE);
//        }
    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        String realObject = Main.getValue(object);
        String realProperty = Main.getValue(property);
        String retVal;
        String realValue = value;

        if (!Vector.isVector(value)) {
            realValue = Main.getValue(value);
        }

        if (Vector.isVector(realValue)) {
            System.out.println("SET found vector with value: " + realValue);
            Vector aV = Vector.fromString(realValue);
            retVal = evaluateVectorProperty(realObject, realProperty, aV);
        } else {
            try {
                double attrDouble = Double.parseDouble(realValue);
                retVal = "cmds.setAttr(\'" + realObject + "." + realProperty + "\', " + attrDouble + ")\n";
            }
            catch (NumberFormatException e) {
                retVal = "cmds.setAttr(\'" + realObject + "." + realProperty + "\'" + realValue + ")\n";
            }
        }
        System.out.println(retVal);
        return retVal;
    }

    public String evaluateVectorProperty(String object, String property, Vector value) {
        String retVal;
        if (property.equals("color")) {
            retVal = "setColor(\'"+object + "\'," + value.a+"/255.0,"+value.b+"/255.0,"+value.c+"/255.0)\n";
        } else {
            retVal = "cmds.setAttr(\'" + object + "." + property + "\', " + value.a + ", " +
                    value.b + ", " + value.c + ", type=\"double3\")\n";;
        }
        return retVal;
    }
}
