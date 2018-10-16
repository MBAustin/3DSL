package ast;

import ui.Main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.StringJoiner;


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
        // TODO I think I did this correctly. Right now, it's printing the command.
        //System.out.println("groupName: " + groupName);
        //System.out.println("objects: " + objects);
        ArrayList<String> objectList = new ArrayList<String>();
        for (String k:objects)
            objectList.add("'" +k+ "'");
        //System.out.println("Printing the list");
        //for(String k:objectList)
        //    System.out.println(k);
        System.out.println("cmds.group("+objectList.toString().replace("[","").replace("]","")+", name='"+groupName+"')");
        return "cmds.group("+objectList.toString().replace("[","").replace("]","")+", name='"+groupName+"')";
    }
    
}
