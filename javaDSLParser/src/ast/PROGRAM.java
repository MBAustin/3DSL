package ast;

import libs.Node;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class PROGRAM extends Node {
    private List<STATEMENT> statements = new ArrayList<>();

    @Override
    public void parse() {
        tokenizer.getAndCheckNext( "Hello!");
        while(!tokenizer.checkToken( "Thanks!")){
            STATEMENT s = null;
            if (tokenizer.checkToken("make me a")) {
                s = new SHAPEDEC();
            }
            else if (tokenizer.checkToken("parent")) {
                s = new EDGEDEC();
            }
            else if (tokenizer.checkToken("set")) {
                s = new ATTRDEC();
            }
            else if (tokenizer.checkToken("assign")) {
                s = new ASSIGNDEC();
            }
            else if (tokenizer.checkToken("move")) {
                s = new MOVEDEC();
            }
            else if (tokenizer.checkToken("rotate")) {
                s = new ROTATEDEC();
            }
            statements.add(s);
            s.parse();
        }
    }

    @Override
    public void evaluate() throws FileNotFoundException, UnsupportedEncodingException {
        writer = new PrintWriter("myLittleDotProgram.dot", "UTF-8");
        writer.println("import maya.cmds as cmds");
        writer.println("cmds.file(f=True, new=True)");
        for (STATEMENT s : statements){
            s.evaluate();
        }
       // writer.println("}");
        writer.close();
    }
}
