package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class GROUP extends STATEMENT {
    // group {OBJECT}, {OBJECT}...  as <name>**
    private ArrayList<String> objects;
    private String groupName;

    @Override
    public void parse() {
        String temp;
        objects = new ArrayList<String>();
        tokenizer.getAndCheckNext("group");
        while (!tokenizer.checkToken("as")) {
            System.out.println("here??");
            temp = tokenizer.getNext();
            temp = temp.replace(",","");
            objects.add(temp);
        }
        tokenizer.getAndCheckNext("as");
        groupName = tokenizer.getNext();

    }

    @Override
    public String evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        // TODO Matt, add all objects in objects arrayList as children to new object called groupName
        System.out.println("groupName: " + groupName);
        System.out.println("objects: " + objects);

        return null;
    }


}
