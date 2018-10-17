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
        String boilerPlate = "import maya.cmds as cmds\n" +
                "import random\n"+
                "def setColor(obj, rVal, gVal, bVal):\n" +
                "\tshd = cmds.shadingNode('lambert', asShader=True, n='%s_lmb' % obj)\n" +
                "\tsg = cmds.sets(n='%s_sg' % obj, renderable=True, noSurfaceShader=True, empty=True)\n" +
                "\tcmds.setAttr('%s.color' % shd, rVal, gVal, bVal, type='double3')\n" +
                "\tcmds.connectAttr('%s.outColor' % shd, '%s.surfaceShader' % sg, f=True)\n" +
                "\tcmds.sets(obj, e=True, fe=sg)\n";

        writer.println(boilerPlate);
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
